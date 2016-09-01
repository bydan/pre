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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//DetalleActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class DetalleActivoFijoDataAccess extends  DetalleActivoFijoDataAccessAdditional{ //DetalleActivoFijoDataAccessAdditional,DataAccessHelper<DetalleActivoFijo>
	//static Logger logger = Logger.getLogger(DetalleActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_grupo_activo_fijo,id_sub_grupo_activo_fijo,id_tipo_ramo_activo_fijo,id_tipo_activo_fijo_empresa,id_tipo_depreciacion_empresa,id_estado_activo_fijo,id_cliente,id_partida_presu,codigo,nombre,serie,fecha_compra,fecha_mantenimiento,fecha_correccion,fecha_depreciacion,clave,marca,modelo,color,fecha,valor_util,costo_de_compra,vida_util,valor_residual,cantidad,nombre_propietario,responsable,path_foto,numero_comprobante,referencia,valor_cotizacion,con_partes,con_garantia,con_existencia,fecha_baja,path_foto2)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_grupo_activo_fijo=?,id_sub_grupo_activo_fijo=?,id_tipo_ramo_activo_fijo=?,id_tipo_activo_fijo_empresa=?,id_tipo_depreciacion_empresa=?,id_estado_activo_fijo=?,id_cliente=?,id_partida_presu=?,codigo=?,nombre=?,serie=?,fecha_compra=?,fecha_mantenimiento=?,fecha_correccion=?,fecha_depreciacion=?,clave=?,marca=?,modelo=?,color=?,fecha=?,valor_util=?,costo_de_compra=?,vida_util=?,valor_residual=?,cantidad=?,nombre_propietario=?,responsable=?,path_foto=?,numero_comprobante=?,referencia=?,valor_cotizacion=?,con_partes=?,con_garantia=?,con_existencia=?,fecha_baja=?,path_foto2=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleactivofijo from "+DetalleActivoFijoConstantesFunciones.SPERSISTENCENAME+" detalleactivofijo";
	public static String QUERYSELECTNATIVE="select "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_sub_grupo_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_tipo_ramo_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_tipo_activo_fijo_empresa,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_tipo_depreciacion_empresa,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_estado_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_cliente,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_partida_presu,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".codigo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".nombre,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".serie,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_compra,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_mantenimiento,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_correccion,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_depreciacion,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".clave,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".marca,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".modelo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".color,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".valor_util,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".costo_de_compra,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".vida_util,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".valor_residual,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".cantidad,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".nombre_propietario,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".responsable,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".path_foto,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".referencia,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".valor_cotizacion,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".con_partes,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".con_garantia,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".con_existencia,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_baja,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".path_foto2 from "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME;//+" as "+DetalleActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".codigo from "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME;//+" as "+DetalleActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_grupo_activo_fijo=?,id_sub_grupo_activo_fijo=?,id_tipo_ramo_activo_fijo=?,id_tipo_activo_fijo_empresa=?,id_tipo_depreciacion_empresa=?,id_estado_activo_fijo=?,id_cliente=?,id_partida_presu=?,codigo=?,nombre=?,serie=?,fecha_compra=?,fecha_mantenimiento=?,fecha_correccion=?,fecha_depreciacion=?,clave=?,marca=?,modelo=?,color=?,fecha=?,valor_util=?,costo_de_compra=?,vida_util=?,valor_residual=?,cantidad=?,nombre_propietario=?,responsable=?,path_foto=?,numero_comprobante=?,referencia=?,valor_cotizacion=?,con_partes=?,con_garantia=?,con_existencia=?,fecha_baja=?,path_foto2=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEACTIVOFIJO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEACTIVOFIJO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected DetalleActivoFijoDataAccessAdditional detalleactivofijoDataAccessAdditional=null;
	
	public DetalleActivoFijoDataAccessAdditional getDetalleActivoFijoDataAccessAdditional() {
		return this.detalleactivofijoDataAccessAdditional;
	}
	
	public void setDetalleActivoFijoDataAccessAdditional(DetalleActivoFijoDataAccessAdditional detalleactivofijoDataAccessAdditional) {
		try {
			this.detalleactivofijoDataAccessAdditional=detalleactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleActivoFijoDataAccess() {
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
		DetalleActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleActivoFijoOriginal(DetalleActivoFijo detalleactivofijo)throws Exception  {
		detalleactivofijo.setDetalleActivoFijoOriginal((DetalleActivoFijo)detalleactivofijo.clone());		
	}
	
	public void setDetalleActivoFijosOriginal(List<DetalleActivoFijo> detalleactivofijos)throws Exception  {
		
		for(DetalleActivoFijo detalleactivofijo:detalleactivofijos){
			detalleactivofijo.setDetalleActivoFijoOriginal((DetalleActivoFijo)detalleactivofijo.clone());
		}
	}
	
	public static void setDetalleActivoFijoOriginalStatic(DetalleActivoFijo detalleactivofijo)throws Exception  {
		detalleactivofijo.setDetalleActivoFijoOriginal((DetalleActivoFijo)detalleactivofijo.clone());		
	}
	
	public static void setDetalleActivoFijosOriginalStatic(List<DetalleActivoFijo> detalleactivofijos)throws Exception  {
		
		for(DetalleActivoFijo detalleactivofijo:detalleactivofijos){
			detalleactivofijo.setDetalleActivoFijoOriginal((DetalleActivoFijo)detalleactivofijo.clone());
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
	
	public  DetalleActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleActivoFijo entity = new DetalleActivoFijo();		
		
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
	
	public  DetalleActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleActivoFijo entity = new DetalleActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.DetalleActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleActivoFijoOriginal(new DetalleActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleActivoFijo("",entity,resultSet); 
				
				//entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleActivoFijo entity = new DetalleActivoFijo();
				
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
	
	public  DetalleActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleActivoFijo entity = new DetalleActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.DetalleActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleActivoFijoOriginal(new DetalleActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleActivoFijo("",entity,resultSet);    
				
				//entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleActivoFijo entity = new DetalleActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.DetalleActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		
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
	
	public  List<DetalleActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleActivoFijo("",entity,resultSet);
      	    	
				//entity.setDetalleActivoFijoOriginal( new DetalleActivoFijo());
      	    	//entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
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
	
	public  List<DetalleActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleActivoFijo();
					//entity.setMapDetalleActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleActivoFijoDataAccess.getEntityDetalleActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleActivoFijoOriginal( new DetalleActivoFijo());
					////entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
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
	
	public  DetalleActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleActivoFijo();
					//entity.setMapDetalleActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleActivoFijoDataAccess.getEntityDetalleActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleActivoFijoOriginal( new DetalleActivoFijo());
					////entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleActivoFijo getEntityDetalleActivoFijo(String strPrefijo,DetalleActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleActivoFijoDataAccess.setFieldReflectionDetalleActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleActivoFijo=DetalleActivoFijoConstantesFunciones.getTodosTiposColumnasDetalleActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleActivoFijo) {
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
							field = DetalleActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleActivoFijoDataAccess.setFieldReflectionDetalleActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleActivoFijo(Field field,String strPrefijo,String sColumn,DetalleActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.FECHACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleActivoFijoConstantesFunciones.FECHACORRECCION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleActivoFijoConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.MARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.MODELO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.COLOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleActivoFijoConstantesFunciones.VALORUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.COSTODECOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.VIDAUTIL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.VALORRESIDUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.PATHFOTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.REFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.VALORCOTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.CONPARTES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.CONGARANTIA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.CONEXISTENCIA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleActivoFijoConstantesFunciones.FECHABAJA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleActivoFijoConstantesFunciones.PATHFOTO2:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleActivoFijo();
					entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleActivoFijo("",entity,resultSet);
					
					//entity.setDetalleActivoFijoOriginal( new DetalleActivoFijo());
					//entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
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
	
	public  List<DetalleActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleActivoFijo("",entity,resultSet);
      	    	
				//entity.setDetalleActivoFijoOriginal( new DetalleActivoFijo());
      	    	//entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
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
	
	public  List<DetalleActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleActivoFijo> entities = new  ArrayList<DetalleActivoFijo>();
		DetalleActivoFijo entity = new DetalleActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleActivoFijo("",entity,resultSet);
      	    	
				//entity.setDetalleActivoFijoOriginal( new DetalleActivoFijo());
      	    	//entity.setDetalleActivoFijoOriginal(super.getEntity("",entity.getDetalleActivoFijoOriginal(),resultSet,DetalleActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleActivoFijoOriginal(this.getEntityDetalleActivoFijo("",entity.getDetalleActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleActivoFijo getEntityDetalleActivoFijo(String strPrefijo,DetalleActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_grupo_activo_fijo(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO));
				entity.setid_sub_grupo_activo_fijo(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO));
				entity.setid_tipo_ramo_activo_fijo(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO));
				entity.setid_tipo_activo_fijo_empresa(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA));
				entity.setid_tipo_depreciacion_empresa(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA));
				entity.setid_estado_activo_fijo(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDCLIENTE));
				entity.setid_partida_presu(resultSet.getLong(strPrefijo+DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU));
				entity.setcodigo(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.NOMBRE));
				entity.setserie(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.SERIE));
				entity.setfecha_compra(new Date(resultSet.getDate(strPrefijo+DetalleActivoFijoConstantesFunciones.FECHACOMPRA).getTime()));
				entity.setfecha_mantenimiento(new Date(resultSet.getDate(strPrefijo+DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO).getTime()));
				entity.setfecha_correccion(new Date(resultSet.getDate(strPrefijo+DetalleActivoFijoConstantesFunciones.FECHACORRECCION).getTime()));
				entity.setfecha_depreciacion(new Date(resultSet.getDate(strPrefijo+DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION).getTime()));
				entity.setclave(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.CLAVE));
				entity.setmarca(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.MARCA));
				entity.setmodelo(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.MODELO));
				entity.setcolor(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.COLOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetalleActivoFijoConstantesFunciones.FECHA).getTime()));
				entity.setvalor_util(resultSet.getDouble(strPrefijo+DetalleActivoFijoConstantesFunciones.VALORUTIL));
				entity.setcosto_de_compra(resultSet.getDouble(strPrefijo+DetalleActivoFijoConstantesFunciones.COSTODECOMPRA));
				entity.setvida_util(resultSet.getDouble(strPrefijo+DetalleActivoFijoConstantesFunciones.VIDAUTIL));
				entity.setvalor_residual(resultSet.getDouble(strPrefijo+DetalleActivoFijoConstantesFunciones.VALORRESIDUAL));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleActivoFijoConstantesFunciones.CANTIDAD));
				entity.setnombre_propietario(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO));
				entity.setresponsable(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.RESPONSABLE));
				entity.setpath_foto(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.PATHFOTO));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setreferencia(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.REFERENCIA));
				entity.setvalor_cotizacion(resultSet.getDouble(strPrefijo+DetalleActivoFijoConstantesFunciones.VALORCOTIZACION));
				entity.setcon_partes(resultSet.getBoolean(strPrefijo+DetalleActivoFijoConstantesFunciones.CONPARTES));
				entity.setcon_garantia(resultSet.getBoolean(strPrefijo+DetalleActivoFijoConstantesFunciones.CONGARANTIA));
				entity.setcon_existencia(resultSet.getBoolean(strPrefijo+DetalleActivoFijoConstantesFunciones.CONEXISTENCIA));
				entity.setfecha_baja(new Date(resultSet.getDate(strPrefijo+DetalleActivoFijoConstantesFunciones.FECHABAJA).getTime()));
				entity.setpath_foto2(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.PATHFOTO2));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+DetalleActivoFijoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleActivoFijoDataAccess.TABLENAME,DetalleActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleActivoFijoDataAccess.setDetalleActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleactivofijo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		DetalleGrupoActivoFijo detallegrupoactivofijo= new DetalleGrupoActivoFijo();

		try {
			DetalleGrupoActivoFijoDataAccess detallegrupoactivofijoDataAccess=new DetalleGrupoActivoFijoDataAccess();

			detallegrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,reldetalleactivofijo.getid_detalle_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallegrupoactivofijo;

	}

	public SubGrupoActivoFijo getSubGrupoActivoFijo(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		SubGrupoActivoFijo subgrupoactivofijo= new SubGrupoActivoFijo();

		try {
			SubGrupoActivoFijoDataAccess subgrupoactivofijoDataAccess=new SubGrupoActivoFijoDataAccess();

			subgrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subgrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			subgrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			subgrupoactivofijo=subgrupoactivofijoDataAccess.getEntity(connexion,reldetalleactivofijo.getid_sub_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subgrupoactivofijo;

	}

	public TipoRamoActivoFijo getTipoRamoActivoFijo(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		TipoRamoActivoFijo tiporamoactivofijo= new TipoRamoActivoFijo();

		try {
			TipoRamoActivoFijoDataAccess tiporamoactivofijoDataAccess=new TipoRamoActivoFijoDataAccess();

			tiporamoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporamoactivofijoDataAccess.setConnexionType(this.connexionType);
			tiporamoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			tiporamoactivofijo=tiporamoactivofijoDataAccess.getEntity(connexion,reldetalleactivofijo.getid_tipo_ramo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporamoactivofijo;

	}

	public TipoActivoFijoEmpresa getTipoActivoFijoEmpresa(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		TipoActivoFijoEmpresa tipoactivofijoempresa= new TipoActivoFijoEmpresa();

		try {
			TipoActivoFijoEmpresaDataAccess tipoactivofijoempresaDataAccess=new TipoActivoFijoEmpresaDataAccess();

			tipoactivofijoempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoactivofijoempresaDataAccess.setConnexionType(this.connexionType);
			tipoactivofijoempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipoactivofijoempresa=tipoactivofijoempresaDataAccess.getEntity(connexion,reldetalleactivofijo.getid_tipo_activo_fijo_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoactivofijoempresa;

	}

	public TipoDepreciacionEmpresa getTipoDepreciacionEmpresa(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		TipoDepreciacionEmpresa tipodepreciacionempresa= new TipoDepreciacionEmpresa();

		try {
			TipoDepreciacionEmpresaDataAccess tipodepreciacionempresaDataAccess=new TipoDepreciacionEmpresaDataAccess();

			tipodepreciacionempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodepreciacionempresaDataAccess.setConnexionType(this.connexionType);
			tipodepreciacionempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipodepreciacionempresa=tipodepreciacionempresaDataAccess.getEntity(connexion,reldetalleactivofijo.getid_tipo_depreciacion_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodepreciacionempresa;

	}

	public EstadoActivoFijo getEstadoActivoFijo(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		EstadoActivoFijo estadoactivofijo= new EstadoActivoFijo();

		try {
			EstadoActivoFijoDataAccess estadoactivofijoDataAccess=new EstadoActivoFijoDataAccess();

			estadoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoactivofijoDataAccess.setConnexionType(this.connexionType);
			estadoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion,reldetalleactivofijo.getid_estado_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoactivofijo;

	}

	public Cliente getCliente(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldetalleactivofijo.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public PartidaPresu getPartidaPresu(Connexion connexion,DetalleActivoFijo reldetalleactivofijo)throws SQLException,Exception {

		PartidaPresu partidapresu= new PartidaPresu();

		try {
			PartidaPresuDataAccess partidapresuDataAccess=new PartidaPresuDataAccess();

			partidapresuDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			partidapresuDataAccess.setConnexionType(this.connexionType);
			partidapresuDataAccess.setParameterDbType(this.parameterDbType);

			partidapresu=partidapresuDataAccess.getEntity(connexion,reldetalleactivofijo.getid_partida_presu());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return partidapresu;

	}


		
		public List<MantenimientoActivoFijo> getMantenimientoActivoFijos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<MantenimientoActivoFijo> mantenimientoactivofijos= new ArrayList<MantenimientoActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+".mantenimiento_activo_fijo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN mantenimientoactivofijo.DetalleActivoFijo WHERE mantenimientoactivofijo.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MantenimientoActivoFijoDataAccess mantenimientoactivofijoDataAccess=new MantenimientoActivoFijoDataAccess();

			mantenimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			mantenimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mantenimientoactivofijos;

	}

	public List<ServicioTransporte> getServicioTransportes(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<ServicioTransporte> serviciotransportes= new ArrayList<ServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN serviciotransporte.DetalleActivoFijo WHERE serviciotransporte.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

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

	public List<MovimientoActivoFijo> getMovimientoActivoFijoDestinos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<MovimientoActivoFijo> movimientoactivofijodestinos= new ArrayList<MovimientoActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+MovimientoActivoFijoConstantesFunciones.SCHEMA+".movimiento_activo_fijo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN movimientoactivofijo.DetalleActivoFijoDestino WHERE movimientoactivofijo.DetalleActivoFijoDestino.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoActivoFijoDataAccess movimientoactivofijoDataAccess=new MovimientoActivoFijoDataAccess();

			movimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			movimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			movimientoactivofijodestinos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoactivofijodestinos;

	}

	public List<Vehiculo> getVehiculos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+VehiculoConstantesFunciones.SCHEMA+".vehiculo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN vehiculo.DetalleActivoFijo WHERE vehiculo.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			VehiculoDataAccess vehiculoDataAccess=new VehiculoDataAccess();

			vehiculoDataAccess.setConnexionType(this.connexionType);
			vehiculoDataAccess.setParameterDbType(this.parameterDbType);
			vehiculos=vehiculoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vehiculos;

	}

	public List<MetodoDepreciacion> getMetodoDepreciacions(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<MetodoDepreciacion> metododepreciacions= new ArrayList<MetodoDepreciacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+MetodoDepreciacionConstantesFunciones.SCHEMA+".metodo_depreciacion.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN metododepreciacion.DetalleActivoFijo WHERE metododepreciacion.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MetodoDepreciacionDataAccess metododepreciacionDataAccess=new MetodoDepreciacionDataAccess();

			metododepreciacionDataAccess.setConnexionType(this.connexionType);
			metododepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return metododepreciacions;

	}

	public List<ResponsableActivoFijo> getResponsableActivoFijos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<ResponsableActivoFijo> responsableactivofijos= new ArrayList<ResponsableActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+ResponsableActivoFijoConstantesFunciones.SCHEMA+".responsable_activo_fijo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN responsableactivofijo.DetalleActivoFijo WHERE responsableactivofijo.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ResponsableActivoFijoDataAccess responsableactivofijoDataAccess=new ResponsableActivoFijoDataAccess();

			responsableactivofijoDataAccess.setConnexionType(this.connexionType);
			responsableactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsableactivofijos;

	}

	public List<DepreciacionActivoFijo> getDepreciacionActivoFijos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<DepreciacionActivoFijo> depreciacionactivofijos= new ArrayList<DepreciacionActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+".depreciacion_activo_fijo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN depreciacionactivofijo.DetalleActivoFijo WHERE depreciacionactivofijo.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DepreciacionActivoFijoDataAccess depreciacionactivofijoDataAccess=new DepreciacionActivoFijoDataAccess();

			depreciacionactivofijoDataAccess.setConnexionType(this.connexionType);
			depreciacionactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			depreciacionactivofijos=depreciacionactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return depreciacionactivofijos;

	}

	public List<GastoDepreciacionCentroCosto> getGastoDepreciacionCentroCostos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos= new ArrayList<GastoDepreciacionCentroCosto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+".gasto_depreciacion_centro_costo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN gastodepreciacioncentrocosto.DetalleActivoFijo WHERE gastodepreciacioncentrocosto.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GastoDepreciacionCentroCostoDataAccess gastodepreciacioncentrocostoDataAccess=new GastoDepreciacionCentroCostoDataAccess();

			gastodepreciacioncentrocostoDataAccess.setConnexionType(this.connexionType);
			gastodepreciacioncentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastodepreciacioncentrocostos;

	}

	public List<ParteActivoFijo> getParteActivoFijos(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws SQLException,Exception {

		List<ParteActivoFijo> parteactivofijos= new ArrayList<ParteActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo ON "+ParteActivoFijoConstantesFunciones.SCHEMA+".parte_activo_fijo.id_detalle_activo_fijo="+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id WHERE "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id="+String.valueOf(detalleactivofijo.getId());
			} else {
				sQuery=" INNER JOIN parteactivofijo.DetalleActivoFijo WHERE parteactivofijo.DetalleActivoFijo.id="+String.valueOf(detalleactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParteActivoFijoDataAccess parteactivofijoDataAccess=new ParteActivoFijoDataAccess();

			parteactivofijoDataAccess.setConnexionType(this.connexionType);
			parteactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parteactivofijos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleActivoFijo detalleactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleactivofijo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_grupo_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_grupo_activo_fijo.setValue(detalleactivofijo.getid_detalle_grupo_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_grupo_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_grupo_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_grupo_activo_fijo.setValue(detalleactivofijo.getid_sub_grupo_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_grupo_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_ramo_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_ramo_activo_fijo.setValue(detalleactivofijo.getid_tipo_ramo_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_ramo_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_activo_fijo_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_activo_fijo_empresa.setValue(detalleactivofijo.getid_tipo_activo_fijo_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_activo_fijo_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_depreciacion_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_depreciacion_empresa.setValue(detalleactivofijo.getid_tipo_depreciacion_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_depreciacion_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_activo_fijo.setValue(detalleactivofijo.getid_estado_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(detalleactivofijo.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_partida_presu=new ParameterValue<Long>();
					parameterMaintenanceValueid_partida_presu.setValue(detalleactivofijo.getid_partida_presu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_partida_presu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(detalleactivofijo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(detalleactivofijo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detalleactivofijo.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_compra=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_compra.setValue(detalleactivofijo.getfecha_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_mantenimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_mantenimiento.setValue(detalleactivofijo.getfecha_mantenimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_mantenimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_correccion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_correccion.setValue(detalleactivofijo.getfecha_correccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_correccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_depreciacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_depreciacion.setValue(detalleactivofijo.getfecha_depreciacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_depreciacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueclave=new ParameterValue<String>();
					parameterMaintenanceValueclave.setValue(detalleactivofijo.getclave());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueclave);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemarca=new ParameterValue<String>();
					parameterMaintenanceValuemarca.setValue(detalleactivofijo.getmarca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemarca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemodelo=new ParameterValue<String>();
					parameterMaintenanceValuemodelo.setValue(detalleactivofijo.getmodelo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemodelo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecolor=new ParameterValue<String>();
					parameterMaintenanceValuecolor.setValue(detalleactivofijo.getcolor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecolor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(detalleactivofijo.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_util=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_util.setValue(detalleactivofijo.getvalor_util());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_util);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_de_compra=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_de_compra.setValue(detalleactivofijo.getcosto_de_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_de_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevida_util=new ParameterValue<Double>();
					parameterMaintenanceValuevida_util.setValue(detalleactivofijo.getvida_util());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevida_util);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_residual=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_residual.setValue(detalleactivofijo.getvalor_residual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_residual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalleactivofijo.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_propietario=new ParameterValue<String>();
					parameterMaintenanceValuenombre_propietario.setValue(detalleactivofijo.getnombre_propietario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_propietario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(detalleactivofijo.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_foto=new ParameterValue<String>();
					parameterMaintenanceValuepath_foto.setValue(detalleactivofijo.getpath_foto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_foto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detalleactivofijo.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuereferencia=new ParameterValue<String>();
					parameterMaintenanceValuereferencia.setValue(detalleactivofijo.getreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cotizacion.setValue(detalleactivofijo.getvalor_cotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_partes=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_partes.setValue(detalleactivofijo.getcon_partes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_partes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_garantia=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_garantia.setValue(detalleactivofijo.getcon_garantia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_garantia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_existencia=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_existencia.setValue(detalleactivofijo.getcon_existencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_existencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_baja=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_baja.setValue(detalleactivofijo.getfecha_baja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_baja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_foto2=new ParameterValue<String>();
					parameterMaintenanceValuepath_foto2.setValue(detalleactivofijo.getpath_foto2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_foto2);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseDetalleActivoFijo(DetalleActivoFijo detalleactivofijo)throws Exception  {		
		detalleactivofijo.setIsNew(false);
		detalleactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos)throws Exception  {				
		for(DetalleActivoFijo detalleactivofijo:detalleactivofijos) {
			detalleactivofijo.setIsNew(false);
			detalleactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
