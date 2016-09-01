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


import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleCodigoBarraProductoConstantesFunciones extends DetalleCodigoBarraProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleCodigoBarraProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleCodigoBarraProducto"+DetalleCodigoBarraProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleCodigoBarraProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleCodigoBarraProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"_"+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCodigoBarraProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"_"+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"_"+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCodigoBarraProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"_"+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCodigoBarraProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCodigoBarraProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCodigoBarraProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleCodigoBarraProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleCodigoBarraProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleCodigoBarraProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleCodigoBarraProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Codigo Barra Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Codigo Barra Producto";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Codigo Barra Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleCodigoBarraProducto";
	public static final String OBJECTNAME="detallecodigobarraproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_codigo_barra_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallecodigobarraproducto from "+DetalleCodigoBarraProductoConstantesFunciones.SPERSISTENCENAME+" detallecodigobarraproducto";
	public static String QUERYSELECTNATIVE="select "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".version_row,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_bodega,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_producto,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_unidad,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea_categoria,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".id_linea_marca,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".control,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".medicion,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".valor_anterior,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".fecha,"+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME+".observacion from "+DetalleCodigoBarraProductoConstantesFunciones.SCHEMA+"."+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME;//+" as "+DetalleCodigoBarraProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleCodigoBarraProductoConstantesFuncionesAdditional detallecodigobarraproductoConstantesFuncionesAdditional=null;
	
	public DetalleCodigoBarraProductoConstantesFuncionesAdditional getDetalleCodigoBarraProductoConstantesFuncionesAdditional() {
		return this.detallecodigobarraproductoConstantesFuncionesAdditional;
	}
	
	public void setDetalleCodigoBarraProductoConstantesFuncionesAdditional(DetalleCodigoBarraProductoConstantesFuncionesAdditional detallecodigobarraproductoConstantesFuncionesAdditional) {
		try {
			this.detallecodigobarraproductoConstantesFuncionesAdditional=detallecodigobarraproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String CONTROL= "control";
    public static final String MEDICION= "medicion";
    public static final String VALORANTERIOR= "valor_anterior";
    public static final String FECHA= "fecha";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_CONTROL= "Control";
		public static final String LABEL_CONTROL_LOWER= "Control";
    	public static final String LABEL_MEDICION= "Medicion";
		public static final String LABEL_MEDICION_LOWER= "Medicion";
    	public static final String LABEL_VALORANTERIOR= "Valor Anterior";
		public static final String LABEL_VALORANTERIOR_LOWER= "Valor Anterior";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCONTROL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTROL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMEDICION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMEDICION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleCodigoBarraProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEA)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.CONTROL)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_CONTROL;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.MEDICION)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_MEDICION;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_VALORANTERIOR;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.FECHA)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION)) {sLabelColumna=DetalleCodigoBarraProductoConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleCodigoBarraProductoDescripcion(DetalleCodigoBarraProducto detallecodigobarraproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallecodigobarraproducto !=null/* && detallecodigobarraproducto.getId()!=0*/) {
			if(detallecodigobarraproducto.getId()!=null) {
				sDescripcion=detallecodigobarraproducto.getId().toString();
			}//detallecodigobarraproductodetallecodigobarraproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleCodigoBarraProductoDescripcionDetallado(DetalleCodigoBarraProducto detallecodigobarraproducto) {
		String sDescripcion="";
			
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.ID+"=";
		sDescripcion+=detallecodigobarraproducto.getId().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallecodigobarraproducto.getVersionRow().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallecodigobarraproducto.getid_empresa().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallecodigobarraproducto.getid_sucursal().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallecodigobarraproducto.getid_bodega().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallecodigobarraproducto.getid_producto().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallecodigobarraproducto.getid_unidad().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDLINEA+"=";
		sDescripcion+=detallecodigobarraproducto.getid_linea().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=detallecodigobarraproducto.getid_linea_grupo().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=detallecodigobarraproducto.getid_linea_categoria().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=detallecodigobarraproducto.getid_linea_marca().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.CONTROL+"=";
		sDescripcion+=detallecodigobarraproducto.getcontrol()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.MEDICION+"=";
		sDescripcion+=detallecodigobarraproducto.getmedicion()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR+"=";
		sDescripcion+=detallecodigobarraproducto.getvalor_anterior().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.FECHA+"=";
		sDescripcion+=detallecodigobarraproducto.getfecha().toString()+",";
		sDescripcion+=DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=detallecodigobarraproducto.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleCodigoBarraProductoDescripcion(DetalleCodigoBarraProducto detallecodigobarraproducto,String sValor) throws Exception {			
		if(detallecodigobarraproducto !=null) {
			//detallecodigobarraproductodetallecodigobarraproducto.getId().toString();
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallecodigobarraproducto.setcontrol(detallecodigobarraproducto.getcontrol().trim());
		detallecodigobarraproducto.setmedicion(detallecodigobarraproducto.getmedicion().trim());
		detallecodigobarraproducto.setobservacion(detallecodigobarraproducto.getobservacion().trim());
	}
	
	public static void quitarEspaciosDetalleCodigoBarraProductos(List<DetalleCodigoBarraProducto> detallecodigobarraproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto: detallecodigobarraproductos) {
			detallecodigobarraproducto.setcontrol(detallecodigobarraproducto.getcontrol().trim());
			detallecodigobarraproducto.setmedicion(detallecodigobarraproducto.getmedicion().trim());
			detallecodigobarraproducto.setobservacion(detallecodigobarraproducto.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallecodigobarraproducto.getConCambioAuxiliar()) {
			detallecodigobarraproducto.setIsDeleted(detallecodigobarraproducto.getIsDeletedAuxiliar());	
			detallecodigobarraproducto.setIsNew(detallecodigobarraproducto.getIsNewAuxiliar());	
			detallecodigobarraproducto.setIsChanged(detallecodigobarraproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallecodigobarraproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallecodigobarraproducto.setIsDeletedAuxiliar(false);	
			detallecodigobarraproducto.setIsNewAuxiliar(false);	
			detallecodigobarraproducto.setIsChangedAuxiliar(false);
			
			detallecodigobarraproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCodigoBarraProductos(List<DetalleCodigoBarraProducto> detallecodigobarraproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto : detallecodigobarraproductos) {
			if(conAsignarBase && detallecodigobarraproducto.getConCambioAuxiliar()) {
				detallecodigobarraproducto.setIsDeleted(detallecodigobarraproducto.getIsDeletedAuxiliar());	
				detallecodigobarraproducto.setIsNew(detallecodigobarraproducto.getIsNewAuxiliar());	
				detallecodigobarraproducto.setIsChanged(detallecodigobarraproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallecodigobarraproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallecodigobarraproducto.setIsDeletedAuxiliar(false);	
				detallecodigobarraproducto.setIsNewAuxiliar(false);	
				detallecodigobarraproducto.setIsChangedAuxiliar(false);
				
				detallecodigobarraproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproducto,Boolean conEnteros) throws Exception  {
		detallecodigobarraproducto.setvalor_anterior(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleCodigoBarraProductos(List<DetalleCodigoBarraProducto> detallecodigobarraproductos,Boolean conEnteros) throws Exception  {
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto: detallecodigobarraproductos) {
			detallecodigobarraproducto.setvalor_anterior(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleCodigoBarraProducto(List<DetalleCodigoBarraProducto> detallecodigobarraproductos,DetalleCodigoBarraProducto detallecodigobarraproductoAux) throws Exception  {
		DetalleCodigoBarraProductoConstantesFunciones.InicializarValoresDetalleCodigoBarraProducto(detallecodigobarraproductoAux,true);
		
		for(DetalleCodigoBarraProducto detallecodigobarraproducto: detallecodigobarraproductos) {
			if(detallecodigobarraproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallecodigobarraproductoAux.setvalor_anterior(detallecodigobarraproductoAux.getvalor_anterior()+detallecodigobarraproducto.getvalor_anterior());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCodigoBarraProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleCodigoBarraProductoConstantesFunciones.getArrayColumnasGlobalesDetalleCodigoBarraProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCodigoBarraProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleCodigoBarraProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleCodigoBarraProducto> detallecodigobarraproductos,DetalleCodigoBarraProducto detallecodigobarraproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleCodigoBarraProducto detallecodigobarraproductoAux: detallecodigobarraproductos) {
			if(detallecodigobarraproductoAux!=null && detallecodigobarraproducto!=null) {
				if((detallecodigobarraproductoAux.getId()==null && detallecodigobarraproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallecodigobarraproductoAux.getId()!=null && detallecodigobarraproducto.getId()!=null){
					if(detallecodigobarraproductoAux.getId().equals(detallecodigobarraproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleCodigoBarraProducto(List<DetalleCodigoBarraProducto> detallecodigobarraproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_anteriorTotal=0.0;
	
		for(DetalleCodigoBarraProducto detallecodigobarraproducto: detallecodigobarraproductos) {			
			if(detallecodigobarraproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_anteriorTotal+=detallecodigobarraproducto.getvalor_anterior();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR);
		datoGeneral.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_VALORANTERIOR);
		datoGeneral.setdValorDouble(valor_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleCodigoBarraProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_ID, DetalleCodigoBarraProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_VERSIONROW, DetalleCodigoBarraProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDEMPRESA, DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDSUCURSAL, DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDBODEGA, DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDPRODUCTO, DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDUNIDAD, DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEA, DetalleCodigoBarraProductoConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAGRUPO, DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEACATEGORIA, DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAMARCA, DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_CONTROL, DetalleCodigoBarraProductoConstantesFunciones.CONTROL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_MEDICION, DetalleCodigoBarraProductoConstantesFunciones.MEDICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_VALORANTERIOR, DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_FECHA, DetalleCodigoBarraProductoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCodigoBarraProductoConstantesFunciones.LABEL_OBSERVACION, DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleCodigoBarraProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.CONTROL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.MEDICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCodigoBarraProducto() throws Exception  {
		return DetalleCodigoBarraProductoConstantesFunciones.getTiposSeleccionarDetalleCodigoBarraProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCodigoBarraProducto(Boolean conFk) throws Exception  {
		return DetalleCodigoBarraProductoConstantesFunciones.getTiposSeleccionarDetalleCodigoBarraProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCodigoBarraProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_CONTROL);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_CONTROL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_MEDICION);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_MEDICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_VALORANTERIOR);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_VALORANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCodigoBarraProductoConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(DetalleCodigoBarraProductoConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleCodigoBarraProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproductoAux) throws Exception {
		
			detallecodigobarraproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallecodigobarraproductoAux.getEmpresa()));
			detallecodigobarraproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallecodigobarraproductoAux.getSucursal()));
			detallecodigobarraproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallecodigobarraproductoAux.getBodega()));
			detallecodigobarraproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallecodigobarraproductoAux.getProducto()));
			detallecodigobarraproductoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallecodigobarraproductoAux.getUnidad()));
			detallecodigobarraproductoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLinea()));
			detallecodigobarraproductoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLineaGrupo()));
			detallecodigobarraproductoAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLineaCategoria()));
			detallecodigobarraproductoAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCodigoBarraProducto(List<DetalleCodigoBarraProducto> detallecodigobarraproductosTemp) throws Exception {
		for(DetalleCodigoBarraProducto detallecodigobarraproductoAux:detallecodigobarraproductosTemp) {
			
			detallecodigobarraproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallecodigobarraproductoAux.getEmpresa()));
			detallecodigobarraproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallecodigobarraproductoAux.getSucursal()));
			detallecodigobarraproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallecodigobarraproductoAux.getBodega()));
			detallecodigobarraproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallecodigobarraproductoAux.getProducto()));
			detallecodigobarraproductoAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallecodigobarraproductoAux.getUnidad()));
			detallecodigobarraproductoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLinea()));
			detallecodigobarraproductoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLineaGrupo()));
			detallecodigobarraproductoAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLineaCategoria()));
			detallecodigobarraproductoAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(detallecodigobarraproductoAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCodigoBarraProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleCodigoBarraProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCodigoBarraProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCodigoBarraProductoConstantesFunciones.getClassesRelationshipsOfDetalleCodigoBarraProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCodigoBarraProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCodigoBarraProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCodigoBarraProductoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleCodigoBarraProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCodigoBarraProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleCodigoBarraProducto detallecodigobarraproducto,List<DetalleCodigoBarraProducto> detallecodigobarraproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleCodigoBarraProducto detallecodigobarraproductoEncontrado=null;
			
			for(DetalleCodigoBarraProducto detallecodigobarraproductoLocal:detallecodigobarraproductos) {
				if(detallecodigobarraproductoLocal.getId().equals(detallecodigobarraproducto.getId())) {
					detallecodigobarraproductoEncontrado=detallecodigobarraproductoLocal;
					
					detallecodigobarraproductoLocal.setIsChanged(detallecodigobarraproducto.getIsChanged());
					detallecodigobarraproductoLocal.setIsNew(detallecodigobarraproducto.getIsNew());
					detallecodigobarraproductoLocal.setIsDeleted(detallecodigobarraproducto.getIsDeleted());
					
					detallecodigobarraproductoLocal.setGeneralEntityOriginal(detallecodigobarraproducto.getGeneralEntityOriginal());
					
					detallecodigobarraproductoLocal.setId(detallecodigobarraproducto.getId());	
					detallecodigobarraproductoLocal.setVersionRow(detallecodigobarraproducto.getVersionRow());	
					detallecodigobarraproductoLocal.setid_empresa(detallecodigobarraproducto.getid_empresa());	
					detallecodigobarraproductoLocal.setid_sucursal(detallecodigobarraproducto.getid_sucursal());	
					detallecodigobarraproductoLocal.setid_bodega(detallecodigobarraproducto.getid_bodega());	
					detallecodigobarraproductoLocal.setid_producto(detallecodigobarraproducto.getid_producto());	
					detallecodigobarraproductoLocal.setid_unidad(detallecodigobarraproducto.getid_unidad());	
					detallecodigobarraproductoLocal.setid_linea(detallecodigobarraproducto.getid_linea());	
					detallecodigobarraproductoLocal.setid_linea_grupo(detallecodigobarraproducto.getid_linea_grupo());	
					detallecodigobarraproductoLocal.setid_linea_categoria(detallecodigobarraproducto.getid_linea_categoria());	
					detallecodigobarraproductoLocal.setid_linea_marca(detallecodigobarraproducto.getid_linea_marca());	
					detallecodigobarraproductoLocal.setcontrol(detallecodigobarraproducto.getcontrol());	
					detallecodigobarraproductoLocal.setmedicion(detallecodigobarraproducto.getmedicion());	
					detallecodigobarraproductoLocal.setvalor_anterior(detallecodigobarraproducto.getvalor_anterior());	
					detallecodigobarraproductoLocal.setfecha(detallecodigobarraproducto.getfecha());	
					detallecodigobarraproductoLocal.setobservacion(detallecodigobarraproducto.getobservacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallecodigobarraproducto.getIsDeleted()) {
				if(!existe) {
					detallecodigobarraproductos.add(detallecodigobarraproducto);
				}
			} else {
				if(detallecodigobarraproductoEncontrado!=null && permiteQuitar)  {
					detallecodigobarraproductos.remove(detallecodigobarraproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleCodigoBarraProducto detallecodigobarraproducto,List<DetalleCodigoBarraProducto> detallecodigobarraproductos) throws Exception {
		try	{			
			for(DetalleCodigoBarraProducto detallecodigobarraproductoLocal:detallecodigobarraproductos) {
				if(detallecodigobarraproductoLocal.getId().equals(detallecodigobarraproducto.getId())) {
					detallecodigobarraproductoLocal.setIsSelected(detallecodigobarraproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleCodigoBarraProducto(List<DetalleCodigoBarraProducto> detallecodigobarraproductosAux) throws Exception {
		//this.detallecodigobarraproductosAux=detallecodigobarraproductosAux;
		
		for(DetalleCodigoBarraProducto detallecodigobarraproductoAux:detallecodigobarraproductosAux) {
			if(detallecodigobarraproductoAux.getIsChanged()) {
				detallecodigobarraproductoAux.setIsChanged(false);
			}		
			
			if(detallecodigobarraproductoAux.getIsNew()) {
				detallecodigobarraproductoAux.setIsNew(false);
			}	
			
			if(detallecodigobarraproductoAux.getIsDeleted()) {
				detallecodigobarraproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproductoAux) throws Exception {
		//this.detallecodigobarraproductoAux=detallecodigobarraproductoAux;
		
			if(detallecodigobarraproductoAux.getIsChanged()) {
				detallecodigobarraproductoAux.setIsChanged(false);
			}		
			
			if(detallecodigobarraproductoAux.getIsNew()) {
				detallecodigobarraproductoAux.setIsNew(false);
			}	
			
			if(detallecodigobarraproductoAux.getIsDeleted()) {
				detallecodigobarraproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleCodigoBarraProducto detallecodigobarraproductoAsignar,DetalleCodigoBarraProducto detallecodigobarraproducto) throws Exception {
		detallecodigobarraproductoAsignar.setId(detallecodigobarraproducto.getId());	
		detallecodigobarraproductoAsignar.setVersionRow(detallecodigobarraproducto.getVersionRow());	
		detallecodigobarraproductoAsignar.setid_empresa(detallecodigobarraproducto.getid_empresa());
		detallecodigobarraproductoAsignar.setempresa_descripcion(detallecodigobarraproducto.getempresa_descripcion());	
		detallecodigobarraproductoAsignar.setid_sucursal(detallecodigobarraproducto.getid_sucursal());
		detallecodigobarraproductoAsignar.setsucursal_descripcion(detallecodigobarraproducto.getsucursal_descripcion());	
		detallecodigobarraproductoAsignar.setid_bodega(detallecodigobarraproducto.getid_bodega());
		detallecodigobarraproductoAsignar.setbodega_descripcion(detallecodigobarraproducto.getbodega_descripcion());	
		detallecodigobarraproductoAsignar.setid_producto(detallecodigobarraproducto.getid_producto());
		detallecodigobarraproductoAsignar.setproducto_descripcion(detallecodigobarraproducto.getproducto_descripcion());	
		detallecodigobarraproductoAsignar.setid_unidad(detallecodigobarraproducto.getid_unidad());
		detallecodigobarraproductoAsignar.setunidad_descripcion(detallecodigobarraproducto.getunidad_descripcion());	
		detallecodigobarraproductoAsignar.setid_linea(detallecodigobarraproducto.getid_linea());
		detallecodigobarraproductoAsignar.setlinea_descripcion(detallecodigobarraproducto.getlinea_descripcion());	
		detallecodigobarraproductoAsignar.setid_linea_grupo(detallecodigobarraproducto.getid_linea_grupo());
		detallecodigobarraproductoAsignar.setlineagrupo_descripcion(detallecodigobarraproducto.getlineagrupo_descripcion());	
		detallecodigobarraproductoAsignar.setid_linea_categoria(detallecodigobarraproducto.getid_linea_categoria());
		detallecodigobarraproductoAsignar.setlineacategoria_descripcion(detallecodigobarraproducto.getlineacategoria_descripcion());	
		detallecodigobarraproductoAsignar.setid_linea_marca(detallecodigobarraproducto.getid_linea_marca());
		detallecodigobarraproductoAsignar.setlineamarca_descripcion(detallecodigobarraproducto.getlineamarca_descripcion());	
		detallecodigobarraproductoAsignar.setcontrol(detallecodigobarraproducto.getcontrol());	
		detallecodigobarraproductoAsignar.setmedicion(detallecodigobarraproducto.getmedicion());	
		detallecodigobarraproductoAsignar.setvalor_anterior(detallecodigobarraproducto.getvalor_anterior());	
		detallecodigobarraproductoAsignar.setfecha(detallecodigobarraproducto.getfecha());	
		detallecodigobarraproductoAsignar.setobservacion(detallecodigobarraproducto.getobservacion());	
	}
	
	public static void inicializarDetalleCodigoBarraProducto(DetalleCodigoBarraProducto detallecodigobarraproducto) throws Exception {
		try {
				detallecodigobarraproducto.setId(0L);	
					
				detallecodigobarraproducto.setid_empresa(-1L);	
				detallecodigobarraproducto.setid_sucursal(-1L);	
				detallecodigobarraproducto.setid_bodega(-1L);	
				detallecodigobarraproducto.setid_producto(-1L);	
				detallecodigobarraproducto.setid_unidad(-1L);	
				detallecodigobarraproducto.setid_linea(-1L);	
				detallecodigobarraproducto.setid_linea_grupo(-1L);	
				detallecodigobarraproducto.setid_linea_categoria(-1L);	
				detallecodigobarraproducto.setid_linea_marca(-1L);	
				detallecodigobarraproducto.setcontrol("");	
				detallecodigobarraproducto.setmedicion("");	
				detallecodigobarraproducto.setvalor_anterior(0.0);	
				detallecodigobarraproducto.setfecha(new Date());	
				detallecodigobarraproducto.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleCodigoBarraProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_CONTROL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_MEDICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_VALORANTERIOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCodigoBarraProductoConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleCodigoBarraProducto(String sTipo,Row row,Workbook workbook,DetalleCodigoBarraProducto detallecodigobarraproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getcontrol());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getmedicion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getvalor_anterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecodigobarraproducto.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleCodigoBarraProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleCodigoBarraProducto() {
		return this.sFinalQueryDetalleCodigoBarraProducto;
	}
	
	public void setsFinalQueryDetalleCodigoBarraProducto(String sFinalQueryDetalleCodigoBarraProducto) {
		this.sFinalQueryDetalleCodigoBarraProducto= sFinalQueryDetalleCodigoBarraProducto;
	}
	
	public Border resaltarSeleccionarDetalleCodigoBarraProducto=null;
	
	public Border setResaltarSeleccionarDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleCodigoBarraProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleCodigoBarraProducto() {
		return this.resaltarSeleccionarDetalleCodigoBarraProducto;
	}
	
	public void setResaltarSeleccionarDetalleCodigoBarraProducto(Border borderResaltarSeleccionarDetalleCodigoBarraProducto) {
		this.resaltarSeleccionarDetalleCodigoBarraProducto= borderResaltarSeleccionarDetalleCodigoBarraProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleCodigoBarraProducto=null;
	public Boolean mostraridDetalleCodigoBarraProducto=true;
	public Boolean activaridDetalleCodigoBarraProducto=true;

	public Border resaltarid_empresaDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_empresaDetalleCodigoBarraProducto=true;
	public Boolean activarid_empresaDetalleCodigoBarraProducto=true;
	public Boolean cargarid_empresaDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_sucursalDetalleCodigoBarraProducto=true;
	public Boolean activarid_sucursalDetalleCodigoBarraProducto=true;
	public Boolean cargarid_sucursalDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_bodegaDetalleCodigoBarraProducto=true;
	public Boolean activarid_bodegaDetalleCodigoBarraProducto=true;
	public Boolean cargarid_bodegaDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_productoDetalleCodigoBarraProducto=true;
	public Boolean activarid_productoDetalleCodigoBarraProducto=true;
	public Boolean cargarid_productoDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleCodigoBarraProducto=true;//ConEventDepend=true

	public Border resaltarid_unidadDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_unidadDetalleCodigoBarraProducto=true;
	public Boolean activarid_unidadDetalleCodigoBarraProducto=true;
	public Boolean cargarid_unidadDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleCodigoBarraProducto=true;//ConEventDepend=true

	public Border resaltarid_lineaDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_lineaDetalleCodigoBarraProducto=true;
	public Boolean activarid_lineaDetalleCodigoBarraProducto=true;
	public Boolean cargarid_lineaDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_linea_grupoDetalleCodigoBarraProducto=true;
	public Boolean activarid_linea_grupoDetalleCodigoBarraProducto=true;
	public Boolean cargarid_linea_grupoDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_linea_categoriaDetalleCodigoBarraProducto=true;
	public Boolean activarid_linea_categoriaDetalleCodigoBarraProducto=true;
	public Boolean cargarid_linea_categoriaDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaDetalleCodigoBarraProducto=null;
	public Boolean mostrarid_linea_marcaDetalleCodigoBarraProducto=true;
	public Boolean activarid_linea_marcaDetalleCodigoBarraProducto=true;
	public Boolean cargarid_linea_marcaDetalleCodigoBarraProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaDetalleCodigoBarraProducto=false;//ConEventDepend=true

	public Border resaltarcontrolDetalleCodigoBarraProducto=null;
	public Boolean mostrarcontrolDetalleCodigoBarraProducto=true;
	public Boolean activarcontrolDetalleCodigoBarraProducto=true;

	public Border resaltarmedicionDetalleCodigoBarraProducto=null;
	public Boolean mostrarmedicionDetalleCodigoBarraProducto=true;
	public Boolean activarmedicionDetalleCodigoBarraProducto=true;

	public Border resaltarvalor_anteriorDetalleCodigoBarraProducto=null;
	public Boolean mostrarvalor_anteriorDetalleCodigoBarraProducto=true;
	public Boolean activarvalor_anteriorDetalleCodigoBarraProducto=true;

	public Border resaltarfechaDetalleCodigoBarraProducto=null;
	public Boolean mostrarfechaDetalleCodigoBarraProducto=true;
	public Boolean activarfechaDetalleCodigoBarraProducto=false;

	public Border resaltarobservacionDetalleCodigoBarraProducto=null;
	public Boolean mostrarobservacionDetalleCodigoBarraProducto=true;
	public Boolean activarobservacionDetalleCodigoBarraProducto=true;

	
	

	public Border setResaltaridDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltaridDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleCodigoBarraProducto() {
		return this.resaltaridDetalleCodigoBarraProducto;
	}

	public void setResaltaridDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltaridDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostraridDetalleCodigoBarraProducto() {
		return this.mostraridDetalleCodigoBarraProducto;
	}

	public void setMostraridDetalleCodigoBarraProducto(Boolean mostraridDetalleCodigoBarraProducto) {
		this.mostraridDetalleCodigoBarraProducto= mostraridDetalleCodigoBarraProducto;
	}

	public Boolean getActivaridDetalleCodigoBarraProducto() {
		return this.activaridDetalleCodigoBarraProducto;
	}

	public void setActivaridDetalleCodigoBarraProducto(Boolean activaridDetalleCodigoBarraProducto) {
		this.activaridDetalleCodigoBarraProducto= activaridDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_empresaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleCodigoBarraProducto() {
		return this.resaltarid_empresaDetalleCodigoBarraProducto;
	}

	public void setResaltarid_empresaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_empresaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleCodigoBarraProducto() {
		return this.mostrarid_empresaDetalleCodigoBarraProducto;
	}

	public void setMostrarid_empresaDetalleCodigoBarraProducto(Boolean mostrarid_empresaDetalleCodigoBarraProducto) {
		this.mostrarid_empresaDetalleCodigoBarraProducto= mostrarid_empresaDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_empresaDetalleCodigoBarraProducto() {
		return this.activarid_empresaDetalleCodigoBarraProducto;
	}

	public void setActivarid_empresaDetalleCodigoBarraProducto(Boolean activarid_empresaDetalleCodigoBarraProducto) {
		this.activarid_empresaDetalleCodigoBarraProducto= activarid_empresaDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_empresaDetalleCodigoBarraProducto() {
		return this.cargarid_empresaDetalleCodigoBarraProducto;
	}

	public void setCargarid_empresaDetalleCodigoBarraProducto(Boolean cargarid_empresaDetalleCodigoBarraProducto) {
		this.cargarid_empresaDetalleCodigoBarraProducto= cargarid_empresaDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_sucursalDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleCodigoBarraProducto() {
		return this.resaltarid_sucursalDetalleCodigoBarraProducto;
	}

	public void setResaltarid_sucursalDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_sucursalDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleCodigoBarraProducto() {
		return this.mostrarid_sucursalDetalleCodigoBarraProducto;
	}

	public void setMostrarid_sucursalDetalleCodigoBarraProducto(Boolean mostrarid_sucursalDetalleCodigoBarraProducto) {
		this.mostrarid_sucursalDetalleCodigoBarraProducto= mostrarid_sucursalDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_sucursalDetalleCodigoBarraProducto() {
		return this.activarid_sucursalDetalleCodigoBarraProducto;
	}

	public void setActivarid_sucursalDetalleCodigoBarraProducto(Boolean activarid_sucursalDetalleCodigoBarraProducto) {
		this.activarid_sucursalDetalleCodigoBarraProducto= activarid_sucursalDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_sucursalDetalleCodigoBarraProducto() {
		return this.cargarid_sucursalDetalleCodigoBarraProducto;
	}

	public void setCargarid_sucursalDetalleCodigoBarraProducto(Boolean cargarid_sucursalDetalleCodigoBarraProducto) {
		this.cargarid_sucursalDetalleCodigoBarraProducto= cargarid_sucursalDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_bodegaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleCodigoBarraProducto() {
		return this.resaltarid_bodegaDetalleCodigoBarraProducto;
	}

	public void setResaltarid_bodegaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_bodegaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleCodigoBarraProducto() {
		return this.mostrarid_bodegaDetalleCodigoBarraProducto;
	}

	public void setMostrarid_bodegaDetalleCodigoBarraProducto(Boolean mostrarid_bodegaDetalleCodigoBarraProducto) {
		this.mostrarid_bodegaDetalleCodigoBarraProducto= mostrarid_bodegaDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_bodegaDetalleCodigoBarraProducto() {
		return this.activarid_bodegaDetalleCodigoBarraProducto;
	}

	public void setActivarid_bodegaDetalleCodigoBarraProducto(Boolean activarid_bodegaDetalleCodigoBarraProducto) {
		this.activarid_bodegaDetalleCodigoBarraProducto= activarid_bodegaDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_bodegaDetalleCodigoBarraProducto() {
		return this.cargarid_bodegaDetalleCodigoBarraProducto;
	}

	public void setCargarid_bodegaDetalleCodigoBarraProducto(Boolean cargarid_bodegaDetalleCodigoBarraProducto) {
		this.cargarid_bodegaDetalleCodigoBarraProducto= cargarid_bodegaDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_productoDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleCodigoBarraProducto() {
		return this.resaltarid_productoDetalleCodigoBarraProducto;
	}

	public void setResaltarid_productoDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_productoDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleCodigoBarraProducto() {
		return this.mostrarid_productoDetalleCodigoBarraProducto;
	}

	public void setMostrarid_productoDetalleCodigoBarraProducto(Boolean mostrarid_productoDetalleCodigoBarraProducto) {
		this.mostrarid_productoDetalleCodigoBarraProducto= mostrarid_productoDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_productoDetalleCodigoBarraProducto() {
		return this.activarid_productoDetalleCodigoBarraProducto;
	}

	public void setActivarid_productoDetalleCodigoBarraProducto(Boolean activarid_productoDetalleCodigoBarraProducto) {
		this.activarid_productoDetalleCodigoBarraProducto= activarid_productoDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_productoDetalleCodigoBarraProducto() {
		return this.cargarid_productoDetalleCodigoBarraProducto;
	}

	public void setCargarid_productoDetalleCodigoBarraProducto(Boolean cargarid_productoDetalleCodigoBarraProducto) {
		this.cargarid_productoDetalleCodigoBarraProducto= cargarid_productoDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_unidadDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleCodigoBarraProducto() {
		return this.resaltarid_unidadDetalleCodigoBarraProducto;
	}

	public void setResaltarid_unidadDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_unidadDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleCodigoBarraProducto() {
		return this.mostrarid_unidadDetalleCodigoBarraProducto;
	}

	public void setMostrarid_unidadDetalleCodigoBarraProducto(Boolean mostrarid_unidadDetalleCodigoBarraProducto) {
		this.mostrarid_unidadDetalleCodigoBarraProducto= mostrarid_unidadDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_unidadDetalleCodigoBarraProducto() {
		return this.activarid_unidadDetalleCodigoBarraProducto;
	}

	public void setActivarid_unidadDetalleCodigoBarraProducto(Boolean activarid_unidadDetalleCodigoBarraProducto) {
		this.activarid_unidadDetalleCodigoBarraProducto= activarid_unidadDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_unidadDetalleCodigoBarraProducto() {
		return this.cargarid_unidadDetalleCodigoBarraProducto;
	}

	public void setCargarid_unidadDetalleCodigoBarraProducto(Boolean cargarid_unidadDetalleCodigoBarraProducto) {
		this.cargarid_unidadDetalleCodigoBarraProducto= cargarid_unidadDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_lineaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_lineaDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaDetalleCodigoBarraProducto() {
		return this.resaltarid_lineaDetalleCodigoBarraProducto;
	}

	public void setResaltarid_lineaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_lineaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_lineaDetalleCodigoBarraProducto() {
		return this.mostrarid_lineaDetalleCodigoBarraProducto;
	}

	public void setMostrarid_lineaDetalleCodigoBarraProducto(Boolean mostrarid_lineaDetalleCodigoBarraProducto) {
		this.mostrarid_lineaDetalleCodigoBarraProducto= mostrarid_lineaDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_lineaDetalleCodigoBarraProducto() {
		return this.activarid_lineaDetalleCodigoBarraProducto;
	}

	public void setActivarid_lineaDetalleCodigoBarraProducto(Boolean activarid_lineaDetalleCodigoBarraProducto) {
		this.activarid_lineaDetalleCodigoBarraProducto= activarid_lineaDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_lineaDetalleCodigoBarraProducto() {
		return this.cargarid_lineaDetalleCodigoBarraProducto;
	}

	public void setCargarid_lineaDetalleCodigoBarraProducto(Boolean cargarid_lineaDetalleCodigoBarraProducto) {
		this.cargarid_lineaDetalleCodigoBarraProducto= cargarid_lineaDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_linea_grupoDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoDetalleCodigoBarraProducto() {
		return this.resaltarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public void setResaltarid_linea_grupoDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_linea_grupoDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoDetalleCodigoBarraProducto() {
		return this.mostrarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public void setMostrarid_linea_grupoDetalleCodigoBarraProducto(Boolean mostrarid_linea_grupoDetalleCodigoBarraProducto) {
		this.mostrarid_linea_grupoDetalleCodigoBarraProducto= mostrarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_linea_grupoDetalleCodigoBarraProducto() {
		return this.activarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public void setActivarid_linea_grupoDetalleCodigoBarraProducto(Boolean activarid_linea_grupoDetalleCodigoBarraProducto) {
		this.activarid_linea_grupoDetalleCodigoBarraProducto= activarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_linea_grupoDetalleCodigoBarraProducto() {
		return this.cargarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public void setCargarid_linea_grupoDetalleCodigoBarraProducto(Boolean cargarid_linea_grupoDetalleCodigoBarraProducto) {
		this.cargarid_linea_grupoDetalleCodigoBarraProducto= cargarid_linea_grupoDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_linea_categoriaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaDetalleCodigoBarraProducto() {
		return this.resaltarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public void setResaltarid_linea_categoriaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_linea_categoriaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaDetalleCodigoBarraProducto() {
		return this.mostrarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public void setMostrarid_linea_categoriaDetalleCodigoBarraProducto(Boolean mostrarid_linea_categoriaDetalleCodigoBarraProducto) {
		this.mostrarid_linea_categoriaDetalleCodigoBarraProducto= mostrarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_linea_categoriaDetalleCodigoBarraProducto() {
		return this.activarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public void setActivarid_linea_categoriaDetalleCodigoBarraProducto(Boolean activarid_linea_categoriaDetalleCodigoBarraProducto) {
		this.activarid_linea_categoriaDetalleCodigoBarraProducto= activarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_linea_categoriaDetalleCodigoBarraProducto() {
		return this.cargarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public void setCargarid_linea_categoriaDetalleCodigoBarraProducto(Boolean cargarid_linea_categoriaDetalleCodigoBarraProducto) {
		this.cargarid_linea_categoriaDetalleCodigoBarraProducto= cargarid_linea_categoriaDetalleCodigoBarraProducto;
	}

	public Border setResaltarid_linea_marcaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaDetalleCodigoBarraProducto() {
		return this.resaltarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public void setResaltarid_linea_marcaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarid_linea_marcaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaDetalleCodigoBarraProducto() {
		return this.mostrarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public void setMostrarid_linea_marcaDetalleCodigoBarraProducto(Boolean mostrarid_linea_marcaDetalleCodigoBarraProducto) {
		this.mostrarid_linea_marcaDetalleCodigoBarraProducto= mostrarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public Boolean getActivarid_linea_marcaDetalleCodigoBarraProducto() {
		return this.activarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public void setActivarid_linea_marcaDetalleCodigoBarraProducto(Boolean activarid_linea_marcaDetalleCodigoBarraProducto) {
		this.activarid_linea_marcaDetalleCodigoBarraProducto= activarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public Boolean getCargarid_linea_marcaDetalleCodigoBarraProducto() {
		return this.cargarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public void setCargarid_linea_marcaDetalleCodigoBarraProducto(Boolean cargarid_linea_marcaDetalleCodigoBarraProducto) {
		this.cargarid_linea_marcaDetalleCodigoBarraProducto= cargarid_linea_marcaDetalleCodigoBarraProducto;
	}

	public Border setResaltarcontrolDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarcontrolDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontrolDetalleCodigoBarraProducto() {
		return this.resaltarcontrolDetalleCodigoBarraProducto;
	}

	public void setResaltarcontrolDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarcontrolDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarcontrolDetalleCodigoBarraProducto() {
		return this.mostrarcontrolDetalleCodigoBarraProducto;
	}

	public void setMostrarcontrolDetalleCodigoBarraProducto(Boolean mostrarcontrolDetalleCodigoBarraProducto) {
		this.mostrarcontrolDetalleCodigoBarraProducto= mostrarcontrolDetalleCodigoBarraProducto;
	}

	public Boolean getActivarcontrolDetalleCodigoBarraProducto() {
		return this.activarcontrolDetalleCodigoBarraProducto;
	}

	public void setActivarcontrolDetalleCodigoBarraProducto(Boolean activarcontrolDetalleCodigoBarraProducto) {
		this.activarcontrolDetalleCodigoBarraProducto= activarcontrolDetalleCodigoBarraProducto;
	}

	public Border setResaltarmedicionDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarmedicionDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmedicionDetalleCodigoBarraProducto() {
		return this.resaltarmedicionDetalleCodigoBarraProducto;
	}

	public void setResaltarmedicionDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarmedicionDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarmedicionDetalleCodigoBarraProducto() {
		return this.mostrarmedicionDetalleCodigoBarraProducto;
	}

	public void setMostrarmedicionDetalleCodigoBarraProducto(Boolean mostrarmedicionDetalleCodigoBarraProducto) {
		this.mostrarmedicionDetalleCodigoBarraProducto= mostrarmedicionDetalleCodigoBarraProducto;
	}

	public Boolean getActivarmedicionDetalleCodigoBarraProducto() {
		return this.activarmedicionDetalleCodigoBarraProducto;
	}

	public void setActivarmedicionDetalleCodigoBarraProducto(Boolean activarmedicionDetalleCodigoBarraProducto) {
		this.activarmedicionDetalleCodigoBarraProducto= activarmedicionDetalleCodigoBarraProducto;
	}

	public Border setResaltarvalor_anteriorDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarvalor_anteriorDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_anteriorDetalleCodigoBarraProducto() {
		return this.resaltarvalor_anteriorDetalleCodigoBarraProducto;
	}

	public void setResaltarvalor_anteriorDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarvalor_anteriorDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarvalor_anteriorDetalleCodigoBarraProducto() {
		return this.mostrarvalor_anteriorDetalleCodigoBarraProducto;
	}

	public void setMostrarvalor_anteriorDetalleCodigoBarraProducto(Boolean mostrarvalor_anteriorDetalleCodigoBarraProducto) {
		this.mostrarvalor_anteriorDetalleCodigoBarraProducto= mostrarvalor_anteriorDetalleCodigoBarraProducto;
	}

	public Boolean getActivarvalor_anteriorDetalleCodigoBarraProducto() {
		return this.activarvalor_anteriorDetalleCodigoBarraProducto;
	}

	public void setActivarvalor_anteriorDetalleCodigoBarraProducto(Boolean activarvalor_anteriorDetalleCodigoBarraProducto) {
		this.activarvalor_anteriorDetalleCodigoBarraProducto= activarvalor_anteriorDetalleCodigoBarraProducto;
	}

	public Border setResaltarfechaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarfechaDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleCodigoBarraProducto() {
		return this.resaltarfechaDetalleCodigoBarraProducto;
	}

	public void setResaltarfechaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarfechaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleCodigoBarraProducto() {
		return this.mostrarfechaDetalleCodigoBarraProducto;
	}

	public void setMostrarfechaDetalleCodigoBarraProducto(Boolean mostrarfechaDetalleCodigoBarraProducto) {
		this.mostrarfechaDetalleCodigoBarraProducto= mostrarfechaDetalleCodigoBarraProducto;
	}

	public Boolean getActivarfechaDetalleCodigoBarraProducto() {
		return this.activarfechaDetalleCodigoBarraProducto;
	}

	public void setActivarfechaDetalleCodigoBarraProducto(Boolean activarfechaDetalleCodigoBarraProducto) {
		this.activarfechaDetalleCodigoBarraProducto= activarfechaDetalleCodigoBarraProducto;
	}

	public Border setResaltarobservacionDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecodigobarraproductoBeanSwingJInternalFrame.jTtoolBarDetalleCodigoBarraProducto.setBorder(borderResaltar);
		
		this.resaltarobservacionDetalleCodigoBarraProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionDetalleCodigoBarraProducto() {
		return this.resaltarobservacionDetalleCodigoBarraProducto;
	}

	public void setResaltarobservacionDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarobservacionDetalleCodigoBarraProducto= borderResaltar;
	}

	public Boolean getMostrarobservacionDetalleCodigoBarraProducto() {
		return this.mostrarobservacionDetalleCodigoBarraProducto;
	}

	public void setMostrarobservacionDetalleCodigoBarraProducto(Boolean mostrarobservacionDetalleCodigoBarraProducto) {
		this.mostrarobservacionDetalleCodigoBarraProducto= mostrarobservacionDetalleCodigoBarraProducto;
	}

	public Boolean getActivarobservacionDetalleCodigoBarraProducto() {
		return this.activarobservacionDetalleCodigoBarraProducto;
	}

	public void setActivarobservacionDetalleCodigoBarraProducto(Boolean activarobservacionDetalleCodigoBarraProducto) {
		this.activarobservacionDetalleCodigoBarraProducto= activarobservacionDetalleCodigoBarraProducto;
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
		
		
		this.setMostraridDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_empresaDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_sucursalDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_bodegaDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_productoDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_unidadDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_lineaDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_linea_grupoDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_linea_categoriaDetalleCodigoBarraProducto(esInicial);
		this.setMostrarid_linea_marcaDetalleCodigoBarraProducto(esInicial);
		this.setMostrarcontrolDetalleCodigoBarraProducto(esInicial);
		this.setMostrarmedicionDetalleCodigoBarraProducto(esInicial);
		this.setMostrarvalor_anteriorDetalleCodigoBarraProducto(esInicial);
		this.setMostrarfechaDetalleCodigoBarraProducto(esInicial);
		this.setMostrarobservacionDetalleCodigoBarraProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.ID)) {
				this.setMostraridDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.CONTROL)) {
				this.setMostrarcontrolDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.MEDICION)) {
				this.setMostrarmedicionDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR)) {
				this.setMostrarvalor_anteriorDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionDetalleCodigoBarraProducto(esAsigna);
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
		
		
		this.setActivaridDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_empresaDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_sucursalDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_bodegaDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_productoDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_unidadDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_lineaDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_linea_grupoDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_linea_categoriaDetalleCodigoBarraProducto(esInicial);
		this.setActivarid_linea_marcaDetalleCodigoBarraProducto(esInicial);
		this.setActivarcontrolDetalleCodigoBarraProducto(esInicial);
		this.setActivarmedicionDetalleCodigoBarraProducto(esInicial);
		this.setActivarvalor_anteriorDetalleCodigoBarraProducto(esInicial);
		this.setActivarfechaDetalleCodigoBarraProducto(esInicial);
		this.setActivarobservacionDetalleCodigoBarraProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.ID)) {
				this.setActivaridDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.CONTROL)) {
				this.setActivarcontrolDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.MEDICION)) {
				this.setActivarmedicionDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR)) {
				this.setActivarvalor_anteriorDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionDetalleCodigoBarraProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_empresaDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_sucursalDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_bodegaDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_productoDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_unidadDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_lineaDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_linea_grupoDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_linea_categoriaDetalleCodigoBarraProducto(esInicial);
		this.setResaltarid_linea_marcaDetalleCodigoBarraProducto(esInicial);
		this.setResaltarcontrolDetalleCodigoBarraProducto(esInicial);
		this.setResaltarmedicionDetalleCodigoBarraProducto(esInicial);
		this.setResaltarvalor_anteriorDetalleCodigoBarraProducto(esInicial);
		this.setResaltarfechaDetalleCodigoBarraProducto(esInicial);
		this.setResaltarobservacionDetalleCodigoBarraProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.ID)) {
				this.setResaltaridDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.CONTROL)) {
				this.setResaltarcontrolDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.MEDICION)) {
				this.setResaltarmedicionDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.VALORANTERIOR)) {
				this.setResaltarvalor_anteriorDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleCodigoBarraProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCodigoBarraProductoConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionDetalleCodigoBarraProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdBodegaDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdBodegaDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdBodegaDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdEmpresaDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdEmpresaDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdEmpresaDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdLineaDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdLineaDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdLineaDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaCategoriaDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdLineaCategoriaDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdLineaCategoriaDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdLineaCategoriaDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaCategoriaDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaGrupoDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdLineaGrupoDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdLineaGrupoDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdLineaGrupoDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaGrupoDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaMarcaDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdLineaMarcaDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdLineaMarcaDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdLineaMarcaDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaMarcaDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdProductoDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdProductoDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdProductoDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdSucursalDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdSucursalDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdSucursalDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleCodigoBarraProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleCodigoBarraProducto=true;

	public Boolean getMostrarFK_IdUnidadDetalleCodigoBarraProducto() {
		return this.mostrarFK_IdUnidadDetalleCodigoBarraProducto;
	}

	public void setMostrarFK_IdUnidadDetalleCodigoBarraProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleCodigoBarraProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdBodegaDetalleCodigoBarraProducto() {
		return this.activarFK_IdBodegaDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdBodegaDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdEmpresaDetalleCodigoBarraProducto() {
		return this.activarFK_IdEmpresaDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdEmpresaDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdLineaDetalleCodigoBarraProducto() {
		return this.activarFK_IdLineaDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdLineaDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaCategoriaDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdLineaCategoriaDetalleCodigoBarraProducto() {
		return this.activarFK_IdLineaCategoriaDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdLineaCategoriaDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaCategoriaDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaGrupoDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdLineaGrupoDetalleCodigoBarraProducto() {
		return this.activarFK_IdLineaGrupoDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdLineaGrupoDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaGrupoDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaMarcaDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdLineaMarcaDetalleCodigoBarraProducto() {
		return this.activarFK_IdLineaMarcaDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdLineaMarcaDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaMarcaDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdProductoDetalleCodigoBarraProducto() {
		return this.activarFK_IdProductoDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdProductoDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdSucursalDetalleCodigoBarraProducto() {
		return this.activarFK_IdSucursalDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdSucursalDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleCodigoBarraProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleCodigoBarraProducto=true;

	public Boolean getActivarFK_IdUnidadDetalleCodigoBarraProducto() {
		return this.activarFK_IdUnidadDetalleCodigoBarraProducto;
	}

	public void setActivarFK_IdUnidadDetalleCodigoBarraProducto(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleCodigoBarraProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdBodegaDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdBodegaDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdBodegaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdEmpresaDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdEmpresaDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdEmpresaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdLineaDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdLineaDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdLineaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaCategoriaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaGrupoDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdLineaGrupoDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdLineaGrupoDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdLineaGrupoDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaGrupoDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaGrupoDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaGrupoDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaMarcaDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdLineaMarcaDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdLineaMarcaDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdLineaMarcaDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaMarcaDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaMarcaDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaMarcaDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdProductoDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdProductoDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdProductoDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdSucursalDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdSucursalDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdSucursalDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleCodigoBarraProducto= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleCodigoBarraProducto=null;

	public Border getResaltarFK_IdUnidadDetalleCodigoBarraProducto() {
		return this.resaltarFK_IdUnidadDetalleCodigoBarraProducto;
	}

	public void setResaltarFK_IdUnidadDetalleCodigoBarraProducto(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleCodigoBarraProducto= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleCodigoBarraProducto(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCodigoBarraProductoBeanSwingJInternalFrame detallecodigobarraproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleCodigoBarraProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}