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
package com.bydan.erp.contabilidad.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.util.PresuProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuProyectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuProyectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresuProyectoConstantesFunciones extends PresuProyectoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PresuProyecto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuProyecto"+PresuProyectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuProyectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuProyectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuProyectoConstantesFunciones.SCHEMA+"_"+PresuProyectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuProyectoConstantesFunciones.SCHEMA+"_"+PresuProyectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuProyectoConstantesFunciones.SCHEMA+"_"+PresuProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuProyectoConstantesFunciones.SCHEMA+"_"+PresuProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuProyectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuProyectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuProyectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuProyectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proyectoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proyecto";
	public static final String SCLASSWEBTITULO_LOWER="Presu Proyecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuProyecto";
	public static final String OBJECTNAME="presuproyecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_proyecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presuproyecto from "+PresuProyectoConstantesFunciones.SPERSISTENCENAME+" presuproyecto";
	public static String QUERYSELECTNATIVE="select "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_empresa,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_sucursal,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_ejercicio,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".codigo,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".nombre,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_presu_tipo_proyecto,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_centro_costo,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".fecha,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".valor,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".id_presu_estado,"+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME+".descripcion from "+PresuProyectoConstantesFunciones.SCHEMA+"."+PresuProyectoConstantesFunciones.TABLENAME;//+" as "+PresuProyectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresuProyectoConstantesFuncionesAdditional presuproyectoConstantesFuncionesAdditional=null;
	
	public PresuProyectoConstantesFuncionesAdditional getPresuProyectoConstantesFuncionesAdditional() {
		return this.presuproyectoConstantesFuncionesAdditional;
	}
	
	public void setPresuProyectoConstantesFuncionesAdditional(PresuProyectoConstantesFuncionesAdditional presuproyectoConstantesFuncionesAdditional) {
		try {
			this.presuproyectoConstantesFuncionesAdditional=presuproyectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDPRESUTIPOPROYECTO= "id_presu_tipo_proyecto";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String IDPRESUESTADO= "id_presu_estado";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDPRESUTIPOPROYECTO= "Tipo Proyecto";
		public static final String LABEL_IDPRESUTIPOPROYECTO_LOWER= "Presu Tipo Proyecto";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_IDPRESUESTADO= "Estado";
		public static final String LABEL_IDPRESUESTADO_LOWER= "Presu Estado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPresuProyectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.CODIGO)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.NOMBRE)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_IDPRESUTIPOPROYECTO;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.FECHA)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.VALOR)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.IDPRESUESTADO)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_IDPRESUESTADO;}
		if(sNombreColumna.equals(PresuProyectoConstantesFunciones.DESCRIPCION)) {sLabelColumna=PresuProyectoConstantesFunciones.LABEL_DESCRIPCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresuProyectoDescripcion(PresuProyecto presuproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presuproyecto !=null/* && presuproyecto.getId()!=0*/) {
			sDescripcion=presuproyecto.getcodigo();//presuproyectopresuproyecto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuProyectoDescripcionDetallado(PresuProyecto presuproyecto) {
		String sDescripcion="";
			
		sDescripcion+=PresuProyectoConstantesFunciones.ID+"=";
		sDescripcion+=presuproyecto.getId().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presuproyecto.getVersionRow().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presuproyecto.getid_empresa().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=presuproyecto.getid_sucursal().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presuproyecto.getid_ejercicio().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.CODIGO+"=";
		sDescripcion+=presuproyecto.getcodigo()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presuproyecto.getnombre()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO+"=";
		sDescripcion+=presuproyecto.getid_presu_tipo_proyecto().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=presuproyecto.getid_centro_costo().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.FECHA+"=";
		sDescripcion+=presuproyecto.getfecha().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.VALOR+"=";
		sDescripcion+=presuproyecto.getvalor().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.IDPRESUESTADO+"=";
		sDescripcion+=presuproyecto.getid_presu_estado().toString()+",";
		sDescripcion+=PresuProyectoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=presuproyecto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuProyectoDescripcion(PresuProyecto presuproyecto,String sValor) throws Exception {			
		if(presuproyecto !=null) {
			presuproyecto.setcodigo(sValor);;//presuproyectopresuproyecto.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPresuTipoProyectoDescripcion(PresuTipoProyecto presutipoproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presutipoproyecto!=null/*&&presutipoproyecto.getId()>0*/) {
			sDescripcion=PresuTipoProyectoConstantesFunciones.getPresuTipoProyectoDescripcion(presutipoproyecto);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getPresuEstadoDescripcion(PresuEstado presuestado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presuestado!=null/*&&presuestado.getId()>0*/) {
			sDescripcion=PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuestado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPresuEstado")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdPresuTipoProyecto")) {
			sNombreIndice="Tipo=  Por Tipo Proyecto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuEstado(Long id_presu_estado) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_estado!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_presu_estado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuTipoProyecto(Long id_presu_tipo_proyecto) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_tipo_proyecto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Proyecto="+id_presu_tipo_proyecto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresuProyecto(PresuProyecto presuproyecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presuproyecto.setcodigo(presuproyecto.getcodigo().trim());
		presuproyecto.setnombre(presuproyecto.getnombre().trim());
		presuproyecto.setdescripcion(presuproyecto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPresuProyectos(List<PresuProyecto> presuproyectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuProyecto presuproyecto: presuproyectos) {
			presuproyecto.setcodigo(presuproyecto.getcodigo().trim());
			presuproyecto.setnombre(presuproyecto.getnombre().trim());
			presuproyecto.setdescripcion(presuproyecto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuProyecto(PresuProyecto presuproyecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presuproyecto.getConCambioAuxiliar()) {
			presuproyecto.setIsDeleted(presuproyecto.getIsDeletedAuxiliar());	
			presuproyecto.setIsNew(presuproyecto.getIsNewAuxiliar());	
			presuproyecto.setIsChanged(presuproyecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presuproyecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presuproyecto.setIsDeletedAuxiliar(false);	
			presuproyecto.setIsNewAuxiliar(false);	
			presuproyecto.setIsChangedAuxiliar(false);
			
			presuproyecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuProyectos(List<PresuProyecto> presuproyectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuProyecto presuproyecto : presuproyectos) {
			if(conAsignarBase && presuproyecto.getConCambioAuxiliar()) {
				presuproyecto.setIsDeleted(presuproyecto.getIsDeletedAuxiliar());	
				presuproyecto.setIsNew(presuproyecto.getIsNewAuxiliar());	
				presuproyecto.setIsChanged(presuproyecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presuproyecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presuproyecto.setIsDeletedAuxiliar(false);	
				presuproyecto.setIsNewAuxiliar(false);	
				presuproyecto.setIsChangedAuxiliar(false);
				
				presuproyecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuProyecto(PresuProyecto presuproyecto,Boolean conEnteros) throws Exception  {
		presuproyecto.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresuProyectos(List<PresuProyecto> presuproyectos,Boolean conEnteros) throws Exception  {
		
		for(PresuProyecto presuproyecto: presuproyectos) {
			presuproyecto.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuProyecto(List<PresuProyecto> presuproyectos,PresuProyecto presuproyectoAux) throws Exception  {
		PresuProyectoConstantesFunciones.InicializarValoresPresuProyecto(presuproyectoAux,true);
		
		for(PresuProyecto presuproyecto: presuproyectos) {
			if(presuproyecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presuproyectoAux.setvalor(presuproyectoAux.getvalor()+presuproyecto.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuProyecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuProyectoConstantesFunciones.getArrayColumnasGlobalesPresuProyecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuProyecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresuProyectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresuProyectoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresuProyectoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresuProyectoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresuProyectoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresuProyectoConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuProyecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PresuProyectoConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuProyecto> presuproyectos,PresuProyecto presuproyecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuProyecto presuproyectoAux: presuproyectos) {
			if(presuproyectoAux!=null && presuproyecto!=null) {
				if((presuproyectoAux.getId()==null && presuproyecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presuproyectoAux.getId()!=null && presuproyecto.getId()!=null){
					if(presuproyectoAux.getId().equals(presuproyecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuProyecto(List<PresuProyecto> presuproyectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(PresuProyecto presuproyecto: presuproyectos) {			
			if(presuproyecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presuproyecto.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresuProyectoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuProyecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_ID, PresuProyectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_VERSIONROW, PresuProyectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_IDEMPRESA, PresuProyectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_IDSUCURSAL, PresuProyectoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_IDEJERCICIO, PresuProyectoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_CODIGO, PresuProyectoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_NOMBRE, PresuProyectoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_IDPRESUTIPOPROYECTO, PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_IDCENTROCOSTO, PresuProyectoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_FECHA, PresuProyectoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_VALOR, PresuProyectoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_IDPRESUESTADO, PresuProyectoConstantesFunciones.IDPRESUESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoConstantesFunciones.LABEL_DESCRIPCION, PresuProyectoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuProyecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.IDPRESUESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuProyecto() throws Exception  {
		return PresuProyectoConstantesFunciones.getTiposSeleccionarPresuProyecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuProyecto(Boolean conFk) throws Exception  {
		return PresuProyectoConstantesFunciones.getTiposSeleccionarPresuProyecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuProyecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_IDPRESUTIPOPROYECTO);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_IDPRESUTIPOPROYECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_IDPRESUESTADO);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_IDPRESUESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PresuProyectoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuProyecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuProyecto(PresuProyecto presuproyectoAux) throws Exception {
		
			presuproyectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presuproyectoAux.getEmpresa()));
			presuproyectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presuproyectoAux.getSucursal()));
			presuproyectoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presuproyectoAux.getEjercicio()));
			presuproyectoAux.setpresutipoproyecto_descripcion(PresuTipoProyectoConstantesFunciones.getPresuTipoProyectoDescripcion(presuproyectoAux.getPresuTipoProyecto()));
			presuproyectoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(presuproyectoAux.getCentroCosto()));
			presuproyectoAux.setpresuestado_descripcion(PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuproyectoAux.getPresuEstado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresuProyecto(List<PresuProyecto> presuproyectosTemp) throws Exception {
		for(PresuProyecto presuproyectoAux:presuproyectosTemp) {
			
			presuproyectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presuproyectoAux.getEmpresa()));
			presuproyectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presuproyectoAux.getSucursal()));
			presuproyectoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presuproyectoAux.getEjercicio()));
			presuproyectoAux.setpresutipoproyecto_descripcion(PresuTipoProyectoConstantesFunciones.getPresuTipoProyectoDescripcion(presuproyectoAux.getPresuTipoProyecto()));
			presuproyectoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(presuproyectoAux.getCentroCosto()));
			presuproyectoAux.setpresuestado_descripcion(PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuproyectoAux.getPresuEstado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(PresuTipoProyecto.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(PresuEstado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuTipoProyecto.class)) {
						classes.add(new Classe(PresuTipoProyecto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuEstado.class)) {
						classes.add(new Classe(PresuEstado.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(PresuTipoProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuTipoProyecto.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(PresuEstado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuEstado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(PresuTipoProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuTipoProyecto.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(PresuEstado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuEstado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuProyectoConstantesFunciones.getClassesRelationshipsOfPresuProyecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuTransferencia.class));
				classes.add(new Classe(PresuProyectoCuenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuTransferencia.class)) {
						classes.add(new Classe(PresuTransferencia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuProyectoCuenta.class)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuProyectoConstantesFunciones.getClassesRelationshipsFromStringsOfPresuProyecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuTransferencia.class)); continue;
					}

					if(PresuProyectoCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuTransferencia.class)); continue;
					}

					if(PresuProyectoCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PresuProyecto presuproyecto,List<PresuProyecto> presuproyectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuProyecto presuproyectoEncontrado=null;
			
			for(PresuProyecto presuproyectoLocal:presuproyectos) {
				if(presuproyectoLocal.getId().equals(presuproyecto.getId())) {
					presuproyectoEncontrado=presuproyectoLocal;
					
					presuproyectoLocal.setIsChanged(presuproyecto.getIsChanged());
					presuproyectoLocal.setIsNew(presuproyecto.getIsNew());
					presuproyectoLocal.setIsDeleted(presuproyecto.getIsDeleted());
					
					presuproyectoLocal.setGeneralEntityOriginal(presuproyecto.getGeneralEntityOriginal());
					
					presuproyectoLocal.setId(presuproyecto.getId());	
					presuproyectoLocal.setVersionRow(presuproyecto.getVersionRow());	
					presuproyectoLocal.setid_empresa(presuproyecto.getid_empresa());	
					presuproyectoLocal.setid_sucursal(presuproyecto.getid_sucursal());	
					presuproyectoLocal.setid_ejercicio(presuproyecto.getid_ejercicio());	
					presuproyectoLocal.setcodigo(presuproyecto.getcodigo());	
					presuproyectoLocal.setnombre(presuproyecto.getnombre());	
					presuproyectoLocal.setid_presu_tipo_proyecto(presuproyecto.getid_presu_tipo_proyecto());	
					presuproyectoLocal.setid_centro_costo(presuproyecto.getid_centro_costo());	
					presuproyectoLocal.setfecha(presuproyecto.getfecha());	
					presuproyectoLocal.setvalor(presuproyecto.getvalor());	
					presuproyectoLocal.setid_presu_estado(presuproyecto.getid_presu_estado());	
					presuproyectoLocal.setdescripcion(presuproyecto.getdescripcion());	
					
					
					presuproyectoLocal.setPresuTransferencias(presuproyecto.getPresuTransferencias());
					presuproyectoLocal.setPresuProyectoCuentas(presuproyecto.getPresuProyectoCuentas());
					
					existe=true;
					break;
				}
			}
			
			if(!presuproyecto.getIsDeleted()) {
				if(!existe) {
					presuproyectos.add(presuproyecto);
				}
			} else {
				if(presuproyectoEncontrado!=null && permiteQuitar)  {
					presuproyectos.remove(presuproyectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuProyecto presuproyecto,List<PresuProyecto> presuproyectos) throws Exception {
		try	{			
			for(PresuProyecto presuproyectoLocal:presuproyectos) {
				if(presuproyectoLocal.getId().equals(presuproyecto.getId())) {
					presuproyectoLocal.setIsSelected(presuproyecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuProyecto(List<PresuProyecto> presuproyectosAux) throws Exception {
		//this.presuproyectosAux=presuproyectosAux;
		
		for(PresuProyecto presuproyectoAux:presuproyectosAux) {
			if(presuproyectoAux.getIsChanged()) {
				presuproyectoAux.setIsChanged(false);
			}		
			
			if(presuproyectoAux.getIsNew()) {
				presuproyectoAux.setIsNew(false);
			}	
			
			if(presuproyectoAux.getIsDeleted()) {
				presuproyectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuProyecto(PresuProyecto presuproyectoAux) throws Exception {
		//this.presuproyectoAux=presuproyectoAux;
		
			if(presuproyectoAux.getIsChanged()) {
				presuproyectoAux.setIsChanged(false);
			}		
			
			if(presuproyectoAux.getIsNew()) {
				presuproyectoAux.setIsNew(false);
			}	
			
			if(presuproyectoAux.getIsDeleted()) {
				presuproyectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuProyecto presuproyectoAsignar,PresuProyecto presuproyecto) throws Exception {
		presuproyectoAsignar.setId(presuproyecto.getId());	
		presuproyectoAsignar.setVersionRow(presuproyecto.getVersionRow());	
		presuproyectoAsignar.setid_empresa(presuproyecto.getid_empresa());
		presuproyectoAsignar.setempresa_descripcion(presuproyecto.getempresa_descripcion());	
		presuproyectoAsignar.setid_sucursal(presuproyecto.getid_sucursal());
		presuproyectoAsignar.setsucursal_descripcion(presuproyecto.getsucursal_descripcion());	
		presuproyectoAsignar.setid_ejercicio(presuproyecto.getid_ejercicio());
		presuproyectoAsignar.setejercicio_descripcion(presuproyecto.getejercicio_descripcion());	
		presuproyectoAsignar.setcodigo(presuproyecto.getcodigo());	
		presuproyectoAsignar.setnombre(presuproyecto.getnombre());	
		presuproyectoAsignar.setid_presu_tipo_proyecto(presuproyecto.getid_presu_tipo_proyecto());
		presuproyectoAsignar.setpresutipoproyecto_descripcion(presuproyecto.getpresutipoproyecto_descripcion());	
		presuproyectoAsignar.setid_centro_costo(presuproyecto.getid_centro_costo());
		presuproyectoAsignar.setcentrocosto_descripcion(presuproyecto.getcentrocosto_descripcion());	
		presuproyectoAsignar.setfecha(presuproyecto.getfecha());	
		presuproyectoAsignar.setvalor(presuproyecto.getvalor());	
		presuproyectoAsignar.setid_presu_estado(presuproyecto.getid_presu_estado());
		presuproyectoAsignar.setpresuestado_descripcion(presuproyecto.getpresuestado_descripcion());	
		presuproyectoAsignar.setdescripcion(presuproyecto.getdescripcion());	
	}
	
	public static void inicializarPresuProyecto(PresuProyecto presuproyecto) throws Exception {
		try {
				presuproyecto.setId(0L);	
					
				presuproyecto.setid_empresa(-1L);	
				presuproyecto.setid_sucursal(-1L);	
				presuproyecto.setid_ejercicio(-1L);	
				presuproyecto.setcodigo("");	
				presuproyecto.setnombre("");	
				presuproyecto.setid_presu_tipo_proyecto(-1L);	
				presuproyecto.setid_centro_costo(null);	
				presuproyecto.setfecha(new Date());	
				presuproyecto.setvalor(0.0);	
				presuproyecto.setid_presu_estado(-1L);	
				presuproyecto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuProyecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_IDPRESUTIPOPROYECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_IDPRESUESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuProyecto(String sTipo,Row row,Workbook workbook,PresuProyecto presuproyecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getpresutipoproyecto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getpresuestado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyecto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuProyecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuProyecto() {
		return this.sFinalQueryPresuProyecto;
	}
	
	public void setsFinalQueryPresuProyecto(String sFinalQueryPresuProyecto) {
		this.sFinalQueryPresuProyecto= sFinalQueryPresuProyecto;
	}
	
	public Border resaltarSeleccionarPresuProyecto=null;
	
	public Border setResaltarSeleccionarPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuProyecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuProyecto() {
		return this.resaltarSeleccionarPresuProyecto;
	}
	
	public void setResaltarSeleccionarPresuProyecto(Border borderResaltarSeleccionarPresuProyecto) {
		this.resaltarSeleccionarPresuProyecto= borderResaltarSeleccionarPresuProyecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuProyecto=null;
	public Boolean mostraridPresuProyecto=true;
	public Boolean activaridPresuProyecto=true;

	public Border resaltarid_empresaPresuProyecto=null;
	public Boolean mostrarid_empresaPresuProyecto=true;
	public Boolean activarid_empresaPresuProyecto=true;
	public Boolean cargarid_empresaPresuProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresuProyecto=false;//ConEventDepend=true

	public Border resaltarid_sucursalPresuProyecto=null;
	public Boolean mostrarid_sucursalPresuProyecto=true;
	public Boolean activarid_sucursalPresuProyecto=true;
	public Boolean cargarid_sucursalPresuProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPresuProyecto=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresuProyecto=null;
	public Boolean mostrarid_ejercicioPresuProyecto=true;
	public Boolean activarid_ejercicioPresuProyecto=true;
	public Boolean cargarid_ejercicioPresuProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresuProyecto=false;//ConEventDepend=true

	public Border resaltarcodigoPresuProyecto=null;
	public Boolean mostrarcodigoPresuProyecto=true;
	public Boolean activarcodigoPresuProyecto=true;

	public Border resaltarnombrePresuProyecto=null;
	public Boolean mostrarnombrePresuProyecto=true;
	public Boolean activarnombrePresuProyecto=true;

	public Border resaltarid_presu_tipo_proyectoPresuProyecto=null;
	public Boolean mostrarid_presu_tipo_proyectoPresuProyecto=true;
	public Boolean activarid_presu_tipo_proyectoPresuProyecto=true;
	public Boolean cargarid_presu_tipo_proyectoPresuProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_tipo_proyectoPresuProyecto=false;//ConEventDepend=true

	public Border resaltarid_centro_costoPresuProyecto=null;
	public Boolean mostrarid_centro_costoPresuProyecto=true;
	public Boolean activarid_centro_costoPresuProyecto=true;
	public Boolean cargarid_centro_costoPresuProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoPresuProyecto=false;//ConEventDepend=true

	public Border resaltarfechaPresuProyecto=null;
	public Boolean mostrarfechaPresuProyecto=true;
	public Boolean activarfechaPresuProyecto=true;

	public Border resaltarvalorPresuProyecto=null;
	public Boolean mostrarvalorPresuProyecto=true;
	public Boolean activarvalorPresuProyecto=true;

	public Border resaltarid_presu_estadoPresuProyecto=null;
	public Boolean mostrarid_presu_estadoPresuProyecto=true;
	public Boolean activarid_presu_estadoPresuProyecto=true;
	public Boolean cargarid_presu_estadoPresuProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_estadoPresuProyecto=false;//ConEventDepend=true

	public Border resaltardescripcionPresuProyecto=null;
	public Boolean mostrardescripcionPresuProyecto=true;
	public Boolean activardescripcionPresuProyecto=true;

	
	

	public Border setResaltaridPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltaridPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuProyecto() {
		return this.resaltaridPresuProyecto;
	}

	public void setResaltaridPresuProyecto(Border borderResaltar) {
		this.resaltaridPresuProyecto= borderResaltar;
	}

	public Boolean getMostraridPresuProyecto() {
		return this.mostraridPresuProyecto;
	}

	public void setMostraridPresuProyecto(Boolean mostraridPresuProyecto) {
		this.mostraridPresuProyecto= mostraridPresuProyecto;
	}

	public Boolean getActivaridPresuProyecto() {
		return this.activaridPresuProyecto;
	}

	public void setActivaridPresuProyecto(Boolean activaridPresuProyecto) {
		this.activaridPresuProyecto= activaridPresuProyecto;
	}

	public Border setResaltarid_empresaPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresuProyecto() {
		return this.resaltarid_empresaPresuProyecto;
	}

	public void setResaltarid_empresaPresuProyecto(Border borderResaltar) {
		this.resaltarid_empresaPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresuProyecto() {
		return this.mostrarid_empresaPresuProyecto;
	}

	public void setMostrarid_empresaPresuProyecto(Boolean mostrarid_empresaPresuProyecto) {
		this.mostrarid_empresaPresuProyecto= mostrarid_empresaPresuProyecto;
	}

	public Boolean getActivarid_empresaPresuProyecto() {
		return this.activarid_empresaPresuProyecto;
	}

	public void setActivarid_empresaPresuProyecto(Boolean activarid_empresaPresuProyecto) {
		this.activarid_empresaPresuProyecto= activarid_empresaPresuProyecto;
	}

	public Boolean getCargarid_empresaPresuProyecto() {
		return this.cargarid_empresaPresuProyecto;
	}

	public void setCargarid_empresaPresuProyecto(Boolean cargarid_empresaPresuProyecto) {
		this.cargarid_empresaPresuProyecto= cargarid_empresaPresuProyecto;
	}

	public Border setResaltarid_sucursalPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPresuProyecto() {
		return this.resaltarid_sucursalPresuProyecto;
	}

	public void setResaltarid_sucursalPresuProyecto(Border borderResaltar) {
		this.resaltarid_sucursalPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPresuProyecto() {
		return this.mostrarid_sucursalPresuProyecto;
	}

	public void setMostrarid_sucursalPresuProyecto(Boolean mostrarid_sucursalPresuProyecto) {
		this.mostrarid_sucursalPresuProyecto= mostrarid_sucursalPresuProyecto;
	}

	public Boolean getActivarid_sucursalPresuProyecto() {
		return this.activarid_sucursalPresuProyecto;
	}

	public void setActivarid_sucursalPresuProyecto(Boolean activarid_sucursalPresuProyecto) {
		this.activarid_sucursalPresuProyecto= activarid_sucursalPresuProyecto;
	}

	public Boolean getCargarid_sucursalPresuProyecto() {
		return this.cargarid_sucursalPresuProyecto;
	}

	public void setCargarid_sucursalPresuProyecto(Boolean cargarid_sucursalPresuProyecto) {
		this.cargarid_sucursalPresuProyecto= cargarid_sucursalPresuProyecto;
	}

	public Border setResaltarid_ejercicioPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresuProyecto() {
		return this.resaltarid_ejercicioPresuProyecto;
	}

	public void setResaltarid_ejercicioPresuProyecto(Border borderResaltar) {
		this.resaltarid_ejercicioPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresuProyecto() {
		return this.mostrarid_ejercicioPresuProyecto;
	}

	public void setMostrarid_ejercicioPresuProyecto(Boolean mostrarid_ejercicioPresuProyecto) {
		this.mostrarid_ejercicioPresuProyecto= mostrarid_ejercicioPresuProyecto;
	}

	public Boolean getActivarid_ejercicioPresuProyecto() {
		return this.activarid_ejercicioPresuProyecto;
	}

	public void setActivarid_ejercicioPresuProyecto(Boolean activarid_ejercicioPresuProyecto) {
		this.activarid_ejercicioPresuProyecto= activarid_ejercicioPresuProyecto;
	}

	public Boolean getCargarid_ejercicioPresuProyecto() {
		return this.cargarid_ejercicioPresuProyecto;
	}

	public void setCargarid_ejercicioPresuProyecto(Boolean cargarid_ejercicioPresuProyecto) {
		this.cargarid_ejercicioPresuProyecto= cargarid_ejercicioPresuProyecto;
	}

	public Border setResaltarcodigoPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarcodigoPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPresuProyecto() {
		return this.resaltarcodigoPresuProyecto;
	}

	public void setResaltarcodigoPresuProyecto(Border borderResaltar) {
		this.resaltarcodigoPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarcodigoPresuProyecto() {
		return this.mostrarcodigoPresuProyecto;
	}

	public void setMostrarcodigoPresuProyecto(Boolean mostrarcodigoPresuProyecto) {
		this.mostrarcodigoPresuProyecto= mostrarcodigoPresuProyecto;
	}

	public Boolean getActivarcodigoPresuProyecto() {
		return this.activarcodigoPresuProyecto;
	}

	public void setActivarcodigoPresuProyecto(Boolean activarcodigoPresuProyecto) {
		this.activarcodigoPresuProyecto= activarcodigoPresuProyecto;
	}

	public Border setResaltarnombrePresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarnombrePresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresuProyecto() {
		return this.resaltarnombrePresuProyecto;
	}

	public void setResaltarnombrePresuProyecto(Border borderResaltar) {
		this.resaltarnombrePresuProyecto= borderResaltar;
	}

	public Boolean getMostrarnombrePresuProyecto() {
		return this.mostrarnombrePresuProyecto;
	}

	public void setMostrarnombrePresuProyecto(Boolean mostrarnombrePresuProyecto) {
		this.mostrarnombrePresuProyecto= mostrarnombrePresuProyecto;
	}

	public Boolean getActivarnombrePresuProyecto() {
		return this.activarnombrePresuProyecto;
	}

	public void setActivarnombrePresuProyecto(Boolean activarnombrePresuProyecto) {
		this.activarnombrePresuProyecto= activarnombrePresuProyecto;
	}

	public Border setResaltarid_presu_tipo_proyectoPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarid_presu_tipo_proyectoPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_tipo_proyectoPresuProyecto() {
		return this.resaltarid_presu_tipo_proyectoPresuProyecto;
	}

	public void setResaltarid_presu_tipo_proyectoPresuProyecto(Border borderResaltar) {
		this.resaltarid_presu_tipo_proyectoPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarid_presu_tipo_proyectoPresuProyecto() {
		return this.mostrarid_presu_tipo_proyectoPresuProyecto;
	}

	public void setMostrarid_presu_tipo_proyectoPresuProyecto(Boolean mostrarid_presu_tipo_proyectoPresuProyecto) {
		this.mostrarid_presu_tipo_proyectoPresuProyecto= mostrarid_presu_tipo_proyectoPresuProyecto;
	}

	public Boolean getActivarid_presu_tipo_proyectoPresuProyecto() {
		return this.activarid_presu_tipo_proyectoPresuProyecto;
	}

	public void setActivarid_presu_tipo_proyectoPresuProyecto(Boolean activarid_presu_tipo_proyectoPresuProyecto) {
		this.activarid_presu_tipo_proyectoPresuProyecto= activarid_presu_tipo_proyectoPresuProyecto;
	}

	public Boolean getCargarid_presu_tipo_proyectoPresuProyecto() {
		return this.cargarid_presu_tipo_proyectoPresuProyecto;
	}

	public void setCargarid_presu_tipo_proyectoPresuProyecto(Boolean cargarid_presu_tipo_proyectoPresuProyecto) {
		this.cargarid_presu_tipo_proyectoPresuProyecto= cargarid_presu_tipo_proyectoPresuProyecto;
	}

	public Border setResaltarid_centro_costoPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoPresuProyecto() {
		return this.resaltarid_centro_costoPresuProyecto;
	}

	public void setResaltarid_centro_costoPresuProyecto(Border borderResaltar) {
		this.resaltarid_centro_costoPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoPresuProyecto() {
		return this.mostrarid_centro_costoPresuProyecto;
	}

	public void setMostrarid_centro_costoPresuProyecto(Boolean mostrarid_centro_costoPresuProyecto) {
		this.mostrarid_centro_costoPresuProyecto= mostrarid_centro_costoPresuProyecto;
	}

	public Boolean getActivarid_centro_costoPresuProyecto() {
		return this.activarid_centro_costoPresuProyecto;
	}

	public void setActivarid_centro_costoPresuProyecto(Boolean activarid_centro_costoPresuProyecto) {
		this.activarid_centro_costoPresuProyecto= activarid_centro_costoPresuProyecto;
	}

	public Boolean getCargarid_centro_costoPresuProyecto() {
		return this.cargarid_centro_costoPresuProyecto;
	}

	public void setCargarid_centro_costoPresuProyecto(Boolean cargarid_centro_costoPresuProyecto) {
		this.cargarid_centro_costoPresuProyecto= cargarid_centro_costoPresuProyecto;
	}

	public Border setResaltarfechaPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarfechaPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPresuProyecto() {
		return this.resaltarfechaPresuProyecto;
	}

	public void setResaltarfechaPresuProyecto(Border borderResaltar) {
		this.resaltarfechaPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarfechaPresuProyecto() {
		return this.mostrarfechaPresuProyecto;
	}

	public void setMostrarfechaPresuProyecto(Boolean mostrarfechaPresuProyecto) {
		this.mostrarfechaPresuProyecto= mostrarfechaPresuProyecto;
	}

	public Boolean getActivarfechaPresuProyecto() {
		return this.activarfechaPresuProyecto;
	}

	public void setActivarfechaPresuProyecto(Boolean activarfechaPresuProyecto) {
		this.activarfechaPresuProyecto= activarfechaPresuProyecto;
	}

	public Border setResaltarvalorPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarvalorPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresuProyecto() {
		return this.resaltarvalorPresuProyecto;
	}

	public void setResaltarvalorPresuProyecto(Border borderResaltar) {
		this.resaltarvalorPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarvalorPresuProyecto() {
		return this.mostrarvalorPresuProyecto;
	}

	public void setMostrarvalorPresuProyecto(Boolean mostrarvalorPresuProyecto) {
		this.mostrarvalorPresuProyecto= mostrarvalorPresuProyecto;
	}

	public Boolean getActivarvalorPresuProyecto() {
		return this.activarvalorPresuProyecto;
	}

	public void setActivarvalorPresuProyecto(Boolean activarvalorPresuProyecto) {
		this.activarvalorPresuProyecto= activarvalorPresuProyecto;
	}

	public Border setResaltarid_presu_estadoPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltarid_presu_estadoPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_estadoPresuProyecto() {
		return this.resaltarid_presu_estadoPresuProyecto;
	}

	public void setResaltarid_presu_estadoPresuProyecto(Border borderResaltar) {
		this.resaltarid_presu_estadoPresuProyecto= borderResaltar;
	}

	public Boolean getMostrarid_presu_estadoPresuProyecto() {
		return this.mostrarid_presu_estadoPresuProyecto;
	}

	public void setMostrarid_presu_estadoPresuProyecto(Boolean mostrarid_presu_estadoPresuProyecto) {
		this.mostrarid_presu_estadoPresuProyecto= mostrarid_presu_estadoPresuProyecto;
	}

	public Boolean getActivarid_presu_estadoPresuProyecto() {
		return this.activarid_presu_estadoPresuProyecto;
	}

	public void setActivarid_presu_estadoPresuProyecto(Boolean activarid_presu_estadoPresuProyecto) {
		this.activarid_presu_estadoPresuProyecto= activarid_presu_estadoPresuProyecto;
	}

	public Boolean getCargarid_presu_estadoPresuProyecto() {
		return this.cargarid_presu_estadoPresuProyecto;
	}

	public void setCargarid_presu_estadoPresuProyecto(Boolean cargarid_presu_estadoPresuProyecto) {
		this.cargarid_presu_estadoPresuProyecto= cargarid_presu_estadoPresuProyecto;
	}

	public Border setResaltardescripcionPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltar);
		
		this.resaltardescripcionPresuProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPresuProyecto() {
		return this.resaltardescripcionPresuProyecto;
	}

	public void setResaltardescripcionPresuProyecto(Border borderResaltar) {
		this.resaltardescripcionPresuProyecto= borderResaltar;
	}

	public Boolean getMostrardescripcionPresuProyecto() {
		return this.mostrardescripcionPresuProyecto;
	}

	public void setMostrardescripcionPresuProyecto(Boolean mostrardescripcionPresuProyecto) {
		this.mostrardescripcionPresuProyecto= mostrardescripcionPresuProyecto;
	}

	public Boolean getActivardescripcionPresuProyecto() {
		return this.activardescripcionPresuProyecto;
	}

	public void setActivardescripcionPresuProyecto(Boolean activardescripcionPresuProyecto) {
		this.activardescripcionPresuProyecto= activardescripcionPresuProyecto;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridPresuProyecto(esInicial);
		this.setMostrarid_empresaPresuProyecto(esInicial);
		this.setMostrarid_sucursalPresuProyecto(esInicial);
		this.setMostrarid_ejercicioPresuProyecto(esInicial);
		this.setMostrarcodigoPresuProyecto(esInicial);
		this.setMostrarnombrePresuProyecto(esInicial);
		this.setMostrarid_presu_tipo_proyectoPresuProyecto(esInicial);
		this.setMostrarid_centro_costoPresuProyecto(esInicial);
		this.setMostrarfechaPresuProyecto(esInicial);
		this.setMostrarvalorPresuProyecto(esInicial);
		this.setMostrarid_presu_estadoPresuProyecto(esInicial);
		this.setMostrardescripcionPresuProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuProyectoConstantesFunciones.ID)) {
				this.setMostraridPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO)) {
				this.setMostrarid_presu_tipo_proyectoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.FECHA)) {
				this.setMostrarfechaPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDPRESUESTADO)) {
				this.setMostrarid_presu_estadoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPresuProyecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridPresuProyecto(esInicial);
		this.setActivarid_empresaPresuProyecto(esInicial);
		this.setActivarid_sucursalPresuProyecto(esInicial);
		this.setActivarid_ejercicioPresuProyecto(esInicial);
		this.setActivarcodigoPresuProyecto(esInicial);
		this.setActivarnombrePresuProyecto(esInicial);
		this.setActivarid_presu_tipo_proyectoPresuProyecto(esInicial);
		this.setActivarid_centro_costoPresuProyecto(esInicial);
		this.setActivarfechaPresuProyecto(esInicial);
		this.setActivarvalorPresuProyecto(esInicial);
		this.setActivarid_presu_estadoPresuProyecto(esInicial);
		this.setActivardescripcionPresuProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuProyectoConstantesFunciones.ID)) {
				this.setActivaridPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO)) {
				this.setActivarid_presu_tipo_proyectoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.FECHA)) {
				this.setActivarfechaPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.VALOR)) {
				this.setActivarvalorPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDPRESUESTADO)) {
				this.setActivarid_presu_estadoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPresuProyecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuProyecto(esInicial);
		this.setResaltarid_empresaPresuProyecto(esInicial);
		this.setResaltarid_sucursalPresuProyecto(esInicial);
		this.setResaltarid_ejercicioPresuProyecto(esInicial);
		this.setResaltarcodigoPresuProyecto(esInicial);
		this.setResaltarnombrePresuProyecto(esInicial);
		this.setResaltarid_presu_tipo_proyectoPresuProyecto(esInicial);
		this.setResaltarid_centro_costoPresuProyecto(esInicial);
		this.setResaltarfechaPresuProyecto(esInicial);
		this.setResaltarvalorPresuProyecto(esInicial);
		this.setResaltarid_presu_estadoPresuProyecto(esInicial);
		this.setResaltardescripcionPresuProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuProyectoConstantesFunciones.ID)) {
				this.setResaltaridPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO)) {
				this.setResaltarid_presu_tipo_proyectoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.FECHA)) {
				this.setResaltarfechaPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.IDPRESUESTADO)) {
				this.setResaltarid_presu_estadoPresuProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPresuProyecto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPresuTransferenciaPresuProyecto=null;

	public Border getResaltarPresuTransferenciaPresuProyecto() {
		return this.resaltarPresuTransferenciaPresuProyecto;
	}

	public void setResaltarPresuTransferenciaPresuProyecto(Border borderResaltarPresuTransferencia) {
		if(borderResaltarPresuTransferencia!=null) {
			this.resaltarPresuTransferenciaPresuProyecto= borderResaltarPresuTransferencia;
		}
	}

	public Border setResaltarPresuTransferenciaPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltarPresuTransferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltarPresuTransferencia);
			
		this.resaltarPresuTransferenciaPresuProyecto= borderResaltarPresuTransferencia;

		 return borderResaltarPresuTransferencia;
	}



	public Boolean mostrarPresuTransferenciaPresuProyecto=true;

	public Boolean getMostrarPresuTransferenciaPresuProyecto() {
		return this.mostrarPresuTransferenciaPresuProyecto;
	}

	public void setMostrarPresuTransferenciaPresuProyecto(Boolean visibilidadResaltarPresuTransferencia) {
		this.mostrarPresuTransferenciaPresuProyecto= visibilidadResaltarPresuTransferencia;
	}



	public Boolean activarPresuTransferenciaPresuProyecto=true;

	public Boolean gethabilitarResaltarPresuTransferenciaPresuProyecto() {
		return this.activarPresuTransferenciaPresuProyecto;
	}

	public void setActivarPresuTransferenciaPresuProyecto(Boolean habilitarResaltarPresuTransferencia) {
		this.activarPresuTransferenciaPresuProyecto= habilitarResaltarPresuTransferencia;
	}


	public Border resaltarPresuProyectoCuentaPresuProyecto=null;

	public Border getResaltarPresuProyectoCuentaPresuProyecto() {
		return this.resaltarPresuProyectoCuentaPresuProyecto;
	}

	public void setResaltarPresuProyectoCuentaPresuProyecto(Border borderResaltarPresuProyectoCuenta) {
		if(borderResaltarPresuProyectoCuenta!=null) {
			this.resaltarPresuProyectoCuentaPresuProyecto= borderResaltarPresuProyectoCuenta;
		}
	}

	public Border setResaltarPresuProyectoCuentaPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltarPresuProyectoCuenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//presuproyectoBeanSwingJInternalFrame.jTtoolBarPresuProyecto.setBorder(borderResaltarPresuProyectoCuenta);
			
		this.resaltarPresuProyectoCuentaPresuProyecto= borderResaltarPresuProyectoCuenta;

		 return borderResaltarPresuProyectoCuenta;
	}



	public Boolean mostrarPresuProyectoCuentaPresuProyecto=true;

	public Boolean getMostrarPresuProyectoCuentaPresuProyecto() {
		return this.mostrarPresuProyectoCuentaPresuProyecto;
	}

	public void setMostrarPresuProyectoCuentaPresuProyecto(Boolean visibilidadResaltarPresuProyectoCuenta) {
		this.mostrarPresuProyectoCuentaPresuProyecto= visibilidadResaltarPresuProyectoCuenta;
	}



	public Boolean activarPresuProyectoCuentaPresuProyecto=true;

	public Boolean gethabilitarResaltarPresuProyectoCuentaPresuProyecto() {
		return this.activarPresuProyectoCuentaPresuProyecto;
	}

	public void setActivarPresuProyectoCuentaPresuProyecto(Boolean habilitarResaltarPresuProyectoCuenta) {
		this.activarPresuProyectoCuentaPresuProyecto= habilitarResaltarPresuProyectoCuenta;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarPresuTransferenciaPresuProyecto(esInicial);
		this.setMostrarPresuProyectoCuentaPresuProyecto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresuTransferencia.class)) {
				this.setMostrarPresuTransferenciaPresuProyecto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresuProyectoCuenta.class)) {
				this.setMostrarPresuProyectoCuentaPresuProyecto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarPresuTransferenciaPresuProyecto(esInicial);
		this.setActivarPresuProyectoCuentaPresuProyecto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresuTransferencia.class)) {
				this.setActivarPresuTransferenciaPresuProyecto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresuProyectoCuenta.class)) {
				this.setActivarPresuProyectoCuentaPresuProyecto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPresuTransferenciaPresuProyecto(esInicial);
		this.setResaltarPresuProyectoCuentaPresuProyecto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresuTransferencia.class)) {
				this.setResaltarPresuTransferenciaPresuProyecto(esAsigna);
				continue;
			}

			if(clase.clas.equals(PresuProyectoCuenta.class)) {
				this.setResaltarPresuProyectoCuentaPresuProyecto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoPresuProyecto=true;

	public Boolean getMostrarBusquedaPorCodigoPresuProyecto() {
		return this.mostrarBusquedaPorCodigoPresuProyecto;
	}

	public void setMostrarBusquedaPorCodigoPresuProyecto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPresuProyecto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePresuProyecto=true;

	public Boolean getMostrarBusquedaPorNombrePresuProyecto() {
		return this.mostrarBusquedaPorNombrePresuProyecto;
	}

	public void setMostrarBusquedaPorNombrePresuProyecto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePresuProyecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresuProyecto=true;

	public Boolean getMostrarFK_IdEjercicioPresuProyecto() {
		return this.mostrarFK_IdEjercicioPresuProyecto;
	}

	public void setMostrarFK_IdEjercicioPresuProyecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresuProyecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresuProyecto=true;

	public Boolean getMostrarFK_IdEmpresaPresuProyecto() {
		return this.mostrarFK_IdEmpresaPresuProyecto;
	}

	public void setMostrarFK_IdEmpresaPresuProyecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresuProyecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPresuProyecto=true;

	public Boolean getMostrarFK_IdSucursalPresuProyecto() {
		return this.mostrarFK_IdSucursalPresuProyecto;
	}

	public void setMostrarFK_IdSucursalPresuProyecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPresuProyecto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPresuProyecto=true;

	public Boolean getActivarBusquedaPorCodigoPresuProyecto() {
		return this.activarBusquedaPorCodigoPresuProyecto;
	}

	public void setActivarBusquedaPorCodigoPresuProyecto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPresuProyecto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePresuProyecto=true;

	public Boolean getActivarBusquedaPorNombrePresuProyecto() {
		return this.activarBusquedaPorNombrePresuProyecto;
	}

	public void setActivarBusquedaPorNombrePresuProyecto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePresuProyecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresuProyecto=true;

	public Boolean getActivarFK_IdEjercicioPresuProyecto() {
		return this.activarFK_IdEjercicioPresuProyecto;
	}

	public void setActivarFK_IdEjercicioPresuProyecto(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresuProyecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresuProyecto=true;

	public Boolean getActivarFK_IdEmpresaPresuProyecto() {
		return this.activarFK_IdEmpresaPresuProyecto;
	}

	public void setActivarFK_IdEmpresaPresuProyecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresuProyecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPresuProyecto=true;

	public Boolean getActivarFK_IdSucursalPresuProyecto() {
		return this.activarFK_IdSucursalPresuProyecto;
	}

	public void setActivarFK_IdSucursalPresuProyecto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPresuProyecto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPresuProyecto=null;

	public Border getResaltarBusquedaPorCodigoPresuProyecto() {
		return this.resaltarBusquedaPorCodigoPresuProyecto;
	}

	public void setResaltarBusquedaPorCodigoPresuProyecto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPresuProyecto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPresuProyecto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePresuProyecto=null;

	public Border getResaltarBusquedaPorNombrePresuProyecto() {
		return this.resaltarBusquedaPorNombrePresuProyecto;
	}

	public void setResaltarBusquedaPorNombrePresuProyecto(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePresuProyecto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePresuProyecto= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresuProyecto=null;

	public Border getResaltarFK_IdEjercicioPresuProyecto() {
		return this.resaltarFK_IdEjercicioPresuProyecto;
	}

	public void setResaltarFK_IdEjercicioPresuProyecto(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresuProyecto= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresuProyecto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresuProyecto=null;

	public Border getResaltarFK_IdEmpresaPresuProyecto() {
		return this.resaltarFK_IdEmpresaPresuProyecto;
	}

	public void setResaltarFK_IdEmpresaPresuProyecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresuProyecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresuProyecto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPresuProyecto=null;

	public Border getResaltarFK_IdSucursalPresuProyecto() {
		return this.resaltarFK_IdSucursalPresuProyecto;
	}

	public void setResaltarFK_IdSucursalPresuProyecto(Border borderResaltar) {
		this.resaltarFK_IdSucursalPresuProyecto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPresuProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoBeanSwingJInternalFrame presuproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPresuProyecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}