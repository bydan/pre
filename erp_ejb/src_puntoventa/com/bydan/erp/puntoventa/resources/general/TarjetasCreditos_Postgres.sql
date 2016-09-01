select
	(select nombre from puntoventa.tarjeta_credito t where id=f.id_tarjeta_credito)as nombre_tarjeta,
	f.lote,
	f.fecha,
	sum(valor) as total,
	f.id_tarjeta_credito
	
from puntoventa.forma_pago_tarjeta_pun_ven f

--where

group by id_tarjeta_credito,
	 	lote,
	 	fecha