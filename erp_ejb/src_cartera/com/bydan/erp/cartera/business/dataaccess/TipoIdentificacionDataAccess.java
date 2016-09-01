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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TipoIdentificacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class TipoIdentificacionDataAccess extends  TipoIdentificacionDataAccessAdditional{ //TipoIdentificacionDataAccessAdditional,DataAccessHelper<TipoIdentificacion>
	//static Logger logger = Logger.getLogger(TipoIdentificacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_identificacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoidentificacion from "+TipoIdentificacionConstantesFunciones.SPERSISTENCENAME+" tipoidentificacion";
	public static String QUERYSELECTNATIVE="select "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".id,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".version_row,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".codigo,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".nombre from "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME;//+" as "+TipoIdentificacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".id,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".version_row,"+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+".codigo from "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME;//+" as "+TipoIdentificacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoIdentificacionConstantesFunciones.SCHEMA+"."+TipoIdentificacionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOIDENTIFICACION_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOIDENTIFICACION_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOIDENTIFICACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOIDENTIFICACION_SELECT(?,?)";
	
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
	
	
	protected TipoIdentificacionDataAccessAdditional tipoidentificacionDataAccessAdditional=null;
	
	public TipoIdentificacionDataAccessAdditional getTipoIdentificacionDataAccessAdditional() {
		return this.tipoidentificacionDataAccessAdditional;
	}
	
	public void setTipoIdentificacionDataAccessAdditional(TipoIdentificacionDataAccessAdditional tipoidentificacionDataAccessAdditional) {
		try {
			this.tipoidentificacionDataAccessAdditional=tipoidentificacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoIdentificacionDataAccess() {
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
		TipoIdentificacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoIdentificacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoIdentificacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoIdentificacionOriginal(TipoIdentificacion tipoidentificacion)throws Exception  {
		tipoidentificacion.setTipoIdentificacionOriginal((TipoIdentificacion)tipoidentificacion.clone());		
	}
	
	public void setTipoIdentificacionsOriginal(List<TipoIdentificacion> tipoidentificacions)throws Exception  {
		
		for(TipoIdentificacion tipoidentificacion:tipoidentificacions){
			tipoidentificacion.setTipoIdentificacionOriginal((TipoIdentificacion)tipoidentificacion.clone());
		}
	}
	
	public static void setTipoIdentificacionOriginalStatic(TipoIdentificacion tipoidentificacion)throws Exception  {
		tipoidentificacion.setTipoIdentificacionOriginal((TipoIdentificacion)tipoidentificacion.clone());		
	}
	
	public static void setTipoIdentificacionsOriginalStatic(List<TipoIdentificacion> tipoidentificacions)throws Exception  {
		
		for(TipoIdentificacion tipoidentificacion:tipoidentificacions){
			tipoidentificacion.setTipoIdentificacionOriginal((TipoIdentificacion)tipoidentificacion.clone());
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
	
	public  TipoIdentificacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoIdentificacion entity = new TipoIdentificacion();		
		
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
	
	public  TipoIdentificacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoIdentificacion entity = new TipoIdentificacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoIdentificacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoIdentificacionOriginal(new TipoIdentificacion());
      	    	entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoIdentificacion("",entity,resultSet); 
				
				//entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoIdentificacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoIdentificacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoIdentificacion entity = new TipoIdentificacion();
				
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
	
	public  TipoIdentificacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoIdentificacion entity = new TipoIdentificacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIdentificacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoIdentificacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoIdentificacionOriginal(new TipoIdentificacion());
      	    	entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoIdentificacion("",entity,resultSet);    
				
				//entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoIdentificacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoIdentificacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoIdentificacion entity = new TipoIdentificacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIdentificacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoIdentificacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoIdentificacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoIdentificacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		
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
	
	public  List<TipoIdentificacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIdentificacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIdentificacion();
      	    	entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoIdentificacion("",entity,resultSet);
      	    	
				//entity.setTipoIdentificacionOriginal( new TipoIdentificacion());
      	    	//entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoIdentificacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIdentificacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoIdentificacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
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
	
	public  List<TipoIdentificacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIdentificacion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoIdentificacion();
					//entity.setMapTipoIdentificacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoIdentificacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoIdentificacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         		
					entity=TipoIdentificacionDataAccess.getEntityTipoIdentificacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoIdentificacionOriginal( new TipoIdentificacion());
					////entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoIdentificacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIdentificacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoIdentificacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoIdentificacion entity = new TipoIdentificacion();		  
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
	
	public  TipoIdentificacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIdentificacion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoIdentificacion();
					//entity.setMapTipoIdentificacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoIdentificacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoIdentificacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         		
					entity=TipoIdentificacionDataAccess.getEntityTipoIdentificacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoIdentificacionOriginal( new TipoIdentificacion());
					////entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoIdentificacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIdentificacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoIdentificacion getEntityTipoIdentificacion(String strPrefijo,TipoIdentificacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoIdentificacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoIdentificacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoIdentificacionDataAccess.setFieldReflectionTipoIdentificacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoIdentificacion=TipoIdentificacionConstantesFunciones.getTodosTiposColumnasTipoIdentificacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoIdentificacion) {
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
							field = TipoIdentificacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoIdentificacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoIdentificacionDataAccess.setFieldReflectionTipoIdentificacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoIdentificacion(Field field,String strPrefijo,String sColumn,TipoIdentificacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoIdentificacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoIdentificacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoIdentificacionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoIdentificacionConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoIdentificacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIdentificacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoIdentificacion();
					entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoIdentificacion("",entity,resultSet);
					
					//entity.setTipoIdentificacionOriginal( new TipoIdentificacion());
					//entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoIdentificacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIdentificacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoIdentificacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoIdentificacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIdentificacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoIdentificacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
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
	
	public  List<TipoIdentificacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIdentificacion();
      	    	entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoIdentificacion("",entity,resultSet);
      	    	
				//entity.setTipoIdentificacionOriginal( new TipoIdentificacion());
      	    	//entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoIdentificacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIdentificacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoIdentificacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
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
	
	public  List<TipoIdentificacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoIdentificacion> entities = new  ArrayList<TipoIdentificacion>();
		TipoIdentificacion entity = new TipoIdentificacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIdentificacion();
      	    	entity=super.getEntity("",entity,resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoIdentificacion("",entity,resultSet);
      	    	
				//entity.setTipoIdentificacionOriginal( new TipoIdentificacion());
      	    	//entity.setTipoIdentificacionOriginal(super.getEntity("",entity.getTipoIdentificacionOriginal(),resultSet,TipoIdentificacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIdentificacionOriginal(this.getEntityTipoIdentificacion("",entity.getTipoIdentificacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoIdentificacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoIdentificacion getEntityTipoIdentificacion(String strPrefijo,TipoIdentificacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoIdentificacionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoIdentificacionConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoIdentificacionConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoIdentificacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoIdentificacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoIdentificacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoIdentificacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoIdentificacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoIdentificacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoIdentificacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoIdentificacionDataAccess.TABLENAME,TipoIdentificacionDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoIdentificacionDataAccess.setTipoIdentificacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Conyuge> getConyuges(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<Conyuge> conyuges= new ArrayList<Conyuge>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+ConyugeConstantesFunciones.SCHEMA+".conyuge.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN conyuge.TipoIdentificacion WHERE conyuge.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConyugeDataAccess conyugeDataAccess=new ConyugeDataAccess();

			conyugeDataAccess.setConnexionType(this.connexionType);
			conyugeDataAccess.setParameterDbType(this.parameterDbType);
			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return conyuges;

	}

	public List<Cobrador> getCobradors(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<Cobrador> cobradors= new ArrayList<Cobrador>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+CobradorConstantesFunciones.SCHEMA+".cobrador.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN cobrador.TipoIdentificacion WHERE cobrador.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CobradorDataAccess cobradorDataAccess=new CobradorDataAccess();

			cobradorDataAccess.setConnexionType(this.connexionType);
			cobradorDataAccess.setParameterDbType(this.parameterDbType);
			cobradors=cobradorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cobradors;

	}

	public List<RepresentanteLegal> getRepresentanteLegals(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<RepresentanteLegal> representantelegals= new ArrayList<RepresentanteLegal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+RepresentanteLegalConstantesFunciones.SCHEMA+".representantelegal.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN representantelegal.TipoIdentificacion WHERE representantelegal.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RepresentanteLegalDataAccess representantelegalDataAccess=new RepresentanteLegalDataAccess();

			representantelegalDataAccess.setConnexionType(this.connexionType);
			representantelegalDataAccess.setParameterDbType(this.parameterDbType);
			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return representantelegals;

	}

	public List<SubCliente> getSubClientes(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<SubCliente> subclientes= new ArrayList<SubCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN subcliente.TipoIdentificacion WHERE subcliente.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);
			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subclientes;

	}

	public List<Accionista> getAccionistas(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<Accionista> accionistas= new ArrayList<Accionista>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+AccionistaConstantesFunciones.SCHEMA+".accionista.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN accionista.TipoIdentificacion WHERE accionista.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AccionistaDataAccess accionistaDataAccess=new AccionistaDataAccess();

			accionistaDataAccess.setConnexionType(this.connexionType);
			accionistaDataAccess.setParameterDbType(this.parameterDbType);
			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return accionistas;

	}

	public List<Cliente> getClientes(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN cliente.TipoIdentificacion WHERE cliente.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos(Connexion connexion,TipoIdentificacion tipoidentificacion)throws SQLException,Exception {

		List<ParametroCarteraDefecto> parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion ON "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+".parametro_cartera_defecto.id_tipo_identificacion="+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id WHERE "+TipoIdentificacionConstantesFunciones.SCHEMA+".tipo_identificacion.id="+String.valueOf(tipoidentificacion.getId());
			} else {
				sQuery=" INNER JOIN parametrocarteradefecto.TipoIdentificacion WHERE parametrocarteradefecto.TipoIdentificacion.id="+String.valueOf(tipoidentificacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCarteraDefectoDataAccess parametrocarteradefectoDataAccess=new ParametroCarteraDefectoDataAccess();

			parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocarteradefectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoIdentificacion tipoidentificacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoidentificacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoidentificacion.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoidentificacion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoidentificacion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoidentificacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoidentificacion.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoidentificacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoidentificacion.getId());
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
	
	public void setIsNewIsChangedFalseTipoIdentificacion(TipoIdentificacion tipoidentificacion)throws Exception  {		
		tipoidentificacion.setIsNew(false);
		tipoidentificacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoIdentificacions(List<TipoIdentificacion> tipoidentificacions)throws Exception  {				
		for(TipoIdentificacion tipoidentificacion:tipoidentificacions) {
			tipoidentificacion.setIsNew(false);
			tipoidentificacion.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoIdentificacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
