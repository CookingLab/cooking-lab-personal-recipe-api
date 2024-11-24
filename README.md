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

**Description:** This endpoint retrieves personal recipes. If the `owner` parameter is provided, it filters recipes by the specified owner. If the `owner` parameter is not provided, it returns all recipes.   
If the `id` parameter is provided, it filters recipes by the specified id. If the `id` parameter is not provided, it returns all recipes.   
Only one of the 2 parameters can be specified.   

**Parameters:**

- `owner` (optional): The owner of the recipes to filter by.
- `id` (optional): Unique id of the recipe.

**Example Request:**

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

**Example Request:**

```sh
GET /api/recipes/personal?id=1
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
  }
]
```
