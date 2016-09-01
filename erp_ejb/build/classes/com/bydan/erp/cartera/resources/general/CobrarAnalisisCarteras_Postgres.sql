select 
	(select nombre from cartera.tipo_radio_venci where id=r.id_tipo_radio_venci) as nombre_tipo_radio_venci,
	r.dia_desde,
	r.dia_hasta
from cartera.radio_venci_cliente_prove r
--where