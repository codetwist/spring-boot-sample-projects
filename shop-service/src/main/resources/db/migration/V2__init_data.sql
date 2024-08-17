INSERT INTO public.product (name, manufacturer, description) VALUES ('Java in Action 2', 'Java Publishing', '1234');
INSERT INTO public.product (name, manufacturer, description) VALUES ('Jython in Action', 'Python Publishing', 'Python ThisIs');
INSERT INTO public.product (name, manufacturer, description) VALUES ('Go in Action', 'Python Publishing', 'Go ThisIs');
INSERT INTO public.product (name, manufacturer, description) VALUES ('Python in Action', 'Python Publishing', 'Python dddBook');
INSERT INTO public.product (name, manufacturer, description) VALUES ('Go in Action', 'Golang Publishing', 'Go dddBook');

INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.google.com', 1);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.google.com', null);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.yahoo.com', null);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.tesla.com', null);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.tesla.com', 2);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.yahoo.com', 2);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.fff.com', 3);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.dddd.com', 3);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.ss.com', 4);
INSERT INTO public.product_image_location (url, product_id) VALUES ('http://www.ss.com', 4);
