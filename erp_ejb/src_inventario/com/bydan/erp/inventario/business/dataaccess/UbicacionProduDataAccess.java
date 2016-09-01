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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//UbicacionProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class UbicacionProduDataAccess extends  UbicacionProduDataAccessAdditional{ //UbicacionProduDataAccessAdditional,DataAccessHelper<UbicacionProdu>
	//static Logger logger = Logger.getLogger(UbicacionProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="ubicacion_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_ubicacion_bode)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_ubicacion_bode=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select ubicacionprodu from "+UbicacionProduConstantesFunciones.SPERSISTENCENAME+" ubicacionprodu";
	public static String QUERYSELECTNATIVE="select "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".version_row,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_empresa,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_sucursal,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_bodega,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_producto,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id_ubicacion_bode from "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME;//+" as "+UbicacionProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".id,"+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+".version_row from "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME;//+" as "+UbicacionProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UbicacionProduConstantesFunciones.SCHEMA+"."+UbicacionProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_ubicacion_bode=?";
	
	public static String STOREPROCEDUREINSERT="call SP_UBICACIONPRODU_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_UBICACIONPRODU_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_UBICACIONPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_UBICACIONPRODU_SELECT(?,?)";
	
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
	
	
	protected UbicacionProduDataAccessAdditional ubicacionproduDataAccessAdditional=null;
	
	public UbicacionProduDataAccessAdditional getUbicacionProduDataAccessAdditional() {
		return this.ubicacionproduDataAccessAdditional;
	}
	
	public void setUbicacionProduDataAccessAdditional(UbicacionProduDataAccessAdditional ubicacionproduDataAccessAdditional) {
		try {
			this.ubicacionproduDataAccessAdditional=ubicacionproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UbicacionProduDataAccess() {
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
		UbicacionProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UbicacionProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UbicacionProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUbicacionProduOriginal(UbicacionProdu ubicacionprodu)throws Exception  {
		ubicacionprodu.setUbicacionProduOriginal((UbicacionProdu)ubicacionprodu.clone());		
	}
	
	public void setUbicacionProdusOriginal(List<UbicacionProdu> ubicacionprodus)throws Exception  {
		
		for(UbicacionProdu ubicacionprodu:ubicacionprodus){
			ubicacionprodu.setUbicacionProduOriginal((UbicacionProdu)ubicacionprodu.clone());
		}
	}
	
	public static void setUbicacionProduOriginalStatic(UbicacionProdu ubicacionprodu)throws Exception  {
		ubicacionprodu.setUbicacionProduOriginal((UbicacionProdu)ubicacionprodu.clone());		
	}
	
	public static void setUbicacionProdusOriginalStatic(List<UbicacionProdu> ubicacionprodus)throws Exception  {
		
		for(UbicacionProdu ubicacionprodu:ubicacionprodus){
			ubicacionprodu.setUbicacionProduOriginal((UbicacionProdu)ubicacionprodu.clone());
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
	
	public  UbicacionProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		UbicacionProdu entity = new UbicacionProdu();		
		
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
	
	public  UbicacionProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		UbicacionProdu entity = new UbicacionProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.UbicacionProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUbicacionProduOriginal(new UbicacionProdu());
      	    	entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUbicacionProdu("",entity,resultSet); 
				
				//entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUbicacionProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  UbicacionProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UbicacionProdu entity = new UbicacionProdu();
				
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
	
	public  UbicacionProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UbicacionProdu entity = new UbicacionProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.UbicacionProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUbicacionProduOriginal(new UbicacionProdu());
      	    	entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUbicacionProdu("",entity,resultSet);    
				
				//entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUbicacionProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //UbicacionProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		UbicacionProdu entity = new UbicacionProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.UbicacionProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUbicacionProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<UbicacionProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		
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
	
	public  List<UbicacionProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionProdu();
      	    	entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUbicacionProdu("",entity,resultSet);
      	    	
				//entity.setUbicacionProduOriginal( new UbicacionProdu());
      	    	//entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUbicacionProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UbicacionProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
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
	
	public  List<UbicacionProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapUbicacionProdu();
					//entity.setMapUbicacionProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUbicacionProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUbicacionProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         		
					entity=UbicacionProduDataAccess.getEntityUbicacionProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUbicacionProduOriginal( new UbicacionProdu());
					////entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
					////entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUbicacionProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public UbicacionProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UbicacionProdu entity = new UbicacionProdu();		  
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
	
	public  UbicacionProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapUbicacionProdu();
					//entity.setMapUbicacionProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUbicacionProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUbicacionProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         		
					entity=UbicacionProduDataAccess.getEntityUbicacionProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUbicacionProduOriginal( new UbicacionProdu());
					////entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
					////entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUbicacionProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static UbicacionProdu getEntityUbicacionProdu(String strPrefijo,UbicacionProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = UbicacionProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = UbicacionProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UbicacionProduDataAccess.setFieldReflectionUbicacionProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUbicacionProdu=UbicacionProduConstantesFunciones.getTodosTiposColumnasUbicacionProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUbicacionProdu) {
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
							field = UbicacionProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = UbicacionProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UbicacionProduDataAccess.setFieldReflectionUbicacionProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUbicacionProdu(Field field,String strPrefijo,String sColumn,UbicacionProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UbicacionProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UbicacionProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionProduConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionProduConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionProduConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UbicacionProduConstantesFunciones.IDUBICACIONBODE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UbicacionProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new UbicacionProdu();
					entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUbicacionProdu("",entity,resultSet);
					
					//entity.setUbicacionProduOriginal( new UbicacionProdu());
					//entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
					//entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUbicacionProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UbicacionProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UbicacionProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UbicacionProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<UbicacionProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
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
	
	public  List<UbicacionProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionProdu();
      	    	entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUbicacionProdu("",entity,resultSet);
      	    	
				//entity.setUbicacionProduOriginal( new UbicacionProdu());
      	    	//entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUbicacionProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUbicacionProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UbicacionProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
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
	
	public  List<UbicacionProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UbicacionProdu> entities = new  ArrayList<UbicacionProdu>();
		UbicacionProdu entity = new UbicacionProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UbicacionProdu();
      	    	entity=super.getEntity("",entity,resultSet,UbicacionProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUbicacionProdu("",entity,resultSet);
      	    	
				//entity.setUbicacionProduOriginal( new UbicacionProdu());
      	    	//entity.setUbicacionProduOriginal(super.getEntity("",entity.getUbicacionProduOriginal(),resultSet,UbicacionProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUbicacionProduOriginal(this.getEntityUbicacionProdu("",entity.getUbicacionProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUbicacionProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public UbicacionProdu getEntityUbicacionProdu(String strPrefijo,UbicacionProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+UbicacionProduConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+UbicacionProduConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+UbicacionProduConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+UbicacionProduConstantesFunciones.IDPRODUCTO));
				entity.setid_ubicacion_bode(resultSet.getLong(strPrefijo+UbicacionProduConstantesFunciones.IDUBICACIONBODE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUbicacionProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(UbicacionProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UbicacionProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UbicacionProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UbicacionProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UbicacionProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UbicacionProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UbicacionProduDataAccess.TABLENAME,UbicacionProduDataAccess.ISWITHSTOREPROCEDURES);
			
			UbicacionProduDataAccess.setUbicacionProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,UbicacionProdu relubicacionprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relubicacionprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,UbicacionProdu relubicacionprodu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relubicacionprodu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,UbicacionProdu relubicacionprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relubicacionprodu.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,UbicacionProdu relubicacionprodu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relubicacionprodu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public UbicacionBode getUbicacionBode(Connexion connexion,UbicacionProdu relubicacionprodu)throws SQLException,Exception {

		UbicacionBode ubicacionbode= new UbicacionBode();

		try {
			UbicacionBodeDataAccess ubicacionbodeDataAccess=new UbicacionBodeDataAccess();

			ubicacionbodeDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ubicacionbodeDataAccess.setConnexionType(this.connexionType);
			ubicacionbodeDataAccess.setParameterDbType(this.parameterDbType);

			ubicacionbode=ubicacionbodeDataAccess.getEntity(connexion,relubicacionprodu.getid_ubicacion_bode());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ubicacionbode;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,UbicacionProdu ubicacionprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!ubicacionprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(ubicacionprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(ubicacionprodu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(ubicacionprodu.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(ubicacionprodu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ubicacion_bode=new ParameterValue<Long>();
					parameterMaintenanceValueid_ubicacion_bode.setValue(ubicacionprodu.getid_ubicacion_bode());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ubicacion_bode);
					parametersTemp.add(parameterMaintenance);
					
						if(!ubicacionprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(ubicacionprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(ubicacionprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(ubicacionprodu.getId());
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
	
	public void setIsNewIsChangedFalseUbicacionProdu(UbicacionProdu ubicacionprodu)throws Exception  {		
		ubicacionprodu.setIsNew(false);
		ubicacionprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUbicacionProdus(List<UbicacionProdu> ubicacionprodus)throws Exception  {				
		for(UbicacionProdu ubicacionprodu:ubicacionprodus) {
			ubicacionprodu.setIsNew(false);
			ubicacionprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarUbicacionProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
