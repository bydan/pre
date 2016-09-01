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
package com.bydan.erp.puntoventa.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//FormaPagoPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class FormaPagoPuntoVentaDataAccess extends  FormaPagoPuntoVentaDataAccessAdditional{ //FormaPagoPuntoVentaDataAccessAdditional,DataAccessHelper<FormaPagoPuntoVenta>
	//static Logger logger = Logger.getLogger(FormaPagoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="forma_pago_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_factura_punto_venta,id_tipo_forma_pago,porcentaje,valor,fecha,descripcion,fecha_inicio,numero_dias_plazo,fecha_fin,id_banco,id_cuenta_banco_pun_ven,id_tipo_riesgo_cheque,numero_cuenta,numero_cheque,girador,id_banco_tarjeta,id_tarjeta_credito,id_tipo_interes_tarjeta,id_tipo_pago_tarjeta,id_conexion,id_mes,numero,tarjeta_habiente,autorizacion,voucher,lote,cuota,valor_retencion,valor_comision,valor_calculado,valor_cancelado,valor_difiere,numero_retencion,numero_liquidacion,id_anio,id_cuenta_contable,id_asiento_contable)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura_punto_venta=?,id_tipo_forma_pago=?,porcentaje=?,valor=?,fecha=?,descripcion=?,fecha_inicio=?,numero_dias_plazo=?,fecha_fin=?,id_banco=?,id_cuenta_banco_pun_ven=?,id_tipo_riesgo_cheque=?,numero_cuenta=?,numero_cheque=?,girador=?,id_banco_tarjeta=?,id_tarjeta_credito=?,id_tipo_interes_tarjeta=?,id_tipo_pago_tarjeta=?,id_conexion=?,id_mes=?,numero=?,tarjeta_habiente=?,autorizacion=?,voucher=?,lote=?,cuota=?,valor_retencion=?,valor_comision=?,valor_calculado=?,valor_cancelado=?,valor_difiere=?,numero_retencion=?,numero_liquidacion=?,id_anio=?,id_cuenta_contable=?,id_asiento_contable=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formapagopuntoventa from "+FormaPagoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" formapagopuntoventa";
	public static String QUERYSELECTNATIVE="select "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_ejercicio,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_periodo,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".porcentaje,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".descripcion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".fecha_inicio,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_dias_plazo,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".fecha_fin,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_banco,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_cuenta_banco_pun_ven,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_riesgo_cheque,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_cuenta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_cheque,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".girador,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_banco_tarjeta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_interes_tarjeta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_pago_tarjeta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_conexion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_mes,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_habiente,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".autorizacion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".voucher,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".lote,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".cuota,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_retencion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_comision,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_calculado,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_cancelado,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_difiere,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_retencion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_liquidacion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_anio,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_asiento_contable from "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FormaPagoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FormaPagoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_factura_punto_venta=?,id_tipo_forma_pago=?,porcentaje=?,valor=?,fecha=?,descripcion=?,fecha_inicio=?,numero_dias_plazo=?,fecha_fin=?,id_banco=?,id_cuenta_banco_pun_ven=?,id_tipo_riesgo_cheque=?,numero_cuenta=?,numero_cheque=?,girador=?,id_banco_tarjeta=?,id_tarjeta_credito=?,id_tipo_interes_tarjeta=?,id_tipo_pago_tarjeta=?,id_conexion=?,id_mes=?,numero=?,tarjeta_habiente=?,autorizacion=?,voucher=?,lote=?,cuota=?,valor_retencion=?,valor_comision=?,valor_calculado=?,valor_cancelado=?,valor_difiere=?,numero_retencion=?,numero_liquidacion=?,id_anio=?,id_cuenta_contable=?,id_asiento_contable=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMAPAGOPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMAPAGOPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMAPAGOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMAPAGOPUNTOVENTA_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected FormaPagoPuntoVentaDataAccessAdditional formapagopuntoventaDataAccessAdditional=null;
	
	public FormaPagoPuntoVentaDataAccessAdditional getFormaPagoPuntoVentaDataAccessAdditional() {
		return this.formapagopuntoventaDataAccessAdditional;
	}
	
	public void setFormaPagoPuntoVentaDataAccessAdditional(FormaPagoPuntoVentaDataAccessAdditional formapagopuntoventaDataAccessAdditional) {
		try {
			this.formapagopuntoventaDataAccessAdditional=formapagopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormaPagoPuntoVentaDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		FormaPagoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormaPagoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormaPagoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setFormaPagoPuntoVentaOriginal(FormaPagoPuntoVenta formapagopuntoventa)throws Exception  {
		formapagopuntoventa.setFormaPagoPuntoVentaOriginal((FormaPagoPuntoVenta)formapagopuntoventa.clone());		
	}
	
	public void setFormaPagoPuntoVentasOriginal(List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception  {
		
		for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas){
			formapagopuntoventa.setFormaPagoPuntoVentaOriginal((FormaPagoPuntoVenta)formapagopuntoventa.clone());
		}
	}
	
	public static void setFormaPagoPuntoVentaOriginalStatic(FormaPagoPuntoVenta formapagopuntoventa)throws Exception  {
		formapagopuntoventa.setFormaPagoPuntoVentaOriginal((FormaPagoPuntoVenta)formapagopuntoventa.clone());		
	}
	
	public static void setFormaPagoPuntoVentasOriginalStatic(List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception  {
		
		for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas){
			formapagopuntoventa.setFormaPagoPuntoVentaOriginal((FormaPagoPuntoVenta)formapagopuntoventa.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  FormaPagoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  FormaPagoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.FormaPagoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormaPagoPuntoVentaOriginal(new FormaPagoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormaPagoPuntoVenta("",entity,resultSet); 
				
				//entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormaPagoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormaPagoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  FormaPagoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.FormaPagoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormaPagoPuntoVentaOriginal(new FormaPagoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormaPagoPuntoVenta("",entity,resultSet);    
				
				//entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormaPagoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormaPagoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.FormaPagoPuntoVenta.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseFormaPagoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormaPagoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<FormaPagoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormaPagoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormaPagoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFormaPagoPuntoVentaOriginal( new FormaPagoPuntoVenta());
      	    	//entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormaPagoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormaPagoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<FormaPagoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormaPagoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapFormaPagoPuntoVenta();
					//entity.setMapFormaPagoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormaPagoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormaPagoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=FormaPagoPuntoVentaDataAccess.getEntityFormaPagoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormaPagoPuntoVentaOriginal( new FormaPagoPuntoVenta());
					////entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormaPagoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormaPagoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  FormaPagoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormaPagoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapFormaPagoPuntoVenta();
					//entity.setMapFormaPagoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormaPagoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormaPagoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=FormaPagoPuntoVentaDataAccess.getEntityFormaPagoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormaPagoPuntoVentaOriginal( new FormaPagoPuntoVenta());
					////entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormaPagoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormaPagoPuntoVenta getEntityFormaPagoPuntoVenta(String strPrefijo,FormaPagoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormaPagoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormaPagoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormaPagoPuntoVentaDataAccess.setFieldReflectionFormaPagoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormaPagoPuntoVenta=FormaPagoPuntoVentaConstantesFunciones.getTodosTiposColumnasFormaPagoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormaPagoPuntoVenta) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = FormaPagoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormaPagoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormaPagoPuntoVentaDataAccess.setFieldReflectionFormaPagoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormaPagoPuntoVenta(Field field,String strPrefijo,String sColumn,FormaPagoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormaPagoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.GIRADOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDCONEXION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VOUCHER:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.CUOTA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormaPagoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new FormaPagoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormaPagoPuntoVenta("",entity,resultSet);
					
					//entity.setFormaPagoPuntoVentaOriginal( new FormaPagoPuntoVenta());
					//entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormaPagoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormaPagoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormaPagoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormaPagoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<FormaPagoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<FormaPagoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormaPagoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormaPagoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFormaPagoPuntoVentaOriginal( new FormaPagoPuntoVenta());
      	    	//entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormaPagoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormaPagoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormaPagoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<FormaPagoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormaPagoPuntoVenta> entities = new  ArrayList<FormaPagoPuntoVenta>();
		FormaPagoPuntoVenta entity = new FormaPagoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormaPagoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormaPagoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setFormaPagoPuntoVentaOriginal( new FormaPagoPuntoVenta());
      	    	//entity.setFormaPagoPuntoVentaOriginal(super.getEntity("",entity.getFormaPagoPuntoVentaOriginal(),resultSet,FormaPagoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormaPagoPuntoVentaOriginal(this.getEntityFormaPagoPuntoVenta("",entity.getFormaPagoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormaPagoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormaPagoPuntoVenta getEntityFormaPagoPuntoVenta(String strPrefijo,FormaPagoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDPERIODO));
				entity.setid_factura_punto_venta(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA));
				entity.setid_tipo_forma_pago(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VALOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.FECHA).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO).getTime()));
				entity.setnumero_dias_plazo(resultSet.getInt(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.FECHAFIN).getTime()));
				entity.setid_banco(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDBANCO));if(resultSet.wasNull()) {entity.setid_banco(null); }
				entity.setid_cuenta_banco_pun_ven(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN));if(resultSet.wasNull()) {entity.setid_cuenta_banco_pun_ven(null); }
				entity.setid_tipo_riesgo_cheque(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE));if(resultSet.wasNull()) {entity.setid_tipo_riesgo_cheque(null); }
				entity.setnumero_cuenta(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA));
				entity.setnumero_cheque(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE));
				entity.setgirador(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.GIRADOR));
				entity.setid_banco_tarjeta(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA));if(resultSet.wasNull()) {entity.setid_banco_tarjeta(null); }
				entity.setid_tarjeta_credito(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO));if(resultSet.wasNull()) {entity.setid_tarjeta_credito(null); }
				entity.setid_tipo_interes_tarjeta(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA));if(resultSet.wasNull()) {entity.setid_tipo_interes_tarjeta(null); }
				entity.setid_tipo_pago_tarjeta(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA));if(resultSet.wasNull()) {entity.setid_tipo_pago_tarjeta(null); }
				entity.setid_conexion(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDCONEXION));if(resultSet.wasNull()) {entity.setid_conexion(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setnumero(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.NUMERO));
				entity.settarjeta_habiente(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE));
				entity.setautorizacion(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION));
				entity.setvoucher(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VOUCHER));
				entity.setlote(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.LOTE));
				entity.setcuota(resultSet.getInt(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.CUOTA));
				entity.setvalor_retencion(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION));
				entity.setvalor_comision(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION));
				entity.setvalor_calculado(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO));
				entity.setvalor_cancelado(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO));
				entity.setvalor_difiere(resultSet.getDouble(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION));
				entity.setnumero_liquidacion(resultSet.getString(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION));
				entity.setid_anio(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormaPagoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormaPagoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormaPagoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormaPagoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormaPagoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormaPagoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormaPagoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormaPagoPuntoVentaDataAccess.TABLENAME,FormaPagoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			FormaPagoPuntoVentaDataAccess.setFormaPagoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformapagopuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relformapagopuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relformapagopuntoventa.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relformapagopuntoventa.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public FacturaPuntoVenta getFacturaPuntoVenta(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		FacturaPuntoVenta facturapuntoventa= new FacturaPuntoVenta();

		try {
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			facturapuntoventa=facturapuntoventaDataAccess.getEntity(connexion,relformapagopuntoventa.getid_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventa;

	}

	public TipoFormaPago getTipoFormaPago(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		TipoFormaPago tipoformapago= new TipoFormaPago();

		try {
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,relformapagopuntoventa.getid_tipo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapago;

	}

	public Banco getBanco(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relformapagopuntoventa.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public CuentaBancoPunVen getCuentaBancoPunVen(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		CuentaBancoPunVen cuentabancopunven= new CuentaBancoPunVen();

		try {
			CuentaBancoPunVenDataAccess cuentabancopunvenDataAccess=new CuentaBancoPunVenDataAccess();

			cuentabancopunvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentabancopunvenDataAccess.setConnexionType(this.connexionType);
			cuentabancopunvenDataAccess.setParameterDbType(this.parameterDbType);

			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion,relformapagopuntoventa.getid_cuenta_banco_pun_ven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabancopunven;

	}

	public TipoRiesgoCheque getTipoRiesgoCheque(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		TipoRiesgoCheque tiporiesgocheque= new TipoRiesgoCheque();

		try {
			TipoRiesgoChequeDataAccess tiporiesgochequeDataAccess=new TipoRiesgoChequeDataAccess();

			tiporiesgochequeDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporiesgochequeDataAccess.setConnexionType(this.connexionType);
			tiporiesgochequeDataAccess.setParameterDbType(this.parameterDbType);

			tiporiesgocheque=tiporiesgochequeDataAccess.getEntity(connexion,relformapagopuntoventa.getid_tipo_riesgo_cheque());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporiesgocheque;

	}

	public Banco getBancoTarjeta(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relformapagopuntoventa.getid_banco_tarjeta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TarjetaCredito getTarjetaCredito(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		TarjetaCredito tarjetacredito= new TarjetaCredito();

		try {
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);

			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion,relformapagopuntoventa.getid_tarjeta_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacredito;

	}

	public TipoInteresTarjeta getTipoInteresTarjeta(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		TipoInteresTarjeta tipointerestarjeta= new TipoInteresTarjeta();

		try {
			TipoInteresTarjetaDataAccess tipointerestarjetaDataAccess=new TipoInteresTarjetaDataAccess();

			tipointerestarjetaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipointerestarjetaDataAccess.setConnexionType(this.connexionType);
			tipointerestarjetaDataAccess.setParameterDbType(this.parameterDbType);

			tipointerestarjeta=tipointerestarjetaDataAccess.getEntity(connexion,relformapagopuntoventa.getid_tipo_interes_tarjeta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipointerestarjeta;

	}

	public TipoPagoTarjeta getTipoPagoTarjeta(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		TipoPagoTarjeta tipopagotarjeta= new TipoPagoTarjeta();

		try {
			TipoPagoTarjetaDataAccess tipopagotarjetaDataAccess=new TipoPagoTarjetaDataAccess();

			tipopagotarjetaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipopagotarjetaDataAccess.setConnexionType(this.connexionType);
			tipopagotarjetaDataAccess.setParameterDbType(this.parameterDbType);

			tipopagotarjeta=tipopagotarjetaDataAccess.getEntity(connexion,relformapagopuntoventa.getid_tipo_pago_tarjeta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipopagotarjeta;

	}

	public Conexion getConexion(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Conexion conexion= new Conexion();

		try {
			ConexionDataAccess conexionDataAccess=new ConexionDataAccess();

			conexionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			conexionDataAccess.setConnexionType(this.connexionType);
			conexionDataAccess.setParameterDbType(this.parameterDbType);

			conexion=conexionDataAccess.getEntity(connexion,relformapagopuntoventa.getid_conexion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return conexion;

	}

	public Mes getMes(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relformapagopuntoventa.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Anio getAnio(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relformapagopuntoventa.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public CuentaContable getCuentaContable(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relformapagopuntoventa.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public AsientoContable getAsientoContable(Connexion connexion,FormaPagoPuntoVenta relformapagopuntoventa)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relformapagopuntoventa.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormaPagoPuntoVenta formapagopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formapagopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formapagopuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(formapagopuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(formapagopuntoventa.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(formapagopuntoventa.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura_punto_venta.setValue(formapagopuntoventa.getid_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_forma_pago.setValue(formapagopuntoventa.getid_tipo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(formapagopuntoventa.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(formapagopuntoventa.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(formapagopuntoventa.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(formapagopuntoventa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(formapagopuntoventa.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias_plazo=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias_plazo.setValue(formapagopuntoventa.getnumero_dias_plazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias_plazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(formapagopuntoventa.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(formapagopuntoventa.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_banco_pun_ven=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_banco_pun_ven.setValue(formapagopuntoventa.getid_cuenta_banco_pun_ven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_banco_pun_ven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_riesgo_cheque=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_riesgo_cheque.setValue(formapagopuntoventa.getid_tipo_riesgo_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_riesgo_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta.setValue(formapagopuntoventa.getnumero_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque.setValue(formapagopuntoventa.getnumero_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuegirador=new ParameterValue<String>();
					parameterMaintenanceValuegirador.setValue(formapagopuntoventa.getgirador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegirador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco_tarjeta=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco_tarjeta.setValue(formapagopuntoventa.getid_banco_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tarjeta_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tarjeta_credito.setValue(formapagopuntoventa.getid_tarjeta_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tarjeta_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_interes_tarjeta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_interes_tarjeta.setValue(formapagopuntoventa.getid_tipo_interes_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_interes_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_pago_tarjeta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_pago_tarjeta.setValue(formapagopuntoventa.getid_tipo_pago_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_pago_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_conexion=new ParameterValue<Long>();
					parameterMaintenanceValueid_conexion.setValue(formapagopuntoventa.getid_conexion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_conexion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(formapagopuntoventa.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(formapagopuntoventa.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetarjeta_habiente=new ParameterValue<String>();
					parameterMaintenanceValuetarjeta_habiente.setValue(formapagopuntoventa.gettarjeta_habiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetarjeta_habiente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautorizacion=new ParameterValue<String>();
					parameterMaintenanceValueautorizacion.setValue(formapagopuntoventa.getautorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuevoucher=new ParameterValue<String>();
					parameterMaintenanceValuevoucher.setValue(formapagopuntoventa.getvoucher());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevoucher);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(formapagopuntoventa.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecuota=new ParameterValue<Integer>();
					parameterMaintenanceValuecuota.setValue(formapagopuntoventa.getcuota());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecuota);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_retencion.setValue(formapagopuntoventa.getvalor_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_comision=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_comision.setValue(formapagopuntoventa.getvalor_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_comision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_calculado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_calculado.setValue(formapagopuntoventa.getvalor_calculado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_calculado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cancelado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cancelado.setValue(formapagopuntoventa.getvalor_cancelado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cancelado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_difiere=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_difiere.setValue(formapagopuntoventa.getvalor_difiere());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_difiere);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(formapagopuntoventa.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_liquidacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_liquidacion.setValue(formapagopuntoventa.getnumero_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(formapagopuntoventa.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(formapagopuntoventa.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(formapagopuntoventa.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
						if(!formapagopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formapagopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formapagopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formapagopuntoventa.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventa)throws Exception  {		
		formapagopuntoventa.setIsNew(false);
		formapagopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception  {				
		for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas) {
			formapagopuntoventa.setIsNew(false);
			formapagopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarFormaPagoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
