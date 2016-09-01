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
import com.bydan.erp.cartera.util.*;//RutaTransporteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class RutaTransporteDataAccess extends  RutaTransporteDataAccessAdditional{ //RutaTransporteDataAccessAdditional,DataAccessHelper<RutaTransporte>
	//static Logger logger = Logger.getLogger(RutaTransporteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="ruta_transporte";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,origen,destino,precio)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,origen=?,destino=?,precio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select rutatransporte from "+RutaTransporteConstantesFunciones.SPERSISTENCENAME+" rutatransporte";
	public static String QUERYSELECTNATIVE="select "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".id,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".version_row,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".id_empresa,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".nombre,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".origen,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".destino,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".precio from "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME;//+" as "+RutaTransporteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".id,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".version_row,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".nombre from "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME;//+" as "+RutaTransporteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,origen=?,destino=?,precio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RUTATRANSPORTE_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RUTATRANSPORTE_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RUTATRANSPORTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RUTATRANSPORTE_SELECT(?,?)";
	
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
	
	
	protected RutaTransporteDataAccessAdditional rutatransporteDataAccessAdditional=null;
	
	public RutaTransporteDataAccessAdditional getRutaTransporteDataAccessAdditional() {
		return this.rutatransporteDataAccessAdditional;
	}
	
	public void setRutaTransporteDataAccessAdditional(RutaTransporteDataAccessAdditional rutatransporteDataAccessAdditional) {
		try {
			this.rutatransporteDataAccessAdditional=rutatransporteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RutaTransporteDataAccess() {
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
		RutaTransporteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RutaTransporteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RutaTransporteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRutaTransporteOriginal(RutaTransporte rutatransporte)throws Exception  {
		rutatransporte.setRutaTransporteOriginal((RutaTransporte)rutatransporte.clone());		
	}
	
	public void setRutaTransportesOriginal(List<RutaTransporte> rutatransportes)throws Exception  {
		
		for(RutaTransporte rutatransporte:rutatransportes){
			rutatransporte.setRutaTransporteOriginal((RutaTransporte)rutatransporte.clone());
		}
	}
	
	public static void setRutaTransporteOriginalStatic(RutaTransporte rutatransporte)throws Exception  {
		rutatransporte.setRutaTransporteOriginal((RutaTransporte)rutatransporte.clone());		
	}
	
	public static void setRutaTransportesOriginalStatic(List<RutaTransporte> rutatransportes)throws Exception  {
		
		for(RutaTransporte rutatransporte:rutatransportes){
			rutatransporte.setRutaTransporteOriginal((RutaTransporte)rutatransporte.clone());
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
	
	public  RutaTransporte getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RutaTransporte entity = new RutaTransporte();		
		
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
	
	public  RutaTransporte getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RutaTransporte entity = new RutaTransporte();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.RutaTransporte.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRutaTransporteOriginal(new RutaTransporte());
      	    	entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRutaTransporte("",entity,resultSet); 
				
				//entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRutaTransporte(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RutaTransporte getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RutaTransporte entity = new RutaTransporte();
				
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
	
	public  RutaTransporte getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RutaTransporte entity = new RutaTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RutaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RutaTransporte.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRutaTransporteOriginal(new RutaTransporte());
      	    	entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRutaTransporte("",entity,resultSet);    
				
				//entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRutaTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RutaTransporte
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RutaTransporte entity = new RutaTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RutaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RutaTransporte.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRutaTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RutaTransporte> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		
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
	
	public  List<RutaTransporte> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RutaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RutaTransporte();
      	    	entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRutaTransporte("",entity,resultSet);
      	    	
				//entity.setRutaTransporteOriginal( new RutaTransporte());
      	    	//entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRutaTransportes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRutaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RutaTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
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
	
	public  List<RutaTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RutaTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapRutaTransporte();
					//entity.setMapRutaTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRutaTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRutaTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         		
					entity=RutaTransporteDataAccess.getEntityRutaTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRutaTransporteOriginal( new RutaTransporte());
					////entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRutaTransportes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRutaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RutaTransporte getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RutaTransporte entity = new RutaTransporte();		  
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
	
	public  RutaTransporte getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RutaTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapRutaTransporte();
					//entity.setMapRutaTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRutaTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRutaTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         		
					entity=RutaTransporteDataAccess.getEntityRutaTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRutaTransporteOriginal( new RutaTransporte());
					////entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRutaTransporte(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRutaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RutaTransporte getEntityRutaTransporte(String strPrefijo,RutaTransporte entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RutaTransporte.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RutaTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RutaTransporteDataAccess.setFieldReflectionRutaTransporte(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRutaTransporte=RutaTransporteConstantesFunciones.getTodosTiposColumnasRutaTransporte();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRutaTransporte) {
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
							field = RutaTransporte.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RutaTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RutaTransporteDataAccess.setFieldReflectionRutaTransporte(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRutaTransporte(Field field,String strPrefijo,String sColumn,RutaTransporte entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RutaTransporteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RutaTransporteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RutaTransporteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RutaTransporteConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RutaTransporteConstantesFunciones.ORIGEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RutaTransporteConstantesFunciones.DESTINO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RutaTransporteConstantesFunciones.PRECIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RutaTransporte>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RutaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RutaTransporte();
					entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRutaTransporte("",entity,resultSet);
					
					//entity.setRutaTransporteOriginal( new RutaTransporte());
					//entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
					//entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRutaTransportes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRutaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RutaTransporte>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RutaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RutaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RutaTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
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
	
	public  List<RutaTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RutaTransporte();
      	    	entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRutaTransporte("",entity,resultSet);
      	    	
				//entity.setRutaTransporteOriginal( new RutaTransporte());
      	    	//entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRutaTransportes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRutaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RutaTransporte> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
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
	
	public  List<RutaTransporte> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RutaTransporte> entities = new  ArrayList<RutaTransporte>();
		RutaTransporte entity = new RutaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RutaTransporte();
      	    	entity=super.getEntity("",entity,resultSet,RutaTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRutaTransporte("",entity,resultSet);
      	    	
				//entity.setRutaTransporteOriginal( new RutaTransporte());
      	    	//entity.setRutaTransporteOriginal(super.getEntity("",entity.getRutaTransporteOriginal(),resultSet,RutaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRutaTransporteOriginal(this.getEntityRutaTransporte("",entity.getRutaTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRutaTransportes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RutaTransporte getEntityRutaTransporte(String strPrefijo,RutaTransporte entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RutaTransporteConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+RutaTransporteConstantesFunciones.NOMBRE));
				entity.setorigen(resultSet.getString(strPrefijo+RutaTransporteConstantesFunciones.ORIGEN));
				entity.setdestino(resultSet.getString(strPrefijo+RutaTransporteConstantesFunciones.DESTINO));
				entity.setprecio(resultSet.getDouble(strPrefijo+RutaTransporteConstantesFunciones.PRECIO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+RutaTransporteConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRutaTransporte(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RutaTransporte entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RutaTransporteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RutaTransporteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RutaTransporteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RutaTransporteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RutaTransporteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RutaTransporteDataAccess.TABLENAME,RutaTransporteDataAccess.ISWITHSTOREPROCEDURES);
			
			RutaTransporteDataAccess.setRutaTransporteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RutaTransporte relrutatransporte)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrutatransporte.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<Proforma> getProformas(Connexion connexion,RutaTransporte rutatransporte)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_ruta_transporte="+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte.id WHERE "+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte.id="+String.valueOf(rutatransporte.getId());
			} else {
				sQuery=" INNER JOIN proforma.RutaTransporte WHERE proforma.RutaTransporte.id="+String.valueOf(rutatransporte.getId());

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

	public List<Pedido> getPedidos(Connexion connexion,RutaTransporte rutatransporte)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_ruta_transporte="+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte.id WHERE "+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte.id="+String.valueOf(rutatransporte.getId());
			} else {
				sQuery=" INNER JOIN pedido.RutaTransporte WHERE pedido.RutaTransporte.id="+String.valueOf(rutatransporte.getId());

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

	public List<ServicioTransporte> getServicioTransportes(Connexion connexion,RutaTransporte rutatransporte)throws SQLException,Exception {

		List<ServicioTransporte> serviciotransportes= new ArrayList<ServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte ON "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id_ruta_transporte="+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte.id WHERE "+RutaTransporteConstantesFunciones.SCHEMA+".ruta_transporte.id="+String.valueOf(rutatransporte.getId());
			} else {
				sQuery=" INNER JOIN serviciotransporte.RutaTransporte WHERE serviciotransporte.RutaTransporte.id="+String.valueOf(rutatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioTransporteDataAccess serviciotransporteDataAccess=new ServicioTransporteDataAccess();

			serviciotransporteDataAccess.setConnexionType(this.connexionType);
			serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serviciotransportes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RutaTransporte rutatransporte) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!rutatransporte.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(rutatransporte.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(rutatransporte.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorigen=new ParameterValue<String>();
					parameterMaintenanceValueorigen.setValue(rutatransporte.getorigen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorigen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedestino=new ParameterValue<String>();
					parameterMaintenanceValuedestino.setValue(rutatransporte.getdestino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedestino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(rutatransporte.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
						if(!rutatransporte.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(rutatransporte.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(rutatransporte.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(rutatransporte.getId());
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
	
	public void setIsNewIsChangedFalseRutaTransporte(RutaTransporte rutatransporte)throws Exception  {		
		rutatransporte.setIsNew(false);
		rutatransporte.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRutaTransportes(List<RutaTransporte> rutatransportes)throws Exception  {				
		for(RutaTransporte rutatransporte:rutatransportes) {
			rutatransporte.setIsNew(false);
			rutatransporte.setIsChanged(false);
		}
	}
	
	public void generarExportarRutaTransporte(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
