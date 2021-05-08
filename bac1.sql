PGDMP                  	        y           postgres    10.15    10.15 G    K           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            L           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            M           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            N           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    4            �            1259    24609    users    TABLE     A  CREATE TABLE public.users (
    userid bigint NOT NULL,
    username character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    pass character varying(100) NOT NULL,
    usertoken character varying(100),
    registerdate timestamp without time zone NOT NULL,
    usertoken2 character varying(100)
);
    DROP TABLE public.users;
       public         postgres    false    4            �            1255    49588    findalluser()    FUNCTION     �   CREATE FUNCTION public.findalluser() RETURNS SETOF public.users
    LANGUAGE plpgsql
    AS $$
BEGIN
RETURN QUERY 
SELECT * FROM users;
END;
$$;
 $   DROP FUNCTION public.findalluser();
       public       postgres    false    199    4            �            1255    49450    findmaxviewproduct()    FUNCTION       CREATE FUNCTION public.findmaxviewproduct() RETURNS TABLE(productid bigint, cnt bigint)
    LANGUAGE plpgsql
    AS $$
BEGIN
RETURN QUERY 
SELECT view_product.productid , count(*) AS cnt from view_product
NATURAL JOIN product
GROUP BY view_product.productid
ORDER BY cnt DESC;
END;
$$;
 +   DROP FUNCTION public.findmaxviewproduct();
       public       postgres    false    4            �            1259    24695    view_product    TABLE     �   CREATE TABLE public.view_product (
    viewid bigint NOT NULL,
    productid bigint,
    userid bigint,
    viewdate timestamp without time zone NOT NULL
);
     DROP TABLE public.view_product;
       public         postgres    false    4            �            1255    49448    findproductwithmaxview()    FUNCTION     '  CREATE FUNCTION public.findproductwithmaxview() RETURNS SETOF public.view_product
    LANGUAGE plpgsql
    AS $$
BEGIN
RETURN QUERY 
SELECT productid , count(*) AS cnt,product.productname from view_product
NATURAL JOIN product
GROUP BY productid,product.productname 
ORDER BY cnt DESC;
END;
$$;
 /   DROP FUNCTION public.findproductwithmaxview();
       public       postgres    false    203    4            �            1259    24714    user_address    TABLE     �   CREATE TABLE public.user_address (
    addressid bigint NOT NULL,
    userid bigint,
    addresss character varying(200) NOT NULL,
    mobile character(11) NOT NULL,
    postcode character(10),
    viewdate timestamp without time zone NOT NULL
);
     DROP TABLE public.user_address;
       public         postgres    false    4            �            1259    24726    address_addressid_seq    SEQUENCE        CREATE SEQUENCE public.address_addressid_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.address_addressid_seq;
       public       postgres    false    4    205            O           0    0    address_addressid_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE public.address_addressid_seq OWNED BY public.user_address.addressid;
            public       postgres    false    206            �            1259    41090    blog    TABLE     �  CREATE TABLE public.blog (
    blogid bigint NOT NULL,
    summary character varying(2000) NOT NULL,
    page character varying(100) NOT NULL,
    releasedate timestamp without time zone NOT NULL,
    blogcategury1 character varying(100) NOT NULL,
    blogcategury2 character varying(100) NOT NULL,
    blogname character varying(200) NOT NULL,
    metadescription character varying(200),
    metakeyword character varying(200)
);
    DROP TABLE public.blog;
       public         postgres    false    4            �            1259    41098    blog_blogid_seq    SEQUENCE     ~   CREATE SEQUENCE public.blog_blogid_seq
    START WITH 100000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.blog_blogid_seq;
       public       postgres    false    207    4            P           0    0    blog_blogid_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.blog_blogid_seq OWNED BY public.blog.blogid;
            public       postgres    false    208            �            1259    24677    order_product    TABLE     �   CREATE TABLE public.order_product (
    orderid bigint NOT NULL,
    productid bigint,
    userid bigint,
    ordernum integer,
    orderdate timestamp without time zone NOT NULL,
    status character varying(200)
);
 !   DROP TABLE public.order_product;
       public         postgres    false    4            �            1259    24692    order_orderid_seq    SEQUENCE     �   CREATE SEQUENCE public.order_orderid_seq
    START WITH 100000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.order_orderid_seq;
       public       postgres    false    4    201            Q           0    0    order_orderid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.order_orderid_seq OWNED BY public.order_product.orderid;
            public       postgres    false    202            �            1259    24598    product    TABLE     �  CREATE TABLE public.product (
    productid bigint NOT NULL,
    productname character varying(200) NOT NULL,
    productcat1 character varying(50) NOT NULL,
    productcat2 character varying(50) NOT NULL,
    productsummary character varying(2000) NOT NULL,
    productdescription character varying(100) NOT NULL,
    pic1 character varying(100) NOT NULL,
    pic2 character varying(100) NOT NULL,
    pic3 character varying(100) NOT NULL,
    pic4 character varying(100) NOT NULL,
    pic5 character varying(100) NOT NULL,
    pic6 character varying(100) NOT NULL,
    price bigint,
    inputdate timestamp without time zone NOT NULL,
    metadescription character varying(200),
    metakeyword character varying(200)
);
    DROP TABLE public.product;
       public         postgres    false    4            �            1259    24606    product_productid_seq    SEQUENCE     �   CREATE SEQUENCE public.product_productid_seq
    START WITH 100000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.product_productid_seq;
       public       postgres    false    197    4            R           0    0    product_productid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.product_productid_seq OWNED BY public.product.productid;
            public       postgres    false    198            �            1259    49490    sequence    TABLE     k   CREATE TABLE public.sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);
    DROP TABLE public.sequence;
       public         postgres    false    4            �            1259    24614    users_userid_seq    SEQUENCE        CREATE SEQUENCE public.users_userid_seq
    START WITH 100000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.users_userid_seq;
       public       postgres    false    199    4            S           0    0    users_userid_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.users_userid_seq OWNED BY public.users.userid;
            public       postgres    false    200            �            1259    41876 	   view_blog    TABLE     �   CREATE TABLE public.view_blog (
    viewblogid bigint NOT NULL,
    viewblogdate timestamp without time zone,
    blogid bigint,
    userid bigint
);
    DROP TABLE public.view_blog;
       public         postgres    false    4            �            1259    24710    view_viewid_seq    SEQUENCE     ~   CREATE SEQUENCE public.view_viewid_seq
    START WITH 100000
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.view_viewid_seq;
       public       postgres    false    4    203            T           0    0    view_viewid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.view_viewid_seq OWNED BY public.view_product.viewid;
            public       postgres    false    204            �            1259    41850    viewblog_viewblogidid_seq    SEQUENCE     �   CREATE SEQUENCE public.viewblog_viewblogidid_seq
    START WITH 50
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.viewblog_viewblogidid_seq;
       public       postgres    false    4            �
           2604    41100    blog blogid    DEFAULT     j   ALTER TABLE ONLY public.blog ALTER COLUMN blogid SET DEFAULT nextval('public.blog_blogid_seq'::regclass);
 :   ALTER TABLE public.blog ALTER COLUMN blogid DROP DEFAULT;
       public       postgres    false    208    207            �
           2604    24694    order_product orderid    DEFAULT     v   ALTER TABLE ONLY public.order_product ALTER COLUMN orderid SET DEFAULT nextval('public.order_orderid_seq'::regclass);
 D   ALTER TABLE public.order_product ALTER COLUMN orderid DROP DEFAULT;
       public       postgres    false    202    201            �
           2604    24608    product productid    DEFAULT     v   ALTER TABLE ONLY public.product ALTER COLUMN productid SET DEFAULT nextval('public.product_productid_seq'::regclass);
 @   ALTER TABLE public.product ALTER COLUMN productid DROP DEFAULT;
       public       postgres    false    198    197            �
           2604    24728    user_address addressid    DEFAULT     {   ALTER TABLE ONLY public.user_address ALTER COLUMN addressid SET DEFAULT nextval('public.address_addressid_seq'::regclass);
 E   ALTER TABLE public.user_address ALTER COLUMN addressid DROP DEFAULT;
       public       postgres    false    206    205            �
           2604    24616    users userid    DEFAULT     l   ALTER TABLE ONLY public.users ALTER COLUMN userid SET DEFAULT nextval('public.users_userid_seq'::regclass);
 ;   ALTER TABLE public.users ALTER COLUMN userid DROP DEFAULT;
       public       postgres    false    200    199            �
           2604    24713    view_product viewid    DEFAULT     r   ALTER TABLE ONLY public.view_product ALTER COLUMN viewid SET DEFAULT nextval('public.view_viewid_seq'::regclass);
 B   ALTER TABLE public.view_product ALTER COLUMN viewid DROP DEFAULT;
       public       postgres    false    204    203            D          0    41090    blog 
   TABLE DATA               �   COPY public.blog (blogid, summary, page, releasedate, blogcategury1, blogcategury2, blogname, metadescription, metakeyword) FROM stdin;
    public       postgres    false    207   �W       >          0    24677    order_product 
   TABLE DATA               `   COPY public.order_product (orderid, productid, userid, ordernum, orderdate, status) FROM stdin;
    public       postgres    false    201   \Y       :          0    24598    product 
   TABLE DATA               �   COPY public.product (productid, productname, productcat1, productcat2, productsummary, productdescription, pic1, pic2, pic3, pic4, pic5, pic6, price, inputdate, metadescription, metakeyword) FROM stdin;
    public       postgres    false    197   yY       H          0    49490    sequence 
   TABLE DATA               7   COPY public.sequence (seq_name, seq_count) FROM stdin;
    public       postgres    false    211   P\       B          0    24714    user_address 
   TABLE DATA               _   COPY public.user_address (addressid, userid, addresss, mobile, postcode, viewdate) FROM stdin;
    public       postgres    false    205   w\       <          0    24609    users 
   TABLE DATA               c   COPY public.users (userid, username, email, pass, usertoken, registerdate, usertoken2) FROM stdin;
    public       postgres    false    199   �\       G          0    41876 	   view_blog 
   TABLE DATA               M   COPY public.view_blog (viewblogid, viewblogdate, blogid, userid) FROM stdin;
    public       postgres    false    210   �i       @          0    24695    view_product 
   TABLE DATA               K   COPY public.view_product (viewid, productid, userid, viewdate) FROM stdin;
    public       postgres    false    203   k       U           0    0    address_addressid_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.address_addressid_seq', 21351, true);
            public       postgres    false    206            V           0    0    blog_blogid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.blog_blogid_seq', 119000, true);
            public       postgres    false    208            W           0    0    order_orderid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.order_orderid_seq', 121350, true);
            public       postgres    false    202            X           0    0    product_productid_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.product_productid_seq', 121651, true);
            public       postgres    false    198            Y           0    0    users_userid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.users_userid_seq', 124850, true);
            public       postgres    false    200            Z           0    0    view_viewid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.view_viewid_seq', 123100, true);
            public       postgres    false    204            [           0    0    viewblog_viewblogidid_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.viewblog_viewblogidid_seq', 14700, true);
            public       postgres    false    209            �
           2606    41097    blog blog_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.blog
    ADD CONSTRAINT blog_pkey PRIMARY KEY (blogid);
 8   ALTER TABLE ONLY public.blog DROP CONSTRAINT blog_pkey;
       public         postgres    false    207            �
           2606    24681     order_product order_product_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_pkey PRIMARY KEY (orderid);
 J   ALTER TABLE ONLY public.order_product DROP CONSTRAINT order_product_pkey;
       public         postgres    false    201            �
           2606    24605    product product_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (productid);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public         postgres    false    197            �
           2606    49494    sequence sequence_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);
 @   ALTER TABLE ONLY public.sequence DROP CONSTRAINT sequence_pkey;
       public         postgres    false    211            �
           2606    24718    user_address user_address_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT user_address_pkey PRIMARY KEY (addressid);
 H   ALTER TABLE ONLY public.user_address DROP CONSTRAINT user_address_pkey;
       public         postgres    false    205            �
           2606    24720 $   user_address user_address_userid_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT user_address_userid_key UNIQUE (userid);
 N   ALTER TABLE ONLY public.user_address DROP CONSTRAINT user_address_userid_key;
       public         postgres    false    205            �
           2606    24613    users users_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    199            �
           2606    41880    view_blog view_blog_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.view_blog
    ADD CONSTRAINT view_blog_pkey PRIMARY KEY (viewblogid);
 B   ALTER TABLE ONLY public.view_blog DROP CONSTRAINT view_blog_pkey;
       public         postgres    false    210            �
           2606    24699    view_product view_product_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.view_product
    ADD CONSTRAINT view_product_pkey PRIMARY KEY (viewid);
 H   ALTER TABLE ONLY public.view_product DROP CONSTRAINT view_product_pkey;
       public         postgres    false    203            �
           2606    24734 (   order_product fk_order_product_productid    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT fk_order_product_productid FOREIGN KEY (productid) REFERENCES public.product(productid);
 R   ALTER TABLE ONLY public.order_product DROP CONSTRAINT fk_order_product_productid;
       public       postgres    false    2724    201    197            �
           2606    24729 %   order_product fk_order_product_userid    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT fk_order_product_userid FOREIGN KEY (userid) REFERENCES public.users(userid);
 O   ALTER TABLE ONLY public.order_product DROP CONSTRAINT fk_order_product_userid;
       public       postgres    false    201    2726    199            �
           2606    24739 #   user_address fk_user_address_userid    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT fk_user_address_userid FOREIGN KEY (userid) REFERENCES public.users(userid);
 M   ALTER TABLE ONLY public.user_address DROP CONSTRAINT fk_user_address_userid;
       public       postgres    false    2726    205    199            �
           2606    41881    view_blog fk_view_blog_blogid    FK CONSTRAINT     ~   ALTER TABLE ONLY public.view_blog
    ADD CONSTRAINT fk_view_blog_blogid FOREIGN KEY (blogid) REFERENCES public.blog(blogid);
 G   ALTER TABLE ONLY public.view_blog DROP CONSTRAINT fk_view_blog_blogid;
       public       postgres    false    207    2736    210            �
           2606    41886    view_blog fk_view_blog_userid    FK CONSTRAINT        ALTER TABLE ONLY public.view_blog
    ADD CONSTRAINT fk_view_blog_userid FOREIGN KEY (userid) REFERENCES public.users(userid);
 G   ALTER TABLE ONLY public.view_blog DROP CONSTRAINT fk_view_blog_userid;
       public       postgres    false    2726    199    210            �
           2606    24749 &   view_product fk_view_product_productid    FK CONSTRAINT     �   ALTER TABLE ONLY public.view_product
    ADD CONSTRAINT fk_view_product_productid FOREIGN KEY (productid) REFERENCES public.product(productid);
 P   ALTER TABLE ONLY public.view_product DROP CONSTRAINT fk_view_product_productid;
       public       postgres    false    197    2724    203            �
           2606    24744 #   view_product fk_view_product_userid    FK CONSTRAINT     �   ALTER TABLE ONLY public.view_product
    ADD CONSTRAINT fk_view_product_userid FOREIGN KEY (userid) REFERENCES public.users(userid);
 M   ALTER TABLE ONLY public.view_product DROP CONSTRAINT fk_view_product_userid;
       public       postgres    false    2726    199    203            �
           2606    24682 *   order_product order_product_productid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);
 T   ALTER TABLE ONLY public.order_product DROP CONSTRAINT order_product_productid_fkey;
       public       postgres    false    2724    197    201            �
           2606    24687 '   order_product order_product_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 Q   ALTER TABLE ONLY public.order_product DROP CONSTRAINT order_product_userid_fkey;
       public       postgres    false    201    2726    199            �
           2606    24721 %   user_address user_address_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_address
    ADD CONSTRAINT user_address_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 O   ALTER TABLE ONLY public.user_address DROP CONSTRAINT user_address_userid_fkey;
       public       postgres    false    199    2726    205            �
           2606    24700 (   view_product view_product_productid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.view_product
    ADD CONSTRAINT view_product_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);
 R   ALTER TABLE ONLY public.view_product DROP CONSTRAINT view_product_productid_fkey;
       public       postgres    false    203    197    2724            �
           2606    24705 %   view_product view_product_userid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.view_product
    ADD CONSTRAINT view_product_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(userid);
 O   ALTER TABLE ONLY public.view_product DROP CONSTRAINT view_product_userid_fkey;
       public       postgres    false    2726    203    199            D   �  x�mRKn�0]�S�AI�������l�J�T�8 ��"���X�Wѓ��e��U�|����������8�d����)�fH��HІ����� �}�Ҕ�Ì6f� l�mV��7��5)A
 �%�\(���64/���r��`�9�'K�18HZ	���v��� ���7���LsB����W#��0��tM����#�\��?.�3|i�L�)K3�1����q�E^#� F���炾l�h�>2ͱ8hްE��N(����I@]R���[�)LLi�wRv�a�H���ˋ����G�s�[n�7��[m��R�6�q�^�^���j�W�+E���ylG���yxw���ou��v�#�״c�0��s2�Z��؛iG��'�ԟ���B����z      >      x������ � �      :   �  x����k�Fǟ�b0Z������1�=�+��Q'/�/���NX9��L���8�?L�q�@���CJ���9�M�iHI�f����səH�G���yw޿��w����u}�V1��_�ѓ�Q\29N���\@�>����6���U�l1�e9���[�)�����ՠܽ�^t����9�+�yk.�W�m�e~{=�4m}?.���zy���-�U�����2�KuUe�M��n��2o�#��}CH�?�/?�Vv�E����?�.���[��4��E+��^�A��NA% ��;��<2�������7�\����v�����F��S��������1�A]NS�mu'�e̿��B�s��Y���Ewyc}���A�s�z䨴����ep\��j ���)U;����i�X���q;G�jH0��y0�E�U�O���o�O��&錚G�H]$���od?��7'��a�g����{���;���M��k������j�n�C���O���O���e�1���S�.uh�ɱ0���J�s��(m�T����;FA)Cf�7.ͥE�7�ـ"Ue�2�2��VޱD[9��KcFJ!Ek�s��ۧEH�eR�BaT1�,҈��=�tn�4��KCF��J�I�F�Li�,�>�Im�GQ�HLY�^*�F�h��u1�ث�&8�#��ň��C�Tr�O���pmm�o�`i      H      x�v�ww��4������ T      B      x������ � �      <   �  x��Y[���n�B`��d����	|��la�+i�􎬩险��P0%t4;�>	���/v��֟��^��8�A�i,�b��Zõ>�\�
