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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//ResponsableFondoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class ResponsableFondoDataAccess extends  ResponsableFondoDataAccessAdditional{ //ResponsableFondoDataAccessAdditional,DataAccessHelper<ResponsableFondo>
	//static Logger logger = Logger.getLogger(ResponsableFondoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="responsable_fondo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_empleado,secuencial,valor_caja)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,secuencial=?,valor_caja=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select responsablefondo from "+ResponsableFondoConstantesFunciones.SPERSISTENCENAME+" responsablefondo";
	public static String QUERYSELECTNATIVE="select "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".version_row,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id_empresa,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id_sucursal,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id_empleado,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".secuencial,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".valor_caja from "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME;//+" as "+ResponsableFondoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".id,"+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+".version_row from "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME;//+" as "+ResponsableFondoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ResponsableFondoConstantesFunciones.SCHEMA+"."+ResponsableFondoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,secuencial=?,valor_caja=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RESPONSABLEFONDO_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RESPONSABLEFONDO_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RESPONSABLEFONDO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RESPONSABLEFONDO_SELECT(?,?)";
	
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
	
	
	protected ResponsableFondoDataAccessAdditional responsablefondoDataAccessAdditional=null;
	
	public ResponsableFondoDataAccessAdditional getResponsableFondoDataAccessAdditional() {
		return this.responsablefondoDataAccessAdditional;
	}
	
	public void setResponsableFondoDataAccessAdditional(ResponsableFondoDataAccessAdditional responsablefondoDataAccessAdditional) {
		try {
			this.responsablefondoDataAccessAdditional=responsablefondoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ResponsableFondoDataAccess() {
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
		ResponsableFondoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ResponsableFondoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ResponsableFondoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setResponsableFondoOriginal(ResponsableFondo responsablefondo)throws Exception  {
		responsablefondo.setResponsableFondoOriginal((ResponsableFondo)responsablefondo.clone());		
	}
	
	public void setResponsableFondosOriginal(List<ResponsableFondo> responsablefondos)throws Exception  {
		
		for(ResponsableFondo responsablefondo:responsablefondos){
			responsablefondo.setResponsableFondoOriginal((ResponsableFondo)responsablefondo.clone());
		}
	}
	
	public static void setResponsableFondoOriginalStatic(ResponsableFondo responsablefondo)throws Exception  {
		responsablefondo.setResponsableFondoOriginal((ResponsableFondo)responsablefondo.clone());		
	}
	
	public static void setResponsableFondosOriginalStatic(List<ResponsableFondo> responsablefondos)throws Exception  {
		
		for(ResponsableFondo responsablefondo:responsablefondos){
			responsablefondo.setResponsableFondoOriginal((ResponsableFondo)responsablefondo.clone());
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
	
	public  ResponsableFondo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ResponsableFondo entity = new ResponsableFondo();		
		
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
	
	public  ResponsableFondo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ResponsableFondo entity = new ResponsableFondo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ResponsableFondo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setResponsableFondoOriginal(new ResponsableFondo());
      	    	entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityResponsableFondo("",entity,resultSet); 
				
				//entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseResponsableFondo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ResponsableFondo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ResponsableFondo entity = new ResponsableFondo();
				
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
	
	public  ResponsableFondo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ResponsableFondo entity = new ResponsableFondo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableFondoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ResponsableFondo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setResponsableFondoOriginal(new ResponsableFondo());
      	    	entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityResponsableFondo("",entity,resultSet);    
				
				//entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseResponsableFondo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ResponsableFondo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ResponsableFondo entity = new ResponsableFondo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableFondoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ResponsableFondo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseResponsableFondo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ResponsableFondo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		
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
	
	public  List<ResponsableFondo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableFondoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableFondo();
      	    	entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResponsableFondo("",entity,resultSet);
      	    	
				//entity.setResponsableFondoOriginal( new ResponsableFondo());
      	    	//entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResponsableFondos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableFondo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ResponsableFondo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
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
	
	public  List<ResponsableFondo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableFondo();
				
				if(conMapGenerico) {
					entity.inicializarMapResponsableFondo();
					//entity.setMapResponsableFondo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapResponsableFondoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapResponsableFondo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         		
					entity=ResponsableFondoDataAccess.getEntityResponsableFondo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setResponsableFondoOriginal( new ResponsableFondo());
					////entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
					////entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResponsableFondos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableFondo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ResponsableFondo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ResponsableFondo entity = new ResponsableFondo();		  
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
	
	public  ResponsableFondo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableFondo();
				
				if(conMapGenerico) {
					entity.inicializarMapResponsableFondo();
					//entity.setMapResponsableFondo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapResponsableFondoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapResponsableFondo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         		
					entity=ResponsableFondoDataAccess.getEntityResponsableFondo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setResponsableFondoOriginal( new ResponsableFondo());
					////entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
					////entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseResponsableFondo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableFondo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ResponsableFondo getEntityResponsableFondo(String strPrefijo,ResponsableFondo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ResponsableFondo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ResponsableFondo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ResponsableFondoDataAccess.setFieldReflectionResponsableFondo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasResponsableFondo=ResponsableFondoConstantesFunciones.getTodosTiposColumnasResponsableFondo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasResponsableFondo) {
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
							field = ResponsableFondo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ResponsableFondo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ResponsableFondoDataAccess.setFieldReflectionResponsableFondo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionResponsableFondo(Field field,String strPrefijo,String sColumn,ResponsableFondo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ResponsableFondoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableFondoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResponsableFondoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableFondoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableFondoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableFondoConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableFondoConstantesFunciones.VALORCAJA:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ResponsableFondo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableFondoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ResponsableFondo();
					entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityResponsableFondo("",entity,resultSet);
					
					//entity.setResponsableFondoOriginal( new ResponsableFondo());
					//entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
					//entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseResponsableFondos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableFondo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ResponsableFondo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResponsableFondoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableFondoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ResponsableFondo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
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
	
	public  List<ResponsableFondo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableFondo();
      	    	entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResponsableFondo("",entity,resultSet);
      	    	
				//entity.setResponsableFondoOriginal( new ResponsableFondo());
      	    	//entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseResponsableFondos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableFondo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ResponsableFondo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
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
	
	public  List<ResponsableFondo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableFondo> entities = new  ArrayList<ResponsableFondo>();
		ResponsableFondo entity = new ResponsableFondo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableFondo();
      	    	entity=super.getEntity("",entity,resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResponsableFondo("",entity,resultSet);
      	    	
				//entity.setResponsableFondoOriginal( new ResponsableFondo());
      	    	//entity.setResponsableFondoOriginal(super.getEntity("",entity.getResponsableFondoOriginal(),resultSet,ResponsableFondoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableFondoOriginal(this.getEntityResponsableFondo("",entity.getResponsableFondoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResponsableFondos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ResponsableFondo getEntityResponsableFondo(String strPrefijo,ResponsableFondo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ResponsableFondoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ResponsableFondoConstantesFunciones.IDSUCURSAL));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ResponsableFondoConstantesFunciones.IDEMPLEADO));
				entity.setsecuencial(resultSet.getLong(strPrefijo+ResponsableFondoConstantesFunciones.SECUENCIAL));
				entity.setvalor_caja(resultSet.getDouble(strPrefijo+ResponsableFondoConstantesFunciones.VALORCAJA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowResponsableFondo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ResponsableFondo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ResponsableFondoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ResponsableFondoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ResponsableFondoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ResponsableFondoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ResponsableFondoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ResponsableFondoDataAccess.TABLENAME,ResponsableFondoDataAccess.ISWITHSTOREPROCEDURES);
			
			ResponsableFondoDataAccess.setResponsableFondoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ResponsableFondo relresponsablefondo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relresponsablefondo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ResponsableFondo relresponsablefondo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relresponsablefondo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleado(Connexion connexion,ResponsableFondo relresponsablefondo)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relresponsablefondo.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
		public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,ResponsableFondo responsablefondo)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ResponsableFondoConstantesFunciones.SCHEMA+".responsable_fondo ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_responsable_fondo="+ResponsableFondoConstantesFunciones.SCHEMA+".responsable_fondo.id WHERE "+ResponsableFondoConstantesFunciones.SCHEMA+".responsable_fondo.id="+String.valueOf(responsablefondo.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.ResponsableFondo WHERE facturaproveedor.ResponsableFondo.id="+String.valueOf(responsablefondo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ResponsableFondo responsablefondo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!responsablefondo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(responsablefondo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(responsablefondo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(responsablefondo.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencial=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencial.setValue(responsablefondo.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_caja=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_caja.setValue(responsablefondo.getvalor_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_caja);
					parametersTemp.add(parameterMaintenance);
					
						if(!responsablefondo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(responsablefondo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(responsablefondo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(responsablefondo.getId());
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
	
	public void setIsNewIsChangedFalseResponsableFondo(ResponsableFondo responsablefondo)throws Exception  {		
		responsablefondo.setIsNew(false);
		responsablefondo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseResponsableFondos(List<ResponsableFondo> responsablefondos)throws Exception  {				
		for(ResponsableFondo responsablefondo:responsablefondos) {
			responsablefondo.setIsNew(false);
			responsablefondo.setIsChanged(false);
		}
	}
	
	public void generarExportarResponsableFondo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
