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
import com.bydan.erp.inventario.util.*;//LineaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class LineaDataAccess extends  LineaDataAccessAdditional{ //LineaDataAccessAdditional,DataAccessHelper<Linea>
	//static Logger logger = Logger.getLogger(LineaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="linea";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_nivel_linea,id_linea,codigo,nombre,descripcion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_nivel_linea=?,id_linea=?,codigo=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select linea from "+LineaConstantesFunciones.SPERSISTENCENAME+" linea";
	public static String QUERYSELECTNATIVE="select "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".version_row,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id_empresa,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id_nivel_linea,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id_linea,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".codigo,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".nombre,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".descripcion from "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME;//+" as "+LineaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".id,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".version_row,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".codigo,"+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+".nombre from "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME;//+" as "+LineaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+LineaConstantesFunciones.SCHEMA+"."+LineaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_nivel_linea=?,id_linea=?,codigo=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_LINEA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_LINEA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_LINEA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_LINEA_SELECT(?,?)";
	
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
	
	
	protected LineaDataAccessAdditional lineaDataAccessAdditional=null;
	
	public LineaDataAccessAdditional getLineaDataAccessAdditional() {
		return this.lineaDataAccessAdditional;
	}
	
	public void setLineaDataAccessAdditional(LineaDataAccessAdditional lineaDataAccessAdditional) {
		try {
			this.lineaDataAccessAdditional=lineaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public LineaDataAccess() {
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
		LineaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		LineaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		LineaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setLineaOriginal(Linea linea)throws Exception  {
		linea.setLineaOriginal((Linea)linea.clone());		
	}
	
	public void setLineasOriginal(List<Linea> lineas)throws Exception  {
		
		for(Linea linea:lineas){
			linea.setLineaOriginal((Linea)linea.clone());
		}
	}
	
	public static void setLineaOriginalStatic(Linea linea)throws Exception  {
		linea.setLineaOriginal((Linea)linea.clone());		
	}
	
	public static void setLineasOriginalStatic(List<Linea> lineas)throws Exception  {
		
		for(Linea linea:lineas){
			linea.setLineaOriginal((Linea)linea.clone());
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
	
	public  Linea getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Linea entity = new Linea();		
		
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
	
	public  Linea getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Linea entity = new Linea();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LineaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LineaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Linea.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setLineaOriginal(new Linea());
      	    	entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLinea("",entity,resultSet); 
				
				//entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseLinea(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Linea getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Linea entity = new Linea();
				
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
	
	public  Linea getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Linea entity = new Linea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LineaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LineaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Linea.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setLineaOriginal(new Linea());
      	    	entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLinea("",entity,resultSet);    
				
				//entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseLinea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Linea
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Linea entity = new Linea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LineaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LineaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Linea.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseLinea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Linea> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		
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
	
	public  List<Linea> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=LineaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LineaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Linea();
      	    	entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLinea("",entity,resultSet);
      	    	
				//entity.setLineaOriginal( new Linea());
      	    	//entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLineas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLinea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Linea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
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
	
	public  List<Linea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Linea();
				
				if(conMapGenerico) {
					entity.inicializarMapLinea();
					//entity.setMapLinea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapLineaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLinea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         		
					entity=LineaDataAccess.getEntityLinea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLineaOriginal( new Linea());
					////entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
					////entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLineas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLinea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Linea getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Linea entity = new Linea();		  
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
	
	public  Linea getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Linea entity = new Linea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Linea();
				
				if(conMapGenerico) {
					entity.inicializarMapLinea();
					//entity.setMapLinea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapLineaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLinea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         		
					entity=LineaDataAccess.getEntityLinea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLineaOriginal( new Linea());
					////entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
					////entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseLinea(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLinea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Linea getEntityLinea(String strPrefijo,Linea entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Linea.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Linea.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					LineaDataAccess.setFieldReflectionLinea(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasLinea=LineaConstantesFunciones.getTodosTiposColumnasLinea();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasLinea) {
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
							field = Linea.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Linea.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						LineaDataAccess.setFieldReflectionLinea(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionLinea(Field field,String strPrefijo,String sColumn,Linea entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case LineaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LineaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaConstantesFunciones.IDNIVELLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LineaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LineaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Linea>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LineaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LineaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Linea();
					entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityLinea("",entity,resultSet);
					
					//entity.setLineaOriginal( new Linea());
					//entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
					//entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseLineas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLinea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Linea>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LineaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LineaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Linea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
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
	
	public  List<Linea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Linea();
      	    	entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLinea("",entity,resultSet);
      	    	
				//entity.setLineaOriginal( new Linea());
      	    	//entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseLineas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLinea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Linea> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
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
	
	public  List<Linea> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Linea> entities = new  ArrayList<Linea>();
		Linea entity = new Linea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Linea();
      	    	entity=super.getEntity("",entity,resultSet,LineaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLinea("",entity,resultSet);
      	    	
				//entity.setLineaOriginal( new Linea());
      	    	//entity.setLineaOriginal(super.getEntity("",entity.getLineaOriginal(),resultSet,LineaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaOriginal(this.getEntityLinea("",entity.getLineaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLineas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Linea getEntityLinea(String strPrefijo,Linea entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+LineaConstantesFunciones.IDEMPRESA));
				entity.setid_nivel_linea(resultSet.getLong(strPrefijo+LineaConstantesFunciones.IDNIVELLINEA));
				entity.setid_linea(resultSet.getLong(strPrefijo+LineaConstantesFunciones.IDLINEA));if(resultSet.wasNull()) {entity.setid_linea(null); }
				entity.setcodigo(resultSet.getString(strPrefijo+LineaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+LineaConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+LineaConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+LineaConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+LineaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowLinea(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Linea entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=LineaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=LineaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=LineaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=LineaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(LineaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,LineaDataAccess.TABLENAME,LineaDataAccess.ISWITHSTOREPROCEDURES);
			
			LineaDataAccess.setLineaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Linea rellinea)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,rellinea.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public NivelLinea getNivelLinea(Connexion connexion,Linea rellinea)throws SQLException,Exception {

		NivelLinea nivellinea= new NivelLinea();

		try {
			NivelLineaDataAccess nivellineaDataAccess=new NivelLineaDataAccess();

			nivellineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			nivellineaDataAccess.setConnexionType(this.connexionType);
			nivellineaDataAccess.setParameterDbType(this.parameterDbType);

			nivellinea=nivellineaDataAccess.getEntity(connexion,rellinea.getid_nivel_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return nivellinea;

	}

	public Linea getLinea(Connexion connexion,Linea rellinea)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,rellinea.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


		
		public List<PresupuestoLinea> getPresupuestoLineas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<PresupuestoLinea> presupuestolineas= new ArrayList<PresupuestoLinea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+PresupuestoLineaConstantesFunciones.SCHEMA+".presupuesto_linea.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN presupuestolinea.Linea WHERE presupuestolinea.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoLineaDataAccess presupuestolineaDataAccess=new PresupuestoLineaDataAccess();

			presupuestolineaDataAccess.setConnexionType(this.connexionType);
			presupuestolineaDataAccess.setParameterDbType(this.parameterDbType);
			presupuestolineas=presupuestolineaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestolineas;

	}

	public List<Linea> getLineas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<Linea> lineas= new ArrayList<Linea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+LineaConstantesFunciones.SCHEMA+".linea.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN linea.Linea WHERE linea.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);
			lineas=lineaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return lineas;

	}

	public List<ComisionGrupo> getComisionGrupoGrupos(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<ComisionGrupo> comisiongrupogrupos= new ArrayList<ComisionGrupo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+ComisionGrupoConstantesFunciones.SCHEMA+".comision_grupo.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN comisiongrupo.LineaGrupo WHERE comisiongrupo.LineaGrupo.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionGrupoDataAccess comisiongrupoDataAccess=new ComisionGrupoDataAccess();

			comisiongrupoDataAccess.setConnexionType(this.connexionType);
			comisiongrupoDataAccess.setParameterDbType(this.parameterDbType);
			comisiongrupogrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisiongrupogrupos;

	}

	public List<ProductoPuntoVenta> getProductoPuntoVentas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<ProductoPuntoVenta> productopuntoventas= new ArrayList<ProductoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+ProductoPuntoVentaConstantesFunciones.SCHEMA+".producto_punto_venta.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN productopuntoventa.Linea WHERE productopuntoventa.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoPuntoVentaDataAccess productopuntoventaDataAccess=new ProductoPuntoVentaDataAccess();

			productopuntoventaDataAccess.setConnexionType(this.connexionType);
			productopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			productopuntoventas=productopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productopuntoventas;

	}

	public List<ComisionLinea> getComisionLineas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<ComisionLinea> comisionlineas= new ArrayList<ComisionLinea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+ComisionLineaConstantesFunciones.SCHEMA+".comision_linea.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN comisionlinea.Linea WHERE comisionlinea.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionLineaDataAccess comisionlineaDataAccess=new ComisionLineaDataAccess();

			comisionlineaDataAccess.setConnexionType(this.connexionType);
			comisionlineaDataAccess.setParameterDbType(this.parameterDbType);
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionlineas;

	}

	public List<ComisionCate> getComisionCates(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<ComisionCate> comisioncates= new ArrayList<ComisionCate>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+ComisionCateConstantesFunciones.SCHEMA+".comision_cate.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN comisioncate.Linea WHERE comisioncate.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionCateDataAccess comisioncateDataAccess=new ComisionCateDataAccess();

			comisioncateDataAccess.setConnexionType(this.connexionType);
			comisioncateDataAccess.setParameterDbType(this.parameterDbType);
			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisioncates;

	}

	public List<DetallePlaneacionCompra> getDetallePlaneacionCompras(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<DetallePlaneacionCompra> detalleplaneacioncompras= new ArrayList<DetallePlaneacionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+".detalle_planeacion_compra.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN detalleplaneacioncompra.Linea WHERE detalleplaneacioncompra.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePlaneacionCompraDataAccess detalleplaneacioncompraDataAccess=new DetallePlaneacionCompraDataAccess();

			detalleplaneacioncompraDataAccess.setConnexionType(this.connexionType);
			detalleplaneacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			detalleplaneacioncompras=detalleplaneacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleplaneacioncompras;

	}

	public List<CuentasContablesLineaProducto> getCuentasContablesLineaProductoCategorias(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<CuentasContablesLineaProducto> cuentascontableslineaproductocategorias= new ArrayList<CuentasContablesLineaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+".cuentas_contables_linea_producto.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN cuentascontableslineaproducto.LineaCategoria WHERE cuentascontableslineaproducto.LineaCategoria.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentasContablesLineaProductoDataAccess cuentascontableslineaproductoDataAccess=new CuentasContablesLineaProductoDataAccess();

			cuentascontableslineaproductoDataAccess.setConnexionType(this.connexionType);
			cuentascontableslineaproductoDataAccess.setParameterDbType(this.parameterDbType);
			cuentascontableslineaproductocategorias=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentascontableslineaproductocategorias;

	}

	public List<Precio> getPrecioGrupos(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<Precio> preciogrupos= new ArrayList<Precio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+PrecioConstantesFunciones.SCHEMA+".precio.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN precio.LineaGrupo WHERE precio.LineaGrupo.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrecioDataAccess precioDataAccess=new PrecioDataAccess();

			precioDataAccess.setConnexionType(this.connexionType);
			precioDataAccess.setParameterDbType(this.parameterDbType);
			preciogrupos=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return preciogrupos;

	}

	public List<LineaPuntoVenta> getLineaPuntoVentaMarcas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<LineaPuntoVenta> lineapuntoventamarcas= new ArrayList<LineaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+LineaPuntoVentaConstantesFunciones.SCHEMA+".linea_punto_venta.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN lineapuntoventa.LineaMarca WHERE lineapuntoventa.LineaMarca.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LineaPuntoVentaDataAccess lineapuntoventaDataAccess=new LineaPuntoVentaDataAccess();

			lineapuntoventaDataAccess.setConnexionType(this.connexionType);
			lineapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			lineapuntoventamarcas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return lineapuntoventamarcas;

	}

	public List<DetalleCodigoBarraProducto> getDetalleCodigoBarraProductoMarcas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<DetalleCodigoBarraProducto> detallecodigobarraproductomarcas= new ArrayList<DetalleCodigoBarraProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+".detalle_codigo_barra_producto.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN detallecodigobarraproducto.LineaMarca WHERE detallecodigobarraproducto.LineaMarca.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleCodigoBarraProductoDataAccess detallecodigobarraproductoDataAccess=new DetalleCodigoBarraProductoDataAccess();

			detallecodigobarraproductoDataAccess.setConnexionType(this.connexionType);
			detallecodigobarraproductoDataAccess.setParameterDbType(this.parameterDbType);
			detallecodigobarraproductomarcas=detallecodigobarraproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallecodigobarraproductomarcas;

	}

	public List<PresupuestoVentasLineas> getPresupuestoVentasLineasMarcas(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<PresupuestoVentasLineas> presupuestoventaslineasmarcas= new ArrayList<PresupuestoVentasLineas>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+".presupuesto_ventas_lineas.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN presupuestoventaslineas.LineaMarca WHERE presupuestoventaslineas.LineaMarca.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoVentasLineasDataAccess presupuestoventaslineasDataAccess=new PresupuestoVentasLineasDataAccess();

			presupuestoventaslineasDataAccess.setConnexionType(this.connexionType);
			presupuestoventaslineasDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoventaslineasmarcas=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoventaslineasmarcas;

	}

	public List<CentroCostoGrupoProducto> getCentroCostoGrupoProductos(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<CentroCostoGrupoProducto> centrocostogrupoproductos= new ArrayList<CentroCostoGrupoProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+".centro_costo_grupo_producto.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN centrocostogrupoproducto.Linea WHERE centrocostogrupoproducto.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CentroCostoGrupoProductoDataAccess centrocostogrupoproductoDataAccess=new CentroCostoGrupoProductoDataAccess();

			centrocostogrupoproductoDataAccess.setConnexionType(this.connexionType);
			centrocostogrupoproductoDataAccess.setParameterDbType(this.parameterDbType);
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocostogrupoproductos;

	}

	public List<Producto> getProductos(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<Producto> productos= new ArrayList<Producto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+ProductoConstantesFunciones.SCHEMA+".producto.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN producto.Linea WHERE producto.Linea.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productos;

	}

	public List<ComisionMarca> getComisionMarcaGrupos(Connexion connexion,Linea linea)throws SQLException,Exception {

		List<ComisionMarca> comisionmarcagrupos= new ArrayList<ComisionMarca>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+LineaConstantesFunciones.SCHEMA+".linea ON "+ComisionMarcaConstantesFunciones.SCHEMA+".comision_marca.id_linea="+LineaConstantesFunciones.SCHEMA+".linea.id WHERE "+LineaConstantesFunciones.SCHEMA+".linea.id="+String.valueOf(linea.getId());
			} else {
				sQuery=" INNER JOIN comisionmarca.LineaGrupo WHERE comisionmarca.LineaGrupo.id="+String.valueOf(linea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionMarcaDataAccess comisionmarcaDataAccess=new ComisionMarcaDataAccess();

			comisionmarcaDataAccess.setConnexionType(this.connexionType);
			comisionmarcaDataAccess.setParameterDbType(this.parameterDbType);
			comisionmarcagrupos=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionmarcagrupos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Linea linea) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!linea.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(linea.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_nivel_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_nivel_linea.setValue(linea.getid_nivel_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_nivel_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(linea.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(linea.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(linea.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(linea.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!linea.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(linea.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(linea.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(linea.getId());
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
	
	public void setIsNewIsChangedFalseLinea(Linea linea)throws Exception  {		
		linea.setIsNew(false);
		linea.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseLineas(List<Linea> lineas)throws Exception  {				
		for(Linea linea:lineas) {
			linea.setIsNew(false);
			linea.setIsChanged(false);
		}
	}
	
	public void generarExportarLinea(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
