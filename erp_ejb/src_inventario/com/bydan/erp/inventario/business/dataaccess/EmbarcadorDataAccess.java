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
import com.bydan.erp.inventario.util.*;//EmbarcadorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class EmbarcadorDataAccess extends  EmbarcadorDataAccessAdditional{ //EmbarcadorDataAccessAdditional,DataAccessHelper<Embarcador>
	//static Logger logger = Logger.getLogger(EmbarcadorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="embarcador";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,ruc,direccion,telefono,contacto,e_mail,fax,id_tipo_via_transporte,id_puerto,id_empleado,id_pais,id_ciudad)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,ruc=?,direccion=?,telefono=?,contacto=?,e_mail=?,fax=?,id_tipo_via_transporte=?,id_puerto=?,id_empleado=?,id_pais=?,id_ciudad=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select embarcador from "+EmbarcadorConstantesFunciones.SPERSISTENCENAME+" embarcador";
	public static String QUERYSELECTNATIVE="select "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".version_row,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_empresa,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".nombre,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".ruc,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".direccion,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".telefono,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".contacto,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".e_mail,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".fax,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_puerto,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_empleado,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_pais,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id_ciudad from "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME;//+" as "+EmbarcadorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".id,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".version_row,"+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+".nombre from "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME;//+" as "+EmbarcadorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmbarcadorConstantesFunciones.SCHEMA+"."+EmbarcadorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,ruc=?,direccion=?,telefono=?,contacto=?,e_mail=?,fax=?,id_tipo_via_transporte=?,id_puerto=?,id_empleado=?,id_pais=?,id_ciudad=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMBARCADOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMBARCADOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMBARCADOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMBARCADOR_SELECT(?,?)";
	
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
	
	
	protected EmbarcadorDataAccessAdditional embarcadorDataAccessAdditional=null;
	
	public EmbarcadorDataAccessAdditional getEmbarcadorDataAccessAdditional() {
		return this.embarcadorDataAccessAdditional;
	}
	
	public void setEmbarcadorDataAccessAdditional(EmbarcadorDataAccessAdditional embarcadorDataAccessAdditional) {
		try {
			this.embarcadorDataAccessAdditional=embarcadorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmbarcadorDataAccess() {
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
		EmbarcadorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmbarcadorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmbarcadorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmbarcadorOriginal(Embarcador embarcador)throws Exception  {
		embarcador.setEmbarcadorOriginal((Embarcador)embarcador.clone());		
	}
	
	public void setEmbarcadorsOriginal(List<Embarcador> embarcadors)throws Exception  {
		
		for(Embarcador embarcador:embarcadors){
			embarcador.setEmbarcadorOriginal((Embarcador)embarcador.clone());
		}
	}
	
	public static void setEmbarcadorOriginalStatic(Embarcador embarcador)throws Exception  {
		embarcador.setEmbarcadorOriginal((Embarcador)embarcador.clone());		
	}
	
	public static void setEmbarcadorsOriginalStatic(List<Embarcador> embarcadors)throws Exception  {
		
		for(Embarcador embarcador:embarcadors){
			embarcador.setEmbarcadorOriginal((Embarcador)embarcador.clone());
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
	
	public  Embarcador getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Embarcador entity = new Embarcador();		
		
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
	
	public  Embarcador getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Embarcador entity = new Embarcador();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Embarcador.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmbarcadorOriginal(new Embarcador());
      	    	entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmbarcador("",entity,resultSet); 
				
				//entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmbarcador(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Embarcador getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Embarcador entity = new Embarcador();
				
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
	
	public  Embarcador getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Embarcador entity = new Embarcador();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmbarcadorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Embarcador.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmbarcadorOriginal(new Embarcador());
      	    	entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmbarcador("",entity,resultSet);    
				
				//entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmbarcador(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Embarcador
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Embarcador entity = new Embarcador();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmbarcadorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Embarcador.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmbarcador(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Embarcador> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		
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
	
	public  List<Embarcador> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmbarcadorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Embarcador();
      	    	entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmbarcador("",entity,resultSet);
      	    	
				//entity.setEmbarcadorOriginal( new Embarcador());
      	    	//entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmbarcadors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmbarcador(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Embarcador> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
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
	
	public  List<Embarcador> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Embarcador();
				
				if(conMapGenerico) {
					entity.inicializarMapEmbarcador();
					//entity.setMapEmbarcador(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmbarcadorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmbarcador().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         		
					entity=EmbarcadorDataAccess.getEntityEmbarcador("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmbarcadorOriginal( new Embarcador());
					////entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
					////entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmbarcadors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmbarcador(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Embarcador getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Embarcador entity = new Embarcador();		  
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
	
	public  Embarcador getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Embarcador entity = new Embarcador();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Embarcador();
				
				if(conMapGenerico) {
					entity.inicializarMapEmbarcador();
					//entity.setMapEmbarcador(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmbarcadorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmbarcador().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         		
					entity=EmbarcadorDataAccess.getEntityEmbarcador("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmbarcadorOriginal( new Embarcador());
					////entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
					////entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmbarcador(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmbarcador(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Embarcador getEntityEmbarcador(String strPrefijo,Embarcador entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Embarcador.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Embarcador.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmbarcadorDataAccess.setFieldReflectionEmbarcador(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmbarcador=EmbarcadorConstantesFunciones.getTodosTiposColumnasEmbarcador();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmbarcador) {
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
							field = Embarcador.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Embarcador.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmbarcadorDataAccess.setFieldReflectionEmbarcador(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmbarcador(Field field,String strPrefijo,String sColumn,Embarcador entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmbarcadorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.CONTACTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.FAX:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.IDPUERTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmbarcadorConstantesFunciones.IDCIUDAD:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Embarcador>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmbarcadorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Embarcador();
					entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmbarcador("",entity,resultSet);
					
					//entity.setEmbarcadorOriginal( new Embarcador());
					//entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
					//entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmbarcadors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmbarcador(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Embarcador>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmbarcadorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmbarcadorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Embarcador> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
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
	
	public  List<Embarcador> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Embarcador();
      	    	entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmbarcador("",entity,resultSet);
      	    	
				//entity.setEmbarcadorOriginal( new Embarcador());
      	    	//entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmbarcadors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmbarcador(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Embarcador> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
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
	
	public  List<Embarcador> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Embarcador> entities = new  ArrayList<Embarcador>();
		Embarcador entity = new Embarcador();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Embarcador();
      	    	entity=super.getEntity("",entity,resultSet,EmbarcadorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmbarcador("",entity,resultSet);
      	    	
				//entity.setEmbarcadorOriginal( new Embarcador());
      	    	//entity.setEmbarcadorOriginal(super.getEntity("",entity.getEmbarcadorOriginal(),resultSet,EmbarcadorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmbarcadorOriginal(this.getEntityEmbarcador("",entity.getEmbarcadorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmbarcadors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Embarcador getEntityEmbarcador(String strPrefijo,Embarcador entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmbarcadorConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.NOMBRE));
				entity.setruc(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.RUC));
				entity.setdireccion(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.TELEFONO));
				entity.setcontacto(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.CONTACTO));
				entity.sete_mail(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.EMAIL));
				entity.setfax(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.FAX));
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+EmbarcadorConstantesFunciones.IDTIPOVIATRANSPORTE));
				entity.setid_puerto(resultSet.getLong(strPrefijo+EmbarcadorConstantesFunciones.IDPUERTO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmbarcadorConstantesFunciones.IDEMPLEADO));
				entity.setid_pais(resultSet.getLong(strPrefijo+EmbarcadorConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+EmbarcadorConstantesFunciones.IDCIUDAD));if(resultSet.wasNull()) {entity.setid_ciudad(null); }
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EmbarcadorConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmbarcador(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Embarcador entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmbarcadorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmbarcadorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmbarcadorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmbarcadorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmbarcadorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmbarcadorDataAccess.TABLENAME,EmbarcadorDataAccess.ISWITHSTOREPROCEDURES);
			
			EmbarcadorDataAccess.setEmbarcadorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Embarcador relembarcador)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relembarcador.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,Embarcador relembarcador)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,relembarcador.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}

	public Puerto getPuerto(Connexion connexion,Embarcador relembarcador)throws SQLException,Exception {

		Puerto puerto= new Puerto();

		try {
			PuertoDataAccess puertoDataAccess=new PuertoDataAccess();

			puertoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			puertoDataAccess.setConnexionType(this.connexionType);
			puertoDataAccess.setParameterDbType(this.parameterDbType);

			puerto=puertoDataAccess.getEntity(connexion,relembarcador.getid_puerto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return puerto;

	}

	public Empleado getEmpleado(Connexion connexion,Embarcador relembarcador)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relembarcador.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Pais getPais(Connexion connexion,Embarcador relembarcador)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relembarcador.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,Embarcador relembarcador)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relembarcador.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
		public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,Embarcador embarcador)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmbarcadorConstantesFunciones.SCHEMA+".embarcador ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_embarcador="+EmbarcadorConstantesFunciones.SCHEMA+".embarcador.id WHERE "+EmbarcadorConstantesFunciones.SCHEMA+".embarcador.id="+String.valueOf(embarcador.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.Embarcador WHERE pedidocompraimpor.Embarcador.id="+String.valueOf(embarcador.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}

	public List<ParametroCompra> getParametroCompras(Connexion connexion,Embarcador embarcador)throws SQLException,Exception {

		List<ParametroCompra> parametrocompras= new ArrayList<ParametroCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmbarcadorConstantesFunciones.SCHEMA+".embarcador ON "+ParametroCompraConstantesFunciones.SCHEMA+".parametro_compra.id_embarcador="+EmbarcadorConstantesFunciones.SCHEMA+".embarcador.id WHERE "+EmbarcadorConstantesFunciones.SCHEMA+".embarcador.id="+String.valueOf(embarcador.getId());
			} else {
				sQuery=" INNER JOIN parametrocompra.Embarcador WHERE parametrocompra.Embarcador.id="+String.valueOf(embarcador.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCompraDataAccess parametrocompraDataAccess=new ParametroCompraDataAccess();

			parametrocompraDataAccess.setConnexionType(this.connexionType);
			parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Embarcador embarcador) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!embarcador.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(embarcador.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(embarcador.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(embarcador.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(embarcador.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(embarcador.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontacto=new ParameterValue<String>();
					parameterMaintenanceValuecontacto.setValue(embarcador.getcontacto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontacto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuee_mail=new ParameterValue<String>();
					parameterMaintenanceValuee_mail.setValue(embarcador.gete_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuee_mail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefax=new ParameterValue<String>();
					parameterMaintenanceValuefax.setValue(embarcador.getfax());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefax);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(embarcador.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_puerto=new ParameterValue<Long>();
					parameterMaintenanceValueid_puerto.setValue(embarcador.getid_puerto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_puerto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(embarcador.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(embarcador.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(embarcador.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
						if(!embarcador.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(embarcador.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(embarcador.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(embarcador.getId());
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
	
	public void setIsNewIsChangedFalseEmbarcador(Embarcador embarcador)throws Exception  {		
		embarcador.setIsNew(false);
		embarcador.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmbarcadors(List<Embarcador> embarcadors)throws Exception  {				
		for(Embarcador embarcador:embarcadors) {
			embarcador.setIsNew(false);
			embarcador.setIsChanged(false);
		}
	}
	
	public void generarExportarEmbarcador(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
