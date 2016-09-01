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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.ProcesoMayorizarDiarioConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoMayorizarDiarioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoMayorizarDiarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoMayorizarDiarioConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoMayorizarDiario";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoMayorizarDiario"+ProcesoMayorizarDiarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoMayorizarDiarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoMayorizarDiarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"_"+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoMayorizarDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"_"+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"_"+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoMayorizarDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"_"+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoMayorizarDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoMayorizarDiarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoMayorizarDiarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoMayorizarDiarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoMayorizarDiarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoMayorizarDiarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoMayorizarDiarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Mayorizar Diarioes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Mayorizar Diario";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Mayorizar Diario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoMayorizarDiario";
	public static final String OBJECTNAME="procesomayorizardiario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="proceso_mayorizar_diario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesomayorizardiario from "+ProcesoMayorizarDiarioConstantesFunciones.SPERSISTENCENAME+" procesomayorizardiario";
	public static String QUERYSELECTNATIVE="select "+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".id,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".version_row,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".id_ejercicio,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".fecha_inicio,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".fecha_fin,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".codigo,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".fecha,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".beneficiario,"+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME+".valor from "+ProcesoMayorizarDiarioConstantesFunciones.SCHEMA+"."+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME;//+" as "+ProcesoMayorizarDiarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String CODIGO= "codigo";
    public static final String FECHA= "fecha";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String VALOR= "valor";
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
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getProcesoMayorizarDiarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAINICIO)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAFIN)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHA)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(ProcesoMayorizarDiarioConstantesFunciones.VALOR)) {sLabelColumna=ProcesoMayorizarDiarioConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoMayorizarDiarioDescripcion(ProcesoMayorizarDiario procesomayorizardiario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesomayorizardiario !=null/* && procesomayorizardiario.getId()!=0*/) {
			sDescripcion=procesomayorizardiario.getId().toString()+"-"+procesomayorizardiario.getcodigo();//procesomayorizardiarioprocesomayorizardiario.getId().toString().trim()+"-"+procesomayorizardiario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoMayorizarDiarioDescripcionDetallado(ProcesoMayorizarDiario procesomayorizardiario) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.ID+"=";
		sDescripcion+=procesomayorizardiario.getId().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesomayorizardiario.getVersionRow().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesomayorizardiario.getid_empresa().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesomayorizardiario.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=procesomayorizardiario.getid_ejercicio().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=procesomayorizardiario.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=procesomayorizardiario.getfecha_inicio().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=procesomayorizardiario.getfecha_fin().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesomayorizardiario.getcodigo()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.FECHA+"=";
		sDescripcion+=procesomayorizardiario.getfecha().toString()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=procesomayorizardiario.getbeneficiario()+",";
		sDescripcion+=ProcesoMayorizarDiarioConstantesFunciones.VALOR+"=";
		sDescripcion+=procesomayorizardiario.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoMayorizarDiarioDescripcion(ProcesoMayorizarDiario procesomayorizardiario,String sValor) throws Exception {			
		if(procesomayorizardiario !=null) {
			
procesomayorizardiario.setcodigo(sValor);;//procesomayorizardiarioprocesomayorizardiario.getId().toString().trim()+"-"+procesomayorizardiario.getcodigo().trim();
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

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoMayorizarDiario")) {
			sNombreIndice="Tipo=  Por Codigo Por Tipo Movimiento Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoMayorizarDiario(String codigo,Long id_tipo_movimiento,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoMayorizarDiario(ProcesoMayorizarDiario procesomayorizardiario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesomayorizardiario.setcodigo(procesomayorizardiario.getcodigo().trim());
		procesomayorizardiario.setbeneficiario(procesomayorizardiario.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosProcesoMayorizarDiarios(List<ProcesoMayorizarDiario> procesomayorizardiarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoMayorizarDiario procesomayorizardiario: procesomayorizardiarios) {
			procesomayorizardiario.setcodigo(procesomayorizardiario.getcodigo().trim());
			procesomayorizardiario.setbeneficiario(procesomayorizardiario.getbeneficiario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoMayorizarDiario(ProcesoMayorizarDiario procesomayorizardiario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesomayorizardiario.getConCambioAuxiliar()) {
			procesomayorizardiario.setIsDeleted(procesomayorizardiario.getIsDeletedAuxiliar());	
			procesomayorizardiario.setIsNew(procesomayorizardiario.getIsNewAuxiliar());	
			procesomayorizardiario.setIsChanged(procesomayorizardiario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesomayorizardiario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesomayorizardiario.setIsDeletedAuxiliar(false);	
			procesomayorizardiario.setIsNewAuxiliar(false);	
			procesomayorizardiario.setIsChangedAuxiliar(false);
			
			procesomayorizardiario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoMayorizarDiarios(List<ProcesoMayorizarDiario> procesomayorizardiarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoMayorizarDiario procesomayorizardiario : procesomayorizardiarios) {
			if(conAsignarBase && procesomayorizardiario.getConCambioAuxiliar()) {
				procesomayorizardiario.setIsDeleted(procesomayorizardiario.getIsDeletedAuxiliar());	
				procesomayorizardiario.setIsNew(procesomayorizardiario.getIsNewAuxiliar());	
				procesomayorizardiario.setIsChanged(procesomayorizardiario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesomayorizardiario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesomayorizardiario.setIsDeletedAuxiliar(false);	
				procesomayorizardiario.setIsNewAuxiliar(false);	
				procesomayorizardiario.setIsChangedAuxiliar(false);
				
				procesomayorizardiario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoMayorizarDiario(ProcesoMayorizarDiario procesomayorizardiario,Boolean conEnteros) throws Exception  {
		procesomayorizardiario.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoMayorizarDiarios(List<ProcesoMayorizarDiario> procesomayorizardiarios,Boolean conEnteros) throws Exception  {
		
		for(ProcesoMayorizarDiario procesomayorizardiario: procesomayorizardiarios) {
			procesomayorizardiario.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoMayorizarDiario(List<ProcesoMayorizarDiario> procesomayorizardiarios,ProcesoMayorizarDiario procesomayorizardiarioAux) throws Exception  {
		ProcesoMayorizarDiarioConstantesFunciones.InicializarValoresProcesoMayorizarDiario(procesomayorizardiarioAux,true);
		
		for(ProcesoMayorizarDiario procesomayorizardiario: procesomayorizardiarios) {
			if(procesomayorizardiario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesomayorizardiarioAux.setvalor(procesomayorizardiarioAux.getvalor()+procesomayorizardiario.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoMayorizarDiario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoMayorizarDiarioConstantesFunciones.getArrayColumnasGlobalesProcesoMayorizarDiario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoMayorizarDiario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoMayorizarDiario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoMayorizarDiario> procesomayorizardiarios,ProcesoMayorizarDiario procesomayorizardiario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoMayorizarDiario procesomayorizardiarioAux: procesomayorizardiarios) {
			if(procesomayorizardiarioAux!=null && procesomayorizardiario!=null) {
				if((procesomayorizardiarioAux.getId()==null && procesomayorizardiario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesomayorizardiarioAux.getId()!=null && procesomayorizardiario.getId()!=null){
					if(procesomayorizardiarioAux.getId().equals(procesomayorizardiario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoMayorizarDiario(List<ProcesoMayorizarDiario> procesomayorizardiarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(ProcesoMayorizarDiario procesomayorizardiario: procesomayorizardiarios) {			
			if(procesomayorizardiario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=procesomayorizardiario.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoMayorizarDiario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoMayorizarDiario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoMayorizarDiario() throws Exception  {
		return ProcesoMayorizarDiarioConstantesFunciones.getTiposSeleccionarProcesoMayorizarDiario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoMayorizarDiario(Boolean conFk) throws Exception  {
		return ProcesoMayorizarDiarioConstantesFunciones.getTiposSeleccionarProcesoMayorizarDiario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoMayorizarDiario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoMayorizarDiarioConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(ProcesoMayorizarDiarioConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoMayorizarDiario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoMayorizarDiario(ProcesoMayorizarDiario procesomayorizardiarioAux) throws Exception {
		
			procesomayorizardiarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesomayorizardiarioAux.getEmpresa()));
			procesomayorizardiarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesomayorizardiarioAux.getSucursal()));
			procesomayorizardiarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesomayorizardiarioAux.getEjercicio()));
			procesomayorizardiarioAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(procesomayorizardiarioAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoMayorizarDiario(List<ProcesoMayorizarDiario> procesomayorizardiariosTemp) throws Exception {
		for(ProcesoMayorizarDiario procesomayorizardiarioAux:procesomayorizardiariosTemp) {
			
			procesomayorizardiarioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesomayorizardiarioAux.getEmpresa()));
			procesomayorizardiarioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesomayorizardiarioAux.getSucursal()));
			procesomayorizardiarioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesomayorizardiarioAux.getEjercicio()));
			procesomayorizardiarioAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(procesomayorizardiarioAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoMayorizarDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoMovimiento.class));
				
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
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoMayorizarDiario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoMayorizarDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoMayorizarDiarioConstantesFunciones.getClassesRelationshipsOfProcesoMayorizarDiario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoMayorizarDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoMayorizarDiario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoMayorizarDiarioConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoMayorizarDiario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoMayorizarDiario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(ProcesoMayorizarDiario procesomayorizardiario,List<ProcesoMayorizarDiario> procesomayorizardiarios,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoMayorizarDiario procesomayorizardiario,List<ProcesoMayorizarDiario> procesomayorizardiarios) throws Exception {
		try	{			
			for(ProcesoMayorizarDiario procesomayorizardiarioLocal:procesomayorizardiarios) {
				if(procesomayorizardiarioLocal.getId().equals(procesomayorizardiario.getId())) {
					procesomayorizardiarioLocal.setIsSelected(procesomayorizardiario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoMayorizarDiario(List<ProcesoMayorizarDiario> procesomayorizardiariosAux) throws Exception {
		//this.procesomayorizardiariosAux=procesomayorizardiariosAux;
		
		for(ProcesoMayorizarDiario procesomayorizardiarioAux:procesomayorizardiariosAux) {
			if(procesomayorizardiarioAux.getIsChanged()) {
				procesomayorizardiarioAux.setIsChanged(false);
			}		
			
			if(procesomayorizardiarioAux.getIsNew()) {
				procesomayorizardiarioAux.setIsNew(false);
			}	
			
			if(procesomayorizardiarioAux.getIsDeleted()) {
				procesomayorizardiarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoMayorizarDiario(ProcesoMayorizarDiario procesomayorizardiarioAux) throws Exception {
		//this.procesomayorizardiarioAux=procesomayorizardiarioAux;
		
			if(procesomayorizardiarioAux.getIsChanged()) {
				procesomayorizardiarioAux.setIsChanged(false);
			}		
			
			if(procesomayorizardiarioAux.getIsNew()) {
				procesomayorizardiarioAux.setIsNew(false);
			}	
			
			if(procesomayorizardiarioAux.getIsDeleted()) {
				procesomayorizardiarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoMayorizarDiario procesomayorizardiarioAsignar,ProcesoMayorizarDiario procesomayorizardiario) throws Exception {
		procesomayorizardiarioAsignar.setId(procesomayorizardiario.getId());	
		procesomayorizardiarioAsignar.setVersionRow(procesomayorizardiario.getVersionRow());	
		procesomayorizardiarioAsignar.setcodigo(procesomayorizardiario.getcodigo());	
		procesomayorizardiarioAsignar.setfecha(procesomayorizardiario.getfecha());	
		procesomayorizardiarioAsignar.setbeneficiario(procesomayorizardiario.getbeneficiario());	
		procesomayorizardiarioAsignar.setvalor(procesomayorizardiario.getvalor());	
	}
	
	public static void inicializarProcesoMayorizarDiario(ProcesoMayorizarDiario procesomayorizardiario) throws Exception {
		try {
				procesomayorizardiario.setId(0L);	
					
				procesomayorizardiario.setcodigo("");	
				procesomayorizardiario.setfecha(new Date());	
				procesomayorizardiario.setbeneficiario("");	
				procesomayorizardiario.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoMayorizarDiario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoMayorizarDiarioConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoMayorizarDiario(String sTipo,Row row,Workbook workbook,ProcesoMayorizarDiario procesomayorizardiario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesomayorizardiario.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoMayorizarDiario="";
	
	public String getsFinalQueryProcesoMayorizarDiario() {
		return this.sFinalQueryProcesoMayorizarDiario;
	}
	
	public void setsFinalQueryProcesoMayorizarDiario(String sFinalQueryProcesoMayorizarDiario) {
		this.sFinalQueryProcesoMayorizarDiario= sFinalQueryProcesoMayorizarDiario;
	}
	
	public Border resaltarSeleccionarProcesoMayorizarDiario=null;
	
	public Border setResaltarSeleccionarProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoMayorizarDiario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoMayorizarDiario() {
		return this.resaltarSeleccionarProcesoMayorizarDiario;
	}
	
	public void setResaltarSeleccionarProcesoMayorizarDiario(Border borderResaltarSeleccionarProcesoMayorizarDiario) {
		this.resaltarSeleccionarProcesoMayorizarDiario= borderResaltarSeleccionarProcesoMayorizarDiario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoMayorizarDiario=null;
	public Boolean mostraridProcesoMayorizarDiario=true;
	public Boolean activaridProcesoMayorizarDiario=true;

	public Border resaltarid_empresaProcesoMayorizarDiario=null;
	public Boolean mostrarid_empresaProcesoMayorizarDiario=true;
	public Boolean activarid_empresaProcesoMayorizarDiario=true;
	public Boolean cargarid_empresaProcesoMayorizarDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoMayorizarDiario=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoMayorizarDiario=null;
	public Boolean mostrarid_sucursalProcesoMayorizarDiario=true;
	public Boolean activarid_sucursalProcesoMayorizarDiario=true;
	public Boolean cargarid_sucursalProcesoMayorizarDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoMayorizarDiario=false;//ConEventDepend=true

	public Border resaltarid_ejercicioProcesoMayorizarDiario=null;
	public Boolean mostrarid_ejercicioProcesoMayorizarDiario=true;
	public Boolean activarid_ejercicioProcesoMayorizarDiario=true;
	public Boolean cargarid_ejercicioProcesoMayorizarDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProcesoMayorizarDiario=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoProcesoMayorizarDiario=null;
	public Boolean mostrarid_tipo_movimientoProcesoMayorizarDiario=true;
	public Boolean activarid_tipo_movimientoProcesoMayorizarDiario=true;
	public Boolean cargarid_tipo_movimientoProcesoMayorizarDiario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoProcesoMayorizarDiario=false;//ConEventDepend=true

	public Border resaltarfecha_inicioProcesoMayorizarDiario=null;
	public Boolean mostrarfecha_inicioProcesoMayorizarDiario=true;
	public Boolean activarfecha_inicioProcesoMayorizarDiario=true;

	public Border resaltarfecha_finProcesoMayorizarDiario=null;
	public Boolean mostrarfecha_finProcesoMayorizarDiario=true;
	public Boolean activarfecha_finProcesoMayorizarDiario=true;

	public Border resaltarcodigoProcesoMayorizarDiario=null;
	public Boolean mostrarcodigoProcesoMayorizarDiario=true;
	public Boolean activarcodigoProcesoMayorizarDiario=true;

	public Border resaltarfechaProcesoMayorizarDiario=null;
	public Boolean mostrarfechaProcesoMayorizarDiario=true;
	public Boolean activarfechaProcesoMayorizarDiario=true;

	public Border resaltarbeneficiarioProcesoMayorizarDiario=null;
	public Boolean mostrarbeneficiarioProcesoMayorizarDiario=true;
	public Boolean activarbeneficiarioProcesoMayorizarDiario=true;

	public Border resaltarvalorProcesoMayorizarDiario=null;
	public Boolean mostrarvalorProcesoMayorizarDiario=true;
	public Boolean activarvalorProcesoMayorizarDiario=true;

	
	

	public Border setResaltaridProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltaridProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoMayorizarDiario() {
		return this.resaltaridProcesoMayorizarDiario;
	}

	public void setResaltaridProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltaridProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostraridProcesoMayorizarDiario() {
		return this.mostraridProcesoMayorizarDiario;
	}

	public void setMostraridProcesoMayorizarDiario(Boolean mostraridProcesoMayorizarDiario) {
		this.mostraridProcesoMayorizarDiario= mostraridProcesoMayorizarDiario;
	}

	public Boolean getActivaridProcesoMayorizarDiario() {
		return this.activaridProcesoMayorizarDiario;
	}

	public void setActivaridProcesoMayorizarDiario(Boolean activaridProcesoMayorizarDiario) {
		this.activaridProcesoMayorizarDiario= activaridProcesoMayorizarDiario;
	}

	public Border setResaltarid_empresaProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoMayorizarDiario() {
		return this.resaltarid_empresaProcesoMayorizarDiario;
	}

	public void setResaltarid_empresaProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarid_empresaProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoMayorizarDiario() {
		return this.mostrarid_empresaProcesoMayorizarDiario;
	}

	public void setMostrarid_empresaProcesoMayorizarDiario(Boolean mostrarid_empresaProcesoMayorizarDiario) {
		this.mostrarid_empresaProcesoMayorizarDiario= mostrarid_empresaProcesoMayorizarDiario;
	}

	public Boolean getActivarid_empresaProcesoMayorizarDiario() {
		return this.activarid_empresaProcesoMayorizarDiario;
	}

	public void setActivarid_empresaProcesoMayorizarDiario(Boolean activarid_empresaProcesoMayorizarDiario) {
		this.activarid_empresaProcesoMayorizarDiario= activarid_empresaProcesoMayorizarDiario;
	}

	public Boolean getCargarid_empresaProcesoMayorizarDiario() {
		return this.cargarid_empresaProcesoMayorizarDiario;
	}

	public void setCargarid_empresaProcesoMayorizarDiario(Boolean cargarid_empresaProcesoMayorizarDiario) {
		this.cargarid_empresaProcesoMayorizarDiario= cargarid_empresaProcesoMayorizarDiario;
	}

	public Border setResaltarid_sucursalProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoMayorizarDiario() {
		return this.resaltarid_sucursalProcesoMayorizarDiario;
	}

	public void setResaltarid_sucursalProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarid_sucursalProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoMayorizarDiario() {
		return this.mostrarid_sucursalProcesoMayorizarDiario;
	}

	public void setMostrarid_sucursalProcesoMayorizarDiario(Boolean mostrarid_sucursalProcesoMayorizarDiario) {
		this.mostrarid_sucursalProcesoMayorizarDiario= mostrarid_sucursalProcesoMayorizarDiario;
	}

	public Boolean getActivarid_sucursalProcesoMayorizarDiario() {
		return this.activarid_sucursalProcesoMayorizarDiario;
	}

	public void setActivarid_sucursalProcesoMayorizarDiario(Boolean activarid_sucursalProcesoMayorizarDiario) {
		this.activarid_sucursalProcesoMayorizarDiario= activarid_sucursalProcesoMayorizarDiario;
	}

	public Boolean getCargarid_sucursalProcesoMayorizarDiario() {
		return this.cargarid_sucursalProcesoMayorizarDiario;
	}

	public void setCargarid_sucursalProcesoMayorizarDiario(Boolean cargarid_sucursalProcesoMayorizarDiario) {
		this.cargarid_sucursalProcesoMayorizarDiario= cargarid_sucursalProcesoMayorizarDiario;
	}

	public Border setResaltarid_ejercicioProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProcesoMayorizarDiario() {
		return this.resaltarid_ejercicioProcesoMayorizarDiario;
	}

	public void setResaltarid_ejercicioProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarid_ejercicioProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProcesoMayorizarDiario() {
		return this.mostrarid_ejercicioProcesoMayorizarDiario;
	}

	public void setMostrarid_ejercicioProcesoMayorizarDiario(Boolean mostrarid_ejercicioProcesoMayorizarDiario) {
		this.mostrarid_ejercicioProcesoMayorizarDiario= mostrarid_ejercicioProcesoMayorizarDiario;
	}

	public Boolean getActivarid_ejercicioProcesoMayorizarDiario() {
		return this.activarid_ejercicioProcesoMayorizarDiario;
	}

	public void setActivarid_ejercicioProcesoMayorizarDiario(Boolean activarid_ejercicioProcesoMayorizarDiario) {
		this.activarid_ejercicioProcesoMayorizarDiario= activarid_ejercicioProcesoMayorizarDiario;
	}

	public Boolean getCargarid_ejercicioProcesoMayorizarDiario() {
		return this.cargarid_ejercicioProcesoMayorizarDiario;
	}

	public void setCargarid_ejercicioProcesoMayorizarDiario(Boolean cargarid_ejercicioProcesoMayorizarDiario) {
		this.cargarid_ejercicioProcesoMayorizarDiario= cargarid_ejercicioProcesoMayorizarDiario;
	}

	public Border setResaltarid_tipo_movimientoProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoProcesoMayorizarDiario() {
		return this.resaltarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public void setResaltarid_tipo_movimientoProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarid_tipo_movimientoProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoProcesoMayorizarDiario() {
		return this.mostrarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public void setMostrarid_tipo_movimientoProcesoMayorizarDiario(Boolean mostrarid_tipo_movimientoProcesoMayorizarDiario) {
		this.mostrarid_tipo_movimientoProcesoMayorizarDiario= mostrarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public Boolean getActivarid_tipo_movimientoProcesoMayorizarDiario() {
		return this.activarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public void setActivarid_tipo_movimientoProcesoMayorizarDiario(Boolean activarid_tipo_movimientoProcesoMayorizarDiario) {
		this.activarid_tipo_movimientoProcesoMayorizarDiario= activarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public Boolean getCargarid_tipo_movimientoProcesoMayorizarDiario() {
		return this.cargarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public void setCargarid_tipo_movimientoProcesoMayorizarDiario(Boolean cargarid_tipo_movimientoProcesoMayorizarDiario) {
		this.cargarid_tipo_movimientoProcesoMayorizarDiario= cargarid_tipo_movimientoProcesoMayorizarDiario;
	}

	public Border setResaltarfecha_inicioProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioProcesoMayorizarDiario() {
		return this.resaltarfecha_inicioProcesoMayorizarDiario;
	}

	public void setResaltarfecha_inicioProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarfecha_inicioProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioProcesoMayorizarDiario() {
		return this.mostrarfecha_inicioProcesoMayorizarDiario;
	}

	public void setMostrarfecha_inicioProcesoMayorizarDiario(Boolean mostrarfecha_inicioProcesoMayorizarDiario) {
		this.mostrarfecha_inicioProcesoMayorizarDiario= mostrarfecha_inicioProcesoMayorizarDiario;
	}

	public Boolean getActivarfecha_inicioProcesoMayorizarDiario() {
		return this.activarfecha_inicioProcesoMayorizarDiario;
	}

	public void setActivarfecha_inicioProcesoMayorizarDiario(Boolean activarfecha_inicioProcesoMayorizarDiario) {
		this.activarfecha_inicioProcesoMayorizarDiario= activarfecha_inicioProcesoMayorizarDiario;
	}

	public Border setResaltarfecha_finProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarfecha_finProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finProcesoMayorizarDiario() {
		return this.resaltarfecha_finProcesoMayorizarDiario;
	}

	public void setResaltarfecha_finProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarfecha_finProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarfecha_finProcesoMayorizarDiario() {
		return this.mostrarfecha_finProcesoMayorizarDiario;
	}

	public void setMostrarfecha_finProcesoMayorizarDiario(Boolean mostrarfecha_finProcesoMayorizarDiario) {
		this.mostrarfecha_finProcesoMayorizarDiario= mostrarfecha_finProcesoMayorizarDiario;
	}

	public Boolean getActivarfecha_finProcesoMayorizarDiario() {
		return this.activarfecha_finProcesoMayorizarDiario;
	}

	public void setActivarfecha_finProcesoMayorizarDiario(Boolean activarfecha_finProcesoMayorizarDiario) {
		this.activarfecha_finProcesoMayorizarDiario= activarfecha_finProcesoMayorizarDiario;
	}

	public Border setResaltarcodigoProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoMayorizarDiario() {
		return this.resaltarcodigoProcesoMayorizarDiario;
	}

	public void setResaltarcodigoProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarcodigoProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoMayorizarDiario() {
		return this.mostrarcodigoProcesoMayorizarDiario;
	}

	public void setMostrarcodigoProcesoMayorizarDiario(Boolean mostrarcodigoProcesoMayorizarDiario) {
		this.mostrarcodigoProcesoMayorizarDiario= mostrarcodigoProcesoMayorizarDiario;
	}

	public Boolean getActivarcodigoProcesoMayorizarDiario() {
		return this.activarcodigoProcesoMayorizarDiario;
	}

	public void setActivarcodigoProcesoMayorizarDiario(Boolean activarcodigoProcesoMayorizarDiario) {
		this.activarcodigoProcesoMayorizarDiario= activarcodigoProcesoMayorizarDiario;
	}

	public Border setResaltarfechaProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoMayorizarDiario() {
		return this.resaltarfechaProcesoMayorizarDiario;
	}

	public void setResaltarfechaProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarfechaProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoMayorizarDiario() {
		return this.mostrarfechaProcesoMayorizarDiario;
	}

	public void setMostrarfechaProcesoMayorizarDiario(Boolean mostrarfechaProcesoMayorizarDiario) {
		this.mostrarfechaProcesoMayorizarDiario= mostrarfechaProcesoMayorizarDiario;
	}

	public Boolean getActivarfechaProcesoMayorizarDiario() {
		return this.activarfechaProcesoMayorizarDiario;
	}

	public void setActivarfechaProcesoMayorizarDiario(Boolean activarfechaProcesoMayorizarDiario) {
		this.activarfechaProcesoMayorizarDiario= activarfechaProcesoMayorizarDiario;
	}

	public Border setResaltarbeneficiarioProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioProcesoMayorizarDiario() {
		return this.resaltarbeneficiarioProcesoMayorizarDiario;
	}

	public void setResaltarbeneficiarioProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarbeneficiarioProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioProcesoMayorizarDiario() {
		return this.mostrarbeneficiarioProcesoMayorizarDiario;
	}

	public void setMostrarbeneficiarioProcesoMayorizarDiario(Boolean mostrarbeneficiarioProcesoMayorizarDiario) {
		this.mostrarbeneficiarioProcesoMayorizarDiario= mostrarbeneficiarioProcesoMayorizarDiario;
	}

	public Boolean getActivarbeneficiarioProcesoMayorizarDiario() {
		return this.activarbeneficiarioProcesoMayorizarDiario;
	}

	public void setActivarbeneficiarioProcesoMayorizarDiario(Boolean activarbeneficiarioProcesoMayorizarDiario) {
		this.activarbeneficiarioProcesoMayorizarDiario= activarbeneficiarioProcesoMayorizarDiario;
	}

	public Border setResaltarvalorProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesomayorizardiarioBeanSwingJInternalFrame.jTtoolBarProcesoMayorizarDiario.setBorder(borderResaltar);
		
		this.resaltarvalorProcesoMayorizarDiario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorProcesoMayorizarDiario() {
		return this.resaltarvalorProcesoMayorizarDiario;
	}

	public void setResaltarvalorProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarvalorProcesoMayorizarDiario= borderResaltar;
	}

	public Boolean getMostrarvalorProcesoMayorizarDiario() {
		return this.mostrarvalorProcesoMayorizarDiario;
	}

	public void setMostrarvalorProcesoMayorizarDiario(Boolean mostrarvalorProcesoMayorizarDiario) {
		this.mostrarvalorProcesoMayorizarDiario= mostrarvalorProcesoMayorizarDiario;
	}

	public Boolean getActivarvalorProcesoMayorizarDiario() {
		return this.activarvalorProcesoMayorizarDiario;
	}

	public void setActivarvalorProcesoMayorizarDiario(Boolean activarvalorProcesoMayorizarDiario) {
		this.activarvalorProcesoMayorizarDiario= activarvalorProcesoMayorizarDiario;
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
		
		
		this.setMostraridProcesoMayorizarDiario(esInicial);
		this.setMostrarid_empresaProcesoMayorizarDiario(esInicial);
		this.setMostrarid_sucursalProcesoMayorizarDiario(esInicial);
		this.setMostrarid_ejercicioProcesoMayorizarDiario(esInicial);
		this.setMostrarid_tipo_movimientoProcesoMayorizarDiario(esInicial);
		this.setMostrarfecha_inicioProcesoMayorizarDiario(esInicial);
		this.setMostrarfecha_finProcesoMayorizarDiario(esInicial);
		this.setMostrarcodigoProcesoMayorizarDiario(esInicial);
		this.setMostrarfechaProcesoMayorizarDiario(esInicial);
		this.setMostrarbeneficiarioProcesoMayorizarDiario(esInicial);
		this.setMostrarvalorProcesoMayorizarDiario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.ID)) {
				this.setMostraridProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.VALOR)) {
				this.setMostrarvalorProcesoMayorizarDiario(esAsigna);
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
		
		
		this.setActivaridProcesoMayorizarDiario(esInicial);
		this.setActivarid_empresaProcesoMayorizarDiario(esInicial);
		this.setActivarid_sucursalProcesoMayorizarDiario(esInicial);
		this.setActivarid_ejercicioProcesoMayorizarDiario(esInicial);
		this.setActivarid_tipo_movimientoProcesoMayorizarDiario(esInicial);
		this.setActivarfecha_inicioProcesoMayorizarDiario(esInicial);
		this.setActivarfecha_finProcesoMayorizarDiario(esInicial);
		this.setActivarcodigoProcesoMayorizarDiario(esInicial);
		this.setActivarfechaProcesoMayorizarDiario(esInicial);
		this.setActivarbeneficiarioProcesoMayorizarDiario(esInicial);
		this.setActivarvalorProcesoMayorizarDiario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.ID)) {
				this.setActivaridProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.VALOR)) {
				this.setActivarvalorProcesoMayorizarDiario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoMayorizarDiario(esInicial);
		this.setResaltarid_empresaProcesoMayorizarDiario(esInicial);
		this.setResaltarid_sucursalProcesoMayorizarDiario(esInicial);
		this.setResaltarid_ejercicioProcesoMayorizarDiario(esInicial);
		this.setResaltarid_tipo_movimientoProcesoMayorizarDiario(esInicial);
		this.setResaltarfecha_inicioProcesoMayorizarDiario(esInicial);
		this.setResaltarfecha_finProcesoMayorizarDiario(esInicial);
		this.setResaltarcodigoProcesoMayorizarDiario(esInicial);
		this.setResaltarfechaProcesoMayorizarDiario(esInicial);
		this.setResaltarbeneficiarioProcesoMayorizarDiario(esInicial);
		this.setResaltarvalorProcesoMayorizarDiario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.ID)) {
				this.setResaltaridProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioProcesoMayorizarDiario(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoMayorizarDiarioConstantesFunciones.VALOR)) {
				this.setResaltarvalorProcesoMayorizarDiario(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario=true;

	public Boolean getMostrarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario() {
		return this.mostrarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario;
	}

	public void setMostrarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario=true;

	public Boolean getActivarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario() {
		return this.activarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario;
	}

	public void setActivarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario=null;

	public Border getResaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario() {
		return this.resaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario;
	}

	public void setResaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario(Border borderResaltar) {
		this.resaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario= borderResaltar;
	}

	public void setResaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoMayorizarDiarioBeanSwingJInternalFrame procesomayorizardiarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoMayorizarDiarioProcesoMayorizarDiario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}