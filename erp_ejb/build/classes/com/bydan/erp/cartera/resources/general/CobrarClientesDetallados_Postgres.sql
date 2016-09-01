select 
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente) as nombre_grupo_cliente,
	(select nombre from cartera.titulo_cliente where id=c.id_titulo_cliente) as nombre_titulo_cliente,
	c.codigo,
	c.nombre,
	c.apellido,
	c.ruc,
	(select max(nombre) from facturacion.contacto_cliente where id_cliente=c.id) as nombre_contacto_cliente,
	(select string_agg(direccion,',') from cartera.direccion where id_cliente=c.id) as direccion_direccion,
	(select string_agg(e_mail,',') from cartera.e_mail where id_cliente=c.id) as e_mail_e_mail,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono
from cartera.cliente c
--where