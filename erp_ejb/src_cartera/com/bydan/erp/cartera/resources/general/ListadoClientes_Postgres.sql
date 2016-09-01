select 	
		(select nombre from seguridad.zona where id=c.id_zona)as nombre_zona,
		(select nombre from seguridad.ciudad where id=c.id_ciudad)as nombre_ciudad,
		c.codigo,
		c.nombre,
		c.apellido,	
		c.ruc,
		(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id_ciudad)as telefonos,
		(select string_agg(direccion,',') from cartera.direccion where id_cliente=c.id_ciudad)as direcciones,
		(select string_agg(e_mail,',') from cartera.e_mail where id_cliente=c.id_ciudad)as emails,
		(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente)as nombre_grupo_cliente

from cartera.cliente c

--where