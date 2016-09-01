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
import com.bydan.erp.cartera.util.*;//SubPreguntaEvaluacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class SubPreguntaEvaluacionDataAccess extends  SubPreguntaEvaluacionDataAccessAdditional{ //SubPreguntaEvaluacionDataAccessAdditional,DataAccessHelper<SubPreguntaEvaluacion>
	//static Logger logger = Logger.getLogger(SubPreguntaEvaluacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="sub_pregunta_evaluacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_pregunta_evaluacion,id_ejercicio,id_periodo,orden,pregunta,porcentaje_si,con_factura,con_orden_compra,con_completo,con_a_tiempo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pregunta_evaluacion=?,id_ejercicio=?,id_periodo=?,orden=?,pregunta=?,porcentaje_si=?,con_factura=?,con_orden_compra=?,con_completo=?,con_a_tiempo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select subpreguntaevaluacion from "+SubPreguntaEvaluacionConstantesFunciones.SPERSISTENCENAME+" subpreguntaevaluacion";
	public static String QUERYSELECTNATIVE="select "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".version_row,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_empresa,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_sucursal,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_pregunta_evaluacion,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_ejercicio,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id_periodo,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".orden,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".pregunta,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".porcentaje_si,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_factura,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_orden_compra,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_completo,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".con_a_tiempo from "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME;//+" as "+SubPreguntaEvaluacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".id,"+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+".version_row from "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME;//+" as "+SubPreguntaEvaluacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+"."+SubPreguntaEvaluacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pregunta_evaluacion=?,id_ejercicio=?,id_periodo=?,orden=?,pregunta=?,porcentaje_si=?,con_factura=?,con_orden_compra=?,con_completo=?,con_a_tiempo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SUBPREGUNTAEVALUACION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SUBPREGUNTAEVALUACION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SUBPREGUNTAEVALUACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SUBPREGUNTAEVALUACION_SELECT(?,?)";
	
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
	
	
	protected SubPreguntaEvaluacionDataAccessAdditional subpreguntaevaluacionDataAccessAdditional=null;
	
	public SubPreguntaEvaluacionDataAccessAdditional getSubPreguntaEvaluacionDataAccessAdditional() {
		return this.subpreguntaevaluacionDataAccessAdditional;
	}
	
	public void setSubPreguntaEvaluacionDataAccessAdditional(SubPreguntaEvaluacionDataAccessAdditional subpreguntaevaluacionDataAccessAdditional) {
		try {
			this.subpreguntaevaluacionDataAccessAdditional=subpreguntaevaluacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SubPreguntaEvaluacionDataAccess() {
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
		SubPreguntaEvaluacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SubPreguntaEvaluacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SubPreguntaEvaluacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSubPreguntaEvaluacionOriginal(SubPreguntaEvaluacion subpreguntaevaluacion)throws Exception  {
		subpreguntaevaluacion.setSubPreguntaEvaluacionOriginal((SubPreguntaEvaluacion)subpreguntaevaluacion.clone());		
	}
	
	public void setSubPreguntaEvaluacionsOriginal(List<SubPreguntaEvaluacion> subpreguntaevaluacions)throws Exception  {
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions){
			subpreguntaevaluacion.setSubPreguntaEvaluacionOriginal((SubPreguntaEvaluacion)subpreguntaevaluacion.clone());
		}
	}
	
	public static void setSubPreguntaEvaluacionOriginalStatic(SubPreguntaEvaluacion subpreguntaevaluacion)throws Exception  {
		subpreguntaevaluacion.setSubPreguntaEvaluacionOriginal((SubPreguntaEvaluacion)subpreguntaevaluacion.clone());		
	}
	
	public static void setSubPreguntaEvaluacionsOriginalStatic(List<SubPreguntaEvaluacion> subpreguntaevaluacions)throws Exception  {
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions){
			subpreguntaevaluacion.setSubPreguntaEvaluacionOriginal((SubPreguntaEvaluacion)subpreguntaevaluacion.clone());
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
	
	public  SubPreguntaEvaluacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		
		
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
	
	public  SubPreguntaEvaluacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.SubPreguntaEvaluacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSubPreguntaEvaluacionOriginal(new SubPreguntaEvaluacion());
      	    	entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubPreguntaEvaluacion("",entity,resultSet); 
				
				//entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSubPreguntaEvaluacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SubPreguntaEvaluacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();
				
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
	
	public  SubPreguntaEvaluacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubPreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.SubPreguntaEvaluacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSubPreguntaEvaluacionOriginal(new SubPreguntaEvaluacion());
      	    	entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubPreguntaEvaluacion("",entity,resultSet);    
				
				//entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSubPreguntaEvaluacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SubPreguntaEvaluacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubPreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.SubPreguntaEvaluacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSubPreguntaEvaluacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SubPreguntaEvaluacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		
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
	
	public  List<SubPreguntaEvaluacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubPreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubPreguntaEvaluacion();
      	    	entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubPreguntaEvaluacion("",entity,resultSet);
      	    	
				//entity.setSubPreguntaEvaluacionOriginal( new SubPreguntaEvaluacion());
      	    	//entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubPreguntaEvaluacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubPreguntaEvaluacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
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
	
	public  List<SubPreguntaEvaluacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubPreguntaEvaluacion();
				
				if(conMapGenerico) {
					entity.inicializarMapSubPreguntaEvaluacion();
					//entity.setMapSubPreguntaEvaluacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSubPreguntaEvaluacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubPreguntaEvaluacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
					entity=SubPreguntaEvaluacionDataAccess.getEntitySubPreguntaEvaluacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubPreguntaEvaluacionOriginal( new SubPreguntaEvaluacion());
					////entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
					////entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubPreguntaEvaluacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SubPreguntaEvaluacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
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
	
	public  SubPreguntaEvaluacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubPreguntaEvaluacion();
				
				if(conMapGenerico) {
					entity.inicializarMapSubPreguntaEvaluacion();
					//entity.setMapSubPreguntaEvaluacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSubPreguntaEvaluacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubPreguntaEvaluacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
					entity=SubPreguntaEvaluacionDataAccess.getEntitySubPreguntaEvaluacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubPreguntaEvaluacionOriginal( new SubPreguntaEvaluacion());
					////entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
					////entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSubPreguntaEvaluacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SubPreguntaEvaluacion getEntitySubPreguntaEvaluacion(String strPrefijo,SubPreguntaEvaluacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SubPreguntaEvaluacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SubPreguntaEvaluacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SubPreguntaEvaluacionDataAccess.setFieldReflectionSubPreguntaEvaluacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSubPreguntaEvaluacion=SubPreguntaEvaluacionConstantesFunciones.getTodosTiposColumnasSubPreguntaEvaluacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSubPreguntaEvaluacion) {
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
							field = SubPreguntaEvaluacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SubPreguntaEvaluacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SubPreguntaEvaluacionDataAccess.setFieldReflectionSubPreguntaEvaluacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSubPreguntaEvaluacion(Field field,String strPrefijo,String sColumn,SubPreguntaEvaluacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SubPreguntaEvaluacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.PREGUNTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.CONFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubPreguntaEvaluacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubPreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SubPreguntaEvaluacion();
					entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySubPreguntaEvaluacion("",entity,resultSet);
					
					//entity.setSubPreguntaEvaluacionOriginal( new SubPreguntaEvaluacion());
					//entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
					//entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSubPreguntaEvaluacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubPreguntaEvaluacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubPreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubPreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SubPreguntaEvaluacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
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
	
	public  List<SubPreguntaEvaluacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubPreguntaEvaluacion();
      	    	entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubPreguntaEvaluacion("",entity,resultSet);
      	    	
				//entity.setSubPreguntaEvaluacionOriginal( new SubPreguntaEvaluacion());
      	    	//entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSubPreguntaEvaluacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubPreguntaEvaluacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
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
	
	public  List<SubPreguntaEvaluacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubPreguntaEvaluacion> entities = new  ArrayList<SubPreguntaEvaluacion>();
		SubPreguntaEvaluacion entity = new SubPreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubPreguntaEvaluacion();
      	    	entity=super.getEntity("",entity,resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubPreguntaEvaluacion("",entity,resultSet);
      	    	
				//entity.setSubPreguntaEvaluacionOriginal( new SubPreguntaEvaluacion());
      	    	//entity.setSubPreguntaEvaluacionOriginal(super.getEntity("",entity.getSubPreguntaEvaluacionOriginal(),resultSet,SubPreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubPreguntaEvaluacionOriginal(this.getEntitySubPreguntaEvaluacion("",entity.getSubPreguntaEvaluacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubPreguntaEvaluacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SubPreguntaEvaluacion getEntitySubPreguntaEvaluacion(String strPrefijo,SubPreguntaEvaluacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL));
				entity.setid_pregunta_evaluacion(resultSet.getLong(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.IDPERIODO));
				entity.setorden(resultSet.getInt(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.ORDEN));
				entity.setpregunta(resultSet.getString(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.PREGUNTA));
				entity.setporcentaje_si(resultSet.getDouble(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI));
				entity.setcon_factura(resultSet.getBoolean(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.CONFACTURA));
				entity.setcon_orden_compra(resultSet.getBoolean(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA));
				entity.setcon_completo(resultSet.getBoolean(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO));
				entity.setcon_a_tiempo(resultSet.getBoolean(strPrefijo+SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSubPreguntaEvaluacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SubPreguntaEvaluacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SubPreguntaEvaluacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SubPreguntaEvaluacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SubPreguntaEvaluacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SubPreguntaEvaluacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SubPreguntaEvaluacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SubPreguntaEvaluacionDataAccess.TABLENAME,SubPreguntaEvaluacionDataAccess.ISWITHSTOREPROCEDURES);
			
			SubPreguntaEvaluacionDataAccess.setSubPreguntaEvaluacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SubPreguntaEvaluacion relsubpreguntaevaluacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsubpreguntaevaluacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,SubPreguntaEvaluacion relsubpreguntaevaluacion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsubpreguntaevaluacion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public PreguntaEvaluacion getPreguntaEvaluacion(Connexion connexion,SubPreguntaEvaluacion relsubpreguntaevaluacion)throws SQLException,Exception {

		PreguntaEvaluacion preguntaevaluacion= new PreguntaEvaluacion();

		try {
			PreguntaEvaluacionDataAccess preguntaevaluacionDataAccess=new PreguntaEvaluacionDataAccess();

			preguntaevaluacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			preguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			preguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);

			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion,relsubpreguntaevaluacion.getid_pregunta_evaluacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return preguntaevaluacion;

	}

	public Ejercicio getEjercicio(Connexion connexion,SubPreguntaEvaluacion relsubpreguntaevaluacion)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relsubpreguntaevaluacion.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,SubPreguntaEvaluacion relsubpreguntaevaluacion)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relsubpreguntaevaluacion.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}


		
		public List<DetalleEvaluacionProveedor> getDetalleEvaluacionProveedors(Connexion connexion,SubPreguntaEvaluacion subpreguntaevaluacion)throws SQLException,Exception {

		List<DetalleEvaluacionProveedor> detalleevaluacionproveedors= new ArrayList<DetalleEvaluacionProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+".sub_pregunta_evaluacion ON "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+".detalle_evaluacion_proveedor.id_sub_pregunta_evaluacion="+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+".sub_pregunta_evaluacion.id WHERE "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+".sub_pregunta_evaluacion.id="+String.valueOf(subpreguntaevaluacion.getId());
			} else {
				sQuery=" INNER JOIN detalleevaluacionproveedor.SubPreguntaEvaluacion WHERE detalleevaluacionproveedor.SubPreguntaEvaluacion.id="+String.valueOf(subpreguntaevaluacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleEvaluacionProveedorDataAccess detalleevaluacionproveedorDataAccess=new DetalleEvaluacionProveedorDataAccess();

			detalleevaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			detalleevaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleevaluacionproveedors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!subpreguntaevaluacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(subpreguntaevaluacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(subpreguntaevaluacion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pregunta_evaluacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_pregunta_evaluacion.setValue(subpreguntaevaluacion.getid_pregunta_evaluacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pregunta_evaluacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(subpreguntaevaluacion.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(subpreguntaevaluacion.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(subpreguntaevaluacion.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepregunta=new ParameterValue<String>();
					parameterMaintenanceValuepregunta.setValue(subpreguntaevaluacion.getpregunta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepregunta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_si=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_si.setValue(subpreguntaevaluacion.getporcentaje_si());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_si);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_factura.setValue(subpreguntaevaluacion.getcon_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_orden_compra=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_orden_compra.setValue(subpreguntaevaluacion.getcon_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_completo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_completo.setValue(subpreguntaevaluacion.getcon_completo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_completo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_a_tiempo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_a_tiempo.setValue(subpreguntaevaluacion.getcon_a_tiempo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_a_tiempo);
					parametersTemp.add(parameterMaintenance);
					
						if(!subpreguntaevaluacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(subpreguntaevaluacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(subpreguntaevaluacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(subpreguntaevaluacion.getId());
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
	
	public void setIsNewIsChangedFalseSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion)throws Exception  {		
		subpreguntaevaluacion.setIsNew(false);
		subpreguntaevaluacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSubPreguntaEvaluacions(List<SubPreguntaEvaluacion> subpreguntaevaluacions)throws Exception  {				
		for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions) {
			subpreguntaevaluacion.setIsNew(false);
			subpreguntaevaluacion.setIsChanged(false);
		}
	}
	
	public void generarExportarSubPreguntaEvaluacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