�y#O���B��N|�4���|`��������}�R<���tnN�`�F+���=��=��!=�S���1�}w�c�oS\��;|JqE�Œ̵���X?{��i���e�1��v^x����g,��w�y��%�<�R�'|*��7~��Ų�i��]�i;�+��G�g��s<��=�慞�٣��|�o�eGA�%�k��{e�j�nǐǜ��	?�=���������o���|%��5/���!�S0�Rl)�zFOw.[,W�/ws���qt]c�a����8��&i��o���}�ǰi9��⯀�:mp�	�M*c�^�܇�<3�[��L��F����2+����+��5)�#��K�����>��� Rj(^]�<Y`^(���2R=�{�-y=���yº�v^w�~t?�����1w�sdl,�?HY%�3�X���|�kr.�L	�glhE]�Gm�ޚ���������s����`��)�JI�:�.�^Gϫ4�lJ����:߾}�����^;��	;9zu��w�ԡ��}:�Q�.=zHK�(�~��w�>0&�RWNz c��zM P,�)�D�=��F�<��V�i�>��̡�l#	u_�B�Zuh�PV!g>�'(㫚G��?�ۇ��GN�d�jt'WC��hN��T��[I�O�}Z|�"e���	��D�>*�}�	J���1o�EYb�T��CKsFG>�f��r��IaK%L�^��0��E})�^�x�4�w0�(:���Z���3����~N�%��/Wkt�we��F�NNj�}|��ܙ��Rc�����&�1aiˮ<[$E�%���
��_�aj��f�E�Z²�oJ����d�Wo97�_���$�C�Ę���w�ޠ�GA�Q
��--8E�8�2Th��}���~�ğ�i��?��T]���(���}Z}p}�6���ѓu<���b����]o����A���e��f�#)�zi1��@��n��P������m�ի��u���s-'��	���3##*t&e#L	������KJ5�i=H�*�]��\`&2��Ĺs鑄<"���G٥j���	0|{�Ùr�[<x�LYJ���B��XRzS���G�[X����l5%d��k��i�sy���`���"�;�y���A�T5"K5�Ȍ'`h-#9�>�����O��,��=���Mnt��%��(ʔ�[J� g��*��Ņ����˳Y�
�i-�2G�֑����p�E0�Zkv�Yv�G�ۤzW�5��!��L}nEK�\m8D�MU�W�he��	,���`Q'�O��NInF� ��m̊�)QµF��WWxPN%���M�=��"� �ۯ_��zS�_�(v�F���S*c"�ʈ�Rt�7��H�1?Я��ꨑ�9��c�kL�J+��4�G`�|�J�������wEM
bDi�1et=Ǥ��C�kp�G�0�~��aכr��G3e�=|>�ނ���(�zfNS��������/Z�����"ߠ�m+&C�%a�&`�{V��&X^���_���f�_�Q_�XEa*��\	S�>v�0�	����o	;��m�0t�6\#�N���t��k׎�~{���gai��a8G4�ÑB �{��Y.�?��?X��%���#4hI�=iz˘o�jIy�`/K�A�h4Wi:������a�iBc���Fi�yi�r0B�CvuY"1t`�CH�u����ƫV}F^`6��~ _�>�8�#b:�����>���Ki�
2�|���#��u�t�g8`���tZL6F߸+�E�;`�Lv��G��hR��z�	�e�懼XF�%o�m{�1�Ǟ]0��7��N�Cx�z��[oy�K��nğm�0n�d��nA�'k(L3�Cr�D�+���0�����[���o�|�yi�^9�Vۊ1?6DuW������k���8� �>��H��+���@�D�@�cF?(c�[�q)y��;`bIC˱y�Z{��V���hZ����μ� ]GӼ�+�y{��bxn���k�z��?ٍ���5���:f�
��#���3�#��F����&�6��n;&��@Ӓ#����:'�[��ny?={jO�/�w���x�����;1�3�8�
���==}�oo��c�)��lŊ��Z�<��k�g�x�B�-�1I�N�v�qTE(E��`�T����	�����H~�^|�N*$�c\s�����t�W�6��A�1�4�M�ʎ�.Y��!�޾S�� ��,�(PG���Vy��_q$u�$����ά��p�\q׎$�<�
�-�0"f�ّ���`V��8��<\&�!�t7�KV���h����Uz;�� w`��õ%�l� ���/� ��%�D�����z�'A�s���ك�ى%�b�2b�UP�N�}��}�у��%Ƹ��q���2"H����fޓ�棑�����>�э���y���O#��T�	L�����W��cu�\�3���:���P����t�'����o��#��:�I�f�`���s�#���귒^j|m�#a��]*&��b�k~,�/�1�����| �����[G��b�.#Gi#;�n��Zh�753�({��r _7D�r�l)qS��B��EL�J��?�~��|���|���"���+V�#�H��b_N���^��uG3Dmdi���1s5���JC/�8�������Mả��nk�P�G'�B� �{�`\8�i�G�uKc��X��0�X�4ٻ$���C;G���uK�ʶK���yz��"�����f*g`�gP:p�K\Ѷ�΃���8��صI�q��o�K�{2)�c�6&6y���P�6��=\v�Ny�M&;0�!���?f�\y�s�N�I*���=�����i�q�D��z��1uC�6�3#U����o�#�M� 1q�H����c��BC���Ӓ��U)L����Pc�`��U�!��Y�th�������:z𬾾e�	��h�:9���d;*�&�h
�����̄+g��H\�u���yt0��-DX��2@���3p�#���u�����{)F��+v�G�?~%)��Ζ��M� �|��|���o�^����������@|��+*�/��϶�-�����J�6��Ҽ�����#�b�o���ۧO���Z��      G   g  x���[��0��f�@����t����iji>-��Z��q3z02=ў�'�@`b"f���F���^R�L����j�f����!uLS�@����i����j�Y�`��{�i�7�B��b�C��i���r@N�A<P@e_uR.�Ѿj�= =I��@�6g���_�k�u��_��5�zo���rm��V�}�~�
.j{a����^X�V���.����ײ��"�V�m�m�l�WDC��Y��̆�z�-Vo�X�ma�������c-[m��m��^[���������6j�KX�$����'����0rJwZ.-qJaZ����VۡIjδV��¶�z9��v�L��qa{m%�lڨ��8�`�L�      @   t  x����m�0��z
/P��Q�,��RQZ�)� ��8�'����a�'�'�):�M�q M���)2�ӂ����~������K�L��+��-=mK�c�I�-|�����xj�/���� �s��ӄ`��_8�����$kp�D�V3r�,����`��F������� 5�XK�<�ix,|��+�Ib%�"��ce��qf��=��j$�\�<���Ji=�2HW��c�f��6��] �ܞ1��6+r���j�[�?/#j��C����N�����ɾp�-�2ٓQ-0qT��> �&�չ����6h��@�7�W��Z�I��P�oh?�W1n��f~ା5��o3o��������8�"     