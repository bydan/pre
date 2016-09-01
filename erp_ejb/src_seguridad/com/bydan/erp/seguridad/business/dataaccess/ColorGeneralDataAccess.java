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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//ColorGeneralConstantesFunciones;


import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ColorGeneralDataAccess extends  DataAccessHelperSinIdGenerated<ColorGeneral>{ //ColorGeneralDataAccessAdditional,DataAccessHelper<ColorGeneral>
	//static Logger logger = Logger.getLogger(ColorGeneralDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="color_general";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select colorgeneral from "+ColorGeneralConstantesFunciones.SPERSISTENCENAME+" colorgeneral";
	public static String QUERYSELECTNATIVE="select "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".id,"+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".version_row,"+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".nombre from "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME;//+" as "+ColorGeneralConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".id,"+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".version_row,"+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+".nombre from "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME;//+" as "+ColorGeneralConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ColorGeneralConstantesFunciones.SCHEMA+"."+ColorGeneralConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COLORGENERAL_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COLORGENERAL_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COLORGENERAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COLORGENERAL_SELECT(?,?)";
	
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
	
	
	public ColorGeneralDataAccess() {
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
		ColorGeneralDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ColorGeneralDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ColorGeneralDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setColorGeneralOriginal(ColorGeneral colorgeneral)throws Exception  {
		colorgeneral.setColorGeneralOriginal((ColorGeneral)colorgeneral.clone());		
	}
	
	public void setColorGeneralsOriginal(List<ColorGeneral> colorgenerals)throws Exception  {
		
		for(ColorGeneral colorgeneral:colorgenerals){
			colorgeneral.setColorGeneralOriginal((ColorGeneral)colorgeneral.clone());
		}
	}
	
	public static void setColorGeneralOriginalStatic(ColorGeneral colorgeneral)throws Exception  {
		colorgeneral.setColorGeneralOriginal((ColorGeneral)colorgeneral.clone());		
	}
	
	public static void setColorGeneralsOriginalStatic(List<ColorGeneral> colorgenerals)throws Exception  {
		
		for(ColorGeneral colorgeneral:colorgenerals){
			colorgeneral.setColorGeneralOriginal((ColorGeneral)colorgeneral.clone());
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
	
	public  ColorGeneral getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ColorGeneral entity = new ColorGeneral();		
		
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
	
	public  ColorGeneral getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ColorGeneral entity = new ColorGeneral();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.ColorGeneral.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setColorGeneralOriginal(new ColorGeneral());
      	    	entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityColorGeneral("",entity,resultSet); 
				
				//entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseColorGeneral(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ColorGeneral getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ColorGeneral entity = new ColorGeneral();
				
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
	
	public  ColorGeneral getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ColorGeneral entity = new ColorGeneral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ColorGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ColorGeneral.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setColorGeneralOriginal(new ColorGeneral());
      	    	entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityColorGeneral("",entity,resultSet);    
				
				//entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseColorGeneral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ColorGeneral
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ColorGeneral entity = new ColorGeneral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ColorGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ColorGeneral.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseColorGeneral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ColorGeneral> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
		
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
	
	public  List<ColorGeneral> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ColorGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ColorGeneral();
      	    	entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityColorGeneral("",entity,resultSet);
      	    	
				//entity.setColorGeneralOriginal( new ColorGeneral());
      	    	//entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseColorGenerals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarColorGeneral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ColorGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
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
	
	public  List<ColorGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ColorGeneral();
				
				if(conMapGenerico) {
					entity.inicializarMapColorGeneral();
					//entity.setMapColorGeneral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapColorGeneralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapColorGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         		
					entity=ColorGeneralDataAccess.getEntityColorGeneral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setColorGeneralOriginal( new ColorGeneral());
					////entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseColorGenerals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarColorGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ColorGeneral getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ColorGeneral entity = new ColorGeneral();		  
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
	
	public  ColorGeneral getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ColorGeneral entity = new ColorGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ColorGeneral();
				
				if(conMapGenerico) {
					entity.inicializarMapColorGeneral();
					//entity.setMapColorGeneral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapColorGeneralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapColorGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         		
					entity=ColorGeneralDataAccess.getEntityColorGeneral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setColorGeneralOriginal( new ColorGeneral());
					////entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseColorGeneral(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarColorGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ColorGeneral getEntityColorGeneral(String strPrefijo,ColorGeneral entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ColorGeneral.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ColorGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ColorGeneralDataAccess.setFieldReflectionColorGeneral(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasColorGeneral=ColorGeneralConstantesFunciones.getTodosTiposColumnasColorGeneral();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasColorGeneral) {
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
							field = ColorGeneral.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ColorGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ColorGeneralDataAccess.setFieldReflectionColorGeneral(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionColorGeneral(Field field,String strPrefijo,String sColumn,ColorGeneral entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ColorGeneralConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ColorGeneralConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ColorGeneralConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ColorGeneral>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ColorGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ColorGeneral();
					entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityColorGeneral("",entity,resultSet);
					
					//entity.setColorGeneralOriginal( new ColorGeneral());
					//entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
					//entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseColorGenerals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarColorGeneral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ColorGeneral>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ColorGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ColorGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ColorGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
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
	
	public  List<ColorGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ColorGeneral> entities = new  ArrayList<ColorGeneral>();
		ColorGeneral entity = new ColorGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ColorGeneral();
      	    	entity=super.getEntity("",entity,resultSet,ColorGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityColorGeneral("",entity,resultSet);
      	    	
				//entity.setColorGeneralOriginal( new ColorGeneral());
      	    	//entity.setColorGeneralOriginal(super.getEntity("",entity.getColorGeneralOriginal(),resultSet,ColorGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setColorGeneralOriginal(this.getEntityColorGeneral("",entity.getColorGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseColorGenerals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarColorGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public ColorGeneral getEntityColorGeneral(String strPrefijo,ColorGeneral entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+ColorGeneralConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ColorGeneralConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowColorGeneral(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ColorGeneral entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ColorGeneralDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ColorGeneralDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ColorGeneralDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ColorGeneralDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ColorGeneralConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,ColorGeneralDataAccess.TABLENAME,ColorGeneralDataAccess.ISWITHSTOREPROCEDURES);
			
			ColorGeneralDataAccess.setColorGeneralOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<EstadoPedido> getEstadoPedidos(Connexion connexion,ColorGeneral colorgeneral)throws SQLException,Exception {

		List<EstadoPedido> estadopedidos= new ArrayList<EstadoPedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ColorGeneralConstantesFunciones.SCHEMA+".color_general ON "+EstadoPedidoConstantesFunciones.SCHEMA+".estado_pedido.id_color_general="+ColorGeneralConstantesFunciones.SCHEMA+".color_general.id WHERE "+ColorGeneralConstantesFunciones.SCHEMA+".color_general.id="+String.valueOf(colorgeneral.getId());
			} else {
				sQuery=" INNER JOIN estadopedido.ColorGeneral WHERE estadopedido.ColorGeneral.id="+String.valueOf(colorgeneral.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);
			estadopedidos=estadopedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedidos;

	}

	public List<EstadoProforma> getEstadoProformas(Connexion connexion,ColorGeneral colorgeneral)throws SQLException,Exception {

		List<EstadoProforma> estadoproformas= new ArrayList<EstadoProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ColorGeneralConstantesFunciones.SCHEMA+".color_general ON "+EstadoProformaConstantesFunciones.SCHEMA+".estado_proforma.id_color_general="+ColorGeneralConstantesFunciones.SCHEMA+".color_general.id WHERE "+ColorGeneralConstantesFunciones.SCHEMA+".color_general.id="+String.valueOf(colorgeneral.getId());
			} else {
				sQuery=" INNER JOIN estadoproforma.ColorGeneral WHERE estadoproforma.ColorGeneral.id="+String.valueOf(colorgeneral.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EstadoProformaDataAccess estadoproformaDataAccess=new EstadoProformaDataAccess();

			estadoproformaDataAccess.setConnexionType(this.connexionType);
			estadoproformaDataAccess.setParameterDbType(this.parameterDbType);
			estadoproformas=estadoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoproformas;

	}

	public List<EstadoAsientoContable> getEstadoAsientoContables(Connexion connexion,ColorGeneral colorgeneral)throws SQLException,Exception {

		List<EstadoAsientoContable> estadoasientocontables= new ArrayList<EstadoAsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ColorGeneralConstantesFunciones.SCHEMA+".color_general ON "+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable.id_color_general="+ColorGeneralConstantesFunciones.SCHEMA+".color_general.id WHERE "+ColorGeneralConstantesFunciones.SCHEMA+".color_general.id="+String.valueOf(colorgeneral.getId());
			} else {
				sQuery=" INNER JOIN estadoasientocontable.ColorGeneral WHERE estadoasientocontable.ColorGeneral.id="+String.valueOf(colorgeneral.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EstadoAsientoContableDataAccess estadoasientocontableDataAccess=new EstadoAsientoContableDataAccess();

			estadoasientocontableDataAccess.setConnexionType(this.connexionType);
			estadoasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoasientocontables;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ColorGeneral colorgeneral) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!colorgeneral.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(colorgeneral.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(colorgeneral.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!colorgeneral.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(colorgeneral.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(colorgeneral.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(colorgeneral.getId());
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
	
	public void setIsNewIsChangedFalseColorGeneral(ColorGeneral colorgeneral)throws Exception  {		
		colorgeneral.setIsNew(false);
		colorgeneral.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseColorGenerals(List<ColorGeneral> colorgenerals)throws Exception  {				
		for(ColorGeneral colorgeneral:colorgenerals) {
			colorgeneral.setIsNew(false);
			colorgeneral.setIsChanged(false);
		}
	}
	
	public void generarExportarColorGeneral(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
