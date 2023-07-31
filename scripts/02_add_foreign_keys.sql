ALTER TABLE public.apps
ADD CONSTRAINT fk_apps_categories FOREIGN KEY (category_id) REFERENCES public.categories (id);

ALTER TABLE public.reviews
ADD CONSTRAINT fk_reviews_apps FOREIGN KEY (app_id) REFERENCES public.apps (id);
