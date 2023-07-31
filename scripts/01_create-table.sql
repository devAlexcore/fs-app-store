CREATE TABLE public.categories (
    id uuid NOT NULL,
    "name" varchar(255) NOT NULL,
    CONSTRAINT categories_pkey PRIMARY KEY (id)
);

CREATE TABLE public.apps (
    id uuid NOT NULL,
    average_rating float8 NULL,
    description varchar(255) NOT NULL,
    developer_company varchar(255) NOT NULL,
    image varchar(255) NULL,
    installed boolean,
    "name" varchar(255) NOT NULL,
    price float8 NOT NULL,
    category_id uuid NOT NULL,
    CONSTRAINT apps_pkey PRIMARY KEY (id)
);

CREATE TABLE public.reviews (
    id uuid NOT NULL,
    "comment" varchar(255) NOT NULL,
    app_id uuid NOT NULL,
    CONSTRAINT reviews_pkey PRIMARY KEY (id)
);