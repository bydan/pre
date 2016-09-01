/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.tesoreria.business.entity.report;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.tesoreria.util.PagosAutorizadosConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PagosAutorizados extends PagosAutorizadosAdditional implements Serializable ,Cloneable {//PagosAutorizadosAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private PagosAutorizados pagosautorizadosOriginal;
	
	private Map<String, Object> mapPagosAutorizados;
			
	public Map<String, Object> getMapPagosAutorizados() {
		return mapPagosAutorizados;
	}

	public void setMapPagosAutorizados(Map<String, Object> mapPagosAutorizados) {
		this.mapPagosAutorizados = mapPagosAutorizados;
	}
	
	public void inicializarMapPagosAutorizados() {
		this.mapPagosAutorizados = new HashMap<String,Object>();
	}
	
	public void setMapPagosAutorizadosValue(String sKey,Object oValue) {
		this.mapPagosAutorizados.put(sKey, oValue);
	}
	
	public Object getMapPagosAutorizadosValue(String sKey) {
		return this.mapPagosAutorizados.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_corte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXNUMERO_FACTURA,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXNOMBRE_BANCO,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXNOMBRE_BANCO)
	private String nombre_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_por_pagar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cancelado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXNUMERO_CUENTA,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_autorizado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXDESCRIPCION,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_corte_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXESTADO,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXESTADO)
	private String estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXCODIGO_CUENTA_CON_CLIENTE,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA_CON_CLIENTE)
	private String codigo_cuenta_con_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosConstantesFunciones.SREGEXCODIGO_CUENTA_CON_BANCO,message=PagosAutorizadosConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA_CON_BANCO)
	private String codigo_cuenta_con_banco;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public PagosAutorizados () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pagosautorizadosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.fecha_corte=new Date();
 		this.nombre_cliente="";
 		this.numero_factura="";
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.nombre_banco="";
 		this.valor_por_pagar=0.0;
 		this.valor_cancelado=0.0;
 		this.numero_cuenta="";
 		this.esta_autorizado=false;
 		this.descripcion="";
 		this.fecha_corte_dato=new Date();
 		this.estado="";
 		this.codigo_cuenta_con_cliente="";
 		this.codigo_cuenta_con_banco="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PagosAutorizados (Long id,Date versionRow,String nombre_cliente,String numero_factura,Date fecha_emision,Date fecha_vencimiento,String nombre_banco,Double valor_por_pagar,Double valor_cancelado,String numero_cuenta,Boolean esta_autorizado,String descripcion,Date fecha_corte_dato,String estado,String codigo_cuenta_con_cliente,String codigo_cuenta_con_banco) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagosautorizadosOriginal=this;
		
 		this.nombre_cliente=nombre_cliente;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.nombre_banco=nombre_banco;
 		this.valor_por_pagar=valor_por_pagar;
 		this.valor_cancelado=valor_cancelado;
 		this.numero_cuenta=numero_cuenta;
 		this.esta_autorizado=esta_autorizado;
 		this.descripcion=descripcion;
 		this.fecha_corte_dato=fecha_corte_dato;
 		this.estado=estado;
 		this.codigo_cuenta_con_cliente=codigo_cuenta_con_cliente;
 		this.codigo_cuenta_con_banco=codigo_cuenta_con_banco;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PagosAutorizados (String nombre_cliente,String numero_factura,Date fecha_emision,Date fecha_vencimiento,String nombre_banco,Double valor_por_pagar,Double valor_cancelado,String numero_cuenta,Boolean esta_autorizado,String descripcion,Date fecha_corte_dato,String estado,String codigo_cuenta_con_cliente,String codigo_cuenta_con_banco) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagosautorizadosOriginal=this;
		
 		this.nombre_cliente=nombre_cliente;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.nombre_banco=nombre_banco;
 		this.valor_por_pagar=valor_por_pagar;
 		this.valor_cancelado=valor_cancelado;
 		this.numero_cuenta=numero_cuenta;
 		this.esta_autorizado=esta_autorizado;
 		this.descripcion=descripcion;
 		this.fecha_corte_dato=fecha_corte_dato;
 		this.estado=estado;
 		this.codigo_cuenta_con_cliente=codigo_cuenta_con_cliente;
 		this.codigo_cuenta_con_banco=codigo_cuenta_con_banco;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public PagosAutorizados getPagosAutorizadosOriginal() {
		return this.pagosautorizadosOriginal;
	}
	
	public void setPagosAutorizadosOriginal(PagosAutorizados pagosautorizados) {
		try {
			this.pagosautorizadosOriginal=pagosautorizados;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PagosAutorizadosAdditional pagosautorizadosAdditional=null;
	
	public PagosAutorizadosAdditional getPagosAutorizadosAdditional() {
		return this.pagosautorizadosAdditional;
	}
	
	public void setPagosAutorizadosAdditional(PagosAutorizadosAdditional pagosautorizadosAdditional) {
		try {
			this.pagosautorizadosAdditional=pagosautorizadosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Date getfecha_corte() {
		return this.fecha_corte;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public String getnombre_banco() {
		return this.nombre_banco;
	}
    
	
	public Double getvalor_por_pagar() {
		return this.valor_por_pagar;
	}
    
	
	public Double getvalor_cancelado() {
		return this.valor_cancelado;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public Boolean getesta_autorizado() {
		return this.esta_autorizado;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Date getfecha_corte_dato() {
		return this.fecha_corte_dato;
	}
    
	
	public String getestado() {
		return this.estado;
	}
    
	
	public String getcodigo_cuenta_con_cliente() {
		return this.codigo_cuenta_con_cliente;
	}
    
	
	public String getcodigo_cuenta_con_banco() {
		return this.codigo_cuenta_con_banco;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_corte(Date newfecha_corte)throws Exception
	{
		try {
			if(this.fecha_corte!=newfecha_corte) {
				if(newfecha_corte==null) {
					//newfecha_corte=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna fecha_corte");
					}
				}

				this.fecha_corte=newfecha_corte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cliente(String newnombre_cliente)throws Exception
	{
		try {
			if(this.nombre_cliente!=newnombre_cliente) {
				if(newnombre_cliente==null) {
					//newnombre_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_banco(String newnombre_banco)throws Exception
	{
		try {
			if(this.nombre_banco!=newnombre_banco) {
				if(newnombre_banco==null) {
					//newnombre_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna nombre_banco");
					}
				}

				if(newnombre_banco!=null&&newnombre_banco.length()>150) {
					newnombre_banco=newnombre_banco.substring(0,148);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_banco");
				}

				this.nombre_banco=newnombre_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_por_pagar(Double newvalor_por_pagar)throws Exception
	{
		try {
			if(this.valor_por_pagar!=newvalor_por_pagar) {
				if(newvalor_por_pagar==null) {
					//newvalor_por_pagar=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna valor_por_pagar");
					}
				}

				this.valor_por_pagar=newvalor_por_pagar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cancelado(Double newvalor_cancelado)throws Exception
	{
		try {
			if(this.valor_cancelado!=newvalor_cancelado) {
				if(newvalor_cancelado==null) {
					//newvalor_cancelado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna valor_cancelado");
					}
				}

				this.valor_cancelado=newvalor_cancelado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_autorizado(Boolean newesta_autorizado)throws Exception
	{
		try {
			if(this.esta_autorizado!=newesta_autorizado) {
				if(newesta_autorizado==null) {
					//newesta_autorizado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna esta_autorizado");
					}
				}

				this.esta_autorizado=newesta_autorizado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_corte_dato(Date newfecha_corte_dato)throws Exception
	{
		try {
			if(this.fecha_corte_dato!=newfecha_corte_dato) {
				if(newfecha_corte_dato==null) {
					//newfecha_corte_dato=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna fecha_corte_dato");
					}
				}

				this.fecha_corte_dato=newfecha_corte_dato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestado(String newestado)throws Exception
	{
		try {
			if(this.estado!=newestado) {
				if(newestado==null) {
					//newestado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna estado");
					}
				}

				if(newestado!=null&&newestado.length()>100) {
					newestado=newestado.substring(0,98);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna estado");
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta_con_cliente(String newcodigo_cuenta_con_cliente)throws Exception
	{
		try {
			if(this.codigo_cuenta_con_cliente!=newcodigo_cuenta_con_cliente) {
				if(newcodigo_cuenta_con_cliente==null) {
					//newcodigo_cuenta_con_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna codigo_cuenta_con_cliente");
					}
				}

				if(newcodigo_cuenta_con_cliente!=null&&newcodigo_cuenta_con_cliente.length()>50) {
					newcodigo_cuenta_con_cliente=newcodigo_cuenta_con_cliente.substring(0,48);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta_con_cliente");
				}

				this.codigo_cuenta_con_cliente=newcodigo_cuenta_con_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta_con_banco(String newcodigo_cuenta_con_banco)throws Exception
	{
		try {
			if(this.codigo_cuenta_con_banco!=newcodigo_cuenta_con_banco) {
				if(newcodigo_cuenta_con_banco==null) {
					//newcodigo_cuenta_con_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizados:Valor nulo no permitido en columna codigo_cuenta_con_banco");
					}
				}

				if(newcodigo_cuenta_con_banco!=null&&newcodigo_cuenta_con_banco.length()>50) {
					newcodigo_cuenta_con_banco=newcodigo_cuenta_con_banco.substring(0,48);
					System.out.println("PagosAutorizados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta_con_banco");
				}

				this.codigo_cuenta_con_banco=newcodigo_cuenta_con_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String esta_autorizado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getesta_autorizado_descripcion() {
		return esta_autorizado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_autorizado_descripcion(String newesta_autorizado_descripcion)throws Exception {
		try {
			this.esta_autorizado_descripcion=newesta_autorizado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.esta_autorizado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

