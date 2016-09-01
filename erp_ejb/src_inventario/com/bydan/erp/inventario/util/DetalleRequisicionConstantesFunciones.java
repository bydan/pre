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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.DetalleRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleRequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleRequisicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleRequisicionConstantesFunciones extends DetalleRequisicionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleRequisicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleRequisicion"+DetalleRequisicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleRequisicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleRequisicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleRequisicionConstantesFunciones.SCHEMA+"_"+DetalleRequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleRequisicionConstantesFunciones.SCHEMA+"_"+DetalleRequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleRequisicionConstantesFunciones.SCHEMA+"_"+DetalleRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleRequisicionConstantesFunciones.SCHEMA+"_"+DetalleRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleRequisicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleRequisicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleRequisicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleRequisicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Requisicions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Requisicion";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Requisicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleRequisicion";
	public static final String OBJECTNAME="detallerequisicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_requisicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallerequisicion from "+DetalleRequisicionConstantesFunciones.SPERSISTENCENAME+" detallerequisicion";
	public static String QUERYSELECTNATIVE="select "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".version_row,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_requisicion,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_periodo,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_anio,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_mes,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_bodega,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_producto,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_unidad,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".cantidad,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".descripcion,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".fecha_autoriza from "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME;//+" as "+DetalleRequisicionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleRequisicionConstantesFuncionesAdditional detallerequisicionConstantesFuncionesAdditional=null;
	
	public DetalleRequisicionConstantesFuncionesAdditional getDetalleRequisicionConstantesFuncionesAdditional() {
		return this.detallerequisicionConstantesFuncionesAdditional;
	}
	
	public void setDetalleRequisicionConstantesFuncionesAdditional(DetalleRequisicionConstantesFuncionesAdditional detallerequisicionConstantesFuncionesAdditional) {
		try {
			this.detallerequisicionConstantesFuncionesAdditional=detallerequisicionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDREQUISICION= "id_requisicion";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHAAUTORIZA= "fecha_autoriza";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDREQUISICION= "Requisicion";
		public static final String LABEL_IDREQUISICION_LOWER= "Requisicion";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHAAUTORIZA= "Fecha Autorizacion";
		public static final String LABEL_FECHAAUTORIZA_LOWER= "Fecha Autoriza";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDetalleRequisicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDREQUISICION)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDREQUISICION;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDANIO)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDMES)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleRequisicionConstantesFunciones.FECHAAUTORIZA)) {sLabelColumna=DetalleRequisicionConstantesFunciones.LABEL_FECHAAUTORIZA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleRequisicionDescripcion(DetalleRequisicion detallerequisicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallerequisicion !=null/* && detallerequisicion.getId()!=0*/) {
			if(detallerequisicion.getId()!=null) {
				sDescripcion=detallerequisicion.getId().toString();
			}//detallerequisiciondetallerequisicion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleRequisicionDescripcionDetallado(DetalleRequisicion detallerequisicion) {
		String sDescripcion="";
			
		sDescripcion+=DetalleRequisicionConstantesFunciones.ID+"=";
		sDescripcion+=detallerequisicion.getId().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallerequisicion.getVersionRow().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDREQUISICION+"=";
		sDescripcion+=detallerequisicion.getid_requisicion().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallerequisicion.getid_empresa().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallerequisicion.getid_sucursal().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallerequisicion.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallerequisicion.getid_periodo().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallerequisicion.getid_anio().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDMES+"=";
		sDescripcion+=detallerequisicion.getid_mes().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallerequisicion.getid_bodega().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallerequisicion.getid_producto().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallerequisicion.getid_unidad().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detallerequisicion.getcantidad().toString()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallerequisicion.getdescripcion()+",";
		sDescripcion+=DetalleRequisicionConstantesFunciones.FECHAAUTORIZA+"=";
		sDescripcion+=detallerequisicion.getfecha_autoriza().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleRequisicionDescripcion(DetalleRequisicion detallerequisicion,String sValor) throws Exception {			
		if(detallerequisicion !=null) {
			//detallerequisiciondetallerequisicion.getId().toString();
		}		
	}
	
		

	public static String getRequisicionDescripcion(Requisicion requisicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(requisicion!=null/*&&requisicion.getId()>0*/) {
			sDescripcion=RequisicionConstantesFunciones.getRequisicionDescripcion(requisicion);
		}

		return sDescripcion;
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdRequisicion")) {
			sNombreIndice="Tipo=  Por Requisicion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRequisicion(Long id_requisicion) {
		String sDetalleIndice=" Parametros->";
		if(id_requisicion!=null) {sDetalleIndice+=" Codigo Unico De Requisicion="+id_requisicion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleRequisicion(DetalleRequisicion detallerequisicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallerequisicion.setdescripcion(detallerequisicion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleRequisicions(List<DetalleRequisicion> detallerequisicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleRequisicion detallerequisicion: detallerequisicions) {
			detallerequisicion.setdescripcion(detallerequisicion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRequisicion(DetalleRequisicion detallerequisicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallerequisicion.getConCambioAuxiliar()) {
			detallerequisicion.setIsDeleted(detallerequisicion.getIsDeletedAuxiliar());	
			detallerequisicion.setIsNew(detallerequisicion.getIsNewAuxiliar());	
			detallerequisicion.setIsChanged(detallerequisicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallerequisicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallerequisicion.setIsDeletedAuxiliar(false);	
			detallerequisicion.setIsNewAuxiliar(false);	
			detallerequisicion.setIsChangedAuxiliar(false);
			
			detallerequisicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRequisicions(List<DetalleRequisicion> detallerequisicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleRequisicion detallerequisicion : detallerequisicions) {
			if(conAsignarBase && detallerequisicion.getConCambioAuxiliar()) {
				detallerequisicion.setIsDeleted(detallerequisicion.getIsDeletedAuxiliar());	
				detallerequisicion.setIsNew(detallerequisicion.getIsNewAuxiliar());	
				detallerequisicion.setIsChanged(detallerequisicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallerequisicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallerequisicion.setIsDeletedAuxiliar(false);	
				detallerequisicion.setIsNewAuxiliar(false);	
				detallerequisicion.setIsChangedAuxiliar(false);
				
				detallerequisicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleRequisicion(DetalleRequisicion detallerequisicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallerequisicion.setcantidad(0L);
		}
	}		
	
	public static void InicializarValoresDetalleRequisicions(List<DetalleRequisicion> detallerequisicions,Boolean conEnteros) throws Exception  {
		
		for(DetalleRequisicion detallerequisicion: detallerequisicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallerequisicion.setcantidad(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleRequisicion(List<DetalleRequisicion> detallerequisicions,DetalleRequisicion detallerequisicionAux) throws Exception  {
		DetalleRequisicionConstantesFunciones.InicializarValoresDetalleRequisicion(detallerequisicionAux,true);
		
		for(DetalleRequisicion detallerequisicion: detallerequisicions) {
			if(detallerequisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallerequisicionAux.setcantidad(detallerequisicionAux.getcantidad()+detallerequisicion.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleRequisicionConstantesFunciones.getArrayColumnasGlobalesDetalleRequisicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRequisicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRequisicionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRequisicionConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleRequisicion> detallerequisicions,DetalleRequisicion detallerequisicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleRequisicion detallerequisicionAux: detallerequisicions) {
			if(detallerequisicionAux!=null && detallerequisicion!=null) {
				if((detallerequisicionAux.getId()==null && detallerequisicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallerequisicionAux.getId()!=null && detallerequisicion.getId()!=null){
					if(detallerequisicionAux.getId().equals(detallerequisicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleRequisicion(List<DetalleRequisicion> detallerequisicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleRequisicion detallerequisicion: detallerequisicions) {			
			if(detallerequisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleRequisicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_ID, DetalleRequisicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_VERSIONROW, DetalleRequisicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDREQUISICION, DetalleRequisicionConstantesFunciones.IDREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDEMPRESA, DetalleRequisicionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDSUCURSAL, DetalleRequisicionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDEJERCICIO, DetalleRequisicionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDPERIODO, DetalleRequisicionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDANIO, DetalleRequisicionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDMES, DetalleRequisicionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDBODEGA, DetalleRequisicionConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDPRODUCTO, DetalleRequisicionConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_IDUNIDAD, DetalleRequisicionConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_CANTIDAD, DetalleRequisicionConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_DESCRIPCION, DetalleRequisicionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRequisicionConstantesFunciones.LABEL_FECHAAUTORIZA, DetalleRequisicionConstantesFunciones.FECHAAUTORIZA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleRequisicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRequisicionConstantesFunciones.FECHAAUTORIZA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRequisicion() throws Exception  {
		return DetalleRequisicionConstantesFunciones.getTiposSeleccionarDetalleRequisicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRequisicion(Boolean conFk) throws Exception  {
		return DetalleRequisicionConstantesFunciones.getTiposSeleccionarDetalleRequisicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRequisicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDREQUISICION);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRequisicionConstantesFunciones.LABEL_FECHAAUTORIZA);
			reporte.setsDescripcion(DetalleRequisicionConstantesFunciones.LABEL_FECHAAUTORIZA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleRequisicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRequisicion(DetalleRequisicion detallerequisicionAux) throws Exception {
		
			detallerequisicionAux.setrequisicion_descripcion(RequisicionConstantesFunciones.getRequisicionDescripcion(detallerequisicionAux.getRequisicion()));
			detallerequisicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallerequisicionAux.getEmpresa()));
			detallerequisicionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallerequisicionAux.getSucursal()));
			detallerequisicionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallerequisicionAux.getEjercicio()));
			detallerequisicionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallerequisicionAux.getPeriodo()));
			detallerequisicionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallerequisicionAux.getAnio()));
			detallerequisicionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallerequisicionAux.getMes()));
			detallerequisicionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallerequisicionAux.getBodega()));
			detallerequisicionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallerequisicionAux.getProducto()));
			detallerequisicionAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallerequisicionAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRequisicion(List<DetalleRequisicion> detallerequisicionsTemp) throws Exception {
		for(DetalleRequisicion detallerequisicionAux:detallerequisicionsTemp) {
			
			detallerequisicionAux.setrequisicion_descripcion(RequisicionConstantesFunciones.getRequisicionDescripcion(detallerequisicionAux.getRequisicion()));
			detallerequisicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallerequisicionAux.getEmpresa()));
			detallerequisicionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallerequisicionAux.getSucursal()));
			detallerequisicionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallerequisicionAux.getEjercicio()));
			detallerequisicionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallerequisicionAux.getPeriodo()));
			detallerequisicionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallerequisicionAux.getAnio()));
			detallerequisicionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallerequisicionAux.getMes()));
			detallerequisicionAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallerequisicionAux.getBodega()));
			detallerequisicionAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallerequisicionAux.getProducto()));
			detallerequisicionAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallerequisicionAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Requisicion.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Requisicion.class)) {
						classes.add(new Classe(Requisicion.class));
					}
				}

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
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Requisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Requisicion.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Requisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Requisicion.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRequisicionConstantesFunciones.getClassesRelationshipsOfDetalleRequisicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRequisicionConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleRequisicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleRequisicion detallerequisicion,List<DetalleRequisicion> detallerequisicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleRequisicion detallerequisicionEncontrado=null;
			
			for(DetalleRequisicion detallerequisicionLocal:detallerequisicions) {
				if(detallerequisicionLocal.getId().equals(detallerequisicion.getId())) {
					detallerequisicionEncontrado=detallerequisicionLocal;
					
					detallerequisicionLocal.setIsChanged(detallerequisicion.getIsChanged());
					detallerequisicionLocal.setIsNew(detallerequisicion.getIsNew());
					detallerequisicionLocal.setIsDeleted(detallerequisicion.getIsDeleted());
					
					detallerequisicionLocal.setGeneralEntityOriginal(detallerequisicion.getGeneralEntityOriginal());
					
					detallerequisicionLocal.setId(detallerequisicion.getId());	
					detallerequisicionLocal.setVersionRow(detallerequisicion.getVersionRow());	
					detallerequisicionLocal.setid_requisicion(detallerequisicion.getid_requisicion());	
					detallerequisicionLocal.setid_empresa(detallerequisicion.getid_empresa());	
					detallerequisicionLocal.setid_sucursal(detallerequisicion.getid_sucursal());	
					detallerequisicionLocal.setid_ejercicio(detallerequisicion.getid_ejercicio());	
					detallerequisicionLocal.setid_periodo(detallerequisicion.getid_periodo());	
					detallerequisicionLocal.setid_anio(detallerequisicion.getid_anio());	
					detallerequisicionLocal.setid_mes(detallerequisicion.getid_mes());	
					detallerequisicionLocal.setid_bodega(detallerequisicion.getid_bodega());	
					detallerequisicionLocal.setid_producto(detallerequisicion.getid_producto());	
					detallerequisicionLocal.setid_unidad(detallerequisicion.getid_unidad());	
					detallerequisicionLocal.setcantidad(detallerequisicion.getcantidad());	
					detallerequisicionLocal.setdescripcion(detallerequisicion.getdescripcion());	
					detallerequisicionLocal.setfecha_autoriza(detallerequisicion.getfecha_autoriza());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallerequisicion.getIsDeleted()) {
				if(!existe) {
					detallerequisicions.add(detallerequisicion);
				}
			} else {
				if(detallerequisicionEncontrado!=null && permiteQuitar)  {
					detallerequisicions.remove(detallerequisicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleRequisicion detallerequisicion,List<DetalleRequisicion> detallerequisicions) throws Exception {
		try	{			
			for(DetalleRequisicion detallerequisicionLocal:detallerequisicions) {
				if(detallerequisicionLocal.getId().equals(detallerequisicion.getId())) {
					detallerequisicionLocal.setIsSelected(detallerequisicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleRequisicion(List<DetalleRequisicion> detallerequisicionsAux) throws Exception {
		//this.detallerequisicionsAux=detallerequisicionsAux;
		
		for(DetalleRequisicion detallerequisicionAux:detallerequisicionsAux) {
			if(detallerequisicionAux.getIsChanged()) {
				detallerequisicionAux.setIsChanged(false);
			}		
			
			if(detallerequisicionAux.getIsNew()) {
				detallerequisicionAux.setIsNew(false);
			}	
			
			if(detallerequisicionAux.getIsDeleted()) {
				detallerequisicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleRequisicion(DetalleRequisicion detallerequisicionAux) throws Exception {
		//this.detallerequisicionAux=detallerequisicionAux;
		
			if(detallerequisicionAux.getIsChanged()) {
				detallerequisicionAux.setIsChanged(false);
			}		
			
			if(detallerequisicionAux.getIsNew()) {
				detallerequisicionAux.setIsNew(false);
			}	
			
			if(detallerequisicionAux.getIsDeleted()) {
				detallerequisicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleRequisicion detallerequisicionAsignar,DetalleRequisicion detallerequisicion) throws Exception {
		detallerequisicionAsignar.setId(detallerequisicion.getId());	
		detallerequisicionAsignar.setVersionRow(detallerequisicion.getVersionRow());	
		detallerequisicionAsignar.setid_requisicion(detallerequisicion.getid_requisicion());
		detallerequisicionAsignar.setrequisicion_descripcion(detallerequisicion.getrequisicion_descripcion());	
		detallerequisicionAsignar.setid_empresa(detallerequisicion.getid_empresa());
		detallerequisicionAsignar.setempresa_descripcion(detallerequisicion.getempresa_descripcion());	
		detallerequisicionAsignar.setid_sucursal(detallerequisicion.getid_sucursal());
		detallerequisicionAsignar.setsucursal_descripcion(detallerequisicion.getsucursal_descripcion());	
		detallerequisicionAsignar.setid_ejercicio(detallerequisicion.getid_ejercicio());
		detallerequisicionAsignar.setejercicio_descripcion(detallerequisicion.getejercicio_descripcion());	
		detallerequisicionAsignar.setid_periodo(detallerequisicion.getid_periodo());
		detallerequisicionAsignar.setperiodo_descripcion(detallerequisicion.getperiodo_descripcion());	
		detallerequisicionAsignar.setid_anio(detallerequisicion.getid_anio());
		detallerequisicionAsignar.setanio_descripcion(detallerequisicion.getanio_descripcion());	
		detallerequisicionAsignar.setid_mes(detallerequisicion.getid_mes());
		detallerequisicionAsignar.setmes_descripcion(detallerequisicion.getmes_descripcion());	
		detallerequisicionAsignar.setid_bodega(detallerequisicion.getid_bodega());
		detallerequisicionAsignar.setbodega_descripcion(detallerequisicion.getbodega_descripcion());	
		detallerequisicionAsignar.setid_producto(detallerequisicion.getid_producto());
		detallerequisicionAsignar.setproducto_descripcion(detallerequisicion.getproducto_descripcion());	
		detallerequisicionAsignar.setid_unidad(detallerequisicion.getid_unidad());
		detallerequisicionAsignar.setunidad_descripcion(detallerequisicion.getunidad_descripcion());	
		detallerequisicionAsignar.setcantidad(detallerequisicion.getcantidad());	
		detallerequisicionAsignar.setdescripcion(detallerequisicion.getdescripcion());	
		detallerequisicionAsignar.setfecha_autoriza(detallerequisicion.getfecha_autoriza());	
	}
	
	public static void inicializarDetalleRequisicion(DetalleRequisicion detallerequisicion) throws Exception {
		try {
				detallerequisicion.setId(0L);	
					
				detallerequisicion.setid_requisicion(-1L);	
				detallerequisicion.setid_empresa(-1L);	
				detallerequisicion.setid_sucursal(-1L);	
				detallerequisicion.setid_ejercicio(-1L);	
				detallerequisicion.setid_periodo(-1L);	
				detallerequisicion.setid_anio(null);	
				detallerequisicion.setid_mes(null);	
				detallerequisicion.setid_bodega(-1L);	
				detallerequisicion.setid_producto(-1L);	
				detallerequisicion.setid_unidad(-1L);	
				detallerequisicion.setcantidad(0L);	
				detallerequisicion.setdescripcion("");	
				detallerequisicion.setfecha_autoriza(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleRequisicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRequisicionConstantesFunciones.LABEL_FECHAAUTORIZA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleRequisicion(String sTipo,Row row,Workbook workbook,DetalleRequisicion detallerequisicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getrequisicion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallerequisicion.getfecha_autoriza());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleRequisicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleRequisicion() {
		return this.sFinalQueryDetalleRequisicion;
	}
	
	public void setsFinalQueryDetalleRequisicion(String sFinalQueryDetalleRequisicion) {
		this.sFinalQueryDetalleRequisicion= sFinalQueryDetalleRequisicion;
	}
	
	public Border resaltarSeleccionarDetalleRequisicion=null;
	
	public Border setResaltarSeleccionarDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleRequisicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleRequisicion() {
		return this.resaltarSeleccionarDetalleRequisicion;
	}
	
	public void setResaltarSeleccionarDetalleRequisicion(Border borderResaltarSeleccionarDetalleRequisicion) {
		this.resaltarSeleccionarDetalleRequisicion= borderResaltarSeleccionarDetalleRequisicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleRequisicion=null;
	public Boolean mostraridDetalleRequisicion=true;
	public Boolean activaridDetalleRequisicion=true;

	public Border resaltarid_requisicionDetalleRequisicion=null;
	public Boolean mostrarid_requisicionDetalleRequisicion=true;
	public Boolean activarid_requisicionDetalleRequisicion=true;
	public Boolean cargarid_requisicionDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_requisicionDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleRequisicion=null;
	public Boolean mostrarid_empresaDetalleRequisicion=true;
	public Boolean activarid_empresaDetalleRequisicion=true;
	public Boolean cargarid_empresaDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleRequisicion=null;
	public Boolean mostrarid_sucursalDetalleRequisicion=true;
	public Boolean activarid_sucursalDetalleRequisicion=true;
	public Boolean cargarid_sucursalDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleRequisicion=null;
	public Boolean mostrarid_ejercicioDetalleRequisicion=true;
	public Boolean activarid_ejercicioDetalleRequisicion=true;
	public Boolean cargarid_ejercicioDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleRequisicion=null;
	public Boolean mostrarid_periodoDetalleRequisicion=true;
	public Boolean activarid_periodoDetalleRequisicion=true;
	public Boolean cargarid_periodoDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleRequisicion=null;
	public Boolean mostrarid_anioDetalleRequisicion=true;
	public Boolean activarid_anioDetalleRequisicion=false;
	public Boolean cargarid_anioDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleRequisicion=null;
	public Boolean mostrarid_mesDetalleRequisicion=true;
	public Boolean activarid_mesDetalleRequisicion=false;
	public Boolean cargarid_mesDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleRequisicion=null;
	public Boolean mostrarid_bodegaDetalleRequisicion=true;
	public Boolean activarid_bodegaDetalleRequisicion=true;
	public Boolean cargarid_bodegaDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleRequisicion=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleRequisicion=null;
	public Boolean mostrarid_productoDetalleRequisicion=true;
	public Boolean activarid_productoDetalleRequisicion=true;
	public Boolean cargarid_productoDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleRequisicion=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleRequisicion=null;
	public Boolean mostrarid_unidadDetalleRequisicion=true;
	public Boolean activarid_unidadDetalleRequisicion=true;
	public Boolean cargarid_unidadDetalleRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleRequisicion=true;//ConEventDepend=true

	public Border resaltarcantidadDetalleRequisicion=null;
	public Boolean mostrarcantidadDetalleRequisicion=true;
	public Boolean activarcantidadDetalleRequisicion=true;

	public Border resaltardescripcionDetalleRequisicion=null;
	public Boolean mostrardescripcionDetalleRequisicion=true;
	public Boolean activardescripcionDetalleRequisicion=true;

	public Border resaltarfecha_autorizaDetalleRequisicion=null;
	public Boolean mostrarfecha_autorizaDetalleRequisicion=true;
	public Boolean activarfecha_autorizaDetalleRequisicion=false;

	
	

	public Border setResaltaridDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltaridDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleRequisicion() {
		return this.resaltaridDetalleRequisicion;
	}

	public void setResaltaridDetalleRequisicion(Border borderResaltar) {
		this.resaltaridDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostraridDetalleRequisicion() {
		return this.mostraridDetalleRequisicion;
	}

	public void setMostraridDetalleRequisicion(Boolean mostraridDetalleRequisicion) {
		this.mostraridDetalleRequisicion= mostraridDetalleRequisicion;
	}

	public Boolean getActivaridDetalleRequisicion() {
		return this.activaridDetalleRequisicion;
	}

	public void setActivaridDetalleRequisicion(Boolean activaridDetalleRequisicion) {
		this.activaridDetalleRequisicion= activaridDetalleRequisicion;
	}

	public Border setResaltarid_requisicionDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_requisicionDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_requisicionDetalleRequisicion() {
		return this.resaltarid_requisicionDetalleRequisicion;
	}

	public void setResaltarid_requisicionDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_requisicionDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_requisicionDetalleRequisicion() {
		return this.mostrarid_requisicionDetalleRequisicion;
	}

	public void setMostrarid_requisicionDetalleRequisicion(Boolean mostrarid_requisicionDetalleRequisicion) {
		this.mostrarid_requisicionDetalleRequisicion= mostrarid_requisicionDetalleRequisicion;
	}

	public Boolean getActivarid_requisicionDetalleRequisicion() {
		return this.activarid_requisicionDetalleRequisicion;
	}

	public void setActivarid_requisicionDetalleRequisicion(Boolean activarid_requisicionDetalleRequisicion) {
		this.activarid_requisicionDetalleRequisicion= activarid_requisicionDetalleRequisicion;
	}

	public Boolean getCargarid_requisicionDetalleRequisicion() {
		return this.cargarid_requisicionDetalleRequisicion;
	}

	public void setCargarid_requisicionDetalleRequisicion(Boolean cargarid_requisicionDetalleRequisicion) {
		this.cargarid_requisicionDetalleRequisicion= cargarid_requisicionDetalleRequisicion;
	}

	public Border setResaltarid_empresaDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleRequisicion() {
		return this.resaltarid_empresaDetalleRequisicion;
	}

	public void setResaltarid_empresaDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_empresaDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleRequisicion() {
		return this.mostrarid_empresaDetalleRequisicion;
	}

	public void setMostrarid_empresaDetalleRequisicion(Boolean mostrarid_empresaDetalleRequisicion) {
		this.mostrarid_empresaDetalleRequisicion= mostrarid_empresaDetalleRequisicion;
	}

	public Boolean getActivarid_empresaDetalleRequisicion() {
		return this.activarid_empresaDetalleRequisicion;
	}

	public void setActivarid_empresaDetalleRequisicion(Boolean activarid_empresaDetalleRequisicion) {
		this.activarid_empresaDetalleRequisicion= activarid_empresaDetalleRequisicion;
	}

	public Boolean getCargarid_empresaDetalleRequisicion() {
		return this.cargarid_empresaDetalleRequisicion;
	}

	public void setCargarid_empresaDetalleRequisicion(Boolean cargarid_empresaDetalleRequisicion) {
		this.cargarid_empresaDetalleRequisicion= cargarid_empresaDetalleRequisicion;
	}

	public Border setResaltarid_sucursalDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleRequisicion() {
		return this.resaltarid_sucursalDetalleRequisicion;
	}

	public void setResaltarid_sucursalDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_sucursalDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleRequisicion() {
		return this.mostrarid_sucursalDetalleRequisicion;
	}

	public void setMostrarid_sucursalDetalleRequisicion(Boolean mostrarid_sucursalDetalleRequisicion) {
		this.mostrarid_sucursalDetalleRequisicion= mostrarid_sucursalDetalleRequisicion;
	}

	public Boolean getActivarid_sucursalDetalleRequisicion() {
		return this.activarid_sucursalDetalleRequisicion;
	}

	public void setActivarid_sucursalDetalleRequisicion(Boolean activarid_sucursalDetalleRequisicion) {
		this.activarid_sucursalDetalleRequisicion= activarid_sucursalDetalleRequisicion;
	}

	public Boolean getCargarid_sucursalDetalleRequisicion() {
		return this.cargarid_sucursalDetalleRequisicion;
	}

	public void setCargarid_sucursalDetalleRequisicion(Boolean cargarid_sucursalDetalleRequisicion) {
		this.cargarid_sucursalDetalleRequisicion= cargarid_sucursalDetalleRequisicion;
	}

	public Border setResaltarid_ejercicioDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleRequisicion() {
		return this.resaltarid_ejercicioDetalleRequisicion;
	}

	public void setResaltarid_ejercicioDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleRequisicion() {
		return this.mostrarid_ejercicioDetalleRequisicion;
	}

	public void setMostrarid_ejercicioDetalleRequisicion(Boolean mostrarid_ejercicioDetalleRequisicion) {
		this.mostrarid_ejercicioDetalleRequisicion= mostrarid_ejercicioDetalleRequisicion;
	}

	public Boolean getActivarid_ejercicioDetalleRequisicion() {
		return this.activarid_ejercicioDetalleRequisicion;
	}

	public void setActivarid_ejercicioDetalleRequisicion(Boolean activarid_ejercicioDetalleRequisicion) {
		this.activarid_ejercicioDetalleRequisicion= activarid_ejercicioDetalleRequisicion;
	}

	public Boolean getCargarid_ejercicioDetalleRequisicion() {
		return this.cargarid_ejercicioDetalleRequisicion;
	}

	public void setCargarid_ejercicioDetalleRequisicion(Boolean cargarid_ejercicioDetalleRequisicion) {
		this.cargarid_ejercicioDetalleRequisicion= cargarid_ejercicioDetalleRequisicion;
	}

	public Border setResaltarid_periodoDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleRequisicion() {
		return this.resaltarid_periodoDetalleRequisicion;
	}

	public void setResaltarid_periodoDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_periodoDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleRequisicion() {
		return this.mostrarid_periodoDetalleRequisicion;
	}

	public void setMostrarid_periodoDetalleRequisicion(Boolean mostrarid_periodoDetalleRequisicion) {
		this.mostrarid_periodoDetalleRequisicion= mostrarid_periodoDetalleRequisicion;
	}

	public Boolean getActivarid_periodoDetalleRequisicion() {
		return this.activarid_periodoDetalleRequisicion;
	}

	public void setActivarid_periodoDetalleRequisicion(Boolean activarid_periodoDetalleRequisicion) {
		this.activarid_periodoDetalleRequisicion= activarid_periodoDetalleRequisicion;
	}

	public Boolean getCargarid_periodoDetalleRequisicion() {
		return this.cargarid_periodoDetalleRequisicion;
	}

	public void setCargarid_periodoDetalleRequisicion(Boolean cargarid_periodoDetalleRequisicion) {
		this.cargarid_periodoDetalleRequisicion= cargarid_periodoDetalleRequisicion;
	}

	public Border setResaltarid_anioDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleRequisicion() {
		return this.resaltarid_anioDetalleRequisicion;
	}

	public void setResaltarid_anioDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_anioDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleRequisicion() {
		return this.mostrarid_anioDetalleRequisicion;
	}

	public void setMostrarid_anioDetalleRequisicion(Boolean mostrarid_anioDetalleRequisicion) {
		this.mostrarid_anioDetalleRequisicion= mostrarid_anioDetalleRequisicion;
	}

	public Boolean getActivarid_anioDetalleRequisicion() {
		return this.activarid_anioDetalleRequisicion;
	}

	public void setActivarid_anioDetalleRequisicion(Boolean activarid_anioDetalleRequisicion) {
		this.activarid_anioDetalleRequisicion= activarid_anioDetalleRequisicion;
	}

	public Boolean getCargarid_anioDetalleRequisicion() {
		return this.cargarid_anioDetalleRequisicion;
	}

	public void setCargarid_anioDetalleRequisicion(Boolean cargarid_anioDetalleRequisicion) {
		this.cargarid_anioDetalleRequisicion= cargarid_anioDetalleRequisicion;
	}

	public Border setResaltarid_mesDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleRequisicion() {
		return this.resaltarid_mesDetalleRequisicion;
	}

	public void setResaltarid_mesDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_mesDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleRequisicion() {
		return this.mostrarid_mesDetalleRequisicion;
	}

	public void setMostrarid_mesDetalleRequisicion(Boolean mostrarid_mesDetalleRequisicion) {
		this.mostrarid_mesDetalleRequisicion= mostrarid_mesDetalleRequisicion;
	}

	public Boolean getActivarid_mesDetalleRequisicion() {
		return this.activarid_mesDetalleRequisicion;
	}

	public void setActivarid_mesDetalleRequisicion(Boolean activarid_mesDetalleRequisicion) {
		this.activarid_mesDetalleRequisicion= activarid_mesDetalleRequisicion;
	}

	public Boolean getCargarid_mesDetalleRequisicion() {
		return this.cargarid_mesDetalleRequisicion;
	}

	public void setCargarid_mesDetalleRequisicion(Boolean cargarid_mesDetalleRequisicion) {
		this.cargarid_mesDetalleRequisicion= cargarid_mesDetalleRequisicion;
	}

	public Border setResaltarid_bodegaDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleRequisicion() {
		return this.resaltarid_bodegaDetalleRequisicion;
	}

	public void setResaltarid_bodegaDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_bodegaDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleRequisicion() {
		return this.mostrarid_bodegaDetalleRequisicion;
	}

	public void setMostrarid_bodegaDetalleRequisicion(Boolean mostrarid_bodegaDetalleRequisicion) {
		this.mostrarid_bodegaDetalleRequisicion= mostrarid_bodegaDetalleRequisicion;
	}

	public Boolean getActivarid_bodegaDetalleRequisicion() {
		return this.activarid_bodegaDetalleRequisicion;
	}

	public void setActivarid_bodegaDetalleRequisicion(Boolean activarid_bodegaDetalleRequisicion) {
		this.activarid_bodegaDetalleRequisicion= activarid_bodegaDetalleRequisicion;
	}

	public Boolean getCargarid_bodegaDetalleRequisicion() {
		return this.cargarid_bodegaDetalleRequisicion;
	}

	public void setCargarid_bodegaDetalleRequisicion(Boolean cargarid_bodegaDetalleRequisicion) {
		this.cargarid_bodegaDetalleRequisicion= cargarid_bodegaDetalleRequisicion;
	}

	public Border setResaltarid_productoDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleRequisicion() {
		return this.resaltarid_productoDetalleRequisicion;
	}

	public void setResaltarid_productoDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_productoDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleRequisicion() {
		return this.mostrarid_productoDetalleRequisicion;
	}

	public void setMostrarid_productoDetalleRequisicion(Boolean mostrarid_productoDetalleRequisicion) {
		this.mostrarid_productoDetalleRequisicion= mostrarid_productoDetalleRequisicion;
	}

	public Boolean getActivarid_productoDetalleRequisicion() {
		return this.activarid_productoDetalleRequisicion;
	}

	public void setActivarid_productoDetalleRequisicion(Boolean activarid_productoDetalleRequisicion) {
		this.activarid_productoDetalleRequisicion= activarid_productoDetalleRequisicion;
	}

	public Boolean getCargarid_productoDetalleRequisicion() {
		return this.cargarid_productoDetalleRequisicion;
	}

	public void setCargarid_productoDetalleRequisicion(Boolean cargarid_productoDetalleRequisicion) {
		this.cargarid_productoDetalleRequisicion= cargarid_productoDetalleRequisicion;
	}

	public Border setResaltarid_unidadDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleRequisicion() {
		return this.resaltarid_unidadDetalleRequisicion;
	}

	public void setResaltarid_unidadDetalleRequisicion(Border borderResaltar) {
		this.resaltarid_unidadDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleRequisicion() {
		return this.mostrarid_unidadDetalleRequisicion;
	}

	public void setMostrarid_unidadDetalleRequisicion(Boolean mostrarid_unidadDetalleRequisicion) {
		this.mostrarid_unidadDetalleRequisicion= mostrarid_unidadDetalleRequisicion;
	}

	public Boolean getActivarid_unidadDetalleRequisicion() {
		return this.activarid_unidadDetalleRequisicion;
	}

	public void setActivarid_unidadDetalleRequisicion(Boolean activarid_unidadDetalleRequisicion) {
		this.activarid_unidadDetalleRequisicion= activarid_unidadDetalleRequisicion;
	}

	public Boolean getCargarid_unidadDetalleRequisicion() {
		return this.cargarid_unidadDetalleRequisicion;
	}

	public void setCargarid_unidadDetalleRequisicion(Boolean cargarid_unidadDetalleRequisicion) {
		this.cargarid_unidadDetalleRequisicion= cargarid_unidadDetalleRequisicion;
	}

	public Border setResaltarcantidadDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleRequisicion() {
		return this.resaltarcantidadDetalleRequisicion;
	}

	public void setResaltarcantidadDetalleRequisicion(Border borderResaltar) {
		this.resaltarcantidadDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleRequisicion() {
		return this.mostrarcantidadDetalleRequisicion;
	}

	public void setMostrarcantidadDetalleRequisicion(Boolean mostrarcantidadDetalleRequisicion) {
		this.mostrarcantidadDetalleRequisicion= mostrarcantidadDetalleRequisicion;
	}

	public Boolean getActivarcantidadDetalleRequisicion() {
		return this.activarcantidadDetalleRequisicion;
	}

	public void setActivarcantidadDetalleRequisicion(Boolean activarcantidadDetalleRequisicion) {
		this.activarcantidadDetalleRequisicion= activarcantidadDetalleRequisicion;
	}

	public Border setResaltardescripcionDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleRequisicion() {
		return this.resaltardescripcionDetalleRequisicion;
	}

	public void setResaltardescripcionDetalleRequisicion(Border borderResaltar) {
		this.resaltardescripcionDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleRequisicion() {
		return this.mostrardescripcionDetalleRequisicion;
	}

	public void setMostrardescripcionDetalleRequisicion(Boolean mostrardescripcionDetalleRequisicion) {
		this.mostrardescripcionDetalleRequisicion= mostrardescripcionDetalleRequisicion;
	}

	public Boolean getActivardescripcionDetalleRequisicion() {
		return this.activardescripcionDetalleRequisicion;
	}

	public void setActivardescripcionDetalleRequisicion(Boolean activardescripcionDetalleRequisicion) {
		this.activardescripcionDetalleRequisicion= activardescripcionDetalleRequisicion;
	}

	public Border setResaltarfecha_autorizaDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallerequisicionBeanSwingJInternalFrame.jTtoolBarDetalleRequisicion.setBorder(borderResaltar);
		
		this.resaltarfecha_autorizaDetalleRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autorizaDetalleRequisicion() {
		return this.resaltarfecha_autorizaDetalleRequisicion;
	}

	public void setResaltarfecha_autorizaDetalleRequisicion(Border borderResaltar) {
		this.resaltarfecha_autorizaDetalleRequisicion= borderResaltar;
	}

	public Boolean getMostrarfecha_autorizaDetalleRequisicion() {
		return this.mostrarfecha_autorizaDetalleRequisicion;
	}

	public void setMostrarfecha_autorizaDetalleRequisicion(Boolean mostrarfecha_autorizaDetalleRequisicion) {
		this.mostrarfecha_autorizaDetalleRequisicion= mostrarfecha_autorizaDetalleRequisicion;
	}

	public Boolean getActivarfecha_autorizaDetalleRequisicion() {
		return this.activarfecha_autorizaDetalleRequisicion;
	}

	public void setActivarfecha_autorizaDetalleRequisicion(Boolean activarfecha_autorizaDetalleRequisicion) {
		this.activarfecha_autorizaDetalleRequisicion= activarfecha_autorizaDetalleRequisicion;
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
		
		
		this.setMostraridDetalleRequisicion(esInicial);
		this.setMostrarid_requisicionDetalleRequisicion(esInicial);
		this.setMostrarid_empresaDetalleRequisicion(esInicial);
		this.setMostrarid_sucursalDetalleRequisicion(esInicial);
		this.setMostrarid_ejercicioDetalleRequisicion(esInicial);
		this.setMostrarid_periodoDetalleRequisicion(esInicial);
		this.setMostrarid_anioDetalleRequisicion(esInicial);
		this.setMostrarid_mesDetalleRequisicion(esInicial);
		this.setMostrarid_bodegaDetalleRequisicion(esInicial);
		this.setMostrarid_productoDetalleRequisicion(esInicial);
		this.setMostrarid_unidadDetalleRequisicion(esInicial);
		this.setMostrarcantidadDetalleRequisicion(esInicial);
		this.setMostrardescripcionDetalleRequisicion(esInicial);
		this.setMostrarfecha_autorizaDetalleRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.ID)) {
				this.setMostraridDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDREQUISICION)) {
				this.setMostrarid_requisicionDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.FECHAAUTORIZA)) {
				this.setMostrarfecha_autorizaDetalleRequisicion(esAsigna);
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
		
		
		this.setActivaridDetalleRequisicion(esInicial);
		this.setActivarid_requisicionDetalleRequisicion(esInicial);
		this.setActivarid_empresaDetalleRequisicion(esInicial);
		this.setActivarid_sucursalDetalleRequisicion(esInicial);
		this.setActivarid_ejercicioDetalleRequisicion(esInicial);
		this.setActivarid_periodoDetalleRequisicion(esInicial);
		this.setActivarid_anioDetalleRequisicion(esInicial);
		this.setActivarid_mesDetalleRequisicion(esInicial);
		this.setActivarid_bodegaDetalleRequisicion(esInicial);
		this.setActivarid_productoDetalleRequisicion(esInicial);
		this.setActivarid_unidadDetalleRequisicion(esInicial);
		this.setActivarcantidadDetalleRequisicion(esInicial);
		this.setActivardescripcionDetalleRequisicion(esInicial);
		this.setActivarfecha_autorizaDetalleRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.ID)) {
				this.setActivaridDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDREQUISICION)) {
				this.setActivarid_requisicionDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.FECHAAUTORIZA)) {
				this.setActivarfecha_autorizaDetalleRequisicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleRequisicion(esInicial);
		this.setResaltarid_requisicionDetalleRequisicion(esInicial);
		this.setResaltarid_empresaDetalleRequisicion(esInicial);
		this.setResaltarid_sucursalDetalleRequisicion(esInicial);
		this.setResaltarid_ejercicioDetalleRequisicion(esInicial);
		this.setResaltarid_periodoDetalleRequisicion(esInicial);
		this.setResaltarid_anioDetalleRequisicion(esInicial);
		this.setResaltarid_mesDetalleRequisicion(esInicial);
		this.setResaltarid_bodegaDetalleRequisicion(esInicial);
		this.setResaltarid_productoDetalleRequisicion(esInicial);
		this.setResaltarid_unidadDetalleRequisicion(esInicial);
		this.setResaltarcantidadDetalleRequisicion(esInicial);
		this.setResaltardescripcionDetalleRequisicion(esInicial);
		this.setResaltarfecha_autorizaDetalleRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.ID)) {
				this.setResaltaridDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDREQUISICION)) {
				this.setResaltarid_requisicionDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRequisicionConstantesFunciones.FECHAAUTORIZA)) {
				this.setResaltarfecha_autorizaDetalleRequisicion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleRequisicion=true;

	public Boolean getMostrarFK_IdBodegaDetalleRequisicion() {
		return this.mostrarFK_IdBodegaDetalleRequisicion;
	}

	public void setMostrarFK_IdBodegaDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleRequisicion=true;

	public Boolean getMostrarFK_IdEjercicioDetalleRequisicion() {
		return this.mostrarFK_IdEjercicioDetalleRequisicion;
	}

	public void setMostrarFK_IdEjercicioDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleRequisicion=true;

	public Boolean getMostrarFK_IdEmpresaDetalleRequisicion() {
		return this.mostrarFK_IdEmpresaDetalleRequisicion;
	}

	public void setMostrarFK_IdEmpresaDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleRequisicion=true;

	public Boolean getMostrarFK_IdPeriodoDetalleRequisicion() {
		return this.mostrarFK_IdPeriodoDetalleRequisicion;
	}

	public void setMostrarFK_IdPeriodoDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleRequisicion=true;

	public Boolean getMostrarFK_IdProductoDetalleRequisicion() {
		return this.mostrarFK_IdProductoDetalleRequisicion;
	}

	public void setMostrarFK_IdProductoDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRequisicionDetalleRequisicion=true;

	public Boolean getMostrarFK_IdRequisicionDetalleRequisicion() {
		return this.mostrarFK_IdRequisicionDetalleRequisicion;
	}

	public void setMostrarFK_IdRequisicionDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRequisicionDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleRequisicion=true;

	public Boolean getMostrarFK_IdSucursalDetalleRequisicion() {
		return this.mostrarFK_IdSucursalDetalleRequisicion;
	}

	public void setMostrarFK_IdSucursalDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleRequisicion=true;

	public Boolean getMostrarFK_IdUnidadDetalleRequisicion() {
		return this.mostrarFK_IdUnidadDetalleRequisicion;
	}

	public void setMostrarFK_IdUnidadDetalleRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleRequisicion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleRequisicion=true;

	public Boolean getActivarFK_IdBodegaDetalleRequisicion() {
		return this.activarFK_IdBodegaDetalleRequisicion;
	}

	public void setActivarFK_IdBodegaDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleRequisicion=true;

	public Boolean getActivarFK_IdEjercicioDetalleRequisicion() {
		return this.activarFK_IdEjercicioDetalleRequisicion;
	}

	public void setActivarFK_IdEjercicioDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleRequisicion=true;

	public Boolean getActivarFK_IdEmpresaDetalleRequisicion() {
		return this.activarFK_IdEmpresaDetalleRequisicion;
	}

	public void setActivarFK_IdEmpresaDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleRequisicion=true;

	public Boolean getActivarFK_IdPeriodoDetalleRequisicion() {
		return this.activarFK_IdPeriodoDetalleRequisicion;
	}

	public void setActivarFK_IdPeriodoDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleRequisicion=true;

	public Boolean getActivarFK_IdProductoDetalleRequisicion() {
		return this.activarFK_IdProductoDetalleRequisicion;
	}

	public void setActivarFK_IdProductoDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdRequisicionDetalleRequisicion=true;

	public Boolean getActivarFK_IdRequisicionDetalleRequisicion() {
		return this.activarFK_IdRequisicionDetalleRequisicion;
	}

	public void setActivarFK_IdRequisicionDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdRequisicionDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleRequisicion=true;

	public Boolean getActivarFK_IdSucursalDetalleRequisicion() {
		return this.activarFK_IdSucursalDetalleRequisicion;
	}

	public void setActivarFK_IdSucursalDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleRequisicion=true;

	public Boolean getActivarFK_IdUnidadDetalleRequisicion() {
		return this.activarFK_IdUnidadDetalleRequisicion;
	}

	public void setActivarFK_IdUnidadDetalleRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleRequisicion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleRequisicion=null;

	public Border getResaltarFK_IdBodegaDetalleRequisicion() {
		return this.resaltarFK_IdBodegaDetalleRequisicion;
	}

	public void setResaltarFK_IdBodegaDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleRequisicion=null;

	public Border getResaltarFK_IdEjercicioDetalleRequisicion() {
		return this.resaltarFK_IdEjercicioDetalleRequisicion;
	}

	public void setResaltarFK_IdEjercicioDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleRequisicion=null;

	public Border getResaltarFK_IdEmpresaDetalleRequisicion() {
		return this.resaltarFK_IdEmpresaDetalleRequisicion;
	}

	public void setResaltarFK_IdEmpresaDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleRequisicion=null;

	public Border getResaltarFK_IdPeriodoDetalleRequisicion() {
		return this.resaltarFK_IdPeriodoDetalleRequisicion;
	}

	public void setResaltarFK_IdPeriodoDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleRequisicion=null;

	public Border getResaltarFK_IdProductoDetalleRequisicion() {
		return this.resaltarFK_IdProductoDetalleRequisicion;
	}

	public void setResaltarFK_IdProductoDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdRequisicionDetalleRequisicion=null;

	public Border getResaltarFK_IdRequisicionDetalleRequisicion() {
		return this.resaltarFK_IdRequisicionDetalleRequisicion;
	}

	public void setResaltarFK_IdRequisicionDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdRequisicionDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdRequisicionDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRequisicionDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleRequisicion=null;

	public Border getResaltarFK_IdSucursalDetalleRequisicion() {
		return this.resaltarFK_IdSucursalDetalleRequisicion;
	}

	public void setResaltarFK_IdSucursalDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleRequisicion=null;

	public Border getResaltarFK_IdUnidadDetalleRequisicion() {
		return this.resaltarFK_IdUnidadDetalleRequisicion;
	}

	public void setResaltarFK_IdUnidadDetalleRequisicion(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRequisicionBeanSwingJInternalFrame detallerequisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleRequisicion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}