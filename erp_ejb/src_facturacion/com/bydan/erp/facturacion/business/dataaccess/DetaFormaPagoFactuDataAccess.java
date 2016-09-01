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
import com.bydan.erp.facturacion.util.*;//DetaFormaPagoFactuConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class DetaFormaPagoFactuDataAccess extends  DetaFormaPagoFactuDataAccessAdditional{ //DetaFormaPagoFactuDataAccessAdditional,DataAccessHelper<DetaFormaPagoFactu>
	//static Logger logger = Logger.getLogger(DetaFormaPagoFactuDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="deta_forma_pago_factu";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_forma_pago,nombre,descripcion)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_forma_pago=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detaformapagofactu from "+DetaFormaPagoFactuConstantesFunciones.SPERSISTENCENAME+" detaformapagofactu";
	public static String QUERYSELECTNATIVE="select "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".version_row,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id_empresa,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".nombre,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".descripcion from "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME;//+" as "+DetaFormaPagoFactuConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".id,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".version_row,"+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+".nombre from "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME;//+" as "+DetaFormaPagoFactuConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+"."+DetaFormaPagoFactuConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_forma_pago=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETAFORMAPAGOFACTU_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETAFORMAPAGOFACTU_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETAFORMAPAGOFACTU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETAFORMAPAGOFACTU_SELECT(?,?)";
	
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
	
	
	protected DetaFormaPagoFactuDataAccessAdditional detaformapagofactuDataAccessAdditional=null;
	
	public DetaFormaPagoFactuDataAccessAdditional getDetaFormaPagoFactuDataAccessAdditional() {
		return this.detaformapagofactuDataAccessAdditional;
	}
	
	public void setDetaFormaPagoFactuDataAccessAdditional(DetaFormaPagoFactuDataAccessAdditional detaformapagofactuDataAccessAdditional) {
		try {
			this.detaformapagofactuDataAccessAdditional=detaformapagofactuDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetaFormaPagoFactuDataAccess() {
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
		DetaFormaPagoFactuDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetaFormaPagoFactuDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetaFormaPagoFactuDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetaFormaPagoFactuOriginal(DetaFormaPagoFactu detaformapagofactu)throws Exception  {
		detaformapagofactu.setDetaFormaPagoFactuOriginal((DetaFormaPagoFactu)detaformapagofactu.clone());		
	}
	
	public void setDetaFormaPagoFactusOriginal(List<DetaFormaPagoFactu> detaformapagofactus)throws Exception  {
		
		for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus){
			detaformapagofactu.setDetaFormaPagoFactuOriginal((DetaFormaPagoFactu)detaformapagofactu.clone());
		}
	}
	
	public static void setDetaFormaPagoFactuOriginalStatic(DetaFormaPagoFactu detaformapagofactu)throws Exception  {
		detaformapagofactu.setDetaFormaPagoFactuOriginal((DetaFormaPagoFactu)detaformapagofactu.clone());		
	}
	
	public static void setDetaFormaPagoFactusOriginalStatic(List<DetaFormaPagoFactu> detaformapagofactus)throws Exception  {
		
		for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus){
			detaformapagofactu.setDetaFormaPagoFactuOriginal((DetaFormaPagoFactu)detaformapagofactu.clone());
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
	
	public  DetaFormaPagoFactu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		
		
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
	
	public  DetaFormaPagoFactu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetaFormaPagoFactu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetaFormaPagoFactuOriginal(new DetaFormaPagoFactu());
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaFormaPagoFactu("",entity,resultSet); 
				
				//entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaFormaPagoFactu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetaFormaPagoFactu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();
				
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
	
	public  DetaFormaPagoFactu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaFormaPagoFactu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetaFormaPagoFactuOriginal(new DetaFormaPagoFactu());
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaFormaPagoFactu("",entity,resultSet);    
				
				//entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaFormaPagoFactu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetaFormaPagoFactu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaFormaPagoFactu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetaFormaPagoFactu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetaFormaPagoFactu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		
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
	
	public  List<DetaFormaPagoFactu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPagoFactu();
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaFormaPagoFactu("",entity,resultSet);
      	    	
				//entity.setDetaFormaPagoFactuOriginal( new DetaFormaPagoFactu());
      	    	//entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagoFactus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPagoFactu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaFormaPagoFactu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
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
	
	public  List<DetaFormaPagoFactu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPagoFactu();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaFormaPagoFactu();
					//entity.setMapDetaFormaPagoFactu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetaFormaPagoFactuValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaFormaPagoFactu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         		
					entity=DetaFormaPagoFactuDataAccess.getEntityDetaFormaPagoFactu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaFormaPagoFactuOriginal( new DetaFormaPagoFactu());
					////entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagoFactus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPagoFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetaFormaPagoFactu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
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
	
	public  DetaFormaPagoFactu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPagoFactu();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaFormaPagoFactu();
					//entity.setMapDetaFormaPagoFactu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetaFormaPagoFactuValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaFormaPagoFactu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         		
					entity=DetaFormaPagoFactuDataAccess.getEntityDetaFormaPagoFactu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaFormaPagoFactuOriginal( new DetaFormaPagoFactu());
					////entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagoFactu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPagoFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetaFormaPagoFactu getEntityDetaFormaPagoFactu(String strPrefijo,DetaFormaPagoFactu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetaFormaPagoFactu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetaFormaPagoFactu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetaFormaPagoFactuDataAccess.setFieldReflectionDetaFormaPagoFactu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetaFormaPagoFactu=DetaFormaPagoFactuConstantesFunciones.getTodosTiposColumnasDetaFormaPagoFactu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetaFormaPagoFactu) {
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
							field = DetaFormaPagoFactu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetaFormaPagoFactu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetaFormaPagoFactuDataAccess.setFieldReflectionDetaFormaPagoFactu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetaFormaPagoFactu(Field field,String strPrefijo,String sColumn,DetaFormaPagoFactu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetaFormaPagoFactuConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoFactuConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaFormaPagoFactuConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaFormaPagoFactuConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaFormaPagoFactuConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaFormaPagoFactu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetaFormaPagoFactu();
					entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetaFormaPagoFactu("",entity,resultSet);
					
					//entity.setDetaFormaPagoFactuOriginal( new DetaFormaPagoFactu());
					//entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
					//entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetaFormaPagoFactus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPagoFactu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaFormaPagoFactu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaFormaPagoFactuDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaFormaPagoFactuDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetaFormaPagoFactu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
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
	
	public  List<DetaFormaPagoFactu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPagoFactu();
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaFormaPagoFactu("",entity,resultSet);
      	    	
				//entity.setDetaFormaPagoFactuOriginal( new DetaFormaPagoFactu());
      	    	//entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetaFormaPagoFactus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaFormaPagoFactu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaFormaPagoFactu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
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
	
	public  List<DetaFormaPagoFactu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaFormaPagoFactu> entities = new  ArrayList<DetaFormaPagoFactu>();
		DetaFormaPagoFactu entity = new DetaFormaPagoFactu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaFormaPagoFactu();
      	    	entity=super.getEntity("",entity,resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaFormaPagoFactu("",entity,resultSet);
      	    	
				//entity.setDetaFormaPagoFactuOriginal( new DetaFormaPagoFactu());
      	    	//entity.setDetaFormaPagoFactuOriginal(super.getEntity("",entity.getDetaFormaPagoFactuOriginal(),resultSet,DetaFormaPagoFactuDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaFormaPagoFactuOriginal(this.getEntityDetaFormaPagoFactu("",entity.getDetaFormaPagoFactuOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaFormaPagoFactus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetaFormaPagoFactu getEntityDetaFormaPagoFactu(String strPrefijo,DetaFormaPagoFactu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetaFormaPagoFactuConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_forma_pago(resultSet.getLong(strPrefijo+DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO));
				entity.setnombre(resultSet.getString(strPrefijo+DetaFormaPagoFactuConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetaFormaPagoFactuConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+DetaFormaPagoFactuConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetaFormaPagoFactu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetaFormaPagoFactu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetaFormaPagoFactuDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetaFormaPagoFactuDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetaFormaPagoFactuDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetaFormaPagoFactuDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetaFormaPagoFactuConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetaFormaPagoFactuDataAccess.TABLENAME,DetaFormaPagoFactuDataAccess.ISWITHSTOREPROCEDURES);
			
			DetaFormaPagoFactuDataAccess.setDetaFormaPagoFactuOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetaFormaPagoFactu reldetaformapagofactu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetaformapagofactu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoFormaPago getTipoFormaPago(Connexion connexion,DetaFormaPagoFactu reldetaformapagofactu)throws SQLException,Exception {

		TipoFormaPago tipoformapago= new TipoFormaPago();

		try {
			TipoFormaPagoDataAccess tipoformapagoDataAccess=new TipoFormaPagoDataAccess();

			tipoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformapagoDataAccess.setConnexionType(this.connexionType);
			tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,reldetaformapagofactu.getid_tipo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformapago;

	}


		
		public List<DetaFormaPago> getDetaFormaPagos(Connexion connexion,DetaFormaPagoFactu detaformapagofactu)throws SQLException,Exception {

		List<DetaFormaPago> detaformapagos= new ArrayList<DetaFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+".deta_forma_pago_factu ON "+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago.id_deta_forma_pago_factu="+DetaFormaPagoFactuConstantesFunciones.SCHEMA+".deta_forma_pago_factu.id WHERE "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+".deta_forma_pago_factu.id="+String.valueOf(detaformapagofactu.getId());
			} else {
				sQuery=" INNER JOIN detaformapago.DetaFormaPagoFactu WHERE detaformapago.DetaFormaPagoFactu.id="+String.valueOf(detaformapagofactu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaFormaPagoDataAccess detaformapagoDataAccess=new DetaFormaPagoDataAccess();

			detaformapagoDataAccess.setConnexionType(this.connexionType);
			detaformapagoDataAccess.setParameterDbType(this.parameterDbType);
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapagos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetaFormaPagoFactu detaformapagofactu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detaformapagofactu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detaformapagofactu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_forma_pago.setValue(detaformapagofactu.getid_tipo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(detaformapagofactu.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detaformapagofactu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detaformapagofactu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detaformapagofactu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detaformapagofactu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detaformapagofactu.getId());
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
	
	public void setIsNewIsChangedFalseDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu)throws Exception  {		
		detaformapagofactu.setIsNew(false);
		detaformapagofactu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetaFormaPagoFactus(List<DetaFormaPagoFactu> detaformapagofactus)throws Exception  {				
		for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus) {
			detaformapagofactu.setIsNew(false);
			detaformapagofactu.setIsChanged(false);
		}
	}
	
	public void generarExportarDetaFormaPagoFactu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
