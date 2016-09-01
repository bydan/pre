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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.CuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CuentaBanco extends CuentaBancoAdditional implements Serializable ,Cloneable {//CuentaBancoAdditional,GeneralEntity
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
	
	private CuentaBanco cuentabancoOriginal;
	
	private Map<String, Object> mapCuentaBanco;
			
	public Map<String, Object> getMapCuentaBanco() {
		return mapCuentaBanco;
	}

	public void setMapCuentaBanco(Map<String, Object> mapCuentaBanco) {
		this.mapCuentaBanco = mapCuentaBanco;
	}
	
	public void inicializarMapCuentaBanco() {
		this.mapCuentaBanco = new HashMap<String,Object>();
	}
	
	public void setMapCuentaBancoValue(String sKey,Object oValue) {
		this.mapCuentaBanco.put(sKey, oValue);
	}
	
	public Object getMapCuentaBancoValue(String sKey) {
		return this.mapCuentaBanco.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_banco_global;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuentaBancoConstantesFunciones.SREGEXCODIGO,message=CuentaBancoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuentaBancoConstantesFunciones.SREGEXNUMERO_CUENTA,message=CuentaBancoConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaBancoConstantesFunciones.SREGEXNUMERO_CHEQUE,message=CuentaBancoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaBancoConstantesFunciones.SREGEXNUMERO_CHEQUE_AUXILIAR,message=CuentaBancoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE_AUXILIAR)
	private String numero_cheque_auxiliar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaBancoConstantesFunciones.SREGEXPROCEDENCIA,message=CuentaBancoConstantesFunciones.SMENSAJEREGEXPROCEDENCIA)
	private String procedencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaBancoConstantesFunciones.SREGEXDESTINO,message=CuentaBancoConstantesFunciones.SMENSAJEREGEXDESTINO)
	private String destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_diario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_cheque;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato_retencion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato_retencion_iva;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Banco banco;
	public TipoCuentaBancoGlobal tipocuentabancoglobal;
	public CuentaContable cuentacontable;
	public EstadoCuentaBanco estadocuentabanco;
	public Formato formatoingreso;
	public Formato formatoegreso;
	public Formato formatodiario;
	public Formato formatocheque;
	public Formato formatoretencion;
	public Formato formatoretencioniva;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String banco_descripcion;
	private String tipocuentabancoglobal_descripcion;
	private String cuentacontable_descripcion;
	private String estadocuentabanco_descripcion;
	private String formatoingreso_descripcion;
	private String formatoegreso_descripcion;
	private String formatodiario_descripcion;
	private String formatocheque_descripcion;
	private String formatoretencion_descripcion;
	private String formatoretencioniva_descripcion;
	
	
	public List<PagoAuto> pagoautos;
	public List<AutoriPagoOrdenCompra> autoripagoordencompras;
	public List<DetalleChequeGirado> detallechequegirados;
	public List<AutoriPago> autoripagos;
		
	public CuentaBanco () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentabancoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_banco=-1L;
 		this.id_tipo_cuenta_banco_global=-1L;
 		this.codigo="";
 		this.numero_cuenta="";
 		this.numero_cheque="";
 		this.numero_cheque_auxiliar="";
 		this.saldo=0.0;
 		this.procedencia="";
 		this.destino="";
 		this.id_cuenta_contable=-1L;
 		this.es_banco=false;
 		this.id_estado_cuenta_banco=-1L;
 		this.id_formato_ingreso=-1L;
 		this.id_formato_egreso=-1L;
 		this.id_formato_diario=-1L;
 		this.id_formato_cheque=-1L;
 		this.id_formato_retencion=null;
 		this.id_formato_retencion_iva=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.banco=null;
		this.tipocuentabancoglobal=null;
		this.cuentacontable=null;
		this.estadocuentabanco=null;
		this.formatoingreso=null;
		this.formatoegreso=null;
		this.formatodiario=null;
		this.formatocheque=null;
		this.formatoretencion=null;
		this.formatoretencioniva=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.banco_descripcion="";
		this.tipocuentabancoglobal_descripcion="";
		this.cuentacontable_descripcion="";
		this.estadocuentabanco_descripcion="";
		this.formatoingreso_descripcion="";
		this.formatoegreso_descripcion="";
		this.formatodiario_descripcion="";
		this.formatocheque_descripcion="";
		this.formatoretencion_descripcion="";
		this.formatoretencioniva_descripcion="";
		
		
		this.pagoautos=null;
		this.autoripagoordencompras=null;
		this.detallechequegirados=null;
		this.autoripagos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentaBanco (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_banco,Long id_tipo_cuenta_banco_global,String codigo,String numero_cuenta,String numero_cheque,String numero_cheque_auxiliar,Double saldo,String procedencia,String destino,Long id_cuenta_contable,Boolean es_banco,Long id_estado_cuenta_banco,Long id_formato_ingreso,Long id_formato_egreso,Long id_formato_diario,Long id_formato_cheque,Long id_formato_retencion,Long id_formato_retencion_iva) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentabancoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.codigo=codigo;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.numero_cheque_auxiliar=numero_cheque_auxiliar;
 		this.saldo=saldo;
 		this.procedencia=procedencia;
 		this.destino=destino;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.es_banco=es_banco;
 		this.id_estado_cuenta_banco=id_estado_cuenta_banco;
 		this.id_formato_ingreso=id_formato_ingreso;
 		this.id_formato_egreso=id_formato_egreso;
 		this.id_formato_diario=id_formato_diario;
 		this.id_formato_cheque=id_formato_cheque;
 		this.id_formato_retencion=id_formato_retencion;
 		this.id_formato_retencion_iva=id_formato_retencion_iva;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentaBanco (Long id_empresa,Long id_sucursal,Long id_banco,Long id_tipo_cuenta_banco_global,String codigo,String numero_cuenta,String numero_cheque,String numero_cheque_auxiliar,Double saldo,String procedencia,String destino,Long id_cuenta_contable,Boolean es_banco,Long id_estado_cuenta_banco,Long id_formato_ingreso,Long id_formato_egreso,Long id_formato_diario,Long id_formato_cheque,Long id_formato_retencion,Long id_formato_retencion_iva) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentabancoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.codigo=codigo;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.numero_cheque_auxiliar=numero_cheque_auxiliar;
 		this.saldo=saldo;
 		this.procedencia=procedencia;
 		this.destino=destino;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.es_banco=es_banco;
 		this.id_estado_cuenta_banco=id_estado_cuenta_banco;
 		this.id_formato_ingreso=id_formato_ingreso;
 		this.id_formato_egreso=id_formato_egreso;
 		this.id_formato_diario=id_formato_diario;
 		this.id_formato_cheque=id_formato_cheque;
 		this.id_formato_retencion=id_formato_retencion;
 		this.id_formato_retencion_iva=id_formato_retencion_iva;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentaBanco cuentabancoLocal=null;
		
		if(object!=null) {
			cuentabancoLocal=(CuentaBanco)object;
			
			if(cuentabancoLocal!=null) {
				if(this.getId()!=null && cuentabancoLocal.getId()!=null) {
					if(this.getId().equals(cuentabancoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentaBancoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(this);
		} else {
			sDetalle=CuentaBancoConstantesFunciones.getCuentaBancoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentaBanco getCuentaBancoOriginal() {
		return this.cuentabancoOriginal;
	}
	
	public void setCuentaBancoOriginal(CuentaBanco cuentabanco) {
		try {
			this.cuentabancoOriginal=cuentabanco;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentaBancoAdditional cuentabancoAdditional=null;
	
	public CuentaBancoAdditional getCuentaBancoAdditional() {
		return this.cuentabancoAdditional;
	}
	
	public void setCuentaBancoAdditional(CuentaBancoAdditional cuentabancoAdditional) {
		try {
			this.cuentabancoAdditional=cuentabancoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_tipo_cuenta_banco_global() {
		return this.id_tipo_cuenta_banco_global;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public String getnumero_cheque_auxiliar() {
		return this.numero_cheque_auxiliar;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
    
	
	public String getprocedencia() {
		return this.procedencia;
	}
    
	
	public String getdestino() {
		return this.destino;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Boolean getes_banco() {
		return this.es_banco;
	}
    
	
	public Long getid_estado_cuenta_banco() {
		return this.id_estado_cuenta_banco;
	}
    
	
	public Long getid_formato_ingreso() {
		return this.id_formato_ingreso;
	}
    
	
	public Long getid_formato_egreso() {
		return this.id_formato_egreso;
	}
    
	
	public Long getid_formato_diario() {
		return this.id_formato_diario;
	}
    
	
	public Long getid_formato_cheque() {
		return this.id_formato_cheque;
	}
    
	
	public Long getid_formato_retencion() {
		return this.id_formato_retencion;
	}
    
	
	public Long getid_formato_retencion_iva() {
		return this.id_formato_retencion_iva;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco(Long newid_banco)throws Exception
	{
		try {
			if(this.id_banco!=newid_banco) {
				if(newid_banco==null) {
					//newid_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_banco_global(Long newid_tipo_cuenta_banco_global)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_banco_global!=newid_tipo_cuenta_banco_global) {
				if(newid_tipo_cuenta_banco_global==null) {
					//newid_tipo_cuenta_banco_global=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_tipo_cuenta_banco_global");
					}
				}

				this.id_tipo_cuenta_banco_global=newid_tipo_cuenta_banco_global;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>100) {
					newcodigo=newcodigo.substring(0,98);
					System.out.println("CuentaBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("CuentaBanco:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("CuentaBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque(String newnumero_cheque)throws Exception
	{
		try {
			if(this.numero_cheque!=newnumero_cheque) {
				if(newnumero_cheque==null) {
					//newnumero_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("CuentaBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque_auxiliar(String newnumero_cheque_auxiliar)throws Exception
	{
		try {
			if(this.numero_cheque_auxiliar!=newnumero_cheque_auxiliar) {
				if(newnumero_cheque_auxiliar==null) {
					//newnumero_cheque_auxiliar="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna numero_cheque_auxiliar");
					}
				}

				if(newnumero_cheque_auxiliar!=null&&newnumero_cheque_auxiliar.length()>50) {
					newnumero_cheque_auxiliar=newnumero_cheque_auxiliar.substring(0,48);
					System.out.println("CuentaBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque_auxiliar");
				}

				this.numero_cheque_auxiliar=newnumero_cheque_auxiliar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo(Double newsaldo)throws Exception
	{
		try {
			if(this.saldo!=newsaldo) {
				if(newsaldo==null) {
					//newsaldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprocedencia(String newprocedencia)throws Exception
	{
		try {
			if(this.procedencia!=newprocedencia) {
				if(newprocedencia==null) {
					//newprocedencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna procedencia");
					}
				}

				if(newprocedencia!=null&&newprocedencia.length()>100) {
					newprocedencia=newprocedencia.substring(0,98);
					System.out.println("CuentaBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna procedencia");
				}

				this.procedencia=newprocedencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdestino(String newdestino)throws Exception
	{
		try {
			if(this.destino!=newdestino) {
				if(newdestino==null) {
					//newdestino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna destino");
					}
				}

				if(newdestino!=null&&newdestino.length()>100) {
					newdestino=newdestino.substring(0,98);
					System.out.println("CuentaBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna destino");
				}

				this.destino=newdestino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_banco(Boolean newes_banco)throws Exception
	{
		try {
			if(this.es_banco!=newes_banco) {
				if(newes_banco==null) {
					//newes_banco=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna es_banco");
					}
				}

				this.es_banco=newes_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_cuenta_banco(Long newid_estado_cuenta_banco)throws Exception
	{
		try {
			if(this.id_estado_cuenta_banco!=newid_estado_cuenta_banco) {
				if(newid_estado_cuenta_banco==null) {
					//newid_estado_cuenta_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_estado_cuenta_banco");
					}
				}

				this.id_estado_cuenta_banco=newid_estado_cuenta_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_ingreso(Long newid_formato_ingreso)throws Exception
	{
		try {
			if(this.id_formato_ingreso!=newid_formato_ingreso) {
				if(newid_formato_ingreso==null) {
					//newid_formato_ingreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_formato_ingreso");
					}
				}

				this.id_formato_ingreso=newid_formato_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_egreso(Long newid_formato_egreso)throws Exception
	{
		try {
			if(this.id_formato_egreso!=newid_formato_egreso) {
				if(newid_formato_egreso==null) {
					//newid_formato_egreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_formato_egreso");
					}
				}

				this.id_formato_egreso=newid_formato_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_diario(Long newid_formato_diario)throws Exception
	{
		try {
			if(this.id_formato_diario!=newid_formato_diario) {
				if(newid_formato_diario==null) {
					//newid_formato_diario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_formato_diario");
					}
				}

				this.id_formato_diario=newid_formato_diario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_cheque(Long newid_formato_cheque)throws Exception
	{
		try {
			if(this.id_formato_cheque!=newid_formato_cheque) {
				if(newid_formato_cheque==null) {
					//newid_formato_cheque=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaBanco:Valor nulo no permitido en columna id_formato_cheque");
					}
				}

				this.id_formato_cheque=newid_formato_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_retencion(Long newid_formato_retencion) {
		if(this.id_formato_retencion==null&&newid_formato_retencion!=null) {
			this.id_formato_retencion=newid_formato_retencion;
				this.setIsChanged(true);
		}

		if(this.id_formato_retencion!=null&&!this.id_formato_retencion.equals(newid_formato_retencion)) {

			this.id_formato_retencion=newid_formato_retencion;
				this.setIsChanged(true);
		}
	}
    
	public void setid_formato_retencion_iva(Long newid_formato_retencion_iva) {
		if(this.id_formato_retencion_iva==null&&newid_formato_retencion_iva!=null) {
			this.id_formato_retencion_iva=newid_formato_retencion_iva;
				this.setIsChanged(true);
		}

		if(this.id_formato_retencion_iva!=null&&!this.id_formato_retencion_iva.equals(newid_formato_retencion_iva)) {

			this.id_formato_retencion_iva=newid_formato_retencion_iva;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() {
		return this.tipocuentabancoglobal;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public EstadoCuentaBanco getEstadoCuentaBanco() {
		return this.estadocuentabanco;
	}

	public Formato getFormatoIngreso() {
		return this.formatoingreso;
	}

	public Formato getFormatoEgreso() {
		return this.formatoegreso;
	}

	public Formato getFormatoDiario() {
		return this.formatodiario;
	}

	public Formato getFormatoCheque() {
		return this.formatocheque;
	}

	public Formato getFormatoRetencion() {
		return this.formatoretencion;
	}

	public Formato getFormatoRetencionIva() {
		return this.formatoretencioniva;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String gettipocuentabancoglobal_descripcion() {
		return this.tipocuentabancoglobal_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getestadocuentabanco_descripcion() {
		return this.estadocuentabanco_descripcion;
	}

	public String getformatoingreso_descripcion() {
		return this.formatoingreso_descripcion;
	}

	public String getformatoegreso_descripcion() {
		return this.formatoegreso_descripcion;
	}

	public String getformatodiario_descripcion() {
		return this.formatodiario_descripcion;
	}

	public String getformatocheque_descripcion() {
		return this.formatocheque_descripcion;
	}

	public String getformatoretencion_descripcion() {
		return this.formatoretencion_descripcion;
	}

	public String getformatoretencioniva_descripcion() {
		return this.formatoretencioniva_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		try {
			this.tipocuentabancoglobal=tipocuentabancoglobal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco) {
		try {
			this.estadocuentabanco=estadocuentabanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoIngreso(Formato formatoingreso) {
		try {
			this.formatoingreso=formatoingreso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoEgreso(Formato formatoegreso) {
		try {
			this.formatoegreso=formatoegreso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoDiario(Formato formatodiario) {
		try {
			this.formatodiario=formatodiario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoCheque(Formato formatocheque) {
		try {
			this.formatocheque=formatocheque;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoRetencion(Formato formatoretencion) {
		try {
			this.formatoretencion=formatoretencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoRetencionIva(Formato formatoretencioniva) {
		try {
			this.formatoretencioniva=formatoretencioniva;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocuentabancoglobal_descripcion(String tipocuentabancoglobal_descripcion) {
		try {
			this.tipocuentabancoglobal_descripcion=tipocuentabancoglobal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocuentabanco_descripcion(String estadocuentabanco_descripcion) {
		try {
			this.estadocuentabanco_descripcion=estadocuentabanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoingreso_descripcion(String formatoingreso_descripcion) {
		try {
			this.formatoingreso_descripcion=formatoingreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoegreso_descripcion(String formatoegreso_descripcion) {
		try {
			this.formatoegreso_descripcion=formatoegreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatodiario_descripcion(String formatodiario_descripcion) {
		try {
			this.formatodiario_descripcion=formatodiario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatocheque_descripcion(String formatocheque_descripcion) {
		try {
			this.formatocheque_descripcion=formatocheque_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoretencion_descripcion(String formatoretencion_descripcion) {
		try {
			this.formatoretencion_descripcion=formatoretencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoretencioniva_descripcion(String formatoretencioniva_descripcion) {
		try {
			this.formatoretencioniva_descripcion=formatoretencioniva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<PagoAuto> getPagoAutos() {
		return this.pagoautos;
	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras() {
		return this.autoripagoordencompras;
	}

	public List<DetalleChequeGirado> getDetalleChequeGirados() {
		return this.detallechequegirados;
	}

	public List<AutoriPago> getAutoriPagos() {
		return this.autoripagos;
	}

	
	
	public  void  setPagoAutos(List<PagoAuto> pagoautos) {
		try {
			this.pagoautos=pagoautos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> autoripagoordencompras) {
		try {
			this.autoripagoordencompras=autoripagoordencompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleChequeGirados(List<DetalleChequeGirado> detallechequegirados) {
		try {
			this.detallechequegirados=detallechequegirados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAutoriPagos(List<AutoriPago> autoripagos) {
		try {
			this.autoripagos=autoripagos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_banco_descripcion="";String id_tipo_cuenta_banco_global_descripcion="";String id_cuenta_contable_descripcion="";String es_banco_descripcion="";String id_estado_cuenta_banco_descripcion="";String id_formato_ingreso_descripcion="";String id_formato_egreso_descripcion="";String id_formato_diario_descripcion="";String id_formato_cheque_descripcion="";String id_formato_retencion_descripcion="";String id_formato_retencion_iva_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_tipo_cuenta_banco_global_descripcion() {
		return id_tipo_cuenta_banco_global_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getes_banco_descripcion() {
		return es_banco_descripcion;
	}
	public String getid_estado_cuenta_banco_descripcion() {
		return id_estado_cuenta_banco_descripcion;
	}
	public String getid_formato_ingreso_descripcion() {
		return id_formato_ingreso_descripcion;
	}
	public String getid_formato_egreso_descripcion() {
		return id_formato_egreso_descripcion;
	}
	public String getid_formato_diario_descripcion() {
		return id_formato_diario_descripcion;
	}
	public String getid_formato_cheque_descripcion() {
		return id_formato_cheque_descripcion;
	}
	public String getid_formato_retencion_descripcion() {
		return id_formato_retencion_descripcion;
	}
	public String getid_formato_retencion_iva_descripcion() {
		return id_formato_retencion_iva_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_banco_descripcion(String newid_banco_descripcion)throws Exception {
		try {
			this.id_banco_descripcion=newid_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cuenta_banco_global_descripcion(String newid_tipo_cuenta_banco_global_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_banco_global_descripcion=newid_tipo_cuenta_banco_global_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_banco_descripcion(String newes_banco_descripcion)throws Exception {
		try {
			this.es_banco_descripcion=newes_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_cuenta_banco_descripcion(String newid_estado_cuenta_banco_descripcion)throws Exception {
		try {
			this.id_estado_cuenta_banco_descripcion=newid_estado_cuenta_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_ingreso_descripcion(String newid_formato_ingreso_descripcion)throws Exception {
		try {
			this.id_formato_ingreso_descripcion=newid_formato_ingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_egreso_descripcion(String newid_formato_egreso_descripcion)throws Exception {
		try {
			this.id_formato_egreso_descripcion=newid_formato_egreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_diario_descripcion(String newid_formato_diario_descripcion)throws Exception {
		try {
			this.id_formato_diario_descripcion=newid_formato_diario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_cheque_descripcion(String newid_formato_cheque_descripcion)throws Exception {
		try {
			this.id_formato_cheque_descripcion=newid_formato_cheque_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_retencion_descripcion(String newid_formato_retencion_descripcion) {
		this.id_formato_retencion_descripcion=newid_formato_retencion_descripcion;
	}
	public void setid_formato_retencion_iva_descripcion(String newid_formato_retencion_iva_descripcion) {
		this.id_formato_retencion_iva_descripcion=newid_formato_retencion_iva_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_banco_descripcion="";this.id_tipo_cuenta_banco_global_descripcion="";this.id_cuenta_contable_descripcion="";this.es_banco_descripcion="";this.id_estado_cuenta_banco_descripcion="";this.id_formato_ingreso_descripcion="";this.id_formato_egreso_descripcion="";this.id_formato_diario_descripcion="";this.id_formato_cheque_descripcion="";this.id_formato_retencion_descripcion="";this.id_formato_retencion_iva_descripcion="";
	}
	
	
	Object pagoautosDescripcionReporte;
	Object autoripagoordencomprasDescripcionReporte;
	Object detallechequegiradosDescripcionReporte;
	Object autoripagosDescripcionReporte;
	
	
	public Object getpagoautosDescripcionReporte() {
		return pagoautosDescripcionReporte;
	}

	public Object getautoripagoordencomprasDescripcionReporte() {
		return autoripagoordencomprasDescripcionReporte;
	}

	public Object getdetallechequegiradosDescripcionReporte() {
		return detallechequegiradosDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	
	
	public  void  setpagoautosDescripcionReporte(Object pagoautos) {
		try {
			this.pagoautosDescripcionReporte=pagoautos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagoordencomprasDescripcionReporte(Object autoripagoordencompras) {
		try {
			this.autoripagoordencomprasDescripcionReporte=autoripagoordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallechequegiradosDescripcionReporte(Object detallechequegirados) {
		try {
			this.detallechequegiradosDescripcionReporte=detallechequegirados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

