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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//DetalleEvaluacionNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleEvaluacionNomiDataAccess extends  DetalleEvaluacionNomiDataAccessAdditional{ //DetalleEvaluacionNomiDataAccessAdditional,DataAccessHelper<DetalleEvaluacionNomi>
	//static Logger logger = Logger.getLogger(DetalleEvaluacionNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_evaluacion_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_evaluacion_nomi,id_formato_nomi,id_pregunta_nomi,respuesta,respuesta_valor,califica1,califica2,califica3,califica4,califica5,califica6,califica7,califica8,califica9,califica10)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_evaluacion_nomi=?,id_formato_nomi=?,id_pregunta_nomi=?,respuesta=?,respuesta_valor=?,califica1=?,califica2=?,califica3=?,califica4=?,califica5=?,califica6=?,califica7=?,califica8=?,califica9=?,califica10=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleevaluacionnomi from "+DetalleEvaluacionNomiConstantesFunciones.SPERSISTENCENAME+" detalleevaluacionnomi";
	public static String QUERYSELECTNATIVE="select "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".version_row,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_empresa,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_evaluacion_nomi,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id_pregunta_nomi,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".respuesta,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".respuesta_valor,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica1,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica2,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica3,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica4,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica5,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica6,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica7,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica8,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica9,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".califica10 from "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME;//+" as "+DetalleEvaluacionNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".id,"+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+".version_row from "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME;//+" as "+DetalleEvaluacionNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+"."+DetalleEvaluacionNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_evaluacion_nomi=?,id_formato_nomi=?,id_pregunta_nomi=?,respuesta=?,respuesta_valor=?,califica1=?,califica2=?,califica3=?,califica4=?,califica5=?,califica6=?,califica7=?,califica8=?,califica9=?,califica10=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEEVALUACIONNOMI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEEVALUACIONNOMI_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEEVALUACIONNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEEVALUACIONNOMI_SELECT(?,?)";
	
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
	
	
	protected DetalleEvaluacionNomiDataAccessAdditional detalleevaluacionnomiDataAccessAdditional=null;
	
	public DetalleEvaluacionNomiDataAccessAdditional getDetalleEvaluacionNomiDataAccessAdditional() {
		return this.detalleevaluacionnomiDataAccessAdditional;
	}
	
	public void setDetalleEvaluacionNomiDataAccessAdditional(DetalleEvaluacionNomiDataAccessAdditional detalleevaluacionnomiDataAccessAdditional) {
		try {
			this.detalleevaluacionnomiDataAccessAdditional=detalleevaluacionnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleEvaluacionNomiDataAccess() {
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
		DetalleEvaluacionNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleEvaluacionNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleEvaluacionNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleEvaluacionNomiOriginal(DetalleEvaluacionNomi detalleevaluacionnomi)throws Exception  {
		detalleevaluacionnomi.setDetalleEvaluacionNomiOriginal((DetalleEvaluacionNomi)detalleevaluacionnomi.clone());		
	}
	
	public void setDetalleEvaluacionNomisOriginal(List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception  {
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis){
			detalleevaluacionnomi.setDetalleEvaluacionNomiOriginal((DetalleEvaluacionNomi)detalleevaluacionnomi.clone());
		}
	}
	
	public static void setDetalleEvaluacionNomiOriginalStatic(DetalleEvaluacionNomi detalleevaluacionnomi)throws Exception  {
		detalleevaluacionnomi.setDetalleEvaluacionNomiOriginal((DetalleEvaluacionNomi)detalleevaluacionnomi.clone());		
	}
	
	public static void setDetalleEvaluacionNomisOriginalStatic(List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception  {
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis){
			detalleevaluacionnomi.setDetalleEvaluacionNomiOriginal((DetalleEvaluacionNomi)detalleevaluacionnomi.clone());
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
	
	public  DetalleEvaluacionNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		
		
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
	
	public  DetalleEvaluacionNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.DetalleEvaluacionNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleEvaluacionNomiOriginal(new DetalleEvaluacionNomi());
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleEvaluacionNomi("",entity,resultSet); 
				
				//entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleEvaluacionNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleEvaluacionNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();
				
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
	
	public  DetalleEvaluacionNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DetalleEvaluacionNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleEvaluacionNomiOriginal(new DetalleEvaluacionNomi());
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleEvaluacionNomi("",entity,resultSet);    
				
				//entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleEvaluacionNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleEvaluacionNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DetalleEvaluacionNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleEvaluacionNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleEvaluacionNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		
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
	
	public  List<DetalleEvaluacionNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionNomi();
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleEvaluacionNomi("",entity,resultSet);
      	    	
				//entity.setDetalleEvaluacionNomiOriginal( new DetalleEvaluacionNomi());
      	    	//entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleEvaluacionNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
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
	
	public  List<DetalleEvaluacionNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleEvaluacionNomi();
					//entity.setMapDetalleEvaluacionNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleEvaluacionNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleEvaluacionNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         		
					entity=DetalleEvaluacionNomiDataAccess.getEntityDetalleEvaluacionNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleEvaluacionNomiOriginal( new DetalleEvaluacionNomi());
					////entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleEvaluacionNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
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
	
	public  DetalleEvaluacionNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleEvaluacionNomi();
					//entity.setMapDetalleEvaluacionNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleEvaluacionNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleEvaluacionNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         		
					entity=DetalleEvaluacionNomiDataAccess.getEntityDetalleEvaluacionNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleEvaluacionNomiOriginal( new DetalleEvaluacionNomi());
					////entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleEvaluacionNomi getEntityDetalleEvaluacionNomi(String strPrefijo,DetalleEvaluacionNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleEvaluacionNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleEvaluacionNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleEvaluacionNomiDataAccess.setFieldReflectionDetalleEvaluacionNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleEvaluacionNomi=DetalleEvaluacionNomiConstantesFunciones.getTodosTiposColumnasDetalleEvaluacionNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleEvaluacionNomi) {
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
							field = DetalleEvaluacionNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleEvaluacionNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleEvaluacionNomiDataAccess.setFieldReflectionDetalleEvaluacionNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleEvaluacionNomi(Field field,String strPrefijo,String sColumn,DetalleEvaluacionNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleEvaluacionNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.RESPUESTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA1:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA2:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA3:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA4:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA5:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA6:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA7:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA8:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA9:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleEvaluacionNomiConstantesFunciones.CALIFICA10:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleEvaluacionNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleEvaluacionNomi();
					entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleEvaluacionNomi("",entity,resultSet);
					
					//entity.setDetalleEvaluacionNomiOriginal( new DetalleEvaluacionNomi());
					//entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleEvaluacionNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleEvaluacionNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleEvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleEvaluacionNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
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
	
	public  List<DetalleEvaluacionNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionNomi();
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleEvaluacionNomi("",entity,resultSet);
      	    	
				//entity.setDetalleEvaluacionNomiOriginal( new DetalleEvaluacionNomi());
      	    	//entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleEvaluacionNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleEvaluacionNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
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
	
	public  List<DetalleEvaluacionNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionNomi> entities = new  ArrayList<DetalleEvaluacionNomi>();
		DetalleEvaluacionNomi entity = new DetalleEvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionNomi();
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleEvaluacionNomi("",entity,resultSet);
      	    	
				//entity.setDetalleEvaluacionNomiOriginal( new DetalleEvaluacionNomi());
      	    	//entity.setDetalleEvaluacionNomiOriginal(super.getEntity("",entity.getDetalleEvaluacionNomiOriginal(),resultSet,DetalleEvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionNomiOriginal(this.getEntityDetalleEvaluacionNomi("",entity.getDetalleEvaluacionNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleEvaluacionNomi getEntityDetalleEvaluacionNomi(String strPrefijo,DetalleEvaluacionNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA));
				entity.setid_evaluacion_nomi(resultSet.getLong(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI));
				entity.setid_formato_nomi(resultSet.getLong(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI));
				entity.setid_pregunta_nomi(resultSet.getLong(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI));
				entity.setrespuesta(resultSet.getString(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.RESPUESTA));
				entity.setrespuesta_valor(resultSet.getDouble(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR));
				entity.setcalifica1(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA1));
				entity.setcalifica2(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA2));
				entity.setcalifica3(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA3));
				entity.setcalifica4(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA4));
				entity.setcalifica5(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA5));
				entity.setcalifica6(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA6));
				entity.setcalifica7(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA7));
				entity.setcalifica8(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA8));
				entity.setcalifica9(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA9));
				entity.setcalifica10(resultSet.getBoolean(strPrefijo+DetalleEvaluacionNomiConstantesFunciones.CALIFICA10));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleEvaluacionNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleEvaluacionNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleEvaluacionNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleEvaluacionNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleEvaluacionNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleEvaluacionNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleEvaluacionNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleEvaluacionNomiDataAccess.TABLENAME,DetalleEvaluacionNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleEvaluacionNomiDataAccess.setDetalleEvaluacionNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleEvaluacionNomi reldetalleevaluacionnomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleevaluacionnomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public EvaluacionNomi getEvaluacionNomi(Connexion connexion,DetalleEvaluacionNomi reldetalleevaluacionnomi)throws SQLException,Exception {

		EvaluacionNomi evaluacionnomi= new EvaluacionNomi();

		try {
			EvaluacionNomiDataAccess evaluacionnomiDataAccess=new EvaluacionNomiDataAccess();

			evaluacionnomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			evaluacionnomiDataAccess.setConnexionType(this.connexionType);
			evaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);

			evaluacionnomi=evaluacionnomiDataAccess.getEntity(connexion,reldetalleevaluacionnomi.getid_evaluacion_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionnomi;

	}

	public FormatoNomi getFormatoNomi(Connexion connexion,DetalleEvaluacionNomi reldetalleevaluacionnomi)throws SQLException,Exception {

		FormatoNomi formatonomi= new FormatoNomi();

		try {
			FormatoNomiDataAccess formatonomiDataAccess=new FormatoNomiDataAccess();

			formatonomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomiDataAccess.setConnexionType(this.connexionType);
			formatonomiDataAccess.setParameterDbType(this.parameterDbType);

			formatonomi=formatonomiDataAccess.getEntity(connexion,reldetalleevaluacionnomi.getid_formato_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomi;

	}

	public PreguntaNomi getPreguntaNomi(Connexion connexion,DetalleEvaluacionNomi reldetalleevaluacionnomi)throws SQLException,Exception {

		PreguntaNomi preguntanomi= new PreguntaNomi();

		try {
			PreguntaNomiDataAccess preguntanomiDataAccess=new PreguntaNomiDataAccess();

			preguntanomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			preguntanomiDataAccess.setConnexionType(this.connexionType);
			preguntanomiDataAccess.setParameterDbType(this.parameterDbType);

			preguntanomi=preguntanomiDataAccess.getEntity(connexion,reldetalleevaluacionnomi.getid_pregunta_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return preguntanomi;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleevaluacionnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleevaluacionnomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_evaluacion_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_evaluacion_nomi.setValue(detalleevaluacionnomi.getid_evaluacion_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_evaluacion_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nomi.setValue(detalleevaluacionnomi.getid_formato_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pregunta_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_pregunta_nomi.setValue(detalleevaluacionnomi.getid_pregunta_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pregunta_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerespuesta=new ParameterValue<String>();
					parameterMaintenanceValuerespuesta.setValue(detalleevaluacionnomi.getrespuesta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerespuesta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuerespuesta_valor=new ParameterValue<Double>();
					parameterMaintenanceValuerespuesta_valor.setValue(detalleevaluacionnomi.getrespuesta_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerespuesta_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica1=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica1.setValue(detalleevaluacionnomi.getcalifica1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica2=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica2.setValue(detalleevaluacionnomi.getcalifica2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica3=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica3.setValue(detalleevaluacionnomi.getcalifica3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica4=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica4.setValue(detalleevaluacionnomi.getcalifica4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica5=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica5.setValue(detalleevaluacionnomi.getcalifica5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica6=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica6.setValue(detalleevaluacionnomi.getcalifica6());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica6);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica7=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica7.setValue(detalleevaluacionnomi.getcalifica7());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica7);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica8=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica8.setValue(detalleevaluacionnomi.getcalifica8());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica8);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica9=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica9.setValue(detalleevaluacionnomi.getcalifica9());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica9);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecalifica10=new ParameterValue<Boolean>();
					parameterMaintenanceValuecalifica10.setValue(detalleevaluacionnomi.getcalifica10());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalifica10);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleevaluacionnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleevaluacionnomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleevaluacionnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleevaluacionnomi.getId());
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
	
	public void setIsNewIsChangedFalseDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomi)throws Exception  {		
		detalleevaluacionnomi.setIsNew(false);
		detalleevaluacionnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis)throws Exception  {				
		for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis) {
			detalleevaluacionnomi.setIsNew(false);
			detalleevaluacionnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleEvaluacionNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
