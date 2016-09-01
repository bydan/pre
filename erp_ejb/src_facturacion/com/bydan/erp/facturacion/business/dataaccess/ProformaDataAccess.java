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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//ProformaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class ProformaDataAccess extends  ProformaDataAccessAdditional{ //ProformaDataAccessAdditional,DataAccessHelper<Proforma>
	//static Logger logger = Logger.getLogger(ProformaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="proforma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_ejercicio,id_periodo,id_anio,id_mes,numero_pre_impreso,fecha_emision,dias,fecha_vencimiento,id_moneda,cotizacion,id_empleado,id_formato,id_estado_proforma,direccion,id_cliente,ruc,es_oferta,telefono,id_tipo_precio,id_vendedor,id_sub_cliente,id_tipo_via_transporte,id_transporte,id_ruta_transporte,descripcion,descuento_porcentaje,monto_con_iva,suman,descuento_valor,monto_sin_iva,descuento_general,flete,ultimo_costo,subtotal,otros_cargos,margen_utilidad,iva,financiamiento,total,otros_valores,anticipo,ice,monto_retencion,fecha,fecha_servidor,hora_inicio,hora_fin,id_centro_costo,id_tipo_proforma,id_consignatario,id_tipo_cambio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,numero_pre_impreso=?,fecha_emision=?,dias=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_formato=?,id_estado_proforma=?,direccion=?,id_cliente=?,ruc=?,es_oferta=?,telefono=?,id_tipo_precio=?,id_vendedor=?,id_sub_cliente=?,id_tipo_via_transporte=?,id_transporte=?,id_ruta_transporte=?,descripcion=?,descuento_porcentaje=?,monto_con_iva=?,suman=?,descuento_valor=?,monto_sin_iva=?,descuento_general=?,flete=?,ultimo_costo=?,subtotal=?,otros_cargos=?,margen_utilidad=?,iva=?,financiamiento=?,total=?,otros_valores=?,anticipo=?,ice=?,monto_retencion=?,fecha=?,fecha_servidor=?,hora_inicio=?,hora_fin=?,id_centro_costo=?,id_tipo_proforma=?,id_consignatario=?,id_tipo_cambio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select proforma from "+ProformaConstantesFunciones.SPERSISTENCENAME+" proforma";
	public static String QUERYSELECTNATIVE="select "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".version_row,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_empresa,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_sucursal,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_usuario,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_ejercicio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_periodo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_anio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_mes,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".numero_pre_impreso,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha_emision,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".dias,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_moneda,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".cotizacion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_empleado,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_formato,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_estado_proforma,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".direccion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_cliente,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".ruc,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".es_oferta,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".telefono,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_precio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_vendedor,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_sub_cliente,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_transporte,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_ruta_transporte,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descripcion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descuento_porcentaje,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".monto_con_iva,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".suman,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descuento_valor,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".monto_sin_iva,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".descuento_general,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".flete,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".ultimo_costo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".subtotal,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".otros_cargos,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".margen_utilidad,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".iva,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".financiamiento,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".total,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".otros_valores,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".anticipo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".ice,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".monto_retencion,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".fecha_servidor,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".hora_inicio,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".hora_fin,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_centro_costo,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_proforma,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_consignatario,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id_tipo_cambio from "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME;//+" as "+ProformaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".id,"+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+".version_row from "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME;//+" as "+ProformaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProformaConstantesFunciones.SCHEMA+"."+ProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,numero_pre_impreso=?,fecha_emision=?,dias=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_formato=?,id_estado_proforma=?,direccion=?,id_cliente=?,ruc=?,es_oferta=?,telefono=?,id_tipo_precio=?,id_vendedor=?,id_sub_cliente=?,id_tipo_via_transporte=?,id_transporte=?,id_ruta_transporte=?,descripcion=?,descuento_porcentaje=?,monto_con_iva=?,suman=?,descuento_valor=?,monto_sin_iva=?,descuento_general=?,flete=?,ultimo_costo=?,subtotal=?,otros_cargos=?,margen_utilidad=?,iva=?,financiamiento=?,total=?,otros_valores=?,anticipo=?,ice=?,monto_retencion=?,fecha=?,fecha_servidor=?,hora_inicio=?,hora_fin=?,id_centro_costo=?,id_tipo_proforma=?,id_consignatario=?,id_tipo_cambio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PROFORMA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PROFORMA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PROFORMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PROFORMA_SELECT(?,?)";
	
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
	
	
	protected ProformaDataAccessAdditional proformaDataAccessAdditional=null;
	
	public ProformaDataAccessAdditional getProformaDataAccessAdditional() {
		return this.proformaDataAccessAdditional;
	}
	
	public void setProformaDataAccessAdditional(ProformaDataAccessAdditional proformaDataAccessAdditional) {
		try {
			this.proformaDataAccessAdditional=proformaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProformaDataAccess() {
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
		ProformaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProformaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProformaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProformaOriginal(Proforma proforma)throws Exception  {
		proforma.setProformaOriginal((Proforma)proforma.clone());		
	}
	
	public void setProformasOriginal(List<Proforma> proformas)throws Exception  {
		
		for(Proforma proforma:proformas){
			proforma.setProformaOriginal((Proforma)proforma.clone());
		}
	}
	
	public static void setProformaOriginalStatic(Proforma proforma)throws Exception  {
		proforma.setProformaOriginal((Proforma)proforma.clone());		
	}
	
	public static void setProformasOriginalStatic(List<Proforma> proformas)throws Exception  {
		
		for(Proforma proforma:proformas){
			proforma.setProformaOriginal((Proforma)proforma.clone());
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
	
	public  Proforma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Proforma entity = new Proforma();		
		
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
	
	public  Proforma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Proforma entity = new Proforma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.Proforma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProformaOriginal(new Proforma());
      	    	entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProforma("",entity,resultSet); 
				
				//entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProforma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Proforma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Proforma entity = new Proforma();
				
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
	
	public  Proforma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Proforma entity = new Proforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Proforma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProformaOriginal(new Proforma());
      	    	entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProforma("",entity,resultSet);    
				
				//entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Proforma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Proforma entity = new Proforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Proforma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Proforma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		
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
	
	public  List<Proforma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Proforma();
      	    	entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProforma("",entity,resultSet);
      	    	
				//entity.setProformaOriginal( new Proforma());
      	    	//entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProformas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Proforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
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
	
	public  List<Proforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Proforma();
				
				if(conMapGenerico) {
					entity.inicializarMapProforma();
					//entity.setMapProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         		
					entity=ProformaDataAccess.getEntityProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProformaOriginal( new Proforma());
					////entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProformas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Proforma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Proforma entity = new Proforma();		  
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
	
	public  Proforma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Proforma entity = new Proforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Proforma();
				
				if(conMapGenerico) {
					entity.inicializarMapProforma();
					//entity.setMapProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         		
					entity=ProformaDataAccess.getEntityProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProformaOriginal( new Proforma());
					////entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProforma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Proforma getEntityProforma(String strPrefijo,Proforma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Proforma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Proforma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProformaDataAccess.setFieldReflectionProforma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProforma=ProformaConstantesFunciones.getTodosTiposColumnasProforma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProforma) {
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
							field = Proforma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Proforma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProformaDataAccess.setFieldReflectionProforma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProforma(Field field,String strPrefijo,String sColumn,Proforma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProformaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProformaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProformaConstantesFunciones.DIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProformaConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProformaConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDESTADOPROFORMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProformaConstantesFunciones.ESOFERTA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProformaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDSUBCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDRUTATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProformaConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.MONTOCONIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.MONTOSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.DESCUENTOGENERAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.OTROSCARGOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.MARGENUTILIDAD:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.OTROSVALORES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.ANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.MONTORETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProformaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProformaConstantesFunciones.FECHASERVIDOR:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProformaConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case ProformaConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDTIPOPROFORMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDCONSIGNATARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProformaConstantesFunciones.IDTIPOCAMBIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Proforma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Proforma();
					entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProforma("",entity,resultSet);
					
					//entity.setProformaOriginal( new Proforma());
					//entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
					//entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProformas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Proforma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Proforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
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
	
	public  List<Proforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Proforma();
      	    	entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProforma("",entity,resultSet);
      	    	
				//entity.setProformaOriginal( new Proforma());
      	    	//entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProformas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Proforma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
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
	
	public  List<Proforma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Proforma> entities = new  ArrayList<Proforma>();
		Proforma entity = new Proforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Proforma();
      	    	entity=super.getEntity("",entity,resultSet,ProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProforma("",entity,resultSet);
      	    	
				//entity.setProformaOriginal( new Proforma());
      	    	//entity.setProformaOriginal(super.getEntity("",entity.getProformaOriginal(),resultSet,ProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProformaOriginal(this.getEntityProforma("",entity.getProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProformas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Proforma getEntityProforma(String strPrefijo,Proforma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDUSUARIO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+ProformaConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+ProformaConstantesFunciones.FECHAEMISION).getTime()));
				entity.setdias(resultSet.getInt(strPrefijo+ProformaConstantesFunciones.DIAS));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+ProformaConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.COTIZACION));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDEMPLEADO));
				entity.setid_formato(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_estado_proforma(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDESTADOPROFORMA));
				entity.setdireccion(resultSet.getString(strPrefijo+ProformaConstantesFunciones.DIRECCION));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDCLIENTE));
				entity.setruc(resultSet.getString(strPrefijo+ProformaConstantesFunciones.RUC));
				entity.setes_oferta(resultSet.getBoolean(strPrefijo+ProformaConstantesFunciones.ESOFERTA));
				entity.settelefono(resultSet.getString(strPrefijo+ProformaConstantesFunciones.TELEFONO));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDTIPOPRECIO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setid_sub_cliente(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDSUBCLIENTE));if(resultSet.wasNull()) {entity.setid_sub_cliente(null); }
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDTIPOVIATRANSPORTE));
				entity.setid_transporte(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDTRANSPORTE));
				entity.setid_ruta_transporte(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDRUTATRANSPORTE));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProformaConstantesFunciones.DESCRIPCION));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.setmonto_con_iva(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.MONTOCONIVA));
				entity.setsuman(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.SUMAN));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.DESCUENTOVALOR));
				entity.setmonto_sin_iva(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.MONTOSINIVA));
				entity.setdescuento_general(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.DESCUENTOGENERAL));
				entity.setflete(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.FLETE));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.ULTIMOCOSTO));
				entity.setsubtotal(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.SUBTOTAL));
				entity.setotros_cargos(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.OTROSCARGOS));
				entity.setmargen_utilidad(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.MARGENUTILIDAD));
				entity.setiva(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.IVA));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.FINANCIAMIENTO));
				entity.settotal(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.TOTAL));
				entity.setotros_valores(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.OTROSVALORES));
				entity.setanticipo(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.ANTICIPO));
				entity.setice(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.ICE));
				entity.setmonto_retencion(resultSet.getDouble(strPrefijo+ProformaConstantesFunciones.MONTORETENCION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ProformaConstantesFunciones.FECHA).getTime()));
				entity.setfecha_servidor(new Date(resultSet.getDate(strPrefijo+ProformaConstantesFunciones.FECHASERVIDOR).getTime()));
				entity.sethora_inicio(resultSet.getTime(strPrefijo+ProformaConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+ProformaConstantesFunciones.HORAFIN));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_tipo_proforma(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDTIPOPROFORMA));
				entity.setid_consignatario(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDCONSIGNATARIO));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+ProformaConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProforma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Proforma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProformaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProformaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProformaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProformaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProformaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProformaDataAccess.TABLENAME,ProformaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProformaDataAccess.setProformaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relproforma.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relproforma.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relproforma.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Ejercicio getEjercicio(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relproforma.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relproforma.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relproforma.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relproforma.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Moneda getMoneda(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relproforma.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relproforma.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relproforma.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public EstadoProforma getEstadoProforma(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		EstadoProforma estadoproforma= new EstadoProforma();

		try {
			EstadoProformaDataAccess estadoproformaDataAccess=new EstadoProformaDataAccess();

			//estadoproformaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoproformaDataAccess.setConnexionType(this.connexionType);
			estadoproformaDataAccess.setParameterDbType(this.parameterDbType);

			estadoproforma=estadoproformaDataAccess.getEntity(connexion,relproforma.getid_estado_proforma());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoproforma;

	}

	public Cliente getCliente(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relproforma.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relproforma.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Vendedor getVendedor(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relproforma.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public SubCliente getSubCliente(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		SubCliente subcliente= new SubCliente();

		try {
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);

			subcliente=subclienteDataAccess.getEntity(connexion,relproforma.getid_sub_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subcliente;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,relproforma.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}

	public Transporte getTransporte(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relproforma.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public RutaTransporte getRutaTransporte(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		RutaTransporte rutatransporte= new RutaTransporte();

		try {
			RutaTransporteDataAccess rutatransporteDataAccess=new RutaTransporteDataAccess();

			rutatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rutatransporteDataAccess.setConnexionType(this.connexionType);
			rutatransporteDataAccess.setParameterDbType(this.parameterDbType);

			rutatransporte=rutatransporteDataAccess.getEntity(connexion,relproforma.getid_ruta_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rutatransporte;

	}

	public CentroCosto getCentroCosto(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relproforma.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public TipoProforma getTipoProforma(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		TipoProforma tipoproforma= new TipoProforma();

		try {
			TipoProformaDataAccess tipoproformaDataAccess=new TipoProformaDataAccess();

			tipoproformaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproformaDataAccess.setConnexionType(this.connexionType);
			tipoproformaDataAccess.setParameterDbType(this.parameterDbType);

			tipoproforma=tipoproformaDataAccess.getEntity(connexion,relproforma.getid_tipo_proforma());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproforma;

	}

	public Consignatario getConsignatario(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		Consignatario consignatario= new Consignatario();

		try {
			ConsignatarioDataAccess consignatarioDataAccess=new ConsignatarioDataAccess();

			consignatarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			consignatarioDataAccess.setConnexionType(this.connexionType);
			consignatarioDataAccess.setParameterDbType(this.parameterDbType);

			consignatario=consignatarioDataAccess.getEntity(connexion,relproforma.getid_consignatario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignatario;

	}

	public TipoCambio getTipoCambio(Connexion connexion,Proforma relproforma)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relproforma.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}


		
		public List<TerminoProforma> getTerminoProformas(Connexion connexion,Proforma proforma)throws SQLException,Exception {

		List<TerminoProforma> terminoproformas= new ArrayList<TerminoProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProformaConstantesFunciones.SCHEMA+".proforma ON "+TerminoProformaConstantesFunciones.SCHEMA+".termino_proforma.id_proforma="+ProformaConstantesFunciones.SCHEMA+".proforma.id WHERE "+ProformaConstantesFunciones.SCHEMA+".proforma.id="+String.valueOf(proforma.getId());
			} else {
				sQuery=" INNER JOIN terminoproforma.Proforma WHERE terminoproforma.Proforma.id="+String.valueOf(proforma.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TerminoProformaDataAccess terminoproformaDataAccess=new TerminoProformaDataAccess();

			terminoproformaDataAccess.setConnexionType(this.connexionType);
			terminoproformaDataAccess.setParameterDbType(this.parameterDbType);
			terminoproformas=terminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return terminoproformas;

	}

	public List<DetalleProforma> getDetalleProformas(Connexion connexion,Proforma proforma)throws SQLException,Exception {

		List<DetalleProforma> detalleproformas= new ArrayList<DetalleProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProformaConstantesFunciones.SCHEMA+".proforma ON "+DetalleProformaConstantesFunciones.SCHEMA+".detalle_proforma.id_proforma="+ProformaConstantesFunciones.SCHEMA+".proforma.id WHERE "+ProformaConstantesFunciones.SCHEMA+".proforma.id="+String.valueOf(proforma.getId());
			} else {
				sQuery=" INNER JOIN detalleproforma.Proforma WHERE detalleproforma.Proforma.id="+String.valueOf(proforma.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProformaDataAccess detalleproformaDataAccess=new DetalleProformaDataAccess();

			detalleproformaDataAccess.setConnexionType(this.connexionType);
			detalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproformas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Proforma proforma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!proforma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(proforma.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(proforma.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(proforma.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(proforma.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(proforma.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(proforma.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(proforma.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_pre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_pre_impreso.setValue(proforma.getnumero_pre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_pre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(proforma.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedias=new ParameterValue<Integer>();
					parameterMaintenanceValuedias.setValue(proforma.getdias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(proforma.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(proforma.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(proforma.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(proforma.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(proforma.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_proforma=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_proforma.setValue(proforma.getid_estado_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(proforma.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(proforma.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(proforma.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_oferta=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_oferta.setValue(proforma.getes_oferta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_oferta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(proforma.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(proforma.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(proforma.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_cliente.setValue(proforma.getid_sub_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(proforma.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(proforma.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ruta_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_ruta_transporte.setValue(proforma.getid_ruta_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ruta_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(proforma.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(proforma.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_con_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_con_iva.setValue(proforma.getmonto_con_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_con_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(proforma.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(proforma.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_sin_iva.setValue(proforma.getmonto_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_general=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_general.setValue(proforma.getdescuento_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(proforma.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(proforma.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesubtotal=new ParameterValue<Double>();
					parameterMaintenanceValuesubtotal.setValue(proforma.getsubtotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesubtotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_cargos=new ParameterValue<Double>();
					parameterMaintenanceValueotros_cargos.setValue(proforma.getotros_cargos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_cargos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemargen_utilidad=new ParameterValue<Double>();
					parameterMaintenanceValuemargen_utilidad.setValue(proforma.getmargen_utilidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemargen_utilidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(proforma.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(proforma.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(proforma.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_valores=new ParameterValue<Double>();
					parameterMaintenanceValueotros_valores.setValue(proforma.getotros_valores());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_valores);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueanticipo=new ParameterValue<Double>();
					parameterMaintenanceValueanticipo.setValue(proforma.getanticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(proforma.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_retencion.setValue(proforma.getmonto_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(proforma.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_servidor=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_servidor.setValue(proforma.getfecha_servidor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_servidor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(proforma.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(proforma.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(proforma.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proforma=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proforma.setValue(proforma.getid_tipo_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_consignatario=new ParameterValue<Long>();
					parameterMaintenanceValueid_consignatario.setValue(proforma.getid_consignatario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_consignatario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(proforma.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
						if(!proforma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(proforma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(proforma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(proforma.getId());
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
	
	public void setIsNewIsChangedFalseProforma(Proforma proforma)throws Exception  {		
		proforma.setIsNew(false);
		proforma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProformas(List<Proforma> proformas)throws Exception  {				
		for(Proforma proforma:proformas) {
			proforma.setIsNew(false);
			proforma.setIsChanged(false);
		}
	}
	
	public void generarExportarProforma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
