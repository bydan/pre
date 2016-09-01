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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.ParametroProductoConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroProductoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroProductoConstantesFunciones extends ParametroProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroProducto";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroProducto"+ParametroProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroProductoConstantesFunciones.SCHEMA+"_"+ParametroProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroProductoConstantesFunciones.SCHEMA+"_"+ParametroProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroProductoConstantesFunciones.SCHEMA+"_"+ParametroProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroProductoConstantesFunciones.SCHEMA+"_"+ParametroProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Producto";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroProducto";
	public static final String OBJECTNAME="parametroproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroproducto from "+ParametroProductoConstantesFunciones.SPERSISTENCENAME+" parametroproducto";
	public static String QUERYSELECTNATIVE="select "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".version_row,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_modulo,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_transaccion,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_bodega,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_producto,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_formato,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".descripcion from "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME;//+" as "+ParametroProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroProductoConstantesFuncionesAdditional parametroproductoConstantesFuncionesAdditional=null;
	
	public ParametroProductoConstantesFuncionesAdditional getParametroProductoConstantesFuncionesAdditional() {
		return this.parametroproductoConstantesFuncionesAdditional;
	}
	
	public void setParametroProductoConstantesFuncionesAdditional(ParametroProductoConstantesFuncionesAdditional parametroproductoConstantesFuncionesAdditional) {
		try {
			this.parametroproductoConstantesFuncionesAdditional=parametroproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDFORMATO= "id_formato";
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
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getParametroProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDMODULO)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.IDFORMATO)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(ParametroProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ParametroProductoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroProductoDescripcion(ParametroProducto parametroproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroproducto !=null/* && parametroproducto.getId()!=0*/) {
			if(parametroproducto.getId()!=null) {
				sDescripcion=parametroproducto.getId().toString();
			}//parametroproductoparametroproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroProductoDescripcionDetallado(ParametroProducto parametroproducto) {
		String sDescripcion="";
			
		sDescripcion+=ParametroProductoConstantesFunciones.ID+"=";
		sDescripcion+=parametroproducto.getId().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroproducto.getVersionRow().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroproducto.getid_empresa().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametroproducto.getid_sucursal().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=parametroproducto.getid_modulo().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=parametroproducto.getid_transaccion().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=parametroproducto.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametroproducto.getid_bodega().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=parametroproducto.getid_producto().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=parametroproducto.getid_formato().toString()+",";
		sDescripcion+=ParametroProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=parametroproducto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroProductoDescripcion(ParametroProducto parametroproducto,String sValor) throws Exception {			
		if(parametroproducto !=null) {
			//parametroproductoparametroproducto.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
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

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroProducto(ParametroProducto parametroproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametroproducto.setdescripcion(parametroproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosParametroProductos(List<ParametroProducto> parametroproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroProducto parametroproducto: parametroproductos) {
			parametroproducto.setdescripcion(parametroproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroProducto(ParametroProducto parametroproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroproducto.getConCambioAuxiliar()) {
			parametroproducto.setIsDeleted(parametroproducto.getIsDeletedAuxiliar());	
			parametroproducto.setIsNew(parametroproducto.getIsNewAuxiliar());	
			parametroproducto.setIsChanged(parametroproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroproducto.setIsDeletedAuxiliar(false);	
			parametroproducto.setIsNewAuxiliar(false);	
			parametroproducto.setIsChangedAuxiliar(false);
			
			parametroproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroProductos(List<ParametroProducto> parametroproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroProducto parametroproducto : parametroproductos) {
			if(conAsignarBase && parametroproducto.getConCambioAuxiliar()) {
				parametroproducto.setIsDeleted(parametroproducto.getIsDeletedAuxiliar());	
				parametroproducto.setIsNew(parametroproducto.getIsNewAuxiliar());	
				parametroproducto.setIsChanged(parametroproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroproducto.setIsDeletedAuxiliar(false);	
				parametroproducto.setIsNewAuxiliar(false);	
				parametroproducto.setIsChangedAuxiliar(false);
				
				parametroproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroProducto(ParametroProducto parametroproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroProductos(List<ParametroProducto> parametroproductos,Boolean conEnteros) throws Exception  {
		
		for(ParametroProducto parametroproducto: parametroproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroProducto(List<ParametroProducto> parametroproductos,ParametroProducto parametroproductoAux) throws Exception  {
		ParametroProductoConstantesFunciones.InicializarValoresParametroProducto(parametroproductoAux,true);
		
		for(ParametroProducto parametroproducto: parametroproductos) {
			if(parametroproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroProductoConstantesFunciones.getArrayColumnasGlobalesParametroProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroProductoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroProductoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroProductoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ParametroProductoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroProducto> parametroproductos,ParametroProducto parametroproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroProducto parametroproductoAux: parametroproductos) {
			if(parametroproductoAux!=null && parametroproducto!=null) {
				if((parametroproductoAux.getId()==null && parametroproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroproductoAux.getId()!=null && parametroproducto.getId()!=null){
					if(parametroproductoAux.getId().equals(parametroproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroProducto(List<ParametroProducto> parametroproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroProducto parametroproducto: parametroproductos) {			
			if(parametroproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_ID, ParametroProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_VERSIONROW, ParametroProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDEMPRESA, ParametroProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDSUCURSAL, ParametroProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDMODULO, ParametroProductoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDTRANSACCION, ParametroProductoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDBODEGA, ParametroProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDPRODUCTO, ParametroProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_IDFORMATO, ParametroProductoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProductoConstantesFunciones.LABEL_DESCRIPCION, ParametroProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroProducto() throws Exception  {
		return ParametroProductoConstantesFunciones.getTiposSeleccionarParametroProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroProducto(Boolean conFk) throws Exception  {
		return ParametroProductoConstantesFunciones.getTiposSeleccionarParametroProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ParametroProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroProducto(ParametroProducto parametroproductoAux) throws Exception {
		
			parametroproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroproductoAux.getEmpresa()));
			parametroproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametroproductoAux.getSucursal()));
			parametroproductoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametroproductoAux.getModulo()));
			parametroproductoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroproductoAux.getTransaccion()));
			parametroproductoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(parametroproductoAux.getTipoTransaccionModulo()));
			parametroproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroproductoAux.getBodega()));
			parametroproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(parametroproductoAux.getProducto()));
			parametroproductoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroproductoAux.getFormato()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroProducto(List<ParametroProducto> parametroproductosTemp) throws Exception {
		for(ParametroProducto parametroproductoAux:parametroproductosTemp) {
			
			parametroproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroproductoAux.getEmpresa()));
			parametroproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametroproductoAux.getSucursal()));
			parametroproductoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametroproductoAux.getModulo()));
			parametroproductoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroproductoAux.getTransaccion()));
			parametroproductoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(parametroproductoAux.getTipoTransaccionModulo()));
			parametroproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroproductoAux.getBodega()));
			parametroproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(parametroproductoAux.getProducto()));
			parametroproductoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroproductoAux.getFormato()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Formato.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
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
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroProductoConstantesFunciones.getClassesRelationshipsOfParametroProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroProductoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroProducto parametroproducto,List<ParametroProducto> parametroproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroProducto parametroproductoEncontrado=null;
			
			for(ParametroProducto parametroproductoLocal:parametroproductos) {
				if(parametroproductoLocal.getId().equals(parametroproducto.getId())) {
					parametroproductoEncontrado=parametroproductoLocal;
					
					parametroproductoLocal.setIsChanged(parametroproducto.getIsChanged());
					parametroproductoLocal.setIsNew(parametroproducto.getIsNew());
					parametroproductoLocal.setIsDeleted(parametroproducto.getIsDeleted());
					
					parametroproductoLocal.setGeneralEntityOriginal(parametroproducto.getGeneralEntityOriginal());
					
					parametroproductoLocal.setId(parametroproducto.getId());	
					parametroproductoLocal.setVersionRow(parametroproducto.getVersionRow());	
					parametroproductoLocal.setid_empresa(parametroproducto.getid_empresa());	
					parametroproductoLocal.setid_sucursal(parametroproducto.getid_sucursal());	
					parametroproductoLocal.setid_modulo(parametroproducto.getid_modulo());	
					parametroproductoLocal.setid_transaccion(parametroproducto.getid_transaccion());	
					parametroproductoLocal.setid_tipo_transaccion_modulo(parametroproducto.getid_tipo_transaccion_modulo());	
					parametroproductoLocal.setid_bodega(parametroproducto.getid_bodega());	
					parametroproductoLocal.setid_producto(parametroproducto.getid_producto());	
					parametroproductoLocal.setid_formato(parametroproducto.getid_formato());	
					parametroproductoLocal.setdescripcion(parametroproducto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroproducto.getIsDeleted()) {
				if(!existe) {
					parametroproductos.add(parametroproducto);
				}
			} else {
				if(parametroproductoEncontrado!=null && permiteQuitar)  {
					parametroproductos.remove(parametroproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroProducto parametroproducto,List<ParametroProducto> parametroproductos) throws Exception {
		try	{			
			for(ParametroProducto parametroproductoLocal:parametroproductos) {
				if(parametroproductoLocal.getId().equals(parametroproducto.getId())) {
					parametroproductoLocal.setIsSelected(parametroproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroProducto(List<ParametroProducto> parametroproductosAux) throws Exception {
		//this.parametroproductosAux=parametroproductosAux;
		
		for(ParametroProducto parametroproductoAux:parametroproductosAux) {
			if(parametroproductoAux.getIsChanged()) {
				parametroproductoAux.setIsChanged(false);
			}		
			
			if(parametroproductoAux.getIsNew()) {
				parametroproductoAux.setIsNew(false);
			}	
			
			if(parametroproductoAux.getIsDeleted()) {
				parametroproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroProducto(ParametroProducto parametroproductoAux) throws Exception {
		//this.parametroproductoAux=parametroproductoAux;
		
			if(parametroproductoAux.getIsChanged()) {
				parametroproductoAux.setIsChanged(false);
			}		
			
			if(parametroproductoAux.getIsNew()) {
				parametroproductoAux.setIsNew(false);
			}	
			
			if(parametroproductoAux.getIsDeleted()) {
				parametroproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroProducto parametroproductoAsignar,ParametroProducto parametroproducto) throws Exception {
		parametroproductoAsignar.setId(parametroproducto.getId());	
		parametroproductoAsignar.setVersionRow(parametroproducto.getVersionRow());	
		parametroproductoAsignar.setid_empresa(parametroproducto.getid_empresa());
		parametroproductoAsignar.setempresa_descripcion(parametroproducto.getempresa_descripcion());	
		parametroproductoAsignar.setid_sucursal(parametroproducto.getid_sucursal());
		parametroproductoAsignar.setsucursal_descripcion(parametroproducto.getsucursal_descripcion());	
		parametroproductoAsignar.setid_modulo(parametroproducto.getid_modulo());
		parametroproductoAsignar.setmodulo_descripcion(parametroproducto.getmodulo_descripcion());	
		parametroproductoAsignar.setid_transaccion(parametroproducto.getid_transaccion());
		parametroproductoAsignar.settransaccion_descripcion(parametroproducto.gettransaccion_descripcion());	
		parametroproductoAsignar.setid_tipo_transaccion_modulo(parametroproducto.getid_tipo_transaccion_modulo());
		parametroproductoAsignar.settipotransaccionmodulo_descripcion(parametroproducto.gettipotransaccionmodulo_descripcion());	
		parametroproductoAsignar.setid_bodega(parametroproducto.getid_bodega());
		parametroproductoAsignar.setbodega_descripcion(parametroproducto.getbodega_descripcion());	
		parametroproductoAsignar.setid_producto(parametroproducto.getid_producto());
		parametroproductoAsignar.setproducto_descripcion(parametroproducto.getproducto_descripcion());	
		parametroproductoAsignar.setid_formato(parametroproducto.getid_formato());
		parametroproductoAsignar.setformato_descripcion(parametroproducto.getformato_descripcion());	
		parametroproductoAsignar.setdescripcion(parametroproducto.getdescripcion());	
	}
	
	public static void inicializarParametroProducto(ParametroProducto parametroproducto) throws Exception {
		try {
				parametroproducto.setId(0L);	
					
				parametroproducto.setid_empresa(-1L);	
				parametroproducto.setid_sucursal(-1L);	
				parametroproducto.setid_modulo(-1L);	
				parametroproducto.setid_transaccion(-1L);	
				parametroproducto.setid_tipo_transaccion_modulo(null);	
				parametroproducto.setid_bodega(-1L);	
				parametroproducto.setid_producto(-1L);	
				parametroproducto.setid_formato(null);	
				parametroproducto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroProducto(String sTipo,Row row,Workbook workbook,ParametroProducto parametroproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroProducto() {
		return this.sFinalQueryParametroProducto;
	}
	
	public void setsFinalQueryParametroProducto(String sFinalQueryParametroProducto) {
		this.sFinalQueryParametroProducto= sFinalQueryParametroProducto;
	}
	
	public Border resaltarSeleccionarParametroProducto=null;
	
	public Border setResaltarSeleccionarParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroProducto() {
		return this.resaltarSeleccionarParametroProducto;
	}
	
	public void setResaltarSeleccionarParametroProducto(Border borderResaltarSeleccionarParametroProducto) {
		this.resaltarSeleccionarParametroProducto= borderResaltarSeleccionarParametroProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroProducto=null;
	public Boolean mostraridParametroProducto=true;
	public Boolean activaridParametroProducto=true;

	public Border resaltarid_empresaParametroProducto=null;
	public Boolean mostrarid_empresaParametroProducto=true;
	public Boolean activarid_empresaParametroProducto=true;
	public Boolean cargarid_empresaParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroProducto=null;
	public Boolean mostrarid_sucursalParametroProducto=true;
	public Boolean activarid_sucursalParametroProducto=true;
	public Boolean cargarid_sucursalParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_moduloParametroProducto=null;
	public Boolean mostrarid_moduloParametroProducto=true;
	public Boolean activarid_moduloParametroProducto=true;
	public Boolean cargarid_moduloParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_transaccionParametroProducto=null;
	public Boolean mostrarid_transaccionParametroProducto=true;
	public Boolean activarid_transaccionParametroProducto=true;
	public Boolean cargarid_transaccionParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloParametroProducto=null;
	public Boolean mostrarid_tipo_transaccion_moduloParametroProducto=true;
	public Boolean activarid_tipo_transaccion_moduloParametroProducto=false;
	public Boolean cargarid_tipo_transaccion_moduloParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaParametroProducto=null;
	public Boolean mostrarid_bodegaParametroProducto=true;
	public Boolean activarid_bodegaParametroProducto=true;
	public Boolean cargarid_bodegaParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_productoParametroProducto=null;
	public Boolean mostrarid_productoParametroProducto=true;
	public Boolean activarid_productoParametroProducto=true;
	public Boolean cargarid_productoParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoParametroProducto=false;//ConEventDepend=true

	public Border resaltarid_formatoParametroProducto=null;
	public Boolean mostrarid_formatoParametroProducto=true;
	public Boolean activarid_formatoParametroProducto=true;
	public Boolean cargarid_formatoParametroProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoParametroProducto=false;//ConEventDepend=true

	public Border resaltardescripcionParametroProducto=null;
	public Boolean mostrardescripcionParametroProducto=true;
	public Boolean activardescripcionParametroProducto=true;

	
	

	public Border setResaltaridParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltaridParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroProducto() {
		return this.resaltaridParametroProducto;
	}

	public void setResaltaridParametroProducto(Border borderResaltar) {
		this.resaltaridParametroProducto= borderResaltar;
	}

	public Boolean getMostraridParametroProducto() {
		return this.mostraridParametroProducto;
	}

	public void setMostraridParametroProducto(Boolean mostraridParametroProducto) {
		this.mostraridParametroProducto= mostraridParametroProducto;
	}

	public Boolean getActivaridParametroProducto() {
		return this.activaridParametroProducto;
	}

	public void setActivaridParametroProducto(Boolean activaridParametroProducto) {
		this.activaridParametroProducto= activaridParametroProducto;
	}

	public Border setResaltarid_empresaParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroProducto() {
		return this.resaltarid_empresaParametroProducto;
	}

	public void setResaltarid_empresaParametroProducto(Border borderResaltar) {
		this.resaltarid_empresaParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroProducto() {
		return this.mostrarid_empresaParametroProducto;
	}

	public void setMostrarid_empresaParametroProducto(Boolean mostrarid_empresaParametroProducto) {
		this.mostrarid_empresaParametroProducto= mostrarid_empresaParametroProducto;
	}

	public Boolean getActivarid_empresaParametroProducto() {
		return this.activarid_empresaParametroProducto;
	}

	public void setActivarid_empresaParametroProducto(Boolean activarid_empresaParametroProducto) {
		this.activarid_empresaParametroProducto= activarid_empresaParametroProducto;
	}

	public Boolean getCargarid_empresaParametroProducto() {
		return this.cargarid_empresaParametroProducto;
	}

	public void setCargarid_empresaParametroProducto(Boolean cargarid_empresaParametroProducto) {
		this.cargarid_empresaParametroProducto= cargarid_empresaParametroProducto;
	}

	public Border setResaltarid_sucursalParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroProducto() {
		return this.resaltarid_sucursalParametroProducto;
	}

	public void setResaltarid_sucursalParametroProducto(Border borderResaltar) {
		this.resaltarid_sucursalParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroProducto() {
		return this.mostrarid_sucursalParametroProducto;
	}

	public void setMostrarid_sucursalParametroProducto(Boolean mostrarid_sucursalParametroProducto) {
		this.mostrarid_sucursalParametroProducto= mostrarid_sucursalParametroProducto;
	}

	public Boolean getActivarid_sucursalParametroProducto() {
		return this.activarid_sucursalParametroProducto;
	}

	public void setActivarid_sucursalParametroProducto(Boolean activarid_sucursalParametroProducto) {
		this.activarid_sucursalParametroProducto= activarid_sucursalParametroProducto;
	}

	public Boolean getCargarid_sucursalParametroProducto() {
		return this.cargarid_sucursalParametroProducto;
	}

	public void setCargarid_sucursalParametroProducto(Boolean cargarid_sucursalParametroProducto) {
		this.cargarid_sucursalParametroProducto= cargarid_sucursalParametroProducto;
	}

	public Border setResaltarid_moduloParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_moduloParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloParametroProducto() {
		return this.resaltarid_moduloParametroProducto;
	}

	public void setResaltarid_moduloParametroProducto(Border borderResaltar) {
		this.resaltarid_moduloParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_moduloParametroProducto() {
		return this.mostrarid_moduloParametroProducto;
	}

	public void setMostrarid_moduloParametroProducto(Boolean mostrarid_moduloParametroProducto) {
		this.mostrarid_moduloParametroProducto= mostrarid_moduloParametroProducto;
	}

	public Boolean getActivarid_moduloParametroProducto() {
		return this.activarid_moduloParametroProducto;
	}

	public void setActivarid_moduloParametroProducto(Boolean activarid_moduloParametroProducto) {
		this.activarid_moduloParametroProducto= activarid_moduloParametroProducto;
	}

	public Boolean getCargarid_moduloParametroProducto() {
		return this.cargarid_moduloParametroProducto;
	}

	public void setCargarid_moduloParametroProducto(Boolean cargarid_moduloParametroProducto) {
		this.cargarid_moduloParametroProducto= cargarid_moduloParametroProducto;
	}

	public Border setResaltarid_transaccionParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_transaccionParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionParametroProducto() {
		return this.resaltarid_transaccionParametroProducto;
	}

	public void setResaltarid_transaccionParametroProducto(Border borderResaltar) {
		this.resaltarid_transaccionParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_transaccionParametroProducto() {
		return this.mostrarid_transaccionParametroProducto;
	}

	public void setMostrarid_transaccionParametroProducto(Boolean mostrarid_transaccionParametroProducto) {
		this.mostrarid_transaccionParametroProducto= mostrarid_transaccionParametroProducto;
	}

	public Boolean getActivarid_transaccionParametroProducto() {
		return this.activarid_transaccionParametroProducto;
	}

	public void setActivarid_transaccionParametroProducto(Boolean activarid_transaccionParametroProducto) {
		this.activarid_transaccionParametroProducto= activarid_transaccionParametroProducto;
	}

	public Boolean getCargarid_transaccionParametroProducto() {
		return this.cargarid_transaccionParametroProducto;
	}

	public void setCargarid_transaccionParametroProducto(Boolean cargarid_transaccionParametroProducto) {
		this.cargarid_transaccionParametroProducto= cargarid_transaccionParametroProducto;
	}

	public Border setResaltarid_tipo_transaccion_moduloParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloParametroProducto() {
		return this.resaltarid_tipo_transaccion_moduloParametroProducto;
	}

	public void setResaltarid_tipo_transaccion_moduloParametroProducto(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloParametroProducto() {
		return this.mostrarid_tipo_transaccion_moduloParametroProducto;
	}

	public void setMostrarid_tipo_transaccion_moduloParametroProducto(Boolean mostrarid_tipo_transaccion_moduloParametroProducto) {
		this.mostrarid_tipo_transaccion_moduloParametroProducto= mostrarid_tipo_transaccion_moduloParametroProducto;
	}

	public Boolean getActivarid_tipo_transaccion_moduloParametroProducto() {
		return this.activarid_tipo_transaccion_moduloParametroProducto;
	}

	public void setActivarid_tipo_transaccion_moduloParametroProducto(Boolean activarid_tipo_transaccion_moduloParametroProducto) {
		this.activarid_tipo_transaccion_moduloParametroProducto= activarid_tipo_transaccion_moduloParametroProducto;
	}

	public Boolean getCargarid_tipo_transaccion_moduloParametroProducto() {
		return this.cargarid_tipo_transaccion_moduloParametroProducto;
	}

	public void setCargarid_tipo_transaccion_moduloParametroProducto(Boolean cargarid_tipo_transaccion_moduloParametroProducto) {
		this.cargarid_tipo_transaccion_moduloParametroProducto= cargarid_tipo_transaccion_moduloParametroProducto;
	}

	public Border setResaltarid_bodegaParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroProducto() {
		return this.resaltarid_bodegaParametroProducto;
	}

	public void setResaltarid_bodegaParametroProducto(Border borderResaltar) {
		this.resaltarid_bodegaParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroProducto() {
		return this.mostrarid_bodegaParametroProducto;
	}

	public void setMostrarid_bodegaParametroProducto(Boolean mostrarid_bodegaParametroProducto) {
		this.mostrarid_bodegaParametroProducto= mostrarid_bodegaParametroProducto;
	}

	public Boolean getActivarid_bodegaParametroProducto() {
		return this.activarid_bodegaParametroProducto;
	}

	public void setActivarid_bodegaParametroProducto(Boolean activarid_bodegaParametroProducto) {
		this.activarid_bodegaParametroProducto= activarid_bodegaParametroProducto;
	}

	public Boolean getCargarid_bodegaParametroProducto() {
		return this.cargarid_bodegaParametroProducto;
	}

	public void setCargarid_bodegaParametroProducto(Boolean cargarid_bodegaParametroProducto) {
		this.cargarid_bodegaParametroProducto= cargarid_bodegaParametroProducto;
	}

	public Border setResaltarid_productoParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoParametroProducto() {
		return this.resaltarid_productoParametroProducto;
	}

	public void setResaltarid_productoParametroProducto(Border borderResaltar) {
		this.resaltarid_productoParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoParametroProducto() {
		return this.mostrarid_productoParametroProducto;
	}

	public void setMostrarid_productoParametroProducto(Boolean mostrarid_productoParametroProducto) {
		this.mostrarid_productoParametroProducto= mostrarid_productoParametroProducto;
	}

	public Boolean getActivarid_productoParametroProducto() {
		return this.activarid_productoParametroProducto;
	}

	public void setActivarid_productoParametroProducto(Boolean activarid_productoParametroProducto) {
		this.activarid_productoParametroProducto= activarid_productoParametroProducto;
	}

	public Boolean getCargarid_productoParametroProducto() {
		return this.cargarid_productoParametroProducto;
	}

	public void setCargarid_productoParametroProducto(Boolean cargarid_productoParametroProducto) {
		this.cargarid_productoParametroProducto= cargarid_productoParametroProducto;
	}

	public Border setResaltarid_formatoParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltarid_formatoParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoParametroProducto() {
		return this.resaltarid_formatoParametroProducto;
	}

	public void setResaltarid_formatoParametroProducto(Border borderResaltar) {
		this.resaltarid_formatoParametroProducto= borderResaltar;
	}

	public Boolean getMostrarid_formatoParametroProducto() {
		return this.mostrarid_formatoParametroProducto;
	}

	public void setMostrarid_formatoParametroProducto(Boolean mostrarid_formatoParametroProducto) {
		this.mostrarid_formatoParametroProducto= mostrarid_formatoParametroProducto;
	}

	public Boolean getActivarid_formatoParametroProducto() {
		return this.activarid_formatoParametroProducto;
	}

	public void setActivarid_formatoParametroProducto(Boolean activarid_formatoParametroProducto) {
		this.activarid_formatoParametroProducto= activarid_formatoParametroProducto;
	}

	public Boolean getCargarid_formatoParametroProducto() {
		return this.cargarid_formatoParametroProducto;
	}

	public void setCargarid_formatoParametroProducto(Boolean cargarid_formatoParametroProducto) {
		this.cargarid_formatoParametroProducto= cargarid_formatoParametroProducto;
	}

	public Border setResaltardescripcionParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproductoBeanSwingJInternalFrame.jTtoolBarParametroProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionParametroProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionParametroProducto() {
		return this.resaltardescripcionParametroProducto;
	}

	public void setResaltardescripcionParametroProducto(Border borderResaltar) {
		this.resaltardescripcionParametroProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionParametroProducto() {
		return this.mostrardescripcionParametroProducto;
	}

	public void setMostrardescripcionParametroProducto(Boolean mostrardescripcionParametroProducto) {
		this.mostrardescripcionParametroProducto= mostrardescripcionParametroProducto;
	}

	public Boolean getActivardescripcionParametroProducto() {
		return this.activardescripcionParametroProducto;
	}

	public void setActivardescripcionParametroProducto(Boolean activardescripcionParametroProducto) {
		this.activardescripcionParametroProducto= activardescripcionParametroProducto;
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
		
		
		this.setMostraridParametroProducto(esInicial);
		this.setMostrarid_empresaParametroProducto(esInicial);
		this.setMostrarid_sucursalParametroProducto(esInicial);
		this.setMostrarid_moduloParametroProducto(esInicial);
		this.setMostrarid_transaccionParametroProducto(esInicial);
		this.setMostrarid_tipo_transaccion_moduloParametroProducto(esInicial);
		this.setMostrarid_bodegaParametroProducto(esInicial);
		this.setMostrarid_productoParametroProducto(esInicial);
		this.setMostrarid_formatoParametroProducto(esInicial);
		this.setMostrardescripcionParametroProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroProductoConstantesFunciones.ID)) {
				this.setMostraridParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionParametroProducto(esAsigna);
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
		
		
		this.setActivaridParametroProducto(esInicial);
		this.setActivarid_empresaParametroProducto(esInicial);
		this.setActivarid_sucursalParametroProducto(esInicial);
		this.setActivarid_moduloParametroProducto(esInicial);
		this.setActivarid_transaccionParametroProducto(esInicial);
		this.setActivarid_tipo_transaccion_moduloParametroProducto(esInicial);
		this.setActivarid_bodegaParametroProducto(esInicial);
		this.setActivarid_productoParametroProducto(esInicial);
		this.setActivarid_formatoParametroProducto(esInicial);
		this.setActivardescripcionParametroProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroProductoConstantesFunciones.ID)) {
				this.setActivaridParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionParametroProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroProducto(esInicial);
		this.setResaltarid_empresaParametroProducto(esInicial);
		this.setResaltarid_sucursalParametroProducto(esInicial);
		this.setResaltarid_moduloParametroProducto(esInicial);
		this.setResaltarid_transaccionParametroProducto(esInicial);
		this.setResaltarid_tipo_transaccion_moduloParametroProducto(esInicial);
		this.setResaltarid_bodegaParametroProducto(esInicial);
		this.setResaltarid_productoParametroProducto(esInicial);
		this.setResaltarid_formatoParametroProducto(esInicial);
		this.setResaltardescripcionParametroProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroProductoConstantesFunciones.ID)) {
				this.setResaltaridParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoParametroProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionParametroProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroProducto=true;

	public Boolean getMostrarFK_IdEmpresaParametroProducto() {
		return this.mostrarFK_IdEmpresaParametroProducto;
	}

	public void setMostrarFK_IdEmpresaParametroProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloParametroProducto=true;

	public Boolean getMostrarFK_IdModuloParametroProducto() {
		return this.mostrarFK_IdModuloParametroProducto;
	}

	public void setMostrarFK_IdModuloParametroProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloParametroProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroProducto=true;

	public Boolean getMostrarFK_IdSucursalParametroProducto() {
		return this.mostrarFK_IdSucursalParametroProducto;
	}

	public void setMostrarFK_IdSucursalParametroProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroProducto=true;

	public Boolean getActivarFK_IdEmpresaParametroProducto() {
		return this.activarFK_IdEmpresaParametroProducto;
	}

	public void setActivarFK_IdEmpresaParametroProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloParametroProducto=true;

	public Boolean getActivarFK_IdModuloParametroProducto() {
		return this.activarFK_IdModuloParametroProducto;
	}

	public void setActivarFK_IdModuloParametroProducto(Boolean habilitarResaltar) {
		this.activarFK_IdModuloParametroProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroProducto=true;

	public Boolean getActivarFK_IdSucursalParametroProducto() {
		return this.activarFK_IdSucursalParametroProducto;
	}

	public void setActivarFK_IdSucursalParametroProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroProducto=null;

	public Border getResaltarFK_IdEmpresaParametroProducto() {
		return this.resaltarFK_IdEmpresaParametroProducto;
	}

	public void setResaltarFK_IdEmpresaParametroProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroProducto= borderResaltar;
	}

	public Border resaltarFK_IdModuloParametroProducto=null;

	public Border getResaltarFK_IdModuloParametroProducto() {
		return this.resaltarFK_IdModuloParametroProducto;
	}

	public void setResaltarFK_IdModuloParametroProducto(Border borderResaltar) {
		this.resaltarFK_IdModuloParametroProducto= borderResaltar;
	}

	public void setResaltarFK_IdModuloParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloParametroProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroProducto=null;

	public Border getResaltarFK_IdSucursalParametroProducto() {
		return this.resaltarFK_IdSucursalParametroProducto;
	}

	public void setResaltarFK_IdSucursalParametroProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroProducto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProductoBeanSwingJInternalFrame parametroproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}