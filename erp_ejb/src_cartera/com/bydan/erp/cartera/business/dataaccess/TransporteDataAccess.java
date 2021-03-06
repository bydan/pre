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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TransporteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class TransporteDataAccess extends  TransporteDataAccessAdditional{ //TransporteDataAccessAdditional,DataAccessHelper<Transporte>
	//static Logger logger = Logger.getLogger(TransporteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transporte";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_via_transporte,codigo,nombre)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_via_transporte=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transporte from "+TransporteConstantesFunciones.SPERSISTENCENAME+" transporte";
	public static String QUERYSELECTNATIVE="select "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".version_row,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id_empresa,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".codigo,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".nombre from "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME;//+" as "+TransporteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".id,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".version_row,"+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+".codigo from "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME;//+" as "+TransporteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransporteConstantesFunciones.SCHEMA+"."+TransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_via_transporte=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSPORTE_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSPORTE_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSPORTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSPORTE_SELECT(?,?)";
	
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
	
	
	protected TransporteDataAccessAdditional transporteDataAccessAdditional=null;
	
	public TransporteDataAccessAdditional getTransporteDataAccessAdditional() {
		return this.transporteDataAccessAdditional;
	}
	
	public void setTransporteDataAccessAdditional(TransporteDataAccessAdditional transporteDataAccessAdditional) {
		try {
			this.transporteDataAccessAdditional=transporteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransporteDataAccess() {
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
		TransporteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransporteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransporteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransporteOriginal(Transporte transporte)throws Exception  {
		transporte.setTransporteOriginal((Transporte)transporte.clone());		
	}
	
	public void setTransportesOriginal(List<Transporte> transportes)throws Exception  {
		
		for(Transporte transporte:transportes){
			transporte.setTransporteOriginal((Transporte)transporte.clone());
		}
	}
	
	public static void setTransporteOriginalStatic(Transporte transporte)throws Exception  {
		transporte.setTransporteOriginal((Transporte)transporte.clone());		
	}
	
	public static void setTransportesOriginalStatic(List<Transporte> transportes)throws Exception  {
		
		for(Transporte transporte:transportes){
			transporte.setTransporteOriginal((Transporte)transporte.clone());
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
	
	public  Transporte getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Transporte entity = new Transporte();		
		
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
	
	public  Transporte getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Transporte entity = new Transporte();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.Transporte.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransporteOriginal(new Transporte());
      	    	entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransporte("",entity,resultSet); 
				
				//entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransporte(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Transporte getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transporte entity = new Transporte();
				
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
	
	public  Transporte getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transporte entity = new Transporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Transporte.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransporteOriginal(new Transporte());
      	    	entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransporte("",entity,resultSet);    
				
				//entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Transporte
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Transporte entity = new Transporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Transporte.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Transporte> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		
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
	
	public  List<Transporte> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transporte();
      	    	entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransporte("",entity,resultSet);
      	    	
				//entity.setTransporteOriginal( new Transporte());
      	    	//entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransportes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
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
	
	public  List<Transporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transporte();
				
				if(conMapGenerico) {
					entity.inicializarMapTransporte();
					//entity.setMapTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         		
					entity=TransporteDataAccess.getEntityTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransporteOriginal( new Transporte());
					////entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransportes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Transporte getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transporte entity = new Transporte();		  
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
	
	public  Transporte getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transporte entity = new Transporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transporte();
				
				if(conMapGenerico) {
					entity.inicializarMapTransporte();
					//entity.setMapTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         		
					entity=TransporteDataAccess.getEntityTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransporteOriginal( new Transporte());
					////entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransporte(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Transporte getEntityTransporte(String strPrefijo,Transporte entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Transporte.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Transporte.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransporteDataAccess.setFieldReflectionTransporte(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransporte=TransporteConstantesFunciones.getTodosTiposColumnasTransporte();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransporte) {
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
							field = Transporte.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Transporte.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransporteDataAccess.setFieldReflectionTransporte(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransporte(Field field,String strPrefijo,String sColumn,Transporte entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransporteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransporteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransporteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransporteConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransporteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransporteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transporte>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Transporte();
					entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransporte("",entity,resultSet);
					
					//entity.setTransporteOriginal( new Transporte());
					//entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
					//entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransportes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transporte>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Transporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
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
	
	public  List<Transporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transporte();
      	    	entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransporte("",entity,resultSet);
      	    	
				//entity.setTransporteOriginal( new Transporte());
      	    	//entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransportes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transporte> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
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
	
	public  List<Transporte> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transporte> entities = new  ArrayList<Transporte>();
		Transporte entity = new Transporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transporte();
      	    	entity=super.getEntity("",entity,resultSet,TransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransporte("",entity,resultSet);
      	    	
				//entity.setTransporteOriginal( new Transporte());
      	    	//entity.setTransporteOriginal(super.getEntity("",entity.getTransporteOriginal(),resultSet,TransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransporteOriginal(this.getEntityTransporte("",entity.getTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransportes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Transporte getEntityTransporte(String strPrefijo,Transporte entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TransporteConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+TransporteConstantesFunciones.IDTIPOVIATRANSPORTE));
				entity.setcodigo(resultSet.getString(strPrefijo+TransporteConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TransporteConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TransporteConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransporte(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Transporte entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransporteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransporteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransporteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransporteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransporteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TransporteDataAccess.TABLENAME,TransporteDataAccess.ISWITHSTOREPROCEDURES);
			
			TransporteDataAccess.setTransporteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Transporte reltransporte)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltransporte.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,Transporte reltransporte)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,reltransporte.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}


		
		public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.Transporte WHERE notacreditosoli.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<PoliticasCliente> getPoliticasClientes(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<PoliticasCliente> politicasclientes= new ArrayList<PoliticasCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+PoliticasClienteConstantesFunciones.SCHEMA+".politicas_cliente.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN politicascliente.Transporte WHERE politicascliente.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticasClienteDataAccess politicasclienteDataAccess=new PoliticasClienteDataAccess();

			politicasclienteDataAccess.setConnexionType(this.connexionType);
			politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicasclientes;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.Transporte WHERE guiaremision.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremisions;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.Transporte WHERE pedidoexpor.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<Proforma> getProformas(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN proforma.Transporte WHERE proforma.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<Factura> getFacturas(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN factura.Transporte WHERE factura.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}

	public List<Pedido> getPedidos(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN pedido.Transporte WHERE pedido.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidos;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN consignacion.Transporte WHERE consignacion.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,Transporte transporte)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransporteConstantesFunciones.SCHEMA+".transporte ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_transporte="+TransporteConstantesFunciones.SCHEMA+".transporte.id WHERE "+TransporteConstantesFunciones.SCHEMA+".transporte.id="+String.valueOf(transporte.getId());
			} else {
				sQuery=" INNER JOIN notacredito.Transporte WHERE notacredito.Transporte.id="+String.valueOf(transporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Transporte transporte) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transporte.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(transporte.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(transporte.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(transporte.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(transporte.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!transporte.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transporte.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transporte.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transporte.getId());
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
	
	public void setIsNewIsChangedFalseTransporte(Transporte transporte)throws Exception  {		
		transporte.setIsNew(false);
		transporte.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransportes(List<Transporte> transportes)throws Exception  {				
		for(Transporte transporte:transportes) {
			transporte.setIsNew(false);
			transporte.setIsChanged(false);
		}
	}
	
	public void generarExportarTransporte(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
