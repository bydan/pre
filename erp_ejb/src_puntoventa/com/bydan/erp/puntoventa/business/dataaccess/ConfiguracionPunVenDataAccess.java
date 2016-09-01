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
import com.bydan.erp.puntoventa.util.*;//ConfiguracionPunVenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ConfiguracionPunVenDataAccess extends  ConfiguracionPunVenDataAccessAdditional{ //ConfiguracionPunVenDataAccessAdditional,DataAccessHelper<ConfiguracionPunVen>
	//static Logger logger = Logger.getLogger(ConfiguracionPunVenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="configuracion_pun_ven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_cuenta_contable_efectivo,id_cuenta_contable_ice,id_cuenta_contable_otros,id_cliente_consumidor_final,id_tipo_documento_factura,id_tipo_documento_nota_venta,id_tipo_documento_nota_credito,id_tipo_documento_tarjeta_credito,id_formato_factura,id_formato_nota_venta,id_formato_nota_credito,id_transaccion_factura,id_transaccion_nota_venta,id_transaccion_nota_credito,id_transaccion_cuenta_factura,id_transaccion_cuenta_nota_venta,id_transaccion_cuenta_nota_credito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_cuenta_contable_efectivo=?,id_cuenta_contable_ice=?,id_cuenta_contable_otros=?,id_cliente_consumidor_final=?,id_tipo_documento_factura=?,id_tipo_documento_nota_venta=?,id_tipo_documento_nota_credito=?,id_tipo_documento_tarjeta_credito=?,id_formato_factura=?,id_formato_nota_venta=?,id_formato_nota_credito=?,id_transaccion_factura=?,id_transaccion_nota_venta=?,id_transaccion_nota_credito=?,id_transaccion_cuenta_factura=?,id_transaccion_cuenta_nota_venta=?,id_transaccion_cuenta_nota_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select configuracionpunven from "+ConfiguracionPunVenConstantesFunciones.SPERSISTENCENAME+" configuracionpunven";
	public static String QUERYSELECTNATIVE="select "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".version_row,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_empresa,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_bodega,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable_efectivo,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable_ice,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable_otros,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_cliente_consumidor_final,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_nota_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_tipo_documento_tarjeta_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_formato_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_formato_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_formato_nota_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_nota_credito,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_cuenta_factura,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_cuenta_nota_venta,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id_transaccion_cuenta_nota_credito from "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME;//+" as "+ConfiguracionPunVenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".id,"+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+".version_row from "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME;//+" as "+ConfiguracionPunVenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ConfiguracionPunVenConstantesFunciones.SCHEMA+"."+ConfiguracionPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_cuenta_contable_efectivo=?,id_cuenta_contable_ice=?,id_cuenta_contable_otros=?,id_cliente_consumidor_final=?,id_tipo_documento_factura=?,id_tipo_documento_nota_venta=?,id_tipo_documento_nota_credito=?,id_tipo_documento_tarjeta_credito=?,id_formato_factura=?,id_formato_nota_venta=?,id_formato_nota_credito=?,id_transaccion_factura=?,id_transaccion_nota_venta=?,id_transaccion_nota_credito=?,id_transaccion_cuenta_factura=?,id_transaccion_cuenta_nota_venta=?,id_transaccion_cuenta_nota_credito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CONFIGURACIONPUNVEN_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CONFIGURACIONPUNVEN_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CONFIGURACIONPUNVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CONFIGURACIONPUNVEN_SELECT(?,?)";
	
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
	
	
	protected ConfiguracionPunVenDataAccessAdditional configuracionpunvenDataAccessAdditional=null;
	
	public ConfiguracionPunVenDataAccessAdditional getConfiguracionPunVenDataAccessAdditional() {
		return this.configuracionpunvenDataAccessAdditional;
	}
	
	public void setConfiguracionPunVenDataAccessAdditional(ConfiguracionPunVenDataAccessAdditional configuracionpunvenDataAccessAdditional) {
		try {
			this.configuracionpunvenDataAccessAdditional=configuracionpunvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ConfiguracionPunVenDataAccess() {
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
		ConfiguracionPunVenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ConfiguracionPunVenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ConfiguracionPunVenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setConfiguracionPunVenOriginal(ConfiguracionPunVen configuracionpunven)throws Exception  {
		configuracionpunven.setConfiguracionPunVenOriginal((ConfiguracionPunVen)configuracionpunven.clone());		
	}
	
	public void setConfiguracionPunVensOriginal(List<ConfiguracionPunVen> configuracionpunvens)throws Exception  {
		
		for(ConfiguracionPunVen configuracionpunven:configuracionpunvens){
			configuracionpunven.setConfiguracionPunVenOriginal((ConfiguracionPunVen)configuracionpunven.clone());
		}
	}
	
	public static void setConfiguracionPunVenOriginalStatic(ConfiguracionPunVen configuracionpunven)throws Exception  {
		configuracionpunven.setConfiguracionPunVenOriginal((ConfiguracionPunVen)configuracionpunven.clone());		
	}
	
	public static void setConfiguracionPunVensOriginalStatic(List<ConfiguracionPunVen> configuracionpunvens)throws Exception  {
		
		for(ConfiguracionPunVen configuracionpunven:configuracionpunvens){
			configuracionpunven.setConfiguracionPunVenOriginal((ConfiguracionPunVen)configuracionpunven.clone());
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
	
	public  ConfiguracionPunVen getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		
		
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
	
	public  ConfiguracionPunVen getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.ConfiguracionPunVen.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setConfiguracionPunVenOriginal(new ConfiguracionPunVen());
      	    	entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConfiguracionPunVen("",entity,resultSet); 
				
				//entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseConfiguracionPunVen(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ConfiguracionPunVen getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ConfiguracionPunVen entity = new ConfiguracionPunVen();
				
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
	
	public  ConfiguracionPunVen getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ConfiguracionPunVen entity = new ConfiguracionPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConfiguracionPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.ConfiguracionPunVen.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setConfiguracionPunVenOriginal(new ConfiguracionPunVen());
      	    	entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConfiguracionPunVen("",entity,resultSet);    
				
				//entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseConfiguracionPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ConfiguracionPunVen
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ConfiguracionPunVen entity = new ConfiguracionPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConfiguracionPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.ConfiguracionPunVen.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseConfiguracionPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ConfiguracionPunVen> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		
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
	
	public  List<ConfiguracionPunVen> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConfiguracionPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConfiguracionPunVen();
      	    	entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConfiguracionPunVen("",entity,resultSet);
      	    	
				//entity.setConfiguracionPunVenOriginal( new ConfiguracionPunVen());
      	    	//entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConfiguracionPunVens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConfiguracionPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ConfiguracionPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
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
	
	public  List<ConfiguracionPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConfiguracionPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapConfiguracionPunVen();
					//entity.setMapConfiguracionPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapConfiguracionPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConfiguracionPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         		
					entity=ConfiguracionPunVenDataAccess.getEntityConfiguracionPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConfiguracionPunVenOriginal( new ConfiguracionPunVen());
					////entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConfiguracionPunVens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConfiguracionPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ConfiguracionPunVen getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
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
	
	public  ConfiguracionPunVen getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConfiguracionPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapConfiguracionPunVen();
					//entity.setMapConfiguracionPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapConfiguracionPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConfiguracionPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         		
					entity=ConfiguracionPunVenDataAccess.getEntityConfiguracionPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConfiguracionPunVenOriginal( new ConfiguracionPunVen());
					////entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseConfiguracionPunVen(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConfiguracionPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ConfiguracionPunVen getEntityConfiguracionPunVen(String strPrefijo,ConfiguracionPunVen entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ConfiguracionPunVen.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ConfiguracionPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ConfiguracionPunVenDataAccess.setFieldReflectionConfiguracionPunVen(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasConfiguracionPunVen=ConfiguracionPunVenConstantesFunciones.getTodosTiposColumnasConfiguracionPunVen();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasConfiguracionPunVen) {
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
							field = ConfiguracionPunVen.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ConfiguracionPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ConfiguracionPunVenDataAccess.setFieldReflectionConfiguracionPunVen(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConfiguracionPunVen(Field field,String strPrefijo,String sColumn,ConfiguracionPunVen entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConfiguracionPunVenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ConfiguracionPunVen>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConfiguracionPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ConfiguracionPunVen();
					entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityConfiguracionPunVen("",entity,resultSet);
					
					//entity.setConfiguracionPunVenOriginal( new ConfiguracionPunVen());
					//entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
					//entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseConfiguracionPunVens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConfiguracionPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ConfiguracionPunVen>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConfiguracionPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConfiguracionPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ConfiguracionPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
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
	
	public  List<ConfiguracionPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConfiguracionPunVen();
      	    	entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConfiguracionPunVen("",entity,resultSet);
      	    	
				//entity.setConfiguracionPunVenOriginal( new ConfiguracionPunVen());
      	    	//entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseConfiguracionPunVens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConfiguracionPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ConfiguracionPunVen> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
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
	
	public  List<ConfiguracionPunVen> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ConfiguracionPunVen> entities = new  ArrayList<ConfiguracionPunVen>();
		ConfiguracionPunVen entity = new ConfiguracionPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ConfiguracionPunVen();
      	    	entity=super.getEntity("",entity,resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConfiguracionPunVen("",entity,resultSet);
      	    	
				//entity.setConfiguracionPunVenOriginal( new ConfiguracionPunVen());
      	    	//entity.setConfiguracionPunVenOriginal(super.getEntity("",entity.getConfiguracionPunVenOriginal(),resultSet,ConfiguracionPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConfiguracionPunVenOriginal(this.getEntityConfiguracionPunVen("",entity.getConfiguracionPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConfiguracionPunVens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ConfiguracionPunVen getEntityConfiguracionPunVen(String strPrefijo,ConfiguracionPunVen entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDBODEGA));
				entity.setid_cuenta_contable_efectivo(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEEFECTIVO));
				entity.setid_cuenta_contable_ice(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEICE));
				entity.setid_cuenta_contable_otros(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDCUENTACONTABLEOTROS));
				entity.setid_cliente_consumidor_final(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDCLIENTECONSUMIDORFINAL));
				entity.setid_tipo_documento_factura(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOFACTURA));
				entity.setid_tipo_documento_nota_venta(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTAVENTA));
				entity.setid_tipo_documento_nota_credito(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTONOTACREDITO));
				entity.setid_tipo_documento_tarjeta_credito(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTIPODOCUMENTOTARJETACREDITO));
				entity.setid_formato_factura(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDFORMATOFACTURA));
				entity.setid_formato_nota_venta(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDFORMATONOTAVENTA));
				entity.setid_formato_nota_credito(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDFORMATONOTACREDITO));
				entity.setid_transaccion_factura(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONFACTURA));
				entity.setid_transaccion_nota_venta(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTAVENTA));
				entity.setid_transaccion_nota_credito(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONNOTACREDITO));
				entity.setid_transaccion_cuenta_factura(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTAFACTURA));
				entity.setid_transaccion_cuenta_nota_venta(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTAVENTA));
				entity.setid_transaccion_cuenta_nota_credito(resultSet.getLong(strPrefijo+ConfiguracionPunVenConstantesFunciones.IDTRANSACCIONCUENTANOTACREDITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowConfiguracionPunVen(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ConfiguracionPunVen entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ConfiguracionPunVenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ConfiguracionPunVenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ConfiguracionPunVenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ConfiguracionPunVenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ConfiguracionPunVenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ConfiguracionPunVenDataAccess.TABLENAME,ConfiguracionPunVenDataAccess.ISWITHSTOREPROCEDURES);
			
			ConfiguracionPunVenDataAccess.setConfiguracionPunVenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relconfiguracionpunven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relconfiguracionpunven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relconfiguracionpunven.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public CuentaContable getCuentaContableEfectivo(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relconfiguracionpunven.getid_cuenta_contable_efectivo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIce(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relconfiguracionpunven.getid_cuenta_contable_ice());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableOtros(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relconfiguracionpunven.getid_cuenta_contable_otros());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Cliente getClienteConsumidorFinal(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relconfiguracionpunven.getid_cliente_consumidor_final());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoDocumento getTipoDocumentoFactura(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_tipo_documento_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoDocumento getTipoDocumentoNotaVenta(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_tipo_documento_nota_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoDocumento getTipoDocumentoNotaCredito(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_tipo_documento_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoDocumento getTipoDocumentoTarjetaCredito(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_tipo_documento_tarjeta_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public Formato getFormatoFactura(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_formato_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoNotaVenta(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_formato_nota_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoNotaCredito(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relconfiguracionpunven.getid_formato_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Transaccion getTransaccionFactura(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relconfiguracionpunven.getid_transaccion_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionNotaVenta(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relconfiguracionpunven.getid_transaccion_nota_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionNotaCredito(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relconfiguracionpunven.getid_transaccion_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaFactura(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relconfiguracionpunven.getid_transaccion_cuenta_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaNotaVenta(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relconfiguracionpunven.getid_transaccion_cuenta_nota_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCuentaNotaCredito(Connexion connexion,ConfiguracionPunVen relconfiguracionpunven)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relconfiguracionpunven.getid_transaccion_cuenta_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ConfiguracionPunVen configuracionpunven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!configuracionpunven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(configuracionpunven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(configuracionpunven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(configuracionpunven.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_efectivo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_efectivo.setValue(configuracionpunven.getid_cuenta_contable_efectivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_efectivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ice=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ice.setValue(configuracionpunven.getid_cuenta_contable_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_otros=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_otros.setValue(configuracionpunven.getid_cuenta_contable_otros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_otros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_consumidor_final=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_consumidor_final.setValue(configuracionpunven.getid_cliente_consumidor_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_consumidor_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_factura.setValue(configuracionpunven.getid_tipo_documento_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_nota_venta.setValue(configuracionpunven.getid_tipo_documento_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_nota_credito.setValue(configuracionpunven.getid_tipo_documento_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_tarjeta_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_tarjeta_credito.setValue(configuracionpunven.getid_tipo_documento_tarjeta_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_tarjeta_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_factura.setValue(configuracionpunven.getid_formato_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nota_venta.setValue(configuracionpunven.getid_formato_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nota_credito.setValue(configuracionpunven.getid_formato_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_factura.setValue(configuracionpunven.getid_transaccion_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_nota_venta.setValue(configuracionpunven.getid_transaccion_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_nota_credito.setValue(configuracionpunven.getid_transaccion_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_factura.setValue(configuracionpunven.getid_transaccion_cuenta_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_nota_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_nota_venta.setValue(configuracionpunven.getid_transaccion_cuenta_nota_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_nota_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cuenta_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cuenta_nota_credito.setValue(configuracionpunven.getid_transaccion_cuenta_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cuenta_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!configuracionpunven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(configuracionpunven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(configuracionpunven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(configuracionpunven.getId());
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
	
	public void setIsNewIsChangedFalseConfiguracionPunVen(ConfiguracionPunVen configuracionpunven)throws Exception  {		
		configuracionpunven.setIsNew(false);
		configuracionpunven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseConfiguracionPunVens(List<ConfiguracionPunVen> configuracionpunvens)throws Exception  {				
		for(ConfiguracionPunVen configuracionpunven:configuracionpunvens) {
			configuracionpunven.setIsNew(false);
			configuracionpunven.setIsChanged(false);
		}
	}
	
	public void generarExportarConfiguracionPunVen(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
