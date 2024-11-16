# cooking-lab-personal-recipe-api

## API Endpoints

### Get Personal Recipes

**Endpoint:** `/api/recipes/personal`

**Method:** `GET`

**Description:** This endpoint retrieves personal recipes. If the `owner` parameter is provided, it filters recipes by the specified owner. If the `owner` parameter is not provided, it returns all recipes.

**Parameters:**

- `owner` (optional): The owner of the recipes to filter by.

**Example Request:**

```sh
GET /api/recipes/personal?owner=tm
```

**Example Response:**

```json
[
  {
    "title": "Chicken parmesan",
    "ingredients": ["Chicken"],
    "instructions": ["Buy Chicken"],
    "owner": "tm"
  },
  {
    "title": "Beef stew",
    "ingredients": ["Beef"],
    "instructions": ["Buy Beef"],
    "owner": "tm"
  }
]
```
