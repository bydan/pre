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
import com.bydan.erp.facturacion.util.*;//DetalleTerminoProformaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleTerminoProformaDataAccess extends  DetalleTerminoProformaDataAccessAdditional{ //DetalleTerminoProformaDataAccessAdditional,DataAccessHelper<DetalleTerminoProforma>
	//static Logger logger = Logger.getLogger(DetalleTerminoProformaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_termino_proforma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_termino_proforma,numero,detalle)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_termino_proforma=?,numero=?,detalle=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleterminoproforma from "+DetalleTerminoProformaConstantesFunciones.SPERSISTENCENAME+" detalleterminoproforma";
	public static String QUERYSELECTNATIVE="select "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".version_row,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id_termino_proforma,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".numero,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".detalle from "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME;//+" as "+DetalleTerminoProformaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".version_row from "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME;//+" as "+DetalleTerminoProformaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_termino_proforma=?,numero=?,detalle=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLETERMINOPROFORMA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLETERMINOPROFORMA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLETERMINOPROFORMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLETERMINOPROFORMA_SELECT(?,?)";
	
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
	
	
	protected DetalleTerminoProformaDataAccessAdditional detalleterminoproformaDataAccessAdditional=null;
	
	public DetalleTerminoProformaDataAccessAdditional getDetalleTerminoProformaDataAccessAdditional() {
		return this.detalleterminoproformaDataAccessAdditional;
	}
	
	public void setDetalleTerminoProformaDataAccessAdditional(DetalleTerminoProformaDataAccessAdditional detalleterminoproformaDataAccessAdditional) {
		try {
			this.detalleterminoproformaDataAccessAdditional=detalleterminoproformaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleTerminoProformaDataAccess() {
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
		DetalleTerminoProformaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleTerminoProformaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleTerminoProformaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleTerminoProformaOriginal(DetalleTerminoProforma detalleterminoproforma)throws Exception  {
		detalleterminoproforma.setDetalleTerminoProformaOriginal((DetalleTerminoProforma)detalleterminoproforma.clone());		
	}
	
	public void setDetalleTerminoProformasOriginal(List<DetalleTerminoProforma> detalleterminoproformas)throws Exception  {
		
		for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas){
			detalleterminoproforma.setDetalleTerminoProformaOriginal((DetalleTerminoProforma)detalleterminoproforma.clone());
		}
	}
	
	public static void setDetalleTerminoProformaOriginalStatic(DetalleTerminoProforma detalleterminoproforma)throws Exception  {
		detalleterminoproforma.setDetalleTerminoProformaOriginal((DetalleTerminoProforma)detalleterminoproforma.clone());		
	}
	
	public static void setDetalleTerminoProformasOriginalStatic(List<DetalleTerminoProforma> detalleterminoproformas)throws Exception  {
		
		for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas){
			detalleterminoproforma.setDetalleTerminoProformaOriginal((DetalleTerminoProforma)detalleterminoproforma.clone());
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
	
	public  DetalleTerminoProforma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		
		
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
	
	public  DetalleTerminoProforma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetalleTerminoProforma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleTerminoProformaOriginal(new DetalleTerminoProforma());
      	    	entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleTerminoProforma("",entity,resultSet); 
				
				//entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleTerminoProforma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleTerminoProforma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleTerminoProforma entity = new DetalleTerminoProforma();
				
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
	
	public  DetalleTerminoProforma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleTerminoProforma entity = new DetalleTerminoProforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleTerminoProforma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleTerminoProformaOriginal(new DetalleTerminoProforma());
      	    	entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleTerminoProforma("",entity,resultSet);    
				
				//entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleTerminoProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleTerminoProforma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleTerminoProforma entity = new DetalleTerminoProforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleTerminoProforma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleTerminoProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleTerminoProforma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		
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
	
	public  List<DetalleTerminoProforma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTerminoProforma();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTerminoProforma("",entity,resultSet);
      	    	
				//entity.setDetalleTerminoProformaOriginal( new DetalleTerminoProforma());
      	    	//entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTerminoProformas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleTerminoProforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
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
	
	public  List<DetalleTerminoProforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTerminoProforma();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleTerminoProforma();
					//entity.setMapDetalleTerminoProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleTerminoProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleTerminoProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleTerminoProformaDataAccess.getEntityDetalleTerminoProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleTerminoProformaOriginal( new DetalleTerminoProforma());
					////entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTerminoProformas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleTerminoProforma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
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
	
	public  DetalleTerminoProforma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTerminoProforma();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleTerminoProforma();
					//entity.setMapDetalleTerminoProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleTerminoProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleTerminoProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleTerminoProformaDataAccess.getEntityDetalleTerminoProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleTerminoProformaOriginal( new DetalleTerminoProforma());
					////entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleTerminoProforma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleTerminoProforma getEntityDetalleTerminoProforma(String strPrefijo,DetalleTerminoProforma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleTerminoProforma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleTerminoProforma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleTerminoProformaDataAccess.setFieldReflectionDetalleTerminoProforma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleTerminoProforma=DetalleTerminoProformaConstantesFunciones.getTodosTiposColumnasDetalleTerminoProforma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleTerminoProforma) {
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
							field = DetalleTerminoProforma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleTerminoProforma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleTerminoProformaDataAccess.setFieldReflectionDetalleTerminoProforma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleTerminoProforma(Field field,String strPrefijo,String sColumn,DetalleTerminoProforma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleTerminoProformaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTerminoProformaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTerminoProformaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTerminoProformaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTerminoProformaConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleTerminoProformaConstantesFunciones.DETALLE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleTerminoProforma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleTerminoProforma();
					entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleTerminoProforma("",entity,resultSet);
					
					//entity.setDetalleTerminoProformaOriginal( new DetalleTerminoProforma());
					//entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleTerminoProformas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleTerminoProforma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleTerminoProforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
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
	
	public  List<DetalleTerminoProforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTerminoProforma();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTerminoProforma("",entity,resultSet);
      	    	
				//entity.setDetalleTerminoProformaOriginal( new DetalleTerminoProforma());
      	    	//entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleTerminoProformas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleTerminoProforma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
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
	
	public  List<DetalleTerminoProforma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTerminoProforma> entities = new  ArrayList<DetalleTerminoProforma>();
		DetalleTerminoProforma entity = new DetalleTerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTerminoProforma();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTerminoProforma("",entity,resultSet);
      	    	
				//entity.setDetalleTerminoProformaOriginal( new DetalleTerminoProforma());
      	    	//entity.setDetalleTerminoProformaOriginal(super.getEntity("",entity.getDetalleTerminoProformaOriginal(),resultSet,DetalleTerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTerminoProformaOriginal(this.getEntityDetalleTerminoProforma("",entity.getDetalleTerminoProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTerminoProformas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleTerminoProforma getEntityDetalleTerminoProforma(String strPrefijo,DetalleTerminoProforma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleTerminoProformaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleTerminoProformaConstantesFunciones.IDSUCURSAL));
				entity.setid_termino_proforma(resultSet.getLong(strPrefijo+DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA));
				entity.setnumero(resultSet.getInt(strPrefijo+DetalleTerminoProformaConstantesFunciones.NUMERO));
				entity.setdetalle(resultSet.getString(strPrefijo+DetalleTerminoProformaConstantesFunciones.DETALLE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleTerminoProforma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleTerminoProforma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleTerminoProformaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleTerminoProformaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleTerminoProformaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleTerminoProformaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleTerminoProformaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleTerminoProformaDataAccess.TABLENAME,DetalleTerminoProformaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleTerminoProformaDataAccess.setDetalleTerminoProformaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleTerminoProforma reldetalleterminoproforma)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleterminoproforma.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleTerminoProforma reldetalleterminoproforma)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleterminoproforma.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TerminoProforma getTerminoProforma(Connexion connexion,DetalleTerminoProforma reldetalleterminoproforma)throws SQLException,Exception {

		TerminoProforma terminoproforma= new TerminoProforma();

		try {
			TerminoProformaDataAccess terminoproformaDataAccess=new TerminoProformaDataAccess();

			terminoproformaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			terminoproformaDataAccess.setConnexionType(this.connexionType);
			terminoproformaDataAccess.setParameterDbType(this.parameterDbType);

			terminoproforma=terminoproformaDataAccess.getEntity(connexion,reldetalleterminoproforma.getid_termino_proforma());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return terminoproforma;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleTerminoProforma detalleterminoproforma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleterminoproforma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleterminoproforma.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleterminoproforma.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_termino_proforma=new ParameterValue<Long>();
					parameterMaintenanceValueid_termino_proforma.setValue(detalleterminoproforma.getid_termino_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_termino_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero.setValue(detalleterminoproforma.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle=new ParameterValue<String>();
					parameterMaintenanceValuedetalle.setValue(detalleterminoproforma.getdetalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleterminoproforma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleterminoproforma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleterminoproforma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleterminoproforma.getId());
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
	
	public void setIsNewIsChangedFalseDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproforma)throws Exception  {		
		detalleterminoproforma.setIsNew(false);
		detalleterminoproforma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleTerminoProformas(List<DetalleTerminoProforma> detalleterminoproformas)throws Exception  {				
		for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas) {
			detalleterminoproforma.setIsNew(false);
			detalleterminoproforma.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleTerminoProforma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
