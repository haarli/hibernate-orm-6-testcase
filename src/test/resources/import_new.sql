
INSERT INTO public.organization (objectid, name, parentorganization_objectid) VALUES ('ou_1', 'Org 1', NULL);
INSERT INTO public.organization (objectid, name, parentorganization_objectid) VALUES ('ou_2', 'Org 2', 'ou_1');
INSERT INTO public.organization (objectid, name, parentorganization_objectid) VALUES ('ou_3', 'Org 3', NULL);

INSERT INTO public.organization_predecessor (organization_objectid, predecessororganizations_objectid) VALUES ('ou_1', 'ou_3');

INSERT INTO public.user_account (objectid, name, organization_objectid) VALUES ('user_1', 'User 1', 'ou_2');
INSERT INTO public.user_account (objectid, name, organization_objectid) VALUES ('user_2', 'User 2', 'ou_2');