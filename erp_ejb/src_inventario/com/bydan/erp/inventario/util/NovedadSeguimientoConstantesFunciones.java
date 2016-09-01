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


import com.bydan.erp.inventario.util.NovedadSeguimientoConstantesFunciones;
import com.bydan.erp.inventario.util.NovedadSeguimientoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.NovedadSeguimientoParameterGeneral;

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
final public class NovedadSeguimientoConstantesFunciones extends NovedadSeguimientoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NovedadSeguimiento";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NovedadSeguimiento"+NovedadSeguimientoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NovedadSeguimientoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NovedadSeguimientoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NovedadSeguimientoConstantesFunciones.SCHEMA+"_"+NovedadSeguimientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NovedadSeguimientoConstantesFunciones.SCHEMA+"_"+NovedadSeguimientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NovedadSeguimientoConstantesFunciones.SCHEMA+"_"+NovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NovedadSeguimientoConstantesFunciones.SCHEMA+"_"+NovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NovedadSeguimientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NovedadSeguimientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NovedadSeguimientoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NovedadSeguimientoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NovedadSeguimientoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NovedadSeguimientoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Novedad Seguimientoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Novedad Seguimiento";
	public static final String SCLASSWEBTITULO_LOWER="Novedad Seguimiento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NovedadSeguimiento";
	public static final String OBJECTNAME="novedadseguimiento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="novedad_seguimiento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select novedadseguimiento from "+NovedadSeguimientoConstantesFunciones.SPERSISTENCENAME+" novedadseguimiento";
	public static String QUERYSELECTNATIVE="select "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".version_row,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_empresa,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_sucursal,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_detalle_movimiento_inventario,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_novedad_producto,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".numero_comprobante,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".fecha_novedad,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".fecha_seguimiento,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".descripcion,"+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME+".id_estado_novedad_seguimiento from "+NovedadSeguimientoConstantesFunciones.SCHEMA+"."+NovedadSeguimientoConstantesFunciones.TABLENAME;//+" as "+NovedadSeguimientoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NovedadSeguimientoConstantesFuncionesAdditional novedadseguimientoConstantesFuncionesAdditional=null;
	
	public NovedadSeguimientoConstantesFuncionesAdditional getNovedadSeguimientoConstantesFuncionesAdditional() {
		return this.novedadseguimientoConstantesFuncionesAdditional;
	}
	
	public void setNovedadSeguimientoConstantesFuncionesAdditional(NovedadSeguimientoConstantesFuncionesAdditional novedadseguimientoConstantesFuncionesAdditional) {
		try {
			this.novedadseguimientoConstantesFuncionesAdditional=novedadseguimientoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEMOVIMIENTOINVENTARIO= "id_detalle_movimiento_inventario";
    public static final String IDNOVEDADPRODUCTO= "id_novedad_producto";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHANOVEDAD= "fecha_novedad";
    public static final String FECHASEGUIMIENTO= "fecha_seguimiento";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDESTADONOVEDADSEGUIMIENTO= "id_estado_novedad_seguimiento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEMOVIMIENTOINVENTARIO= "Detalle Movimiento Inventario";
		public static final String LABEL_IDDETALLEMOVIMIENTOINVENTARIO_LOWER= "Detalle Movimiento Inventario";
    	public static final String LABEL_IDNOVEDADPRODUCTO= "Novedad Producto";
		public static final String LABEL_IDNOVEDADPRODUCTO_LOWER= "Novedad Producto";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHANOVEDAD= "Fecha Novedad";
		public static final String LABEL_FECHANOVEDAD_LOWER= "Fecha Novedad";
    	public static final String LABEL_FECHASEGUIMIENTO= "Fecha Seguimiento";
		public static final String LABEL_FECHASEGUIMIENTO_LOWER= "Fecha Seguimiento";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDESTADONOVEDADSEGUIMIENTO= "Estado Novedad Seguimiento";
		public static final String LABEL_IDESTADONOVEDADSEGUIMIENTO_LOWER= "Estado Novedad Seguimiento";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getNovedadSeguimientoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.IDEMPRESA)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_IDNOVEDADPRODUCTO;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.FECHANOVEDAD)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_FECHANOVEDAD;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_FECHASEGUIMIENTO;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.DESCRIPCION)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO)) {sLabelColumna=NovedadSeguimientoConstantesFunciones.LABEL_IDESTADONOVEDADSEGUIMIENTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getNovedadSeguimientoDescripcion(NovedadSeguimiento novedadseguimiento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(novedadseguimiento !=null/* && novedadseguimiento.getId()!=0*/) {
			if(novedadseguimiento.getId()!=null) {
				sDescripcion=novedadseguimiento.getId().toString();
			}//novedadseguimientonovedadseguimiento.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNovedadSeguimientoDescripcionDetallado(NovedadSeguimiento novedadseguimiento) {
		String sDescripcion="";
			
		sDescripcion+=NovedadSeguimientoConstantesFunciones.ID+"=";
		sDescripcion+=novedadseguimiento.getId().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=novedadseguimiento.getVersionRow().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=novedadseguimiento.getid_empresa().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=novedadseguimiento.getid_sucursal().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO+"=";
		sDescripcion+=novedadseguimiento.getid_detalle_movimiento_inventario().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO+"=";
		sDescripcion+=novedadseguimiento.getid_novedad_producto().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=novedadseguimiento.getnumero_comprobante()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.FECHANOVEDAD+"=";
		sDescripcion+=novedadseguimiento.getfecha_novedad().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO+"=";
		sDescripcion+=novedadseguimiento.getfecha_seguimiento().toString()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=novedadseguimiento.getdescripcion()+",";
		sDescripcion+=NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO+"=";
		sDescripcion+=novedadseguimiento.getid_estado_novedad_seguimiento().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNovedadSeguimientoDescripcion(NovedadSeguimiento novedadseguimiento,String sValor) throws Exception {			
		if(novedadseguimiento !=null) {
			//novedadseguimientonovedadseguimiento.getId().toString();
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

	public static String getDetalleMovimientoInventarioDescripcion(DetalleMovimientoInventario detallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallemovimientoinventario!=null/*&&detallemovimientoinventario.getId()>0*/) {
			sDescripcion=DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioDescripcion(detallemovimientoinventario);
		}

		return sDescripcion;
	}

	public static String getNovedadProductoDescripcion(NovedadProducto novedadproducto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(novedadproducto!=null/*&&novedadproducto.getId()>0*/) {
			sDescripcion=NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(novedadproducto);
		}

		return sDescripcion;
	}

	public static String getEstadoNovedadSeguimientoDescripcion(EstadoNovedadSeguimiento estadonovedadseguimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadonovedadseguimiento!=null/*&&estadonovedadseguimiento.getId()>0*/) {
			sDescripcion=EstadoNovedadSeguimientoConstantesFunciones.getEstadoNovedadSeguimientoDescripcion(estadonovedadseguimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDetalleMovimientoInventario")) {
			sNombreIndice="Tipo=  Por Detalle Movimiento Inventario";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoNovedadSeguimiento")) {
			sNombreIndice="Tipo=  Por Estado Novedad Seguimiento";
		} else if(sNombreIndice.equals("FK_IdNovedadProducto")) {
			sNombreIndice="Tipo=  Por Novedad Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleMovimientoInventario(Long id_detalle_movimiento_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_movimiento_inventario!=null) {sDetalleIndice+=" Codigo Unico De Detalle Movimiento Inventario="+id_detalle_movimiento_inventario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoNovedadSeguimiento(Long id_estado_novedad_seguimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_novedad_seguimiento!=null) {sDetalleIndice+=" Codigo Unico De Estado Novedad Seguimiento="+id_estado_novedad_seguimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNovedadProducto(Long id_novedad_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_novedad_producto!=null) {sDetalleIndice+=" Codigo Unico De Novedad Producto="+id_novedad_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosNovedadSeguimiento(NovedadSeguimiento novedadseguimiento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		novedadseguimiento.setnumero_comprobante(novedadseguimiento.getnumero_comprobante().trim());
		novedadseguimiento.setdescripcion(novedadseguimiento.getdescripcion().trim());
	}
	
	public static void quitarEspaciosNovedadSeguimientos(List<NovedadSeguimiento> novedadseguimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NovedadSeguimiento novedadseguimiento: novedadseguimientos) {
			novedadseguimiento.setnumero_comprobante(novedadseguimiento.getnumero_comprobante().trim());
			novedadseguimiento.setdescripcion(novedadseguimiento.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedadSeguimiento(NovedadSeguimiento novedadseguimiento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && novedadseguimiento.getConCambioAuxiliar()) {
			novedadseguimiento.setIsDeleted(novedadseguimiento.getIsDeletedAuxiliar());	
			novedadseguimiento.setIsNew(novedadseguimiento.getIsNewAuxiliar());	
			novedadseguimiento.setIsChanged(novedadseguimiento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			novedadseguimiento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			novedadseguimiento.setIsDeletedAuxiliar(false);	
			novedadseguimiento.setIsNewAuxiliar(false);	
			novedadseguimiento.setIsChangedAuxiliar(false);
			
			novedadseguimiento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNovedadSeguimientos(List<NovedadSeguimiento> novedadseguimientos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NovedadSeguimiento novedadseguimiento : novedadseguimientos) {
			if(conAsignarBase && novedadseguimiento.getConCambioAuxiliar()) {
				novedadseguimiento.setIsDeleted(novedadseguimiento.getIsDeletedAuxiliar());	
				novedadseguimiento.setIsNew(novedadseguimiento.getIsNewAuxiliar());	
				novedadseguimiento.setIsChanged(novedadseguimiento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				novedadseguimiento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				novedadseguimiento.setIsDeletedAuxiliar(false);	
				novedadseguimiento.setIsNewAuxiliar(false);	
				novedadseguimiento.setIsChangedAuxiliar(false);
				
				novedadseguimiento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNovedadSeguimiento(NovedadSeguimiento novedadseguimiento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNovedadSeguimientos(List<NovedadSeguimiento> novedadseguimientos,Boolean conEnteros) throws Exception  {
		
		for(NovedadSeguimiento novedadseguimiento: novedadseguimientos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNovedadSeguimiento(List<NovedadSeguimiento> novedadseguimientos,NovedadSeguimiento novedadseguimientoAux) throws Exception  {
		NovedadSeguimientoConstantesFunciones.InicializarValoresNovedadSeguimiento(novedadseguimientoAux,true);
		
		for(NovedadSeguimiento novedadseguimiento: novedadseguimientos) {
			if(novedadseguimiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedadSeguimiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NovedadSeguimientoConstantesFunciones.getArrayColumnasGlobalesNovedadSeguimiento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNovedadSeguimiento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadSeguimientoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadSeguimientoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NovedadSeguimientoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NovedadSeguimientoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNovedadSeguimiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NovedadSeguimiento> novedadseguimientos,NovedadSeguimiento novedadseguimiento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NovedadSeguimiento novedadseguimientoAux: novedadseguimientos) {
			if(novedadseguimientoAux!=null && novedadseguimiento!=null) {
				if((novedadseguimientoAux.getId()==null && novedadseguimiento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(novedadseguimientoAux.getId()!=null && novedadseguimiento.getId()!=null){
					if(novedadseguimientoAux.getId().equals(novedadseguimiento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNovedadSeguimiento(List<NovedadSeguimiento> novedadseguimientos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NovedadSeguimiento novedadseguimiento: novedadseguimientos) {			
			if(novedadseguimiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNovedadSeguimiento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_ID, NovedadSeguimientoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_VERSIONROW, NovedadSeguimientoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_IDEMPRESA, NovedadSeguimientoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_IDSUCURSAL, NovedadSeguimientoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO, NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_IDNOVEDADPRODUCTO, NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_NUMEROCOMPROBANTE, NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_FECHANOVEDAD, NovedadSeguimientoConstantesFunciones.FECHANOVEDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_FECHASEGUIMIENTO, NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_DESCRIPCION, NovedadSeguimientoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NovedadSeguimientoConstantesFunciones.LABEL_IDESTADONOVEDADSEGUIMIENTO, NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNovedadSeguimiento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.FECHANOVEDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadSeguimiento() throws Exception  {
		return NovedadSeguimientoConstantesFunciones.getTiposSeleccionarNovedadSeguimiento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadSeguimiento(Boolean conFk) throws Exception  {
		return NovedadSeguimientoConstantesFunciones.getTiposSeleccionarNovedadSeguimiento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNovedadSeguimiento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_FECHANOVEDAD);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_FECHANOVEDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_FECHASEGUIMIENTO);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_FECHASEGUIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NovedadSeguimientoConstantesFunciones.LABEL_IDESTADONOVEDADSEGUIMIENTO);
			reporte.setsDescripcion(NovedadSeguimientoConstantesFunciones.LABEL_IDESTADONOVEDADSEGUIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNovedadSeguimiento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNovedadSeguimiento(NovedadSeguimiento novedadseguimientoAux) throws Exception {
		
			novedadseguimientoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadseguimientoAux.getEmpresa()));
			novedadseguimientoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(novedadseguimientoAux.getSucursal()));
			novedadseguimientoAux.setdetallemovimientoinventario_descripcion(DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioDescripcion(novedadseguimientoAux.getDetalleMovimientoInventario()));
			novedadseguimientoAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(novedadseguimientoAux.getNovedadProducto()));
			novedadseguimientoAux.setestadonovedadseguimiento_descripcion(EstadoNovedadSeguimientoConstantesFunciones.getEstadoNovedadSeguimientoDescripcion(novedadseguimientoAux.getEstadoNovedadSeguimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNovedadSeguimiento(List<NovedadSeguimiento> novedadseguimientosTemp) throws Exception {
		for(NovedadSeguimiento novedadseguimientoAux:novedadseguimientosTemp) {
			
			novedadseguimientoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(novedadseguimientoAux.getEmpresa()));
			novedadseguimientoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(novedadseguimientoAux.getSucursal()));
			novedadseguimientoAux.setdetallemovimientoinventario_descripcion(DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioDescripcion(novedadseguimientoAux.getDetalleMovimientoInventario()));
			novedadseguimientoAux.setnovedadproducto_descripcion(NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(novedadseguimientoAux.getNovedadProducto()));
			novedadseguimientoAux.setestadonovedadseguimiento_descripcion(EstadoNovedadSeguimientoConstantesFunciones.getEstadoNovedadSeguimientoDescripcion(novedadseguimientoAux.getEstadoNovedadSeguimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleMovimientoInventario.class));
				classes.add(new Classe(NovedadProducto.class));
				classes.add(new Classe(EstadoNovedadSeguimiento.class));
				
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
					if(clas.clas.equals(DetalleMovimientoInventario.class)) {
						classes.add(new Classe(DetalleMovimientoInventario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NovedadProducto.class)) {
						classes.add(new Classe(NovedadProducto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoNovedadSeguimiento.class)) {
						classes.add(new Classe(EstadoNovedadSeguimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNovedadSeguimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(EstadoNovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNovedadSeguimiento.class)); continue;
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

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}

					if(NovedadProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NovedadProducto.class)); continue;
					}

					if(EstadoNovedadSeguimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNovedadSeguimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadSeguimientoConstantesFunciones.getClassesRelationshipsOfNovedadSeguimiento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedadSeguimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NovedadSeguimientoConstantesFunciones.getClassesRelationshipsFromStringsOfNovedadSeguimiento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNovedadSeguimiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NovedadSeguimiento novedadseguimiento,List<NovedadSeguimiento> novedadseguimientos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NovedadSeguimiento novedadseguimientoEncontrado=null;
			
			for(NovedadSeguimiento novedadseguimientoLocal:novedadseguimientos) {
				if(novedadseguimientoLocal.getId().equals(novedadseguimiento.getId())) {
					novedadseguimientoEncontrado=novedadseguimientoLocal;
					
					novedadseguimientoLocal.setIsChanged(novedadseguimiento.getIsChanged());
					novedadseguimientoLocal.setIsNew(novedadseguimiento.getIsNew());
					novedadseguimientoLocal.setIsDeleted(novedadseguimiento.getIsDeleted());
					
					novedadseguimientoLocal.setGeneralEntityOriginal(novedadseguimiento.getGeneralEntityOriginal());
					
					novedadseguimientoLocal.setId(novedadseguimiento.getId());	
					novedadseguimientoLocal.setVersionRow(novedadseguimiento.getVersionRow());	
					novedadseguimientoLocal.setid_empresa(novedadseguimiento.getid_empresa());	
					novedadseguimientoLocal.setid_sucursal(novedadseguimiento.getid_sucursal());	
					novedadseguimientoLocal.setid_detalle_movimiento_inventario(novedadseguimiento.getid_detalle_movimiento_inventario());	
					novedadseguimientoLocal.setid_novedad_producto(novedadseguimiento.getid_novedad_producto());	
					novedadseguimientoLocal.setnumero_comprobante(novedadseguimiento.getnumero_comprobante());	
					novedadseguimientoLocal.setfecha_novedad(novedadseguimiento.getfecha_novedad());	
					novedadseguimientoLocal.setfecha_seguimiento(novedadseguimiento.getfecha_seguimiento());	
					novedadseguimientoLocal.setdescripcion(novedadseguimiento.getdescripcion());	
					novedadseguimientoLocal.setid_estado_novedad_seguimiento(novedadseguimiento.getid_estado_novedad_seguimiento());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!novedadseguimiento.getIsDeleted()) {
				if(!existe) {
					novedadseguimientos.add(novedadseguimiento);
				}
			} else {
				if(novedadseguimientoEncontrado!=null && permiteQuitar)  {
					novedadseguimientos.remove(novedadseguimientoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NovedadSeguimiento novedadseguimiento,List<NovedadSeguimiento> novedadseguimientos) throws Exception {
		try	{			
			for(NovedadSeguimiento novedadseguimientoLocal:novedadseguimientos) {
				if(novedadseguimientoLocal.getId().equals(novedadseguimiento.getId())) {
					novedadseguimientoLocal.setIsSelected(novedadseguimiento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNovedadSeguimiento(List<NovedadSeguimiento> novedadseguimientosAux) throws Exception {
		//this.novedadseguimientosAux=novedadseguimientosAux;
		
		for(NovedadSeguimiento novedadseguimientoAux:novedadseguimientosAux) {
			if(novedadseguimientoAux.getIsChanged()) {
				novedadseguimientoAux.setIsChanged(false);
			}		
			
			if(novedadseguimientoAux.getIsNew()) {
				novedadseguimientoAux.setIsNew(false);
			}	
			
			if(novedadseguimientoAux.getIsDeleted()) {
				novedadseguimientoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNovedadSeguimiento(NovedadSeguimiento novedadseguimientoAux) throws Exception {
		//this.novedadseguimientoAux=novedadseguimientoAux;
		
			if(novedadseguimientoAux.getIsChanged()) {
				novedadseguimientoAux.setIsChanged(false);
			}		
			
			if(novedadseguimientoAux.getIsNew()) {
				novedadseguimientoAux.setIsNew(false);
			}	
			
			if(novedadseguimientoAux.getIsDeleted()) {
				novedadseguimientoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NovedadSeguimiento novedadseguimientoAsignar,NovedadSeguimiento novedadseguimiento) throws Exception {
		novedadseguimientoAsignar.setId(novedadseguimiento.getId());	
		novedadseguimientoAsignar.setVersionRow(novedadseguimiento.getVersionRow());	
		novedadseguimientoAsignar.setid_empresa(novedadseguimiento.getid_empresa());
		novedadseguimientoAsignar.setempresa_descripcion(novedadseguimiento.getempresa_descripcion());	
		novedadseguimientoAsignar.setid_sucursal(novedadseguimiento.getid_sucursal());
		novedadseguimientoAsignar.setsucursal_descripcion(novedadseguimiento.getsucursal_descripcion());	
		novedadseguimientoAsignar.setid_detalle_movimiento_inventario(novedadseguimiento.getid_detalle_movimiento_inventario());
		novedadseguimientoAsignar.setdetallemovimientoinventario_descripcion(novedadseguimiento.getdetallemovimientoinventario_descripcion());	
		novedadseguimientoAsignar.setid_novedad_producto(novedadseguimiento.getid_novedad_producto());
		novedadseguimientoAsignar.setnovedadproducto_descripcion(novedadseguimiento.getnovedadproducto_descripcion());	
		novedadseguimientoAsignar.setnumero_comprobante(novedadseguimiento.getnumero_comprobante());	
		novedadseguimientoAsignar.setfecha_novedad(novedadseguimiento.getfecha_novedad());	
		novedadseguimientoAsignar.setfecha_seguimiento(novedadseguimiento.getfecha_seguimiento());	
		novedadseguimientoAsignar.setdescripcion(novedadseguimiento.getdescripcion());	
		novedadseguimientoAsignar.setid_estado_novedad_seguimiento(novedadseguimiento.getid_estado_novedad_seguimiento());
		novedadseguimientoAsignar.setestadonovedadseguimiento_descripcion(novedadseguimiento.getestadonovedadseguimiento_descripcion());	
	}
	
	public static void inicializarNovedadSeguimiento(NovedadSeguimiento novedadseguimiento) throws Exception {
		try {
				novedadseguimiento.setId(0L);	
					
				novedadseguimiento.setid_empresa(-1L);	
				novedadseguimiento.setid_sucursal(-1L);	
				novedadseguimiento.setid_detalle_movimiento_inventario(-1L);	
				novedadseguimiento.setid_novedad_producto(-1L);	
				novedadseguimiento.setnumero_comprobante("");	
				novedadseguimiento.setfecha_novedad(new Date());	
				novedadseguimiento.setfecha_seguimiento(new Date());	
				novedadseguimiento.setdescripcion("");	
				novedadseguimiento.setid_estado_novedad_seguimiento(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNovedadSeguimiento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_IDNOVEDADPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_FECHANOVEDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_FECHASEGUIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NovedadSeguimientoConstantesFunciones.LABEL_IDESTADONOVEDADSEGUIMIENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNovedadSeguimiento(String sTipo,Row row,Workbook workbook,NovedadSeguimiento novedadseguimiento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getdetallemovimientoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getnovedadproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getfecha_novedad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getfecha_seguimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(novedadseguimiento.getestadonovedadseguimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNovedadSeguimiento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNovedadSeguimiento() {
		return this.sFinalQueryNovedadSeguimiento;
	}
	
	public void setsFinalQueryNovedadSeguimiento(String sFinalQueryNovedadSeguimiento) {
		this.sFinalQueryNovedadSeguimiento= sFinalQueryNovedadSeguimiento;
	}
	
	public Border resaltarSeleccionarNovedadSeguimiento=null;
	
	public Border setResaltarSeleccionarNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNovedadSeguimiento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNovedadSeguimiento() {
		return this.resaltarSeleccionarNovedadSeguimiento;
	}
	
	public void setResaltarSeleccionarNovedadSeguimiento(Border borderResaltarSeleccionarNovedadSeguimiento) {
		this.resaltarSeleccionarNovedadSeguimiento= borderResaltarSeleccionarNovedadSeguimiento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNovedadSeguimiento=null;
	public Boolean mostraridNovedadSeguimiento=true;
	public Boolean activaridNovedadSeguimiento=true;

	public Border resaltarid_empresaNovedadSeguimiento=null;
	public Boolean mostrarid_empresaNovedadSeguimiento=true;
	public Boolean activarid_empresaNovedadSeguimiento=true;
	public Boolean cargarid_empresaNovedadSeguimiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNovedadSeguimiento=false;//ConEventDepend=true

	public Border resaltarid_sucursalNovedadSeguimiento=null;
	public Boolean mostrarid_sucursalNovedadSeguimiento=true;
	public Boolean activarid_sucursalNovedadSeguimiento=true;
	public Boolean cargarid_sucursalNovedadSeguimiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalNovedadSeguimiento=false;//ConEventDepend=true

	public Border resaltarid_detalle_movimiento_inventarioNovedadSeguimiento=null;
	public Boolean mostrarid_detalle_movimiento_inventarioNovedadSeguimiento=true;
	public Boolean activarid_detalle_movimiento_inventarioNovedadSeguimiento=true;
	public Boolean cargarid_detalle_movimiento_inventarioNovedadSeguimiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_movimiento_inventarioNovedadSeguimiento=false;//ConEventDepend=true

	public Border resaltarid_novedad_productoNovedadSeguimiento=null;
	public Boolean mostrarid_novedad_productoNovedadSeguimiento=true;
	public Boolean activarid_novedad_productoNovedadSeguimiento=true;
	public Boolean cargarid_novedad_productoNovedadSeguimiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_novedad_productoNovedadSeguimiento=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteNovedadSeguimiento=null;
	public Boolean mostrarnumero_comprobanteNovedadSeguimiento=true;
	public Boolean activarnumero_comprobanteNovedadSeguimiento=true;

	public Border resaltarfecha_novedadNovedadSeguimiento=null;
	public Boolean mostrarfecha_novedadNovedadSeguimiento=true;
	public Boolean activarfecha_novedadNovedadSeguimiento=false;

	public Border resaltarfecha_seguimientoNovedadSeguimiento=null;
	public Boolean mostrarfecha_seguimientoNovedadSeguimiento=true;
	public Boolean activarfecha_seguimientoNovedadSeguimiento=false;

	public Border resaltardescripcionNovedadSeguimiento=null;
	public Boolean mostrardescripcionNovedadSeguimiento=true;
	public Boolean activardescripcionNovedadSeguimiento=true;

	public Border resaltarid_estado_novedad_seguimientoNovedadSeguimiento=null;
	public Boolean mostrarid_estado_novedad_seguimientoNovedadSeguimiento=true;
	public Boolean activarid_estado_novedad_seguimientoNovedadSeguimiento=true;
	public Boolean cargarid_estado_novedad_seguimientoNovedadSeguimiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_novedad_seguimientoNovedadSeguimiento=false;//ConEventDepend=true

	
	

	public Border setResaltaridNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltaridNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNovedadSeguimiento() {
		return this.resaltaridNovedadSeguimiento;
	}

	public void setResaltaridNovedadSeguimiento(Border borderResaltar) {
		this.resaltaridNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostraridNovedadSeguimiento() {
		return this.mostraridNovedadSeguimiento;
	}

	public void setMostraridNovedadSeguimiento(Boolean mostraridNovedadSeguimiento) {
		this.mostraridNovedadSeguimiento= mostraridNovedadSeguimiento;
	}

	public Boolean getActivaridNovedadSeguimiento() {
		return this.activaridNovedadSeguimiento;
	}

	public void setActivaridNovedadSeguimiento(Boolean activaridNovedadSeguimiento) {
		this.activaridNovedadSeguimiento= activaridNovedadSeguimiento;
	}

	public Border setResaltarid_empresaNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarid_empresaNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNovedadSeguimiento() {
		return this.resaltarid_empresaNovedadSeguimiento;
	}

	public void setResaltarid_empresaNovedadSeguimiento(Border borderResaltar) {
		this.resaltarid_empresaNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarid_empresaNovedadSeguimiento() {
		return this.mostrarid_empresaNovedadSeguimiento;
	}

	public void setMostrarid_empresaNovedadSeguimiento(Boolean mostrarid_empresaNovedadSeguimiento) {
		this.mostrarid_empresaNovedadSeguimiento= mostrarid_empresaNovedadSeguimiento;
	}

	public Boolean getActivarid_empresaNovedadSeguimiento() {
		return this.activarid_empresaNovedadSeguimiento;
	}

	public void setActivarid_empresaNovedadSeguimiento(Boolean activarid_empresaNovedadSeguimiento) {
		this.activarid_empresaNovedadSeguimiento= activarid_empresaNovedadSeguimiento;
	}

	public Boolean getCargarid_empresaNovedadSeguimiento() {
		return this.cargarid_empresaNovedadSeguimiento;
	}

	public void setCargarid_empresaNovedadSeguimiento(Boolean cargarid_empresaNovedadSeguimiento) {
		this.cargarid_empresaNovedadSeguimiento= cargarid_empresaNovedadSeguimiento;
	}

	public Border setResaltarid_sucursalNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarid_sucursalNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalNovedadSeguimiento() {
		return this.resaltarid_sucursalNovedadSeguimiento;
	}

	public void setResaltarid_sucursalNovedadSeguimiento(Border borderResaltar) {
		this.resaltarid_sucursalNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarid_sucursalNovedadSeguimiento() {
		return this.mostrarid_sucursalNovedadSeguimiento;
	}

	public void setMostrarid_sucursalNovedadSeguimiento(Boolean mostrarid_sucursalNovedadSeguimiento) {
		this.mostrarid_sucursalNovedadSeguimiento= mostrarid_sucursalNovedadSeguimiento;
	}

	public Boolean getActivarid_sucursalNovedadSeguimiento() {
		return this.activarid_sucursalNovedadSeguimiento;
	}

	public void setActivarid_sucursalNovedadSeguimiento(Boolean activarid_sucursalNovedadSeguimiento) {
		this.activarid_sucursalNovedadSeguimiento= activarid_sucursalNovedadSeguimiento;
	}

	public Boolean getCargarid_sucursalNovedadSeguimiento() {
		return this.cargarid_sucursalNovedadSeguimiento;
	}

	public void setCargarid_sucursalNovedadSeguimiento(Boolean cargarid_sucursalNovedadSeguimiento) {
		this.cargarid_sucursalNovedadSeguimiento= cargarid_sucursalNovedadSeguimiento;
	}

	public Border setResaltarid_detalle_movimiento_inventarioNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarid_detalle_movimiento_inventarioNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_movimiento_inventarioNovedadSeguimiento() {
		return this.resaltarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public void setResaltarid_detalle_movimiento_inventarioNovedadSeguimiento(Border borderResaltar) {
		this.resaltarid_detalle_movimiento_inventarioNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarid_detalle_movimiento_inventarioNovedadSeguimiento() {
		return this.mostrarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public void setMostrarid_detalle_movimiento_inventarioNovedadSeguimiento(Boolean mostrarid_detalle_movimiento_inventarioNovedadSeguimiento) {
		this.mostrarid_detalle_movimiento_inventarioNovedadSeguimiento= mostrarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public Boolean getActivarid_detalle_movimiento_inventarioNovedadSeguimiento() {
		return this.activarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public void setActivarid_detalle_movimiento_inventarioNovedadSeguimiento(Boolean activarid_detalle_movimiento_inventarioNovedadSeguimiento) {
		this.activarid_detalle_movimiento_inventarioNovedadSeguimiento= activarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public Boolean getCargarid_detalle_movimiento_inventarioNovedadSeguimiento() {
		return this.cargarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public void setCargarid_detalle_movimiento_inventarioNovedadSeguimiento(Boolean cargarid_detalle_movimiento_inventarioNovedadSeguimiento) {
		this.cargarid_detalle_movimiento_inventarioNovedadSeguimiento= cargarid_detalle_movimiento_inventarioNovedadSeguimiento;
	}

	public Border setResaltarid_novedad_productoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarid_novedad_productoNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_novedad_productoNovedadSeguimiento() {
		return this.resaltarid_novedad_productoNovedadSeguimiento;
	}

	public void setResaltarid_novedad_productoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarid_novedad_productoNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarid_novedad_productoNovedadSeguimiento() {
		return this.mostrarid_novedad_productoNovedadSeguimiento;
	}

	public void setMostrarid_novedad_productoNovedadSeguimiento(Boolean mostrarid_novedad_productoNovedadSeguimiento) {
		this.mostrarid_novedad_productoNovedadSeguimiento= mostrarid_novedad_productoNovedadSeguimiento;
	}

	public Boolean getActivarid_novedad_productoNovedadSeguimiento() {
		return this.activarid_novedad_productoNovedadSeguimiento;
	}

	public void setActivarid_novedad_productoNovedadSeguimiento(Boolean activarid_novedad_productoNovedadSeguimiento) {
		this.activarid_novedad_productoNovedadSeguimiento= activarid_novedad_productoNovedadSeguimiento;
	}

	public Boolean getCargarid_novedad_productoNovedadSeguimiento() {
		return this.cargarid_novedad_productoNovedadSeguimiento;
	}

	public void setCargarid_novedad_productoNovedadSeguimiento(Boolean cargarid_novedad_productoNovedadSeguimiento) {
		this.cargarid_novedad_productoNovedadSeguimiento= cargarid_novedad_productoNovedadSeguimiento;
	}

	public Border setResaltarnumero_comprobanteNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteNovedadSeguimiento() {
		return this.resaltarnumero_comprobanteNovedadSeguimiento;
	}

	public void setResaltarnumero_comprobanteNovedadSeguimiento(Border borderResaltar) {
		this.resaltarnumero_comprobanteNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteNovedadSeguimiento() {
		return this.mostrarnumero_comprobanteNovedadSeguimiento;
	}

	public void setMostrarnumero_comprobanteNovedadSeguimiento(Boolean mostrarnumero_comprobanteNovedadSeguimiento) {
		this.mostrarnumero_comprobanteNovedadSeguimiento= mostrarnumero_comprobanteNovedadSeguimiento;
	}

	public Boolean getActivarnumero_comprobanteNovedadSeguimiento() {
		return this.activarnumero_comprobanteNovedadSeguimiento;
	}

	public void setActivarnumero_comprobanteNovedadSeguimiento(Boolean activarnumero_comprobanteNovedadSeguimiento) {
		this.activarnumero_comprobanteNovedadSeguimiento= activarnumero_comprobanteNovedadSeguimiento;
	}

	public Border setResaltarfecha_novedadNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarfecha_novedadNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_novedadNovedadSeguimiento() {
		return this.resaltarfecha_novedadNovedadSeguimiento;
	}

	public void setResaltarfecha_novedadNovedadSeguimiento(Border borderResaltar) {
		this.resaltarfecha_novedadNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarfecha_novedadNovedadSeguimiento() {
		return this.mostrarfecha_novedadNovedadSeguimiento;
	}

	public void setMostrarfecha_novedadNovedadSeguimiento(Boolean mostrarfecha_novedadNovedadSeguimiento) {
		this.mostrarfecha_novedadNovedadSeguimiento= mostrarfecha_novedadNovedadSeguimiento;
	}

	public Boolean getActivarfecha_novedadNovedadSeguimiento() {
		return this.activarfecha_novedadNovedadSeguimiento;
	}

	public void setActivarfecha_novedadNovedadSeguimiento(Boolean activarfecha_novedadNovedadSeguimiento) {
		this.activarfecha_novedadNovedadSeguimiento= activarfecha_novedadNovedadSeguimiento;
	}

	public Border setResaltarfecha_seguimientoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarfecha_seguimientoNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_seguimientoNovedadSeguimiento() {
		return this.resaltarfecha_seguimientoNovedadSeguimiento;
	}

	public void setResaltarfecha_seguimientoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarfecha_seguimientoNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarfecha_seguimientoNovedadSeguimiento() {
		return this.mostrarfecha_seguimientoNovedadSeguimiento;
	}

	public void setMostrarfecha_seguimientoNovedadSeguimiento(Boolean mostrarfecha_seguimientoNovedadSeguimiento) {
		this.mostrarfecha_seguimientoNovedadSeguimiento= mostrarfecha_seguimientoNovedadSeguimiento;
	}

	public Boolean getActivarfecha_seguimientoNovedadSeguimiento() {
		return this.activarfecha_seguimientoNovedadSeguimiento;
	}

	public void setActivarfecha_seguimientoNovedadSeguimiento(Boolean activarfecha_seguimientoNovedadSeguimiento) {
		this.activarfecha_seguimientoNovedadSeguimiento= activarfecha_seguimientoNovedadSeguimiento;
	}

	public Border setResaltardescripcionNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltardescripcionNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNovedadSeguimiento() {
		return this.resaltardescripcionNovedadSeguimiento;
	}

	public void setResaltardescripcionNovedadSeguimiento(Border borderResaltar) {
		this.resaltardescripcionNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrardescripcionNovedadSeguimiento() {
		return this.mostrardescripcionNovedadSeguimiento;
	}

	public void setMostrardescripcionNovedadSeguimiento(Boolean mostrardescripcionNovedadSeguimiento) {
		this.mostrardescripcionNovedadSeguimiento= mostrardescripcionNovedadSeguimiento;
	}

	public Boolean getActivardescripcionNovedadSeguimiento() {
		return this.activardescripcionNovedadSeguimiento;
	}

	public void setActivardescripcionNovedadSeguimiento(Boolean activardescripcionNovedadSeguimiento) {
		this.activardescripcionNovedadSeguimiento= activardescripcionNovedadSeguimiento;
	}

	public Border setResaltarid_estado_novedad_seguimientoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//novedadseguimientoBeanSwingJInternalFrame.jTtoolBarNovedadSeguimiento.setBorder(borderResaltar);
		
		this.resaltarid_estado_novedad_seguimientoNovedadSeguimiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_novedad_seguimientoNovedadSeguimiento() {
		return this.resaltarid_estado_novedad_seguimientoNovedadSeguimiento;
	}

	public void setResaltarid_estado_novedad_seguimientoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarid_estado_novedad_seguimientoNovedadSeguimiento= borderResaltar;
	}

	public Boolean getMostrarid_estado_novedad_seguimientoNovedadSeguimiento() {
		return this.mostrarid_estado_novedad_seguimientoNovedadSeguimiento;
	}

	public void setMostrarid_estado_novedad_seguimientoNovedadSeguimiento(Boolean mostrarid_estado_novedad_seguimientoNovedadSeguimiento) {
		this.mostrarid_estado_novedad_seguimientoNovedadSeguimiento= mostrarid_estado_novedad_seguimientoNovedadSeguimiento;
	}

	public Boolean getActivarid_estado_novedad_seguimientoNovedadSeguimiento() {
		return this.activarid_estado_novedad_seguimientoNovedadSeguimiento;
	}

	public void setActivarid_estado_novedad_seguimientoNovedadSeguimiento(Boolean activarid_estado_novedad_seguimientoNovedadSeguimiento) {
		this.activarid_estado_novedad_seguimientoNovedadSeguimiento= activarid_estado_novedad_seguimientoNovedadSeguimiento;
	}

	public Boolean getCargarid_estado_novedad_seguimientoNovedadSeguimiento() {
		return this.cargarid_estado_novedad_seguimientoNovedadSeguimiento;
	}

	public void setCargarid_estado_novedad_seguimientoNovedadSeguimiento(Boolean cargarid_estado_novedad_seguimientoNovedadSeguimiento) {
		this.cargarid_estado_novedad_seguimientoNovedadSeguimiento= cargarid_estado_novedad_seguimientoNovedadSeguimiento;
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
		
		
		this.setMostraridNovedadSeguimiento(esInicial);
		this.setMostrarid_empresaNovedadSeguimiento(esInicial);
		this.setMostrarid_sucursalNovedadSeguimiento(esInicial);
		this.setMostrarid_detalle_movimiento_inventarioNovedadSeguimiento(esInicial);
		this.setMostrarid_novedad_productoNovedadSeguimiento(esInicial);
		this.setMostrarnumero_comprobanteNovedadSeguimiento(esInicial);
		this.setMostrarfecha_novedadNovedadSeguimiento(esInicial);
		this.setMostrarfecha_seguimientoNovedadSeguimiento(esInicial);
		this.setMostrardescripcionNovedadSeguimiento(esInicial);
		this.setMostrarid_estado_novedad_seguimientoNovedadSeguimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.ID)) {
				this.setMostraridNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {
				this.setMostrarid_detalle_movimiento_inventarioNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setMostrarid_novedad_productoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.FECHANOVEDAD)) {
				this.setMostrarfecha_novedadNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO)) {
				this.setMostrarfecha_seguimientoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO)) {
				this.setMostrarid_estado_novedad_seguimientoNovedadSeguimiento(esAsigna);
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
		
		
		this.setActivaridNovedadSeguimiento(esInicial);
		this.setActivarid_empresaNovedadSeguimiento(esInicial);
		this.setActivarid_sucursalNovedadSeguimiento(esInicial);
		this.setActivarid_detalle_movimiento_inventarioNovedadSeguimiento(esInicial);
		this.setActivarid_novedad_productoNovedadSeguimiento(esInicial);
		this.setActivarnumero_comprobanteNovedadSeguimiento(esInicial);
		this.setActivarfecha_novedadNovedadSeguimiento(esInicial);
		this.setActivarfecha_seguimientoNovedadSeguimiento(esInicial);
		this.setActivardescripcionNovedadSeguimiento(esInicial);
		this.setActivarid_estado_novedad_seguimientoNovedadSeguimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.ID)) {
				this.setActivaridNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {
				this.setActivarid_detalle_movimiento_inventarioNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setActivarid_novedad_productoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.FECHANOVEDAD)) {
				this.setActivarfecha_novedadNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO)) {
				this.setActivarfecha_seguimientoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO)) {
				this.setActivarid_estado_novedad_seguimientoNovedadSeguimiento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNovedadSeguimiento(esInicial);
		this.setResaltarid_empresaNovedadSeguimiento(esInicial);
		this.setResaltarid_sucursalNovedadSeguimiento(esInicial);
		this.setResaltarid_detalle_movimiento_inventarioNovedadSeguimiento(esInicial);
		this.setResaltarid_novedad_productoNovedadSeguimiento(esInicial);
		this.setResaltarnumero_comprobanteNovedadSeguimiento(esInicial);
		this.setResaltarfecha_novedadNovedadSeguimiento(esInicial);
		this.setResaltarfecha_seguimientoNovedadSeguimiento(esInicial);
		this.setResaltardescripcionNovedadSeguimiento(esInicial);
		this.setResaltarid_estado_novedad_seguimientoNovedadSeguimiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.ID)) {
				this.setResaltaridNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {
				this.setResaltarid_detalle_movimiento_inventarioNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDNOVEDADPRODUCTO)) {
				this.setResaltarid_novedad_productoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.FECHANOVEDAD)) {
				this.setResaltarfecha_novedadNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.FECHASEGUIMIENTO)) {
				this.setResaltarfecha_seguimientoNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNovedadSeguimiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(NovedadSeguimientoConstantesFunciones.IDESTADONOVEDADSEGUIMIENTO)) {
				this.setResaltarid_estado_novedad_seguimientoNovedadSeguimiento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdDetalleMovimientoInventarioNovedadSeguimiento=true;

	public Boolean getMostrarFK_IdDetalleMovimientoInventarioNovedadSeguimiento() {
		return this.mostrarFK_IdDetalleMovimientoInventarioNovedadSeguimiento;
	}

	public void setMostrarFK_IdDetalleMovimientoInventarioNovedadSeguimiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleMovimientoInventarioNovedadSeguimiento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNovedadSeguimiento=true;

	public Boolean getMostrarFK_IdEmpresaNovedadSeguimiento() {
		return this.mostrarFK_IdEmpresaNovedadSeguimiento;
	}

	public void setMostrarFK_IdEmpresaNovedadSeguimiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNovedadSeguimiento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento=true;

	public Boolean getMostrarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento() {
		return this.mostrarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento;
	}

	public void setMostrarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNovedadProductoNovedadSeguimiento=true;

	public Boolean getMostrarFK_IdNovedadProductoNovedadSeguimiento() {
		return this.mostrarFK_IdNovedadProductoNovedadSeguimiento;
	}

	public void setMostrarFK_IdNovedadProductoNovedadSeguimiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNovedadProductoNovedadSeguimiento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalNovedadSeguimiento=true;

	public Boolean getMostrarFK_IdSucursalNovedadSeguimiento() {
		return this.mostrarFK_IdSucursalNovedadSeguimiento;
	}

	public void setMostrarFK_IdSucursalNovedadSeguimiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalNovedadSeguimiento= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDetalleMovimientoInventarioNovedadSeguimiento=true;

	public Boolean getActivarFK_IdDetalleMovimientoInventarioNovedadSeguimiento() {
		return this.activarFK_IdDetalleMovimientoInventarioNovedadSeguimiento;
	}

	public void setActivarFK_IdDetalleMovimientoInventarioNovedadSeguimiento(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleMovimientoInventarioNovedadSeguimiento= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNovedadSeguimiento=true;

	public Boolean getActivarFK_IdEmpresaNovedadSeguimiento() {
		return this.activarFK_IdEmpresaNovedadSeguimiento;
	}

	public void setActivarFK_IdEmpresaNovedadSeguimiento(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNovedadSeguimiento= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento=true;

	public Boolean getActivarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento() {
		return this.activarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento;
	}

	public void setActivarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento= habilitarResaltar;
	}

	public Boolean activarFK_IdNovedadProductoNovedadSeguimiento=true;

	public Boolean getActivarFK_IdNovedadProductoNovedadSeguimiento() {
		return this.activarFK_IdNovedadProductoNovedadSeguimiento;
	}

	public void setActivarFK_IdNovedadProductoNovedadSeguimiento(Boolean habilitarResaltar) {
		this.activarFK_IdNovedadProductoNovedadSeguimiento= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalNovedadSeguimiento=true;

	public Boolean getActivarFK_IdSucursalNovedadSeguimiento() {
		return this.activarFK_IdSucursalNovedadSeguimiento;
	}

	public void setActivarFK_IdSucursalNovedadSeguimiento(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalNovedadSeguimiento= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento=null;

	public Border getResaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento() {
		return this.resaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento;
	}

	public void setResaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento(Border borderResaltar) {
		this.resaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento= borderResaltar;
	}

	public void setResaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleMovimientoInventarioNovedadSeguimiento= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNovedadSeguimiento=null;

	public Border getResaltarFK_IdEmpresaNovedadSeguimiento() {
		return this.resaltarFK_IdEmpresaNovedadSeguimiento;
	}

	public void setResaltarFK_IdEmpresaNovedadSeguimiento(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNovedadSeguimiento= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNovedadSeguimiento= borderResaltar;
	}

	public Border resaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento=null;

	public Border getResaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento() {
		return this.resaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento;
	}

	public void setResaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento= borderResaltar;
	}

	public void setResaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoNovedadSeguimientoNovedadSeguimiento= borderResaltar;
	}

	public Border resaltarFK_IdNovedadProductoNovedadSeguimiento=null;

	public Border getResaltarFK_IdNovedadProductoNovedadSeguimiento() {
		return this.resaltarFK_IdNovedadProductoNovedadSeguimiento;
	}

	public void setResaltarFK_IdNovedadProductoNovedadSeguimiento(Border borderResaltar) {
		this.resaltarFK_IdNovedadProductoNovedadSeguimiento= borderResaltar;
	}

	public void setResaltarFK_IdNovedadProductoNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNovedadProductoNovedadSeguimiento= borderResaltar;
	}

	public Border resaltarFK_IdSucursalNovedadSeguimiento=null;

	public Border getResaltarFK_IdSucursalNovedadSeguimiento() {
		return this.resaltarFK_IdSucursalNovedadSeguimiento;
	}

	public void setResaltarFK_IdSucursalNovedadSeguimiento(Border borderResaltar) {
		this.resaltarFK_IdSucursalNovedadSeguimiento= borderResaltar;
	}

	public void setResaltarFK_IdSucursalNovedadSeguimiento(ParametroGeneralUsuario parametroGeneralUsuario/*NovedadSeguimientoBeanSwingJInternalFrame novedadseguimientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalNovedadSeguimiento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}