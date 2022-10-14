-- DROP DATABASE IF EXISTS minhasrecipes;

-- CREATE DATABASE minhasrecipes;

CREATE SEQUENCE tb_category_id_seq START 1 INCREMENT 1;
CREATE TABLE tb_category (
    category_id INTEGER NOT NULL DEFAULT nextval('tb_category_id_seq'),
    description VARCHAR(50) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (category_id)
);

CREATE TABLE tb_unit (
    abbr VARCHAR(3) NOT NULL,
    description VARCHAR(20) NOT NULL,
    CONSTRAINT pk_unit PRIMARY KEY (abbr)
);

CREATE SEQUENCE tb_product_id_seq START 1 INCREMENT 1;
CREATE TABLE tb_product (
    product_id INTEGER NOT NULL DEFAULT nextval('tb_product_id_seq'),
    description VARCHAR(100) NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (product_id)
);

CREATE SEQUENCE tb_user_id_seq START 1 INCREMENT 1;
CREATE TABLE tb_user (
    user_id INTEGER NOT NULL DEFAULT nextval('tb_user_id_seq'),
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    creation_date TIMESTAMP,
    update_date TIMESTAMP,
    exclusion_date TIMESTAMP,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);


CREATE SEQUENCE tb_recipe_id_seq START 1 INCREMENT 1;
CREATE TABLE tb_recipe (
    recipe_id INTEGER NOT NULL DEFAULT nextval('tb_recipe_id_seq'),
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    preparationTime INTEGER NOT NULL,
    portion INTEGER NOT NULL,
    creation_date TIMESTAMP,
    update_date TIMESTAMP,
    exclusion_date TIMESTAMP,
    user_id INTEGER NOT NULL,
    category_id INTEGER,
    CONSTRAINT pk_recipe PRIMARY KEY (recipe_id),
    CONSTRAINT fk_recipe_user FOREIGN KEY (user_id) REFERENCES tb_user(user_id),
    CONSTRAINT fk_recipe_category FOREIGN KEY (category_id) REFERENCES tb_category(category_id)
);

CREATE SEQUENCE tb_ingredient_id_seq START 1 INCREMENT 1;
CREATE TABLE tb_ingredient (
    ingredient_id INTEGER NOT NULL DEFAULT nextval('tb_ingredient_id_seq'),
    amount NUMERIC(11,2) NOT NULL,
    abbr_unit VARCHAR(3) NOT NULL,
    product_id INTEGER NOT NULL,
    CONSTRAINT pk_ingredient PRIMARY KEY (ingredient_id),
    CONSTRAINT fk_ingredient_product FOREIGN KEY (product_id) REFERENCES tb_product(product_id),
    CONSTRAINT fk_ingredient_unit FOREIGN KEY (abbr_unit) REFERENCES tb_unit(abbr)
);

CREATE TABLE tb_ingredient_recipe (
    ingredient_id INTEGER NOT NULL,
    recipe_id INTEGER NOT NULL,
    CONSTRAINT fk_ingredient_recipe_ingredient FOREIGN KEY (ingredient_id) REFERENCES tb_ingredient(ingredient_id),
    CONSTRAINT fk_ingredient_recipe_recipe FOREIGN KEY (recipe_id) REFERENCES tb_recipe(recipe_id)
);

CREATE TABLE tb_rating (
    recipe_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    score INTEGER NOT NULL,
    CONSTRAINT pk_rating PRIMARY KEY (user_id, recipe_id),
    CONSTRAINT fk_rating_recipe FOREIGN KEY (recipe_id) REFERENCES tb_recipe(recipe_id),
    CONSTRAINT fk_rating_user FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE SEQUENCE tb_comment_id_seq START 1 INCREMENT 1;
CREATE TABLE tb_comment (
    comment_id INTEGER NOT NULL DEFAULT nextval('tb_comment_id_seq'),
    title VARCHAR(100) NOT NULL,
    comment_desc VARCHAR(255) NOT NULL,
    recipe_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    creation_date TIMESTAMP,
    exclusion_date TIMESTAMP,
    CONSTRAINT pk_comment PRIMARY KEY (comment_id),
    CONSTRAINT fk_comment_recipe FOREIGN KEY (recipe_id) REFERENCES tb_recipe(recipe_id),
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE tb_method_preparation (
    "order" INTEGER NOT NULL,
    recipe_id INTEGER NOT NULL,
    description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_method_preparation PRIMARY KEY (recipe_id, "order"),
    CONSTRAINT fk_method_preparation_recipe FOREIGN KEY (recipe_id) REFERENCES tb_recipe(recipe_id)
);

CREATE TABLE tb_favorite_recipes (
    recipe_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT fk_favorite_recipes_recipe FOREIGN KEY (recipe_id) REFERENCES tb_recipe(recipe_id),
    CONSTRAINT fk_favorite_recipes_user FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);
