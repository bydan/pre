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
import com.bydan.erp.seguridad.util.*;//ParametroGeneralUsuarioConstantesFunciones;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class ParametroGeneralUsuarioDataAccess extends  ParametroGeneralUsuarioDataAccessAdditional{ //ParametroGeneralUsuarioDataAccessAdditional,DataAccessHelper<ParametroGeneralUsuario>
	//static Logger logger = Logger.getLogger(ParametroGeneralUsuarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_general_usuario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+"(id,version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_moneda,fecha_sistema,id_anio,id_mes,dia,id_tipo_visual,id_tipo_fondo,id_tipo_fondo_borde,id_tipo_fondo_control,id_tipo_fuente,id_tipo_tamanio_control_normal,id_tipo_tamanio_control_relacion,con_tamanio_control_manual,con_tamanio_control_todo_relacion,con_guardar_relaciones,con_mensaje_confirmacion,con_botones_tool_bar,con_mostrar_acciones_campo_general,con_mostrar_acciones_campo_relaciones,id_tipo_exportar,id_tipo_delimiter,con_exportar_cabecera,con_exportar_campo_version,path_exportar,con_precargar_ventanas,con_precargar_por_usuario,con_cargar_por_parte)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_moneda=?,fecha_sistema=?,id_anio=?,id_mes=?,dia=?,id_tipo_visual=?,id_tipo_fondo=?,id_tipo_fondo_borde=?,id_tipo_fondo_control=?,id_tipo_fuente=?,id_tipo_tamanio_control_normal=?,id_tipo_tamanio_control_relacion=?,con_tamanio_control_manual=?,con_tamanio_control_todo_relacion=?,con_guardar_relaciones=?,con_mensaje_confirmacion=?,con_botones_tool_bar=?,con_mostrar_acciones_campo_general=?,con_mostrar_acciones_campo_relaciones=?,id_tipo_exportar=?,id_tipo_delimiter=?,con_exportar_cabecera=?,con_exportar_campo_version=?,path_exportar=?,con_precargar_ventanas=?,con_precargar_por_usuario=?,con_cargar_por_parte=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrogeneralusuario from "+ParametroGeneralUsuarioConstantesFunciones.SPERSISTENCENAME+" parametrogeneralusuario";
	public static String QUERYSELECTNATIVE="select "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".version_row,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_ejercicio,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_periodo,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_moneda,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".fecha_sistema,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_anio,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_mes,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".dia,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_visual,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fondo,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fondo_borde,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fondo_control,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_fuente,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_tamanio_control_normal,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_tamanio_control_relacion,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_tamanio_control_manual,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_tamanio_control_todo_relacion,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_guardar_relaciones,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_mensaje_confirmacion,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_botones_tool_bar,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_mostrar_acciones_campo_general,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_mostrar_acciones_campo_relaciones,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_exportar,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id_tipo_delimiter,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_exportar_cabecera,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_exportar_campo_version,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".path_exportar,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_precargar_ventanas,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_precargar_por_usuario,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".con_cargar_por_parte from "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralUsuarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".id,"+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+".version_row from "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralUsuarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+"."+ParametroGeneralUsuarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_moneda=?,fecha_sistema=?,id_anio=?,id_mes=?,dia=?,id_tipo_visual=?,id_tipo_fondo=?,id_tipo_fondo_borde=?,id_tipo_fondo_control=?,id_tipo_fuente=?,id_tipo_tamanio_control_normal=?,id_tipo_tamanio_control_relacion=?,con_tamanio_control_manual=?,con_tamanio_control_todo_relacion=?,con_guardar_relaciones=?,con_mensaje_confirmacion=?,con_botones_tool_bar=?,con_mostrar_acciones_campo_general=?,con_mostrar_acciones_campo_relaciones=?,id_tipo_exportar=?,id_tipo_delimiter=?,con_exportar_cabecera=?,con_exportar_campo_version=?,path_exportar=?,con_precargar_ventanas=?,con_precargar_por_usuario=?,con_cargar_por_parte=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROGENERALUSUARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROGENERALUSUARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROGENERALUSUARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROGENERALUSUARIO_SELECT(?,?)";
	
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
	
	
	protected ParametroGeneralUsuarioDataAccessAdditional parametrogeneralusuarioDataAccessAdditional=null;
	
	public ParametroGeneralUsuarioDataAccessAdditional getParametroGeneralUsuarioDataAccessAdditional() {
		return this.parametrogeneralusuarioDataAccessAdditional;
	}
	
	public void setParametroGeneralUsuarioDataAccessAdditional(ParametroGeneralUsuarioDataAccessAdditional parametrogeneralusuarioDataAccessAdditional) {
		try {
			this.parametrogeneralusuarioDataAccessAdditional=parametrogeneralusuarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroGeneralUsuarioDataAccess() {
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
		ParametroGeneralUsuarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroGeneralUsuarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroGeneralUsuarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroGeneralUsuarioOriginal(ParametroGeneralUsuario parametrogeneralusuario)throws Exception  {
		parametrogeneralusuario.setParametroGeneralUsuarioOriginal((ParametroGeneralUsuario)parametrogeneralusuario.clone());		
	}
	
	public void setParametroGeneralUsuariosOriginal(List<ParametroGeneralUsuario> parametrogeneralusuarios)throws Exception  {
		
		for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios){
			parametrogeneralusuario.setParametroGeneralUsuarioOriginal((ParametroGeneralUsuario)parametrogeneralusuario.clone());
		}
	}
	
	public static void setParametroGeneralUsuarioOriginalStatic(ParametroGeneralUsuario parametrogeneralusuario)throws Exception  {
		parametrogeneralusuario.setParametroGeneralUsuarioOriginal((ParametroGeneralUsuario)parametrogeneralusuario.clone());		
	}
	
	public static void setParametroGeneralUsuariosOriginalStatic(List<ParametroGeneralUsuario> parametrogeneralusuarios)throws Exception  {
		
		for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios){
			parametrogeneralusuario.setParametroGeneralUsuarioOriginal((ParametroGeneralUsuario)parametrogeneralusuario.clone());
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
	
	public  ParametroGeneralUsuario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		
		
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
	
	public  ParametroGeneralUsuario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.ParametroGeneralUsuario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroGeneralUsuarioOriginal(new ParametroGeneralUsuario());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGeneralUsuario("",entity,resultSet); 
				
				//entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGeneralUsuario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroGeneralUsuario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();
				
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
	
	public  ParametroGeneralUsuario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ParametroGeneralUsuario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroGeneralUsuarioOriginal(new ParametroGeneralUsuario());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGeneralUsuario("",entity,resultSet);    
				
				//entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGeneralUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroGeneralUsuario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ParametroGeneralUsuario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroGeneralUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroGeneralUsuario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		
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
	
	public  List<ParametroGeneralUsuario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralUsuario();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGeneralUsuario("",entity,resultSet);
      	    	
				//entity.setParametroGeneralUsuarioOriginal( new ParametroGeneralUsuario());
      	    	//entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGeneralUsuarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGeneralUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
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
	
	public  List<ParametroGeneralUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGeneralUsuario();
					//entity.setMapParametroGeneralUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroGeneralUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGeneralUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGeneralUsuarioDataAccess.getEntityParametroGeneralUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGeneralUsuarioOriginal( new ParametroGeneralUsuario());
					////entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGeneralUsuarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroGeneralUsuario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
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
	
	public  ParametroGeneralUsuario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGeneralUsuario();
					//entity.setMapParametroGeneralUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroGeneralUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGeneralUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGeneralUsuarioDataAccess.getEntityParametroGeneralUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGeneralUsuarioOriginal( new ParametroGeneralUsuario());
					////entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroGeneralUsuario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroGeneralUsuario getEntityParametroGeneralUsuario(String strPrefijo,ParametroGeneralUsuario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroGeneralUsuario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroGeneralUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroGeneralUsuarioDataAccess.setFieldReflectionParametroGeneralUsuario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroGeneralUsuario=ParametroGeneralUsuarioConstantesFunciones.getTodosTiposColumnasParametroGeneralUsuario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroGeneralUsuario) {
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
							field = ParametroGeneralUsuario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroGeneralUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroGeneralUsuarioDataAccess.setFieldReflectionParametroGeneralUsuario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroGeneralUsuario(Field field,String strPrefijo,String sColumn,ParametroGeneralUsuario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroGeneralUsuarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.DIA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGeneralUsuario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroGeneralUsuario();
					entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroGeneralUsuario("",entity,resultSet);
					
					//entity.setParametroGeneralUsuarioOriginal( new ParametroGeneralUsuario());
					//entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroGeneralUsuarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGeneralUsuario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroGeneralUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
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
	
	public  List<ParametroGeneralUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralUsuario();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGeneralUsuario("",entity,resultSet);
      	    	
				//entity.setParametroGeneralUsuarioOriginal( new ParametroGeneralUsuario());
      	    	//entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroGeneralUsuarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGeneralUsuario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
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
	
	public  List<ParametroGeneralUsuario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralUsuario> entities = new  ArrayList<ParametroGeneralUsuario>();
		ParametroGeneralUsuario entity = new ParametroGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralUsuario();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGeneralUsuario("",entity,resultSet);
      	    	
				//entity.setParametroGeneralUsuarioOriginal( new ParametroGeneralUsuario());
      	    	//entity.setParametroGeneralUsuarioOriginal(super.getEntity("",entity.getParametroGeneralUsuarioOriginal(),resultSet,ParametroGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralUsuarioOriginal(this.getEntityParametroGeneralUsuario("",entity.getParametroGeneralUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGeneralUsuarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroGeneralUsuario getEntityParametroGeneralUsuario(String strPrefijo,ParametroGeneralUsuario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDPERIODO));
				entity.setid_moneda(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDMONEDA));
				entity.setfecha_sistema(new Date(resultSet.getDate(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.FECHASISTEMA).getTime()));
				entity.setid_anio(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setdia(resultSet.getInt(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.DIA));
				entity.setid_tipo_visual(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOVISUAL));
				entity.setid_tipo_fondo(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDO));
				entity.setid_tipo_fondo_borde(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOBORDE));
				entity.setid_tipo_fondo_control(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOFONDOCONTROL));
				entity.setid_tipo_fuente(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOFUENTE));
				entity.setid_tipo_tamanio_control_normal(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLNORMAL));
				entity.setid_tipo_tamanio_control_relacion(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOTAMANIOCONTROLRELACION));
				entity.setcon_tamanio_control_manual(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLMANUAL));
				entity.setcon_tamanio_control_todo_relacion(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONTAMANIOCONTROLTODORELACION));
				entity.setcon_guardar_relaciones(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONGUARDARRELACIONES));
				entity.setcon_mensaje_confirmacion(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONMENSAJECONFIRMACION));
				entity.setcon_botones_tool_bar(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONBOTONESTOOLBAR));
				entity.setcon_mostrar_acciones_campo_general(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPOGENERAL));
				entity.setcon_mostrar_acciones_campo_relaciones(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONMOSTRARACCIONESCAMPORELACIONES));
				entity.setid_tipo_exportar(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPOEXPORTAR));
				entity.setid_tipo_delimiter(resultSet.getLong(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.IDTIPODELIMITER));
				entity.setcon_exportar_cabecera(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCABECERA));
				entity.setcon_exportar_campo_version(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONEXPORTARCAMPOVERSION));
				entity.setpath_exportar(resultSet.getString(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.PATHEXPORTAR));
				entity.setcon_precargar_ventanas(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARVENTANAS));
				entity.setcon_precargar_por_usuario(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONPRECARGARPORUSUARIO));
				entity.setcon_cargar_por_parte(resultSet.getBoolean(strPrefijo+ParametroGeneralUsuarioConstantesFunciones.CONCARGARPORPARTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroGeneralUsuario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroGeneralUsuario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroGeneralUsuarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroGeneralUsuarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroGeneralUsuarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroGeneralUsuarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroGeneralUsuarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroGeneralUsuarioDataAccess.TABLENAME,ParametroGeneralUsuarioDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroGeneralUsuarioDataAccess.setParametroGeneralUsuarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Usuario getUsuario(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relparametrogeneralusuario.getId());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Empresa getEmpresa(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Moneda getMoneda(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Anio getAnio(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public TipoVisual getTipoVisual(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoVisual tipovisual= new TipoVisual();

		try {
			TipoVisualDataAccess tipovisualDataAccess=new TipoVisualDataAccess();

			tipovisualDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovisualDataAccess.setConnexionType(this.connexionType);
			tipovisualDataAccess.setParameterDbType(this.parameterDbType);

			tipovisual=tipovisualDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_visual());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovisual;

	}

	public TipoFondo getTipoFondo(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoFondo tipofondo= new TipoFondo();

		try {
			TipoFondoDataAccess tipofondoDataAccess=new TipoFondoDataAccess();

			tipofondoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofondoDataAccess.setConnexionType(this.connexionType);
			tipofondoDataAccess.setParameterDbType(this.parameterDbType);

			tipofondo=tipofondoDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_fondo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofondo;

	}

	public TipoFondo getTipoFondoBorde(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoFondo tipofondo= new TipoFondo();

		try {
			TipoFondoDataAccess tipofondoDataAccess=new TipoFondoDataAccess();

			tipofondoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofondoDataAccess.setConnexionType(this.connexionType);
			tipofondoDataAccess.setParameterDbType(this.parameterDbType);

			tipofondo=tipofondoDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_fondo_borde());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofondo;

	}

	public TipoFondoControl getTipoFondoControl(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoFondoControl tipofondocontrol= new TipoFondoControl();

		try {
			TipoFondoControlDataAccess tipofondocontrolDataAccess=new TipoFondoControlDataAccess();

			tipofondocontrolDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofondocontrolDataAccess.setConnexionType(this.connexionType);
			tipofondocontrolDataAccess.setParameterDbType(this.parameterDbType);

			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_fondo_control());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofondocontrol;

	}

	public TipoFuente getTipoFuente(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoFuente tipofuente= new TipoFuente();

		try {
			TipoFuenteDataAccess tipofuenteDataAccess=new TipoFuenteDataAccess();

			tipofuenteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofuenteDataAccess.setConnexionType(this.connexionType);
			tipofuenteDataAccess.setParameterDbType(this.parameterDbType);

			tipofuente=tipofuenteDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_fuente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofuente;

	}

	public TipoTamanioControl getTipoTamanioControlNormal(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoTamanioControl tipotamaniocontrol= new TipoTamanioControl();

		try {
			TipoTamanioControlDataAccess tipotamaniocontrolDataAccess=new TipoTamanioControlDataAccess();

			tipotamaniocontrolDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotamaniocontrolDataAccess.setConnexionType(this.connexionType);
			tipotamaniocontrolDataAccess.setParameterDbType(this.parameterDbType);

			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_tamanio_control_normal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotamaniocontrol;

	}

	public TipoTamanioControl getTipoTamanioControlRelacion(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoTamanioControl tipotamaniocontrol= new TipoTamanioControl();

		try {
			TipoTamanioControlDataAccess tipotamaniocontrolDataAccess=new TipoTamanioControlDataAccess();

			tipotamaniocontrolDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotamaniocontrolDataAccess.setConnexionType(this.connexionType);
			tipotamaniocontrolDataAccess.setParameterDbType(this.parameterDbType);

			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_tamanio_control_relacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotamaniocontrol;

	}

	public TipoExportar getTipoExportar(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoExportar tipoexportar= new TipoExportar();

		try {
			TipoExportarDataAccess tipoexportarDataAccess=new TipoExportarDataAccess();

			tipoexportarDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoexportarDataAccess.setConnexionType(this.connexionType);
			tipoexportarDataAccess.setParameterDbType(this.parameterDbType);

			tipoexportar=tipoexportarDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_exportar());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoexportar;

	}

	public TipoDelimiter getTipoDelimiter(Connexion connexion,ParametroGeneralUsuario relparametrogeneralusuario)throws SQLException,Exception {

		TipoDelimiter tipodelimiter= new TipoDelimiter();

		try {
			TipoDelimiterDataAccess tipodelimiterDataAccess=new TipoDelimiterDataAccess();

			tipodelimiterDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodelimiterDataAccess.setConnexionType(this.connexionType);
			tipodelimiterDataAccess.setParameterDbType(this.parameterDbType);

			tipodelimiter=tipodelimiterDataAccess.getEntity(connexion,relparametrogeneralusuario.getid_tipo_delimiter());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodelimiter;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroGeneralUsuario parametrogeneralusuario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrogeneralusuario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(parametrogeneralusuario.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrogeneralusuario.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrogeneralusuario.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(parametrogeneralusuario.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(parametrogeneralusuario.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(parametrogeneralusuario.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_sistema=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_sistema.setValue(parametrogeneralusuario.getfecha_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(parametrogeneralusuario.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(parametrogeneralusuario.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia=new ParameterValue<Integer>();
					parameterMaintenanceValuedia.setValue(parametrogeneralusuario.getdia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_visual=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_visual.setValue(parametrogeneralusuario.getid_tipo_visual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_visual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_fondo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_fondo.setValue(parametrogeneralusuario.getid_tipo_fondo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_fondo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_fondo_borde=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_fondo_borde.setValue(parametrogeneralusuario.getid_tipo_fondo_borde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_fondo_borde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_fondo_control=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_fondo_control.setValue(parametrogeneralusuario.getid_tipo_fondo_control());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_fondo_control);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_fuente=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_fuente.setValue(parametrogeneralusuario.getid_tipo_fuente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_fuente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tamanio_control_normal=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tamanio_control_normal.setValue(parametrogeneralusuario.getid_tipo_tamanio_control_normal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tamanio_control_normal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tamanio_control_relacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tamanio_control_relacion.setValue(parametrogeneralusuario.getid_tipo_tamanio_control_relacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tamanio_control_relacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_tamanio_control_manual=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_tamanio_control_manual.setValue(parametrogeneralusuario.getcon_tamanio_control_manual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_tamanio_control_manual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_tamanio_control_todo_relacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_tamanio_control_todo_relacion.setValue(parametrogeneralusuario.getcon_tamanio_control_todo_relacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_tamanio_control_todo_relacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_guardar_relaciones=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_guardar_relaciones.setValue(parametrogeneralusuario.getcon_guardar_relaciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_guardar_relaciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mensaje_confirmacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mensaje_confirmacion.setValue(parametrogeneralusuario.getcon_mensaje_confirmacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mensaje_confirmacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_botones_tool_bar=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_botones_tool_bar.setValue(parametrogeneralusuario.getcon_botones_tool_bar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_botones_tool_bar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mostrar_acciones_campo_general=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mostrar_acciones_campo_general.setValue(parametrogeneralusuario.getcon_mostrar_acciones_campo_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mostrar_acciones_campo_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mostrar_acciones_campo_relaciones=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mostrar_acciones_campo_relaciones.setValue(parametrogeneralusuario.getcon_mostrar_acciones_campo_relaciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mostrar_acciones_campo_relaciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_exportar=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_exportar.setValue(parametrogeneralusuario.getid_tipo_exportar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_exportar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_delimiter=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_delimiter.setValue(parametrogeneralusuario.getid_tipo_delimiter());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_delimiter);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_exportar_cabecera=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_exportar_cabecera.setValue(parametrogeneralusuario.getcon_exportar_cabecera());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_exportar_cabecera);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_exportar_campo_version=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_exportar_campo_version.setValue(parametrogeneralusuario.getcon_exportar_campo_version());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_exportar_campo_version);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_exportar=new ParameterValue<String>();
					parameterMaintenanceValuepath_exportar.setValue(parametrogeneralusuario.getpath_exportar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_exportar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precargar_ventanas=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precargar_ventanas.setValue(parametrogeneralusuario.getcon_precargar_ventanas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precargar_ventanas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precargar_por_usuario=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precargar_por_usuario.setValue(parametrogeneralusuario.getcon_precargar_por_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precargar_por_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cargar_por_parte=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cargar_por_parte.setValue(parametrogeneralusuario.getcon_cargar_por_parte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cargar_por_parte);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrogeneralusuario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrogeneralusuario.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrogeneralusuario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrogeneralusuario.getId());
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
	
	public void setIsNewIsChangedFalseParametroGeneralUsuario(ParametroGeneralUsuario parametrogeneralusuario)throws Exception  {		
		parametrogeneralusuario.setIsNew(false);
		parametrogeneralusuario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroGeneralUsuarios(List<ParametroGeneralUsuario> parametrogeneralusuarios)throws Exception  {				
		for(ParametroGeneralUsuario parametrogeneralusuario:parametrogeneralusuarios) {
			parametrogeneralusuario.setIsNew(false);
			parametrogeneralusuario.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroGeneralUsuario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
