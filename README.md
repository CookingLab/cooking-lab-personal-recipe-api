# cooking-lab-personal-recipe-api

This API exposes our personal recipes for Cooking Lab.

## Installation 🛠️

To install this project, follow the steps below:

1. Clone the project:
    ```sh
    git clone https://github.com/CookingLab/cooking-lab-personal-recipe-api.git
    ```

2. Navigate to the project directory:
    ```sh
    cd cooking-lab-personal-recipe-api
    ```

3. Install the dependencies:
    ```sh
    ./mvnw install
    ```
   If you get **./mvnw: Permission denied** error, run the following command line:
   ```sh
   chmod +x ./mvnw
   ./mvnw install
   ```

4. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

The application should now be running on `http://localhost:8080`.

## API Endpoints

### Get Personal Recipes

**Endpoint:** `/api/recipes/personal`

**Method:** `GET`

**Description:** This endpoint retrieves personal recipes. It supports filtering recipes based on the `owner` query parameter or the `id` path parameter. If neither is provided, it returns all recipes. Only one of the two parameters can be specified per request.

**Parameters:**

- `owner` (optional): The owner of the recipes to filter by.
- `id` (optional): Unique ID of the recipe (specified as a path parameter).

**Behavior:**

- If the `owner` parameter is provided, the endpoint filters recipes by the specified owner.
- If the `id` path parameter is provided, the endpoint filters recipes by the specified ID.
- If neither parameter is provided, the endpoint returns all recipes.
- If an error occurs (e.g., invalid parameters, service issues), the API returns appropriate HTTP status codes and error messages.

---

### Status Codes

| **Status Code**         | **Description**                                                                 |
|--------------------------|---------------------------------------------------------------------------------|
| **200 OK**              | Request was successful, and the recipes are returned.                         |
| **400 Bad Request**     | The request is invalid, such as when the `id` is null or malformed.            |
| **404 Not Found**       | No recipes were found for the given `owner` or `id`, or there are no recipes.  |
| **500 Internal Server Error** | An unexpected error occurred while processing the request.               |

---

### Example Requests and Responses

#### Get Recipe by Owner
```sh
  GET /api/recipes/personal?owner=tm
```

**Example Response:**

```json
[
  {
    "id": 1,
    "title": "Chicken parmesan",
    "ingredients": ["Chicken"],
    "instructions": ["Buy Chicken"],
    "owner": "tm",
    "imageURL": "https://cooking-lab-personal-recipe-api.onrender.com/images/chicken-parmesan.jpg"
  },
  {
    "id": 2,
    "title": "Beef stew",
    "ingredients": ["Beef"],
    "instructions": ["Buy Beef"],
    "owner": "tm",
    "imageURL": "https://cooking-lab-personal-recipe-api.onrender.com/images/beef-stew.jpg"
  }
]
```

### Example Request:

#### Get recipe by id
```sh
  GET /api/recipes/personal/1
```

### Example Response:

```json
[
  {
    "id": 1,
    "title": "Chicken parmesan",
    "ingredients": ["Chicken"],
    "instructions": ["Buy Chicken"],
    "owner": "tm",
    "imageURL": "https://cooking-lab-personal-recipe-api.onrender.com/images/chicken-parmesan.jpg"
  }
]
```
