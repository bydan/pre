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
import com.bydan.erp.cartera.util.*;//ParametroCarteraDefectoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ParametroCarteraDefectoDataAccess extends  ParametroCarteraDefectoDataAccessAdditional{ //ParametroCarteraDefectoDataAccessAdditional,DataAccessHelper<ParametroCarteraDefecto>
	//static Logger logger = Logger.getLogger(ParametroCarteraDefectoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_cartera_defecto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_pais,id_region,id_provincia,id_ciudad,id_zona,id_tipo_identificacion,id_tipo_nivel_edu,id_pais_nacionalidad,id_tipo_genero,id_estado_civil,id_estado_legal,id_cuenta_contable,id_vendedor,id_ruta,id_dia,id_tipo_precio,id_tipo_lista_precio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pais=?,id_region=?,id_provincia=?,id_ciudad=?,id_zona=?,id_tipo_identificacion=?,id_tipo_nivel_edu=?,id_pais_nacionalidad=?,id_tipo_genero=?,id_estado_civil=?,id_estado_legal=?,id_cuenta_contable=?,id_vendedor=?,id_ruta=?,id_dia=?,id_tipo_precio=?,id_tipo_lista_precio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrocarteradefecto from "+ParametroCarteraDefectoConstantesFunciones.SPERSISTENCENAME+" parametrocarteradefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_pais,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_region,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_provincia,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_ciudad,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_zona,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_nivel_edu,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_pais_nacionalidad,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_genero,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_estado_civil,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_estado_legal,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_vendedor,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_ruta,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_dia,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_precio,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id_tipo_lista_precio from "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroCarteraDefectoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".id,"+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+".version_row from "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroCarteraDefectoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+"."+ParametroCarteraDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pais=?,id_region=?,id_provincia=?,id_ciudad=?,id_zona=?,id_tipo_identificacion=?,id_tipo_nivel_edu=?,id_pais_nacionalidad=?,id_tipo_genero=?,id_estado_civil=?,id_estado_legal=?,id_cuenta_contable=?,id_vendedor=?,id_ruta=?,id_dia=?,id_tipo_precio=?,id_tipo_lista_precio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROCARTERADEFECTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROCARTERADEFECTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROCARTERADEFECTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROCARTERADEFECTO_SELECT(?,?)";
	
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
	
	
	protected ParametroCarteraDefectoDataAccessAdditional parametrocarteradefectoDataAccessAdditional=null;
	
	public ParametroCarteraDefectoDataAccessAdditional getParametroCarteraDefectoDataAccessAdditional() {
		return this.parametrocarteradefectoDataAccessAdditional;
	}
	
	public void setParametroCarteraDefectoDataAccessAdditional(ParametroCarteraDefectoDataAccessAdditional parametrocarteradefectoDataAccessAdditional) {
		try {
			this.parametrocarteradefectoDataAccessAdditional=parametrocarteradefectoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroCarteraDefectoDataAccess() {
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
		ParametroCarteraDefectoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroCarteraDefectoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroCarteraDefectoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroCarteraDefectoOriginal(ParametroCarteraDefecto parametrocarteradefecto)throws Exception  {
		parametrocarteradefecto.setParametroCarteraDefectoOriginal((ParametroCarteraDefecto)parametrocarteradefecto.clone());		
	}
	
	public void setParametroCarteraDefectosOriginal(List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception  {
		
		for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos){
			parametrocarteradefecto.setParametroCarteraDefectoOriginal((ParametroCarteraDefecto)parametrocarteradefecto.clone());
		}
	}
	
	public static void setParametroCarteraDefectoOriginalStatic(ParametroCarteraDefecto parametrocarteradefecto)throws Exception  {
		parametrocarteradefecto.setParametroCarteraDefectoOriginal((ParametroCarteraDefecto)parametrocarteradefecto.clone());		
	}
	
	public static void setParametroCarteraDefectosOriginalStatic(List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception  {
		
		for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos){
			parametrocarteradefecto.setParametroCarteraDefectoOriginal((ParametroCarteraDefecto)parametrocarteradefecto.clone());
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
	
	public  ParametroCarteraDefecto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		
		
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
	
	public  ParametroCarteraDefecto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ParametroCarteraDefecto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroCarteraDefectoOriginal(new ParametroCarteraDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroCarteraDefecto("",entity,resultSet); 
				
				//entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroCarteraDefecto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroCarteraDefecto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();
				
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
	
	public  ParametroCarteraDefecto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ParametroCarteraDefecto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroCarteraDefectoOriginal(new ParametroCarteraDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroCarteraDefecto("",entity,resultSet);    
				
				//entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroCarteraDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroCarteraDefecto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ParametroCarteraDefecto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroCarteraDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroCarteraDefecto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		
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
	
	public  List<ParametroCarteraDefecto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCarteraDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCarteraDefecto("",entity,resultSet);
      	    	
				//entity.setParametroCarteraDefectoOriginal( new ParametroCarteraDefecto());
      	    	//entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCarteraDefectos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCarteraDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroCarteraDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
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
	
	public  List<ParametroCarteraDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCarteraDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroCarteraDefecto();
					//entity.setMapParametroCarteraDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroCarteraDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroCarteraDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroCarteraDefectoDataAccess.getEntityParametroCarteraDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroCarteraDefectoOriginal( new ParametroCarteraDefecto());
					////entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCarteraDefectos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCarteraDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroCarteraDefecto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
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
	
	public  ParametroCarteraDefecto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCarteraDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroCarteraDefecto();
					//entity.setMapParametroCarteraDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroCarteraDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroCarteraDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroCarteraDefectoDataAccess.getEntityParametroCarteraDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroCarteraDefectoOriginal( new ParametroCarteraDefecto());
					////entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroCarteraDefecto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCarteraDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroCarteraDefecto getEntityParametroCarteraDefecto(String strPrefijo,ParametroCarteraDefecto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroCarteraDefecto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroCarteraDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroCarteraDefectoDataAccess.setFieldReflectionParametroCarteraDefecto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroCarteraDefecto=ParametroCarteraDefectoConstantesFunciones.getTodosTiposColumnasParametroCarteraDefecto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroCarteraDefecto) {
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
							field = ParametroCarteraDefecto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroCarteraDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroCarteraDefectoDataAccess.setFieldReflectionParametroCarteraDefecto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroCarteraDefecto(Field field,String strPrefijo,String sColumn,ParametroCarteraDefecto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroCarteraDefectoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDREGION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDRUTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDDIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroCarteraDefecto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroCarteraDefecto();
					entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroCarteraDefecto("",entity,resultSet);
					
					//entity.setParametroCarteraDefectoOriginal( new ParametroCarteraDefecto());
					//entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroCarteraDefectos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCarteraDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroCarteraDefecto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCarteraDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroCarteraDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
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
	
	public  List<ParametroCarteraDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCarteraDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCarteraDefecto("",entity,resultSet);
      	    	
				//entity.setParametroCarteraDefectoOriginal( new ParametroCarteraDefecto());
      	    	//entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroCarteraDefectos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCarteraDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroCarteraDefecto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
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
	
	public  List<ParametroCarteraDefecto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCarteraDefecto> entities = new  ArrayList<ParametroCarteraDefecto>();
		ParametroCarteraDefecto entity = new ParametroCarteraDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCarteraDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCarteraDefecto("",entity,resultSet);
      	    	
				//entity.setParametroCarteraDefectoOriginal( new ParametroCarteraDefecto());
      	    	//entity.setParametroCarteraDefectoOriginal(super.getEntity("",entity.getParametroCarteraDefectoOriginal(),resultSet,ParametroCarteraDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraDefectoOriginal(this.getEntityParametroCarteraDefecto("",entity.getParametroCarteraDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCarteraDefectos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroCarteraDefecto getEntityParametroCarteraDefecto(String strPrefijo,ParametroCarteraDefecto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL));
				entity.setid_pais(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDPAIS));
				entity.setid_region(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDREGION));
				entity.setid_provincia(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDZONA));
				entity.setid_tipo_identificacion(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION));
				entity.setid_tipo_nivel_edu(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU));
				entity.setid_pais_nacionalidad(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD));
				entity.setid_tipo_genero(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO));
				entity.setid_estado_civil(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL));
				entity.setid_estado_legal(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR));
				entity.setid_ruta(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDRUTA));
				entity.setid_dia(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDDIA));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO));
				entity.setid_tipo_lista_precio(resultSet.getLong(strPrefijo+ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroCarteraDefecto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroCarteraDefecto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroCarteraDefectoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroCarteraDefectoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroCarteraDefectoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroCarteraDefectoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroCarteraDefectoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroCarteraDefectoDataAccess.TABLENAME,ParametroCarteraDefectoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroCarteraDefectoDataAccess.setParametroCarteraDefectoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Pais getPais(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Region getRegion(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Region region= new Region();

		try {
			RegionDataAccess regionDataAccess=new RegionDataAccess();

			regionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			regionDataAccess.setConnexionType(this.connexionType);
			regionDataAccess.setParameterDbType(this.parameterDbType);

			region=regionDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_region());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return region;

	}

	public Provincia getProvincia(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);

			provincia=provinciaDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public TipoIdentificacion getTipoIdentificacion(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		TipoIdentificacion tipoidentificacion= new TipoIdentificacion();

		try {
			TipoIdentificacionDataAccess tipoidentificacionDataAccess=new TipoIdentificacionDataAccess();

			tipoidentificacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_tipo_identificacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoidentificacion;

	}

	public TipoNivelEdu getTipoNivelEdu(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		TipoNivelEdu tiponiveledu= new TipoNivelEdu();

		try {
			TipoNivelEduDataAccess tiponiveleduDataAccess=new TipoNivelEduDataAccess();

			tiponiveleduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiponiveleduDataAccess.setConnexionType(this.connexionType);
			tiponiveleduDataAccess.setParameterDbType(this.parameterDbType);

			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_tipo_nivel_edu());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiponiveledu;

	}

	public Pais getPaisNacionalidad(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_pais_nacionalidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public TipoGenero getTipoGenero(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		TipoGenero tipogenero= new TipoGenero();

		try {
			TipoGeneroDataAccess tipogeneroDataAccess=new TipoGeneroDataAccess();

			tipogeneroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogeneroDataAccess.setConnexionType(this.connexionType);
			tipogeneroDataAccess.setParameterDbType(this.parameterDbType);

			tipogenero=tipogeneroDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_tipo_genero());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogenero;

	}

	public EstadoCivil getEstadoCivil(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		EstadoCivil estadocivil= new EstadoCivil();

		try {
			EstadoCivilDataAccess estadocivilDataAccess=new EstadoCivilDataAccess();

			estadocivilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocivilDataAccess.setConnexionType(this.connexionType);
			estadocivilDataAccess.setParameterDbType(this.parameterDbType);

			estadocivil=estadocivilDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_estado_civil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocivil;

	}

	public EstadoLegal getEstadoLegal(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		EstadoLegal estadolegal= new EstadoLegal();

		try {
			EstadoLegalDataAccess estadolegalDataAccess=new EstadoLegalDataAccess();

			estadolegalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadolegalDataAccess.setConnexionType(this.connexionType);
			estadolegalDataAccess.setParameterDbType(this.parameterDbType);

			estadolegal=estadolegalDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_estado_legal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadolegal;

	}

	public CuentaContable getCuentaContable(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Vendedor getVendedor(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Ruta getRuta(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Ruta ruta= new Ruta();

		try {
			RutaDataAccess rutaDataAccess=new RutaDataAccess();

			rutaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rutaDataAccess.setConnexionType(this.connexionType);
			rutaDataAccess.setParameterDbType(this.parameterDbType);

			ruta=rutaDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_ruta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ruta;

	}

	public Dia getDia(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		Dia dia= new Dia();

		try {
			DiaDataAccess diaDataAccess=new DiaDataAccess();

			diaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			diaDataAccess.setConnexionType(this.connexionType);
			diaDataAccess.setParameterDbType(this.parameterDbType);

			dia=diaDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_dia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return dia;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public TipoListaPrecio getTipoListaPrecio(Connexion connexion,ParametroCarteraDefecto relparametrocarteradefecto)throws SQLException,Exception {

		TipoListaPrecio tipolistaprecio= new TipoListaPrecio();

		try {
			TipoListaPrecioDataAccess tipolistaprecioDataAccess=new TipoListaPrecioDataAccess();

			tipolistaprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipolistaprecioDataAccess.setConnexionType(this.connexionType);
			tipolistaprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion,relparametrocarteradefecto.getid_tipo_lista_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipolistaprecio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroCarteraDefecto parametrocarteradefecto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrocarteradefecto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrocarteradefecto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrocarteradefecto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(parametrocarteradefecto.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_region=new ParameterValue<Long>();
					parameterMaintenanceValueid_region.setValue(parametrocarteradefecto.getid_region());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_region);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_provincia=new ParameterValue<Long>();
					parameterMaintenanceValueid_provincia.setValue(parametrocarteradefecto.getid_provincia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_provincia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(parametrocarteradefecto.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(parametrocarteradefecto.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_identificacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_identificacion.setValue(parametrocarteradefecto.getid_tipo_identificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_identificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_nivel_edu=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_nivel_edu.setValue(parametrocarteradefecto.getid_tipo_nivel_edu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_nivel_edu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais_nacionalidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais_nacionalidad.setValue(parametrocarteradefecto.getid_pais_nacionalidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais_nacionalidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_genero=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_genero.setValue(parametrocarteradefecto.getid_tipo_genero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_genero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_civil=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_civil.setValue(parametrocarteradefecto.getid_estado_civil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_civil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_legal=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_legal.setValue(parametrocarteradefecto.getid_estado_legal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_legal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(parametrocarteradefecto.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(parametrocarteradefecto.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ruta=new ParameterValue<Long>();
					parameterMaintenanceValueid_ruta.setValue(parametrocarteradefecto.getid_ruta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ruta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dia=new ParameterValue<Long>();
					parameterMaintenanceValueid_dia.setValue(parametrocarteradefecto.getid_dia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(parametrocarteradefecto.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_lista_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_lista_precio.setValue(parametrocarteradefecto.getid_tipo_lista_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_lista_precio);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrocarteradefecto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrocarteradefecto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrocarteradefecto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrocarteradefecto.getId());
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
	
	public void setIsNewIsChangedFalseParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefecto)throws Exception  {		
		parametrocarteradefecto.setIsNew(false);
		parametrocarteradefecto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception  {				
		for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos) {
			parametrocarteradefecto.setIsNew(false);
			parametrocarteradefecto.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroCarteraDefecto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
