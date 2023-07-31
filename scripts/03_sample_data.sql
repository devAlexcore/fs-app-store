INSERT INTO public.categories (id, name)
VALUES
('de305d54-75b4-431b-adb2-eb6b9e546014', 'Social'),
('6ecd8c99-4036-403d-bf84-c2f8422ae837', 'Games'),
('63c3d3ec-334d-41f3-a4d7-575e4e8ef9a9', 'Entertainment'),
('16ee58bd-3b99-4dac-a28f-492a1f173bcb', 'Music & Audio'),
('7495e677-c810-4b3b-acc7-022b8e1e27f3', 'Photography'),
('f79a007a-1c63-4b76-8f4a-e6bf1ee518e9', 'Maps & Navigation');

INSERT INTO public.apps (id, average_rating, description, developer_company, image, installed, "name", price, category_id)
VALUES
('5a74cfea-d567-41c1-9085-755bf7f51005'::uuid, 2.5, 'La aplicación de Facebook te ayuda a mantener el contacto con amigos y a encontrar a otros que compartan tus intereses.', 'Meta Platform, Inc.', 'https://cdn.icon-icons.com/icons2/2890/PNG/512/apps_social_media_facebook_logo_social_network_media_online_icon_182716.png', true, 'Facebook', 5.0, 'de305d54-75b4-431b-adb2-eb6b9e546014'::uuid),
('a16343b5-87e1-4c8f-8c17-02c5a0a253c1'::uuid, 4.0, 'The PvP MOBA gameplay of League of Legends by Riot Games arrives on mobile in League of Legends: Wild Rift!', 'Riot Games, Inc', 'https://dl.memuplay.com/new_market/img/com.riotgames.league.wildrift.icon.2023-07-19-09-33-17.png', false, 'Wild Rift', 0.0, '6ecd8c99-4036-403d-bf84-c2f8422ae837'::uuid),
('9514d586-a9c0-4fa4-bd49-3433367fc703'::uuid, 1.0, 'reate your dream house, build stories for your characters and play in your way!', 'Toca Life', 'https://dl.memuplay.com/new_market/img/com.tocaboca.tocalifeworld.icon.2023-07-11-02-14-22.png', false, 'Toca Life: World', 1.0, '6ecd8c99-4036-403d-bf84-c2f8422ae837'::uuid),
('79583cae-0cfe-41d0-b949-2e68679f7d20'::uuid, 3.0, 'Music application', 'Spotify, Inc.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Spotify_logo_without_text.svg/2048px-Spotify_logo_without_text.svg.png', false, 'Spotify', 0.0, '16ee58bd-3b99-4dac-a28f-492a1f173bcb'::uuid),
('7bdb674b-9fc8-4564-8752-56c26c498651'::uuid, 2.0, 'Music application', 'Tune, Inc.', 'https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/tunein-icon.png', false, 'TuneIn', 0.0, '16ee58bd-3b99-4dac-a28f-492a1f173bcb'::uuid),
('a80aff73-4d15-4171-96b4-f5cb6ca9e377'::uuid, 4.0, 'Series, Tv Show under demand', 'Netflix, Inc.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Netflix_icon.svg/2048px-Netflix_icon.svg.png', false, 'Netflix', 0.0, '63c3d3ec-334d-41f3-a4d7-575e4e8ef9a9'::uuid),
('c607f5a1-b7e5-4a4a-8052-5a65cd05a0d6'::uuid, 4.5, 'Comparte tus fotos y videos, y descubre cuentas de todo el mundo que están compartiendo cosas que te encantarán.', 'Instagram', 'https://upload.wikimedia.org/wikipedia/commons/5/58/Instagram-Icon.png', false, 'Instagram', 10.0, 'de305d54-75b4-431b-adb2-eb6b9e546014'::uuid),
('01b09a15-dae7-4bac-8b58-37ba9a53930a'::uuid, 3.0, 'Twitter es un servicio que permite que los grupos de amigos, familiares y compañeros de trabajo se comuniquen y estén en contacto a través de mensajes rápidos y frecuentes.', 'Twitter', 'https://upload.wikimedia.org/wikipedia/commons/6/6f/Logo_of_Twitter.svg', false, 'Twitter', 2.0, 'de305d54-75b4-431b-adb2-eb6b9e546014'::uuid),
('16e6a5fd-54d5-4a67-9c27-2a98f8b3f020'::uuid, 2.0, 'La aplicación de Whatsapp te ayuda a mantener el contacto con amigos.', 'Whatsapp', 'https://upload.wikimedia.org/wikipedia/commons/b/b2/WhatsappLogo.svg', true, 'Whatsapp', 10.0, 'de305d54-75b4-431b-adb2-eb6b9e546014'::uuid),
('e3b6b2a6-7a99-4fe2-9b78-c09f8c3a1a2b'::uuid, 4.5, 'La aplicación de Telegram te ayuda a mantener el contacto con amigos.', 'Telegram', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Telegram_alternative_logo.svg/256px-Telegram_alternative_logo.svg.png', false, 'Telegram', 0.0, 'de305d54-75b4-431b-adb2-eb6b9e546014'::uuid),
('c79c8f3e-19c9-4163-9473-2c4a92f77a90'::uuid, 3.0, 'Photo editor', 'Adobe, Inc.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Adobe_Photoshop_Express_logo.svg/640px-Adobe_Photoshop_Express_logo.svg.png', false, 'Photoshop', 20.0, '7495e677-c810-4b3b-acc7-022b8e1e27f3'::uuid),
('ae4ba9cf-dbf7-4e2e-bb5e-3d7751022842'::uuid, 4.5, 'Routes, maps with your location', 'Waze, Crop.', 'https://www.traveloffpath.com/wp-content/uploads/2018/05/waze-logo.png', true, 'Waze', 0.0, 'f79a007a-1c63-4b76-8f4a-e6bf1ee518e9'::uuid);

INSERT INTO public.reviews (id, comment, app_id)
VALUES
('63cd3d77-cc5e-4e2e-8f57-8c78c1305c65', 'Muy buena aplicación.', '5a74cfea-d567-41c1-9085-755bf7f51005'),
('7c25c490-4209-49db-bc0e-32a4258dbf5b', 'Excelente para mantenerse en contacto con amigos.', 'c607f5a1-b7e5-4a4a-8052-5a65cd05a0d6'),
('98c9cc1d-bc52-48b2-a465-0aa0f2e3ce64', 'Puede mejorar.', '01b09a15-dae7-4bac-8b58-37ba9a53930a'),
('d5ad2365-1137-4f15-9e73-8fe94931c779', '¡Lo uso todos los días!', '16e6a5fd-54d5-4a67-9c27-2a98f8b3f020'),
('77fd616d-c5f1-45e9-a7c7-3974d4f44f1b', '¡Fantástico juego de estrategia!', 'e3b6b2a6-7a99-4fe2-9b78-c09f8c3a1a2b'),
('60911e79-c06a-4374-9f26-b293a9ad36f3', 'Muy buena aplicación. sigan asi', '5a74cfea-d567-41c1-9085-755bf7f51005'),
('07c3e6a2-40dd-4311-a9d3-3f00ab2255a1', 'Me encanta esta aplicación', '9514d586-a9c0-4fa4-bd49-3433367fc703'),
('31e16c1e-717f-4e6f-8c8c-b88a7e0da6af', 'Buena aplicación para niños', '9514d586-a9c0-4fa4-bd49-3433367fc703'),
('0fca5c81-33a1-4ea3-ae2f-c47799048246', 'Gran variedad de estaciones de radio', '7bdb674b-9fc8-4564-8752-56c26c498651'),
('a4f76d66-05c5-4f55-8f64-eb0d79c70f3f', 'Muy útil para escuchar podcasts', '7bdb674b-9fc8-4564-8752-56c26c498651'),
('e18b3c88-1a17-486a-81ca-7e974efc9925', 'Excelentes gráficos y jugabilidad', 'a16343b5-87e1-4c8f-8c17-02c5a0a253c1'),
('94b9303a-1e9a-4911-9af6-2a312437d70e', 'Me gusta jugar en mi tiempo libre', 'a16343b5-87e1-4c8f-8c17-02c5a0a253c1'),
('f69d54e9-2317-4373-b014-4e811b170a4f', 'Me gusta mantenerme conectado con amigos', '5a74cfea-d567-41c1-9085-755bf7f51005'),
('e9a1b83c-68c1-4396-83dd-5a99a71970d1', 'La uso todos los días para estar al tanto', '5a74cfea-d567-41c1-9085-755bf7f51005'),
('021a06eb-498b-44b5-91ad-29ac3bc5e7c2', 'Gran selección de música', '79583cae-0cfe-41d0-b949-2e68679f7d20'),
('c5d693b5-36a7-46bf-b383-6329f2f74b9e', 'Buena calidad de sonido', '79583cae-0cfe-41d0-b949-2e68679f7d20'),
('5630c382-46df-44fb-b9ac-3e801f20ef6f', 'Gran catálogo de series y películas', 'a80aff73-4d15-4171-96b4-f5cb6ca9e377'),
('964675b2-1869-4ab9-8f65-e6eb48a2a5fc', 'Me encanta ver contenido original', 'a80aff73-4d15-4171-96b4-f5cb6ca9e377'),
('3c4a112a-58b3-4f95-8c2f-42f4cb48bbab', 'La uso para mantenerme en contacto con la familia', '16e6a5fd-54d5-4a67-9c27-2a98f8b3f020'),
('7e0f8141-2ff1-4f57-81b2-50f5c3078d9e', 'Es una aplicación confiable', '16e6a5fd-54d5-4a67-9c27-2a98f8b3f020'),
('b9d1f0fb-c12d-47c8-9f9c-df5e3635c18e', 'Buena alternativa para la mensajería', 'e3b6b2a6-7a99-4fe2-9b78-c09f8c3a1a2b'),
('27a25b2d-e211-409b-87ca-21803a6d90bb', 'Me gusta su función de chats secretos', 'e3b6b2a6-7a99-4fe2-9b78-c09f8c3a1a2b');