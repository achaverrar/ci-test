# API Design

- [REST API](#rest-api)
  - [Shorten Link](#shorten-link)
  - [Get Link Details](#get-link-details)
- [HTTP Routes](#http-routes)
  - [Redirect](#redirect)

## REST API

**Base URL:** `/api/v1/`

### Shorten Link

#### Request

- **Endpoint:** `POST /api/v1/links`
- **Authenticated:** No
- **Roles:** All
- **Query parameters:** None
- **Path variables:** None
- **Body:**

```json
{
  "targetUrl": "https://www.example.org" // required
}
```

#### Response

- **Status:** `201 Created`
- **Body:**

```json
{
  "id": 1,
  "targetUrl": "https://www.example.org",
  "slug": "abcd1234",
  "shortUrl": "https://sho.rt/abcd1234",
  "createdAt": "2025-08-19T00:00:00.000Z",
  "expiresAt": "2025-08-20T00:00:00.000Z"
}
```

##### Errors

- `400 Bad Request` – invalid URL

### Get Link Details

#### Request

- **Endpoint:** `GET /api/v1/links/{slug}`
- **Authenticated:** No
- **Roles:** All
- **Query parameters:** None
- **Path variables:**
  - slug: (string, required)
- **Body:** None

#### Response

- **Status:** `200 OK`
- **Body:**

```json
{
  "id": 1,
  "targetUrl": "https://www.example.org",
  "slug": "abcd1234",
  "shortUrl": "https://sho.rt/abcd1234",
  "createdAt": "2025-08-19T00:00:00.000Z",
  "expiresAt": "2025-08-20T00:00:00.000Z"
}
```

##### Errors

- `404 Not found` – non-existent slug
- `410 Gone` – expired slug

## HTTP Routes

### Redirect

**Base URL:** `/`

#### Request

- **Endpoint:** `GET /{slug}`
- **Authenticated:** No
- **Roles:** All
- **Query parameters:** None
- **Path variables:**
  - slug: (string, required)
- **Body:** None

#### Response

- **Status:** `302 Found`
- **Headers:**
  - Location: https://www.example.org
- **Body:** None

##### Errors

- `404 Not found` - Serves `/404.html`
