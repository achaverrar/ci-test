# User Stories

- [Current Scope](#current-scope)
  - [US-1: Shorten a link](#us-1-shorten-a-link)
  - [US-2: Redirect from short link](#us-2-redirect-from-short-link)
  - [US-3: Automatic removal of expired links](#us-3-automatic-removal-of-expired-links)
  - [US-4: Not found page](#us-4-not-found-page)
- [Potential Future Features](#potential-future-features)
  - [Authentication and Accounts](#authentication-and-accounts)
  - [Link Management](#link-management)
  - [Sharing and Presentation](#sharing-and-presentation)
  - [Statistics](#statistics)
  - [Security and Abuse](#security-and-abuse)
  - [Admin and Integrations](#admin-and-integrations)
  - [Legal and Policies](#legal-and-policies)

## Current Scope

### US-1: Shorten a link

- **Priority:** Must have
- **Description:** As a user, I want to paste a long URL and shorten it so I can share it easily.

- **Acceptance criteria:**
  - The form requires a URL.
  - The URL must be a valid format.
  - When submitting a valid URL, the system shows the original and the shortened URL.
  - The user can copy the shortened URL with one click.
  - The user can shorten another URL without refreshing the page.
  - If the submission is invalid, the system shows an error message, does not generate a shortened URL, and keeps the user on the form.

### US-2: Redirect from short link

- **Priority:** Must have
- **Description:** As a user, I want to be redirected to the original URL when I open a valid short link.

- **Acceptance criteria:**
  - Opening a valid short link redirects immediately to the original URL.
  - The redirect happens without additional user interaction.
  - If the redirect fails, the user sees a clear error message.

### US-3: Automatic removal of expired links

- **Priority:** Must have
- **Description:** As a user, I want my shortened links to be removed automatically after they expire so I don’t have to manage them manually.

- **Acceptance criteria:**
  - Links expire automatically after 24 hours.
  - Expired links are removed from the system without user interaction.
  - Opening an expired link shows a not found page.

### US-4: Not found page

- **Priority:** Should have
- **Description:** As a user, I want a clear not found page when I open a short link that does not exist.

- **Acceptance criteria:**
  - Opening a slug that was never created shows a not found message.
  - The not found page offers a clear call to action to return to the home page and shorten a new link.
  - The user remains on the not found page until they act.

## Potential Future Features

### Authentication and Accounts

- User accounts with email and password
- OAuth sign-in

### Link Management

- User dashboard to manage all user links
- Create links with a custom alias
- Edit and delete existing links
- Set or change link expiration time
- Password-protected links
- One-time links that expire after a single use
- Bulk shorten links from a CSV

### Sharing and Presentation

- Generate a QR code for each short link
- Display link previews with title, description and icon

### Statistics

- Global statistics: total and unique clicks over time (day, week, month), referrers, and breakdowns by country, device, and browser
- Per-link statistics: total and unique clicks over time (day, week, month), referrers, breakdowns by country, device, and browser, hour-of-day distribution, and last clicked timestamp

### Security and Abuse

- Rate limiting for anonymous and authenticated actions
- Adaptive CAPTCHA challenge for suspicious or high-volume requests
- User reporting flow for abusive or problematic links

### Admin and Integrations

- Admin dashboard to review and manage reports and reported links
- Email notifications to reporters when a report is received and resolved
- Email notifications to link owners when action is taken on their links
- Integration with Discord to notify the admin whenever a new report is submitted

### Legal and Policies

- Public Terms of Use page
- Public Privacy Policy page
