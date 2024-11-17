# cooking-lab-personal-recipe-api

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
    "owner": "tm"
  },
  {
    "id": 2,
    "title": "Beef stew",
    "ingredients": ["Beef"],
    "instructions": ["Buy Beef"],
    "owner": "tm"
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
    "owner": "tm"
  }
]
```
