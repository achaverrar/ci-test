# Documentation Overview

This folder contains supporting artifacts that document the planning and design decisions for the URL Shortener Server.

Use this documentation to understand the system architecture, database design, API structure, and user-focused features.

## Workflow and artifacts

I produce the artifacts in sequence so each one builds on the previous: wireframes → sitemap → user stories → database design → API design.

- **wireframes/**: Low-to-medium fidelity Figma exports that define the frontend structure and key features.
- **sitemap.png**: Visual map of frontend pages showing which routes are public or private and how users can navigate between them.
- **user-stories.md**: Prioritized user stories with acceptance criteria and a backlog of potential future features.
- **database-design.jpg**: Entity-relationship diagram that models how data is stored and establishes the foundation for the API.
- **api-design.md**: First-draft API contracts describing the main HTTP routes and expected behavior.

Together these artifacts guide implementation and keep scope clear.

## Technical Decisions

- **Redirect route**: Handle link redirections on the server to improve performance. Serve a single 404 page from the backend for missing links to avoid duplicating logic, and use Nginx as a reverse proxy to route requests between the frontend and backend applications.
- **Slug generation**: Use a random ID generator instead of hashing since idempotency isn’t needed for my use case of link ownership and automatic removal on expiration. Favor security by selecting from the full set of allowed URL characters to fill 10 fixed-length positions, making slugs hard to predict. Collision odds are low, but in that case, I’ll check the database and generate a new slug.
- **Skip tests during image build:** Building the artifact locally to pass it into the Docker image failed because tests required a running database, creating a circular dependency. To resolve this and support a single-command startup, I moved the artifact build step into the Docker build process. However, running tests inside that stage would require injecting runtime environment variables into the image, which I wanted to avoid. As a result, I decided to skip tests during image builds and instead run them locally and in CI before producing artifacts.
- **Profiles:** I use only two Maven profiles (`dev` and `prod`) since I’m working solo and don't need a staging environment for QA.
- **Profile selection:** Profiles are set at build time to reduce runtime overhead and keep builds cleaner, at the cost of runtime flexibility.
- **SQL logging:** Added p6spy as a dev-only dependency to get detailed SQL query logs for debugging and performance monitoring.
- **Testcontainers for integration tests:** Use Testcontainers to run tests in a production-like environment with a fresh database each time, avoiding interference with the development database.
