select 
	c.codigo,
	c.nombre_completo,
	sum(d.debito_mone_local) as debito_mone_local,
	sum(d.credito_mone_local) as credito_mone_local,
	0.0 as saldo_anterior,
	0.0 as saldo_debito,
	0.0 as saldo_credito
from cartera.cliente c
inner join cartera.detalle_prove d on d.id_cliente=c.id
--where
group by c.codigo,
	 	 c.nombre_completo