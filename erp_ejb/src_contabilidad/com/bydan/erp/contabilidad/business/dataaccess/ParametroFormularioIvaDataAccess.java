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
import com.bydan.erp.contabilidad.util.*;//ParametroFormularioIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ParametroFormularioIvaDataAccess extends  ParametroFormularioIvaDataAccessAdditional{ //ParametroFormularioIvaDataAccessAdditional,DataAccessHelper<ParametroFormularioIva>
	//static Logger logger = Logger.getLogger(ParametroFormularioIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_formulario_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_parametro_formulario_iva,id_grupo_parametro_formulario_iva,id_sub_grupo_parametro_formulario_iva,grupo,grupo2,codigo_sri,nombre,porcentaje,con_total,id_cuenta_contable1,id_cuenta_contable2,id_cuenta_contable3,id_cuenta_contable4,id_cuenta_contable5)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_parametro_formulario_iva=?,id_grupo_parametro_formulario_iva=?,id_sub_grupo_parametro_formulario_iva=?,grupo=?,grupo2=?,codigo_sri=?,nombre=?,porcentaje=?,con_total=?,id_cuenta_contable1=?,id_cuenta_contable2=?,id_cuenta_contable3=?,id_cuenta_contable4=?,id_cuenta_contable5=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroformularioiva from "+ParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" parametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_tipo_parametro_formulario_iva,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_grupo_parametro_formulario_iva,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_sub_grupo_parametro_formulario_iva,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".grupo,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".grupo2,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".codigo_sri,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".porcentaje,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".con_total,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable1,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable2,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable3,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable4,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id_cuenta_contable5 from "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+ParametroFormularioIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+".codigo_sri from "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+ParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFormularioIvaConstantesFunciones.SCHEMA+"."+ParametroFormularioIvaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_parametro_formulario_iva=?,id_grupo_parametro_formulario_iva=?,id_sub_grupo_parametro_formulario_iva=?,grupo=?,grupo2=?,codigo_sri=?,nombre=?,porcentaje=?,con_total=?,id_cuenta_contable1=?,id_cuenta_contable2=?,id_cuenta_contable3=?,id_cuenta_contable4=?,id_cuenta_contable5=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFORMULARIOIVA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFORMULARIOIVA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFORMULARIOIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFORMULARIOIVA_SELECT(?,?)";
	
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
	
	
	protected ParametroFormularioIvaDataAccessAdditional parametroformularioivaDataAccessAdditional=null;
	
	public ParametroFormularioIvaDataAccessAdditional getParametroFormularioIvaDataAccessAdditional() {
		return this.parametroformularioivaDataAccessAdditional;
	}
	
	public void setParametroFormularioIvaDataAccessAdditional(ParametroFormularioIvaDataAccessAdditional parametroformularioivaDataAccessAdditional) {
		try {
			this.parametroformularioivaDataAccessAdditional=parametroformularioivaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFormularioIvaDataAccess() {
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
		ParametroFormularioIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFormularioIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFormularioIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFormularioIvaOriginal(ParametroFormularioIva parametroformularioiva)throws Exception  {
		parametroformularioiva.setParametroFormularioIvaOriginal((ParametroFormularioIva)parametroformularioiva.clone());		
	}
	
	public void setParametroFormularioIvasOriginal(List<ParametroFormularioIva> parametroformularioivas)throws Exception  {
		
		for(ParametroFormularioIva parametroformularioiva:parametroformularioivas){
			parametroformularioiva.setParametroFormularioIvaOriginal((ParametroFormularioIva)parametroformularioiva.clone());
		}
	}
	
	public static void setParametroFormularioIvaOriginalStatic(ParametroFormularioIva parametroformularioiva)throws Exception  {
		parametroformularioiva.setParametroFormularioIvaOriginal((ParametroFormularioIva)parametroformularioiva.clone());		
	}
	
	public static void setParametroFormularioIvasOriginalStatic(List<ParametroFormularioIva> parametroformularioivas)throws Exception  {
		
		for(ParametroFormularioIva parametroformularioiva:parametroformularioivas){
			parametroformularioiva.setParametroFormularioIvaOriginal((ParametroFormularioIva)parametroformularioiva.clone());
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
	
	public  ParametroFormularioIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFormularioIva entity = new ParametroFormularioIva();		
		
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
	
	public  ParametroFormularioIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFormularioIva entity = new ParametroFormularioIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ParametroFormularioIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFormularioIvaOriginal(new ParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFormularioIva("",entity,resultSet); 
				
				//entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFormularioIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFormularioIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFormularioIva entity = new ParametroFormularioIva();
				
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
	
	public  ParametroFormularioIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFormularioIva entity = new ParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroFormularioIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFormularioIvaOriginal(new ParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFormularioIva("",entity,resultSet);    
				
				//entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFormularioIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFormularioIva entity = new ParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroFormularioIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFormularioIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		
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
	
	public  List<ParametroFormularioIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setParametroFormularioIvaOriginal( new ParametroFormularioIva());
      	    	//entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
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
	
	public  List<ParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFormularioIva();
					//entity.setMapParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFormularioIvaDataAccess.getEntityParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFormularioIvaOriginal( new ParametroFormularioIva());
					////entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFormularioIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFormularioIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
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
	
	public  ParametroFormularioIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFormularioIva();
					//entity.setMapParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFormularioIvaDataAccess.getEntityParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFormularioIvaOriginal( new ParametroFormularioIva());
					////entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFormularioIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFormularioIva getEntityParametroFormularioIva(String strPrefijo,ParametroFormularioIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFormularioIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFormularioIvaDataAccess.setFieldReflectionParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFormularioIva=ParametroFormularioIvaConstantesFunciones.getTodosTiposColumnasParametroFormularioIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFormularioIva) {
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
							field = ParametroFormularioIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFormularioIvaDataAccess.setFieldReflectionParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFormularioIva(Field field,String strPrefijo,String sColumn,ParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFormularioIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.GRUPO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.GRUPO2:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.CODIGOSRI:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.CONTOTAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFormularioIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFormularioIva();
					entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFormularioIva("",entity,resultSet);
					
					//entity.setParametroFormularioIvaOriginal( new ParametroFormularioIva());
					//entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFormularioIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
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
	
	public  List<ParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setParametroFormularioIvaOriginal( new ParametroFormularioIva());
      	    	//entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFormularioIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFormularioIva> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
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
	
	public  List<ParametroFormularioIva> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFormularioIva> entities = new  ArrayList<ParametroFormularioIva>();
		ParametroFormularioIva entity = new ParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setParametroFormularioIvaOriginal( new ParametroFormularioIva());
      	    	//entity.setParametroFormularioIvaOriginal(super.getEntity("",entity.getParametroFormularioIvaOriginal(),resultSet,ParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFormularioIvaOriginal(this.getEntityParametroFormularioIva("",entity.getParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFormularioIvas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFormularioIva getEntityParametroFormularioIva(String strPrefijo,ParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_parametro_formulario_iva(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA));
				entity.setid_grupo_parametro_formulario_iva(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA));
				entity.setid_sub_grupo_parametro_formulario_iva(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA));
				entity.setgrupo(resultSet.getInt(strPrefijo+ParametroFormularioIvaConstantesFunciones.GRUPO));
				entity.setgrupo2(resultSet.getInt(strPrefijo+ParametroFormularioIvaConstantesFunciones.GRUPO2));
				entity.setcodigo_sri(resultSet.getString(strPrefijo+ParametroFormularioIvaConstantesFunciones.CODIGOSRI));
				entity.setnombre(resultSet.getString(strPrefijo+ParametroFormularioIvaConstantesFunciones.NOMBRE));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ParametroFormularioIvaConstantesFunciones.PORCENTAJE));
				entity.setcon_total(resultSet.getBoolean(strPrefijo+ParametroFormularioIvaConstantesFunciones.CONTOTAL));
				entity.setid_cuenta_contable1(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1));if(resultSet.wasNull()) {entity.setid_cuenta_contable1(null); }
				entity.setid_cuenta_contable2(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2));if(resultSet.wasNull()) {entity.setid_cuenta_contable2(null); }
				entity.setid_cuenta_contable3(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3));if(resultSet.wasNull()) {entity.setid_cuenta_contable3(null); }
				entity.setid_cuenta_contable4(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4));if(resultSet.wasNull()) {entity.setid_cuenta_contable4(null); }
				entity.setid_cuenta_contable5(resultSet.getLong(strPrefijo+ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5));if(resultSet.wasNull()) {entity.setid_cuenta_contable5(null); }
			} else {
				entity.setcodigo_sri(resultSet.getString(strPrefijo+ParametroFormularioIvaConstantesFunciones.CODIGOSRI));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFormularioIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFormularioIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFormularioIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFormularioIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFormularioIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFormularioIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFormularioIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFormularioIvaDataAccess.TABLENAME,ParametroFormularioIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFormularioIvaDataAccess.setParametroFormularioIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroformularioiva.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoParametroFormularioIva getTipoParametroFormularioIva(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		TipoParametroFormularioIva tipoparametroformularioiva= new TipoParametroFormularioIva();

		try {
			TipoParametroFormularioIvaDataAccess tipoparametroformularioivaDataAccess=new TipoParametroFormularioIvaDataAccess();

			tipoparametroformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			tipoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion,relparametroformularioiva.getid_tipo_parametro_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoparametroformularioiva;

	}

	public GrupoParametroFormularioIva getGrupoParametroFormularioIva(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		GrupoParametroFormularioIva grupoparametroformularioiva= new GrupoParametroFormularioIva();

		try {
			GrupoParametroFormularioIvaDataAccess grupoparametroformularioivaDataAccess=new GrupoParametroFormularioIvaDataAccess();

			grupoparametroformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			grupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion,relparametroformularioiva.getid_grupo_parametro_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoparametroformularioiva;

	}

	public SubGrupoParametroFormularioIva getSubGrupoParametroFormularioIva(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		SubGrupoParametroFormularioIva subgrupoparametroformularioiva= new SubGrupoParametroFormularioIva();

		try {
			SubGrupoParametroFormularioIvaDataAccess subgrupoparametroformularioivaDataAccess=new SubGrupoParametroFormularioIvaDataAccess();

			subgrupoparametroformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subgrupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			subgrupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			subgrupoparametroformularioiva=subgrupoparametroformularioivaDataAccess.getEntity(connexion,relparametroformularioiva.getid_sub_grupo_parametro_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subgrupoparametroformularioiva;

	}

	public CuentaContable getCuentaContable1(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroformularioiva.getid_cuenta_contable1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContable2(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroformularioiva.getid_cuenta_contable2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContable3(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroformularioiva.getid_cuenta_contable3());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContable4(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroformularioiva.getid_cuenta_contable4());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContable5(Connexion connexion,ParametroFormularioIva relparametroformularioiva)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametroformularioiva.getid_cuenta_contable5());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<FormularioRenta> getFormularioRentas(Connexion connexion,ParametroFormularioIva parametroformularioiva)throws SQLException,Exception {

		List<FormularioRenta> formulariorentas= new ArrayList<FormularioRenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva ON "+FormularioRentaConstantesFunciones.SCHEMA+".formulario_renta.id_parametro_formulario_iva="+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id WHERE "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id="+String.valueOf(parametroformularioiva.getId());
			} else {
				sQuery=" INNER JOIN formulariorenta.ParametroFormularioIva WHERE formulariorenta.ParametroFormularioIva.id="+String.valueOf(parametroformularioiva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioRentaDataAccess formulariorentaDataAccess=new FormularioRentaDataAccess();

			formulariorentaDataAccess.setConnexionType(this.connexionType);
			formulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formulariorentas;

	}

	public List<FormularioIva> getFormularioIvas(Connexion connexion,ParametroFormularioIva parametroformularioiva)throws SQLException,Exception {

		List<FormularioIva> formularioivas= new ArrayList<FormularioIva>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva ON "+FormularioIvaConstantesFunciones.SCHEMA+".formulario_iva.id_parametro_formulario_iva="+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id WHERE "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id="+String.valueOf(parametroformularioiva.getId());
			} else {
				sQuery=" INNER JOIN formularioiva.ParametroFormularioIva WHERE formularioiva.ParametroFormularioIva.id="+String.valueOf(parametroformularioiva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioIvaDataAccess formularioivaDataAccess=new FormularioIvaDataAccess();

			formularioivaDataAccess.setConnexionType(this.connexionType);
			formularioivaDataAccess.setParameterDbType(this.parameterDbType);
			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formularioivas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFormularioIva parametroformularioiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroformularioiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroformularioiva.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_parametro_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_parametro_formulario_iva.setValue(parametroformularioiva.getid_tipo_parametro_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_parametro_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_parametro_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_parametro_formulario_iva.setValue(parametroformularioiva.getid_grupo_parametro_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_parametro_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_grupo_parametro_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_grupo_parametro_formulario_iva.setValue(parametroformularioiva.getid_sub_grupo_parametro_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_grupo_parametro_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuegrupo=new ParameterValue<Integer>();
					parameterMaintenanceValuegrupo.setValue(parametroformularioiva.getgrupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegrupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuegrupo2=new ParameterValue<Integer>();
					parameterMaintenanceValuegrupo2.setValue(parametroformularioiva.getgrupo2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegrupo2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_sri=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_sri.setValue(parametroformularioiva.getcodigo_sri());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_sri);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(parametroformularioiva.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(parametroformularioiva.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_total=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_total.setValue(parametroformularioiva.getcon_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable1=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable1.setValue(parametroformularioiva.getid_cuenta_contable1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable2.setValue(parametroformularioiva.getid_cuenta_contable2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable3=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable3.setValue(parametroformularioiva.getid_cuenta_contable3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable4=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable4.setValue(parametroformularioiva.getid_cuenta_contable4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable5=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable5.setValue(parametroformularioiva.getid_cuenta_contable5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable5);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroformularioiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroformularioiva.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroformularioiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroformularioiva.getId());
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
	
	public void setIsNewIsChangedFalseParametroFormularioIva(ParametroFormularioIva parametroformularioiva)throws Exception  {		
		parametroformularioiva.setIsNew(false);
		parametroformularioiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFormularioIvas(List<ParametroFormularioIva> parametroformularioivas)throws Exception  {				
		for(ParametroFormularioIva parametroformularioiva:parametroformularioivas) {
			parametroformularioiva.setIsNew(false);
			parametroformularioiva.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFormularioIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
