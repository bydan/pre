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
package com.bydan.erp.produccion.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//EstadoOrdenProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class EstadoOrdenProduDataAccess extends  DataAccessHelperSinIdGenerated<EstadoOrdenProdu>{ //EstadoOrdenProduDataAccessAdditional,DataAccessHelper<EstadoOrdenProdu>
	//static Logger logger = Logger.getLogger(EstadoOrdenProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_orden_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadoordenprodu from "+EstadoOrdenProduConstantesFunciones.SPERSISTENCENAME+" estadoordenprodu";
	public static String QUERYSELECTNATIVE="select "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".id,"+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".version_row,"+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".nombre from "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME;//+" as "+EstadoOrdenProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".id,"+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".version_row,"+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+".nombre from "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME;//+" as "+EstadoOrdenProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoOrdenProduConstantesFunciones.SCHEMA+"."+EstadoOrdenProduConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOORDENPRODU_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOORDENPRODU_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOORDENPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOORDENPRODU_SELECT(?,?)";
	
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
	
	
	public EstadoOrdenProduDataAccess() {
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
		EstadoOrdenProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoOrdenProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoOrdenProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoOrdenProduOriginal(EstadoOrdenProdu estadoordenprodu)throws Exception  {
		estadoordenprodu.setEstadoOrdenProduOriginal((EstadoOrdenProdu)estadoordenprodu.clone());		
	}
	
	public void setEstadoOrdenProdusOriginal(List<EstadoOrdenProdu> estadoordenprodus)throws Exception  {
		
		for(EstadoOrdenProdu estadoordenprodu:estadoordenprodus){
			estadoordenprodu.setEstadoOrdenProduOriginal((EstadoOrdenProdu)estadoordenprodu.clone());
		}
	}
	
	public static void setEstadoOrdenProduOriginalStatic(EstadoOrdenProdu estadoordenprodu)throws Exception  {
		estadoordenprodu.setEstadoOrdenProduOriginal((EstadoOrdenProdu)estadoordenprodu.clone());		
	}
	
	public static void setEstadoOrdenProdusOriginalStatic(List<EstadoOrdenProdu> estadoordenprodus)throws Exception  {
		
		for(EstadoOrdenProdu estadoordenprodu:estadoordenprodus){
			estadoordenprodu.setEstadoOrdenProduOriginal((EstadoOrdenProdu)estadoordenprodu.clone());
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
	
	public  EstadoOrdenProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		
		
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
	
	public  EstadoOrdenProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.EstadoOrdenProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoOrdenProduOriginal(new EstadoOrdenProdu());
      	    	entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoOrdenProdu("",entity,resultSet); 
				
				//entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoOrdenProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoOrdenProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoOrdenProdu entity = new EstadoOrdenProdu();
				
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
	
	public  EstadoOrdenProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoOrdenProdu entity = new EstadoOrdenProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoOrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.EstadoOrdenProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoOrdenProduOriginal(new EstadoOrdenProdu());
      	    	entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoOrdenProdu("",entity,resultSet);    
				
				//entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoOrdenProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoOrdenProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoOrdenProdu entity = new EstadoOrdenProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoOrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.EstadoOrdenProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoOrdenProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoOrdenProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		
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
	
	public  List<EstadoOrdenProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoOrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoOrdenProdu();
      	    	entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoOrdenProdu("",entity,resultSet);
      	    	
				//entity.setEstadoOrdenProduOriginal( new EstadoOrdenProdu());
      	    	//entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoOrdenProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoOrdenProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
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
	
	public  List<EstadoOrdenProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoOrdenProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoOrdenProdu();
					//entity.setMapEstadoOrdenProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoOrdenProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoOrdenProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         		
					entity=EstadoOrdenProduDataAccess.getEntityEstadoOrdenProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoOrdenProduOriginal( new EstadoOrdenProdu());
					////entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoOrdenProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoOrdenProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
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
	
	public  EstadoOrdenProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoOrdenProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoOrdenProdu();
					//entity.setMapEstadoOrdenProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoOrdenProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoOrdenProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         		
					entity=EstadoOrdenProduDataAccess.getEntityEstadoOrdenProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoOrdenProduOriginal( new EstadoOrdenProdu());
					////entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoOrdenProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoOrdenProdu getEntityEstadoOrdenProdu(String strPrefijo,EstadoOrdenProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoOrdenProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoOrdenProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoOrdenProduDataAccess.setFieldReflectionEstadoOrdenProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoOrdenProdu=EstadoOrdenProduConstantesFunciones.getTodosTiposColumnasEstadoOrdenProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoOrdenProdu) {
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
							field = EstadoOrdenProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoOrdenProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoOrdenProduDataAccess.setFieldReflectionEstadoOrdenProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoOrdenProdu(Field field,String strPrefijo,String sColumn,EstadoOrdenProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoOrdenProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoOrdenProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoOrdenProduConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoOrdenProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoOrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoOrdenProdu();
					entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoOrdenProdu("",entity,resultSet);
					
					//entity.setEstadoOrdenProduOriginal( new EstadoOrdenProdu());
					//entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoOrdenProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoOrdenProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoOrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoOrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoOrdenProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
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
	
	public  List<EstadoOrdenProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoOrdenProdu> entities = new  ArrayList<EstadoOrdenProdu>();
		EstadoOrdenProdu entity = new EstadoOrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoOrdenProdu();
      	    	entity=super.getEntity("",entity,resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoOrdenProdu("",entity,resultSet);
      	    	
				//entity.setEstadoOrdenProduOriginal( new EstadoOrdenProdu());
      	    	//entity.setEstadoOrdenProduOriginal(super.getEntity("",entity.getEstadoOrdenProduOriginal(),resultSet,EstadoOrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoOrdenProduOriginal(this.getEntityEstadoOrdenProdu("",entity.getEstadoOrdenProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoOrdenProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoOrdenProdu getEntityEstadoOrdenProdu(String strPrefijo,EstadoOrdenProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoOrdenProduConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EstadoOrdenProduConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoOrdenProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoOrdenProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoOrdenProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoOrdenProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoOrdenProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoOrdenProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoOrdenProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoOrdenProduDataAccess.TABLENAME,EstadoOrdenProduDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoOrdenProduDataAccess.setEstadoOrdenProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<OrdenProdu> getOrdenProdus(Connexion connexion,EstadoOrdenProdu estadoordenprodu)throws SQLException,Exception {

		List<OrdenProdu> ordenprodus= new ArrayList<OrdenProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoOrdenProduConstantesFunciones.SCHEMA+".estado_orden_produ ON "+OrdenProduConstantesFunciones.SCHEMA+".orden_produ.id_estado_orden_produ="+EstadoOrdenProduConstantesFunciones.SCHEMA+".estado_orden_produ.id WHERE "+EstadoOrdenProduConstantesFunciones.SCHEMA+".estado_orden_produ.id="+String.valueOf(estadoordenprodu.getId());
			} else {
				sQuery=" INNER JOIN ordenprodu.EstadoOrdenProdu WHERE ordenprodu.EstadoOrdenProdu.id="+String.valueOf(estadoordenprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenProduDataAccess ordenproduDataAccess=new OrdenProduDataAccess();

			ordenproduDataAccess.setConnexionType(this.connexionType);
			ordenproduDataAccess.setParameterDbType(this.parameterDbType);
			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordenprodus;

	}

	public List<PedidoProdu> getPedidoProdus(Connexion connexion,EstadoOrdenProdu estadoordenprodu)throws SQLException,Exception {

		List<PedidoProdu> pedidoprodus= new ArrayList<PedidoProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoOrdenProduConstantesFunciones.SCHEMA+".estado_orden_produ ON "+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ.id_estado_orden_produ="+EstadoOrdenProduConstantesFunciones.SCHEMA+".estado_orden_produ.id WHERE "+EstadoOrdenProduConstantesFunciones.SCHEMA+".estado_orden_produ.id="+String.valueOf(estadoordenprodu.getId());
			} else {
				sQuery=" INNER JOIN pedidoprodu.EstadoOrdenProdu WHERE pedidoprodu.EstadoOrdenProdu.id="+String.valueOf(estadoordenprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoProduDataAccess pedidoproduDataAccess=new PedidoProduDataAccess();

			pedidoproduDataAccess.setConnexionType(this.connexionType);
			pedidoproduDataAccess.setParameterDbType(this.parameterDbType);
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoprodus;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoOrdenProdu estadoordenprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadoordenprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadoordenprodu.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadoordenprodu.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadoordenprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadoordenprodu.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadoordenprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadoordenprodu.getId());
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
	
	public void setIsNewIsChangedFalseEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu)throws Exception  {		
		estadoordenprodu.setIsNew(false);
		estadoordenprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoOrdenProdus(List<EstadoOrdenProdu> estadoordenprodus)throws Exception  {				
		for(EstadoOrdenProdu estadoordenprodu:estadoordenprodus) {
			estadoordenprodu.setIsNew(false);
			estadoordenprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoOrdenProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
