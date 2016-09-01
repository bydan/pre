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


import com.bydan.erp.inventario.util.DescuentoTipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.DescuentoTipoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DescuentoTipoPrecioParameterGeneral;

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
final public class DescuentoTipoPrecioConstantesFunciones extends DescuentoTipoPrecioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DescuentoTipoPrecio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DescuentoTipoPrecio"+DescuentoTipoPrecioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DescuentoTipoPrecioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DescuentoTipoPrecioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DescuentoTipoPrecioConstantesFunciones.SCHEMA+"_"+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DescuentoTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DescuentoTipoPrecioConstantesFunciones.SCHEMA+"_"+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DescuentoTipoPrecioConstantesFunciones.SCHEMA+"_"+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DescuentoTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DescuentoTipoPrecioConstantesFunciones.SCHEMA+"_"+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DescuentoTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DescuentoTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DescuentoTipoPrecioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DescuentoTipoPrecioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DescuentoTipoPrecioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DescuentoTipoPrecioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Descuento Tipo Precios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Descuento Tipo Precio";
	public static final String SCLASSWEBTITULO_LOWER="Descuento Tipo Precio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DescuentoTipoPrecio";
	public static final String OBJECTNAME="descuentotipoprecio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="descuento_tipo_precio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select descuentotipoprecio from "+DescuentoTipoPrecioConstantesFunciones.SPERSISTENCENAME+" descuentotipoprecio";
	public static String QUERYSELECTNATIVE="select "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".version_row,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_empresa,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_sucursal,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_usuario,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_bodega,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".id_tipo_precio,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".descripcion,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".porcentaje,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".fecha_inicio,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".fecha_fin,"+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME+".esta_activo from "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+"."+DescuentoTipoPrecioConstantesFunciones.TABLENAME;//+" as "+DescuentoTipoPrecioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DescuentoTipoPrecioConstantesFuncionesAdditional descuentotipoprecioConstantesFuncionesAdditional=null;
	
	public DescuentoTipoPrecioConstantesFuncionesAdditional getDescuentoTipoPrecioConstantesFuncionesAdditional() {
		return this.descuentotipoprecioConstantesFuncionesAdditional;
	}
	
	public void setDescuentoTipoPrecioConstantesFuncionesAdditional(DescuentoTipoPrecioConstantesFuncionesAdditional descuentotipoprecioConstantesFuncionesAdditional) {
		try {
			this.descuentotipoprecioConstantesFuncionesAdditional=descuentotipoprecioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String DESCRIPCION= "descripcion";
    public static final String PORCENTAJE= "porcentaje";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getDescuentoTipoPrecioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.IDEMPRESA)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.IDUSUARIO)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.IDBODEGA)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.DESCRIPCION)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.PORCENTAJE)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.FECHAINICIO)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.FECHAFIN)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO)) {sLabelColumna=DescuentoTipoPrecioConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!descuentotipoprecio.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(descuentotipoprecio.getId(),descuentotipoprecio.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getDescuentoTipoPrecioDescripcion(DescuentoTipoPrecio descuentotipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(descuentotipoprecio !=null/* && descuentotipoprecio.getId()!=0*/) {
			if(descuentotipoprecio.getId()!=null) {
				sDescripcion=descuentotipoprecio.getId().toString();
			}//descuentotipopreciodescuentotipoprecio.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDescuentoTipoPrecioDescripcionDetallado(DescuentoTipoPrecio descuentotipoprecio) {
		String sDescripcion="";
			
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.ID+"=";
		sDescripcion+=descuentotipoprecio.getId().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=descuentotipoprecio.getVersionRow().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=descuentotipoprecio.getid_empresa().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=descuentotipoprecio.getid_sucursal().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=descuentotipoprecio.getid_usuario().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=descuentotipoprecio.getid_bodega().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=descuentotipoprecio.getid_tipo_precio().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=descuentotipoprecio.getdescripcion()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=descuentotipoprecio.getporcentaje().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=descuentotipoprecio.getfecha_inicio().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=descuentotipoprecio.getfecha_fin().toString()+",";
		sDescripcion+=DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=descuentotipoprecio.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDescuentoTipoPrecioDescripcion(DescuentoTipoPrecio descuentotipoprecio,String sValor) throws Exception {			
		if(descuentotipoprecio !=null) {
			//descuentotipopreciodescuentotipoprecio.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		descuentotipoprecio.setdescripcion(descuentotipoprecio.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDescuentoTipoPrecios(List<DescuentoTipoPrecio> descuentotipoprecios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DescuentoTipoPrecio descuentotipoprecio: descuentotipoprecios) {
			descuentotipoprecio.setdescripcion(descuentotipoprecio.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && descuentotipoprecio.getConCambioAuxiliar()) {
			descuentotipoprecio.setIsDeleted(descuentotipoprecio.getIsDeletedAuxiliar());	
			descuentotipoprecio.setIsNew(descuentotipoprecio.getIsNewAuxiliar());	
			descuentotipoprecio.setIsChanged(descuentotipoprecio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			descuentotipoprecio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			descuentotipoprecio.setIsDeletedAuxiliar(false);	
			descuentotipoprecio.setIsNewAuxiliar(false);	
			descuentotipoprecio.setIsChangedAuxiliar(false);
			
			descuentotipoprecio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDescuentoTipoPrecios(List<DescuentoTipoPrecio> descuentotipoprecios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DescuentoTipoPrecio descuentotipoprecio : descuentotipoprecios) {
			if(conAsignarBase && descuentotipoprecio.getConCambioAuxiliar()) {
				descuentotipoprecio.setIsDeleted(descuentotipoprecio.getIsDeletedAuxiliar());	
				descuentotipoprecio.setIsNew(descuentotipoprecio.getIsNewAuxiliar());	
				descuentotipoprecio.setIsChanged(descuentotipoprecio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				descuentotipoprecio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				descuentotipoprecio.setIsDeletedAuxiliar(false);	
				descuentotipoprecio.setIsNewAuxiliar(false);	
				descuentotipoprecio.setIsChangedAuxiliar(false);
				
				descuentotipoprecio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecio,Boolean conEnteros) throws Exception  {
		descuentotipoprecio.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDescuentoTipoPrecios(List<DescuentoTipoPrecio> descuentotipoprecios,Boolean conEnteros) throws Exception  {
		
		for(DescuentoTipoPrecio descuentotipoprecio: descuentotipoprecios) {
			descuentotipoprecio.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDescuentoTipoPrecio(List<DescuentoTipoPrecio> descuentotipoprecios,DescuentoTipoPrecio descuentotipoprecioAux) throws Exception  {
		DescuentoTipoPrecioConstantesFunciones.InicializarValoresDescuentoTipoPrecio(descuentotipoprecioAux,true);
		
		for(DescuentoTipoPrecio descuentotipoprecio: descuentotipoprecios) {
			if(descuentotipoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentotipoprecioAux.setporcentaje(descuentotipoprecioAux.getporcentaje()+descuentotipoprecio.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDescuentoTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DescuentoTipoPrecioConstantesFunciones.getArrayColumnasGlobalesDescuentoTipoPrecio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDescuentoTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DescuentoTipoPrecioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DescuentoTipoPrecioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DescuentoTipoPrecioConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DescuentoTipoPrecioConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDescuentoTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DescuentoTipoPrecio> descuentotipoprecios,DescuentoTipoPrecio descuentotipoprecio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DescuentoTipoPrecio descuentotipoprecioAux: descuentotipoprecios) {
			if(descuentotipoprecioAux!=null && descuentotipoprecio!=null) {
				if((descuentotipoprecioAux.getId()==null && descuentotipoprecio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(descuentotipoprecioAux.getId()!=null && descuentotipoprecio.getId()!=null){
					if(descuentotipoprecioAux.getId().equals(descuentotipoprecio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDescuentoTipoPrecio(List<DescuentoTipoPrecio> descuentotipoprecios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(DescuentoTipoPrecio descuentotipoprecio: descuentotipoprecios) {			
			if(descuentotipoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=descuentotipoprecio.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DescuentoTipoPrecioConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDescuentoTipoPrecio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_ID, DescuentoTipoPrecioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_VERSIONROW, DescuentoTipoPrecioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_IDEMPRESA, DescuentoTipoPrecioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL, DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_IDUSUARIO, DescuentoTipoPrecioConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_IDBODEGA, DescuentoTipoPrecioConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO, DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_DESCRIPCION, DescuentoTipoPrecioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_PORCENTAJE, DescuentoTipoPrecioConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAINICIO, DescuentoTipoPrecioConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAFIN, DescuentoTipoPrecioConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoTipoPrecioConstantesFunciones.LABEL_ESTAACTIVO, DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDescuentoTipoPrecio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDescuentoTipoPrecio() throws Exception  {
		return DescuentoTipoPrecioConstantesFunciones.getTiposSeleccionarDescuentoTipoPrecio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDescuentoTipoPrecio(Boolean conFk) throws Exception  {
		return DescuentoTipoPrecioConstantesFunciones.getTiposSeleccionarDescuentoTipoPrecio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDescuentoTipoPrecio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoTipoPrecioConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(DescuentoTipoPrecioConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDescuentoTipoPrecio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecioAux) throws Exception {
		
			descuentotipoprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(descuentotipoprecioAux.getEmpresa()));
			descuentotipoprecioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(descuentotipoprecioAux.getSucursal()));
			descuentotipoprecioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(descuentotipoprecioAux.getUsuario()));
			descuentotipoprecioAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(descuentotipoprecioAux.getBodega()));
			descuentotipoprecioAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(descuentotipoprecioAux.getTipoPrecio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDescuentoTipoPrecio(List<DescuentoTipoPrecio> descuentotipopreciosTemp) throws Exception {
		for(DescuentoTipoPrecio descuentotipoprecioAux:descuentotipopreciosTemp) {
			
			descuentotipoprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(descuentotipoprecioAux.getEmpresa()));
			descuentotipoprecioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(descuentotipoprecioAux.getSucursal()));
			descuentotipoprecioAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(descuentotipoprecioAux.getUsuario()));
			descuentotipoprecioAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(descuentotipoprecioAux.getBodega()));
			descuentotipoprecioAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(descuentotipoprecioAux.getTipoPrecio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDescuentoTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(TipoPrecio.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDescuentoTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDescuentoTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DescuentoTipoPrecioConstantesFunciones.getClassesRelationshipsOfDescuentoTipoPrecio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDescuentoTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDescuentoTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DescuentoTipoPrecioConstantesFunciones.getClassesRelationshipsFromStringsOfDescuentoTipoPrecio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDescuentoTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DescuentoTipoPrecio descuentotipoprecio,List<DescuentoTipoPrecio> descuentotipoprecios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DescuentoTipoPrecio descuentotipoprecioEncontrado=null;
			
			for(DescuentoTipoPrecio descuentotipoprecioLocal:descuentotipoprecios) {
				if(descuentotipoprecioLocal.getId().equals(descuentotipoprecio.getId())) {
					descuentotipoprecioEncontrado=descuentotipoprecioLocal;
					
					descuentotipoprecioLocal.setIsChanged(descuentotipoprecio.getIsChanged());
					descuentotipoprecioLocal.setIsNew(descuentotipoprecio.getIsNew());
					descuentotipoprecioLocal.setIsDeleted(descuentotipoprecio.getIsDeleted());
					
					descuentotipoprecioLocal.setGeneralEntityOriginal(descuentotipoprecio.getGeneralEntityOriginal());
					
					descuentotipoprecioLocal.setId(descuentotipoprecio.getId());	
					descuentotipoprecioLocal.setVersionRow(descuentotipoprecio.getVersionRow());	
					descuentotipoprecioLocal.setid_empresa(descuentotipoprecio.getid_empresa());	
					descuentotipoprecioLocal.setid_sucursal(descuentotipoprecio.getid_sucursal());	
					descuentotipoprecioLocal.setid_usuario(descuentotipoprecio.getid_usuario());	
					descuentotipoprecioLocal.setid_bodega(descuentotipoprecio.getid_bodega());	
					descuentotipoprecioLocal.setid_tipo_precio(descuentotipoprecio.getid_tipo_precio());	
					descuentotipoprecioLocal.setdescripcion(descuentotipoprecio.getdescripcion());	
					descuentotipoprecioLocal.setporcentaje(descuentotipoprecio.getporcentaje());	
					descuentotipoprecioLocal.setfecha_inicio(descuentotipoprecio.getfecha_inicio());	
					descuentotipoprecioLocal.setfecha_fin(descuentotipoprecio.getfecha_fin());	
					descuentotipoprecioLocal.setesta_activo(descuentotipoprecio.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!descuentotipoprecio.getIsDeleted()) {
				if(!existe) {
					descuentotipoprecios.add(descuentotipoprecio);
				}
			} else {
				if(descuentotipoprecioEncontrado!=null && permiteQuitar)  {
					descuentotipoprecios.remove(descuentotipoprecioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DescuentoTipoPrecio descuentotipoprecio,List<DescuentoTipoPrecio> descuentotipoprecios) throws Exception {
		try	{			
			for(DescuentoTipoPrecio descuentotipoprecioLocal:descuentotipoprecios) {
				if(descuentotipoprecioLocal.getId().equals(descuentotipoprecio.getId())) {
					descuentotipoprecioLocal.setIsSelected(descuentotipoprecio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDescuentoTipoPrecio(List<DescuentoTipoPrecio> descuentotipopreciosAux) throws Exception {
		//this.descuentotipopreciosAux=descuentotipopreciosAux;
		
		for(DescuentoTipoPrecio descuentotipoprecioAux:descuentotipopreciosAux) {
			if(descuentotipoprecioAux.getIsChanged()) {
				descuentotipoprecioAux.setIsChanged(false);
			}		
			
			if(descuentotipoprecioAux.getIsNew()) {
				descuentotipoprecioAux.setIsNew(false);
			}	
			
			if(descuentotipoprecioAux.getIsDeleted()) {
				descuentotipoprecioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecioAux) throws Exception {
		//this.descuentotipoprecioAux=descuentotipoprecioAux;
		
			if(descuentotipoprecioAux.getIsChanged()) {
				descuentotipoprecioAux.setIsChanged(false);
			}		
			
			if(descuentotipoprecioAux.getIsNew()) {
				descuentotipoprecioAux.setIsNew(false);
			}	
			
			if(descuentotipoprecioAux.getIsDeleted()) {
				descuentotipoprecioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DescuentoTipoPrecio descuentotipoprecioAsignar,DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		descuentotipoprecioAsignar.setId(descuentotipoprecio.getId());	
		descuentotipoprecioAsignar.setVersionRow(descuentotipoprecio.getVersionRow());	
		descuentotipoprecioAsignar.setid_empresa(descuentotipoprecio.getid_empresa());
		descuentotipoprecioAsignar.setempresa_descripcion(descuentotipoprecio.getempresa_descripcion());	
		descuentotipoprecioAsignar.setid_sucursal(descuentotipoprecio.getid_sucursal());
		descuentotipoprecioAsignar.setsucursal_descripcion(descuentotipoprecio.getsucursal_descripcion());	
		descuentotipoprecioAsignar.setid_usuario(descuentotipoprecio.getid_usuario());
		descuentotipoprecioAsignar.setusuario_descripcion(descuentotipoprecio.getusuario_descripcion());	
		descuentotipoprecioAsignar.setid_bodega(descuentotipoprecio.getid_bodega());
		descuentotipoprecioAsignar.setbodega_descripcion(descuentotipoprecio.getbodega_descripcion());	
		descuentotipoprecioAsignar.setid_tipo_precio(descuentotipoprecio.getid_tipo_precio());
		descuentotipoprecioAsignar.settipoprecio_descripcion(descuentotipoprecio.gettipoprecio_descripcion());	
		descuentotipoprecioAsignar.setdescripcion(descuentotipoprecio.getdescripcion());	
		descuentotipoprecioAsignar.setporcentaje(descuentotipoprecio.getporcentaje());	
		descuentotipoprecioAsignar.setfecha_inicio(descuentotipoprecio.getfecha_inicio());	
		descuentotipoprecioAsignar.setfecha_fin(descuentotipoprecio.getfecha_fin());	
		descuentotipoprecioAsignar.setesta_activo(descuentotipoprecio.getesta_activo());	
	}
	
	public static void inicializarDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		try {
				descuentotipoprecio.setId(0L);	
					
				descuentotipoprecio.setid_empresa(-1L);	
				descuentotipoprecio.setid_sucursal(-1L);	
				descuentotipoprecio.setid_usuario(-1L);	
				descuentotipoprecio.setid_bodega(-1L);	
				descuentotipoprecio.setid_tipo_precio(-1L);	
				descuentotipoprecio.setdescripcion("");	
				descuentotipoprecio.setporcentaje(0.0);	
				descuentotipoprecio.setfecha_inicio(new Date());	
				descuentotipoprecio.setfecha_fin(new Date());	
				descuentotipoprecio.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDescuentoTipoPrecio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoTipoPrecioConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDescuentoTipoPrecio(String sTipo,Row row,Workbook workbook,DescuentoTipoPrecio descuentotipoprecio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentotipoprecio.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(descuentotipoprecio.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDescuentoTipoPrecio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDescuentoTipoPrecio() {
		return this.sFinalQueryDescuentoTipoPrecio;
	}
	
	public void setsFinalQueryDescuentoTipoPrecio(String sFinalQueryDescuentoTipoPrecio) {
		this.sFinalQueryDescuentoTipoPrecio= sFinalQueryDescuentoTipoPrecio;
	}
	
	public Border resaltarSeleccionarDescuentoTipoPrecio=null;
	
	public Border setResaltarSeleccionarDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDescuentoTipoPrecio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDescuentoTipoPrecio() {
		return this.resaltarSeleccionarDescuentoTipoPrecio;
	}
	
	public void setResaltarSeleccionarDescuentoTipoPrecio(Border borderResaltarSeleccionarDescuentoTipoPrecio) {
		this.resaltarSeleccionarDescuentoTipoPrecio= borderResaltarSeleccionarDescuentoTipoPrecio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDescuentoTipoPrecio=null;
	public Boolean mostraridDescuentoTipoPrecio=true;
	public Boolean activaridDescuentoTipoPrecio=true;

	public Border resaltarid_empresaDescuentoTipoPrecio=null;
	public Boolean mostrarid_empresaDescuentoTipoPrecio=true;
	public Boolean activarid_empresaDescuentoTipoPrecio=true;
	public Boolean cargarid_empresaDescuentoTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDescuentoTipoPrecio=false;//ConEventDepend=true

	public Border resaltarid_sucursalDescuentoTipoPrecio=null;
	public Boolean mostrarid_sucursalDescuentoTipoPrecio=true;
	public Boolean activarid_sucursalDescuentoTipoPrecio=true;
	public Boolean cargarid_sucursalDescuentoTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDescuentoTipoPrecio=false;//ConEventDepend=true

	public Border resaltarid_usuarioDescuentoTipoPrecio=null;
	public Boolean mostrarid_usuarioDescuentoTipoPrecio=true;
	public Boolean activarid_usuarioDescuentoTipoPrecio=true;
	public Boolean cargarid_usuarioDescuentoTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioDescuentoTipoPrecio=false;//ConEventDepend=true

	public Border resaltarid_bodegaDescuentoTipoPrecio=null;
	public Boolean mostrarid_bodegaDescuentoTipoPrecio=true;
	public Boolean activarid_bodegaDescuentoTipoPrecio=true;
	public Boolean cargarid_bodegaDescuentoTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDescuentoTipoPrecio=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioDescuentoTipoPrecio=null;
	public Boolean mostrarid_tipo_precioDescuentoTipoPrecio=true;
	public Boolean activarid_tipo_precioDescuentoTipoPrecio=true;
	public Boolean cargarid_tipo_precioDescuentoTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioDescuentoTipoPrecio=false;//ConEventDepend=true

	public Border resaltardescripcionDescuentoTipoPrecio=null;
	public Boolean mostrardescripcionDescuentoTipoPrecio=true;
	public Boolean activardescripcionDescuentoTipoPrecio=true;

	public Border resaltarporcentajeDescuentoTipoPrecio=null;
	public Boolean mostrarporcentajeDescuentoTipoPrecio=true;
	public Boolean activarporcentajeDescuentoTipoPrecio=true;

	public Border resaltarfecha_inicioDescuentoTipoPrecio=null;
	public Boolean mostrarfecha_inicioDescuentoTipoPrecio=true;
	public Boolean activarfecha_inicioDescuentoTipoPrecio=true;

	public Border resaltarfecha_finDescuentoTipoPrecio=null;
	public Boolean mostrarfecha_finDescuentoTipoPrecio=true;
	public Boolean activarfecha_finDescuentoTipoPrecio=true;

	public Border resaltaresta_activoDescuentoTipoPrecio=null;
	public Boolean mostraresta_activoDescuentoTipoPrecio=true;
	public Boolean activaresta_activoDescuentoTipoPrecio=true;

	
	

	public Border setResaltaridDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltaridDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDescuentoTipoPrecio() {
		return this.resaltaridDescuentoTipoPrecio;
	}

	public void setResaltaridDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltaridDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostraridDescuentoTipoPrecio() {
		return this.mostraridDescuentoTipoPrecio;
	}

	public void setMostraridDescuentoTipoPrecio(Boolean mostraridDescuentoTipoPrecio) {
		this.mostraridDescuentoTipoPrecio= mostraridDescuentoTipoPrecio;
	}

	public Boolean getActivaridDescuentoTipoPrecio() {
		return this.activaridDescuentoTipoPrecio;
	}

	public void setActivaridDescuentoTipoPrecio(Boolean activaridDescuentoTipoPrecio) {
		this.activaridDescuentoTipoPrecio= activaridDescuentoTipoPrecio;
	}

	public Border setResaltarid_empresaDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_empresaDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDescuentoTipoPrecio() {
		return this.resaltarid_empresaDescuentoTipoPrecio;
	}

	public void setResaltarid_empresaDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarid_empresaDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_empresaDescuentoTipoPrecio() {
		return this.mostrarid_empresaDescuentoTipoPrecio;
	}

	public void setMostrarid_empresaDescuentoTipoPrecio(Boolean mostrarid_empresaDescuentoTipoPrecio) {
		this.mostrarid_empresaDescuentoTipoPrecio= mostrarid_empresaDescuentoTipoPrecio;
	}

	public Boolean getActivarid_empresaDescuentoTipoPrecio() {
		return this.activarid_empresaDescuentoTipoPrecio;
	}

	public void setActivarid_empresaDescuentoTipoPrecio(Boolean activarid_empresaDescuentoTipoPrecio) {
		this.activarid_empresaDescuentoTipoPrecio= activarid_empresaDescuentoTipoPrecio;
	}

	public Boolean getCargarid_empresaDescuentoTipoPrecio() {
		return this.cargarid_empresaDescuentoTipoPrecio;
	}

	public void setCargarid_empresaDescuentoTipoPrecio(Boolean cargarid_empresaDescuentoTipoPrecio) {
		this.cargarid_empresaDescuentoTipoPrecio= cargarid_empresaDescuentoTipoPrecio;
	}

	public Border setResaltarid_sucursalDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDescuentoTipoPrecio() {
		return this.resaltarid_sucursalDescuentoTipoPrecio;
	}

	public void setResaltarid_sucursalDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarid_sucursalDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDescuentoTipoPrecio() {
		return this.mostrarid_sucursalDescuentoTipoPrecio;
	}

	public void setMostrarid_sucursalDescuentoTipoPrecio(Boolean mostrarid_sucursalDescuentoTipoPrecio) {
		this.mostrarid_sucursalDescuentoTipoPrecio= mostrarid_sucursalDescuentoTipoPrecio;
	}

	public Boolean getActivarid_sucursalDescuentoTipoPrecio() {
		return this.activarid_sucursalDescuentoTipoPrecio;
	}

	public void setActivarid_sucursalDescuentoTipoPrecio(Boolean activarid_sucursalDescuentoTipoPrecio) {
		this.activarid_sucursalDescuentoTipoPrecio= activarid_sucursalDescuentoTipoPrecio;
	}

	public Boolean getCargarid_sucursalDescuentoTipoPrecio() {
		return this.cargarid_sucursalDescuentoTipoPrecio;
	}

	public void setCargarid_sucursalDescuentoTipoPrecio(Boolean cargarid_sucursalDescuentoTipoPrecio) {
		this.cargarid_sucursalDescuentoTipoPrecio= cargarid_sucursalDescuentoTipoPrecio;
	}

	public Border setResaltarid_usuarioDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_usuarioDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioDescuentoTipoPrecio() {
		return this.resaltarid_usuarioDescuentoTipoPrecio;
	}

	public void setResaltarid_usuarioDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarid_usuarioDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_usuarioDescuentoTipoPrecio() {
		return this.mostrarid_usuarioDescuentoTipoPrecio;
	}

	public void setMostrarid_usuarioDescuentoTipoPrecio(Boolean mostrarid_usuarioDescuentoTipoPrecio) {
		this.mostrarid_usuarioDescuentoTipoPrecio= mostrarid_usuarioDescuentoTipoPrecio;
	}

	public Boolean getActivarid_usuarioDescuentoTipoPrecio() {
		return this.activarid_usuarioDescuentoTipoPrecio;
	}

	public void setActivarid_usuarioDescuentoTipoPrecio(Boolean activarid_usuarioDescuentoTipoPrecio) {
		this.activarid_usuarioDescuentoTipoPrecio= activarid_usuarioDescuentoTipoPrecio;
	}

	public Boolean getCargarid_usuarioDescuentoTipoPrecio() {
		return this.cargarid_usuarioDescuentoTipoPrecio;
	}

	public void setCargarid_usuarioDescuentoTipoPrecio(Boolean cargarid_usuarioDescuentoTipoPrecio) {
		this.cargarid_usuarioDescuentoTipoPrecio= cargarid_usuarioDescuentoTipoPrecio;
	}

	public Border setResaltarid_bodegaDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDescuentoTipoPrecio() {
		return this.resaltarid_bodegaDescuentoTipoPrecio;
	}

	public void setResaltarid_bodegaDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarid_bodegaDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDescuentoTipoPrecio() {
		return this.mostrarid_bodegaDescuentoTipoPrecio;
	}

	public void setMostrarid_bodegaDescuentoTipoPrecio(Boolean mostrarid_bodegaDescuentoTipoPrecio) {
		this.mostrarid_bodegaDescuentoTipoPrecio= mostrarid_bodegaDescuentoTipoPrecio;
	}

	public Boolean getActivarid_bodegaDescuentoTipoPrecio() {
		return this.activarid_bodegaDescuentoTipoPrecio;
	}

	public void setActivarid_bodegaDescuentoTipoPrecio(Boolean activarid_bodegaDescuentoTipoPrecio) {
		this.activarid_bodegaDescuentoTipoPrecio= activarid_bodegaDescuentoTipoPrecio;
	}

	public Boolean getCargarid_bodegaDescuentoTipoPrecio() {
		return this.cargarid_bodegaDescuentoTipoPrecio;
	}

	public void setCargarid_bodegaDescuentoTipoPrecio(Boolean cargarid_bodegaDescuentoTipoPrecio) {
		this.cargarid_bodegaDescuentoTipoPrecio= cargarid_bodegaDescuentoTipoPrecio;
	}

	public Border setResaltarid_tipo_precioDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioDescuentoTipoPrecio() {
		return this.resaltarid_tipo_precioDescuentoTipoPrecio;
	}

	public void setResaltarid_tipo_precioDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarid_tipo_precioDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioDescuentoTipoPrecio() {
		return this.mostrarid_tipo_precioDescuentoTipoPrecio;
	}

	public void setMostrarid_tipo_precioDescuentoTipoPrecio(Boolean mostrarid_tipo_precioDescuentoTipoPrecio) {
		this.mostrarid_tipo_precioDescuentoTipoPrecio= mostrarid_tipo_precioDescuentoTipoPrecio;
	}

	public Boolean getActivarid_tipo_precioDescuentoTipoPrecio() {
		return this.activarid_tipo_precioDescuentoTipoPrecio;
	}

	public void setActivarid_tipo_precioDescuentoTipoPrecio(Boolean activarid_tipo_precioDescuentoTipoPrecio) {
		this.activarid_tipo_precioDescuentoTipoPrecio= activarid_tipo_precioDescuentoTipoPrecio;
	}

	public Boolean getCargarid_tipo_precioDescuentoTipoPrecio() {
		return this.cargarid_tipo_precioDescuentoTipoPrecio;
	}

	public void setCargarid_tipo_precioDescuentoTipoPrecio(Boolean cargarid_tipo_precioDescuentoTipoPrecio) {
		this.cargarid_tipo_precioDescuentoTipoPrecio= cargarid_tipo_precioDescuentoTipoPrecio;
	}

	public Border setResaltardescripcionDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltardescripcionDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDescuentoTipoPrecio() {
		return this.resaltardescripcionDescuentoTipoPrecio;
	}

	public void setResaltardescripcionDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltardescripcionDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrardescripcionDescuentoTipoPrecio() {
		return this.mostrardescripcionDescuentoTipoPrecio;
	}

	public void setMostrardescripcionDescuentoTipoPrecio(Boolean mostrardescripcionDescuentoTipoPrecio) {
		this.mostrardescripcionDescuentoTipoPrecio= mostrardescripcionDescuentoTipoPrecio;
	}

	public Boolean getActivardescripcionDescuentoTipoPrecio() {
		return this.activardescripcionDescuentoTipoPrecio;
	}

	public void setActivardescripcionDescuentoTipoPrecio(Boolean activardescripcionDescuentoTipoPrecio) {
		this.activardescripcionDescuentoTipoPrecio= activardescripcionDescuentoTipoPrecio;
	}

	public Border setResaltarporcentajeDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarporcentajeDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDescuentoTipoPrecio() {
		return this.resaltarporcentajeDescuentoTipoPrecio;
	}

	public void setResaltarporcentajeDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarporcentajeDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarporcentajeDescuentoTipoPrecio() {
		return this.mostrarporcentajeDescuentoTipoPrecio;
	}

	public void setMostrarporcentajeDescuentoTipoPrecio(Boolean mostrarporcentajeDescuentoTipoPrecio) {
		this.mostrarporcentajeDescuentoTipoPrecio= mostrarporcentajeDescuentoTipoPrecio;
	}

	public Boolean getActivarporcentajeDescuentoTipoPrecio() {
		return this.activarporcentajeDescuentoTipoPrecio;
	}

	public void setActivarporcentajeDescuentoTipoPrecio(Boolean activarporcentajeDescuentoTipoPrecio) {
		this.activarporcentajeDescuentoTipoPrecio= activarporcentajeDescuentoTipoPrecio;
	}

	public Border setResaltarfecha_inicioDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioDescuentoTipoPrecio() {
		return this.resaltarfecha_inicioDescuentoTipoPrecio;
	}

	public void setResaltarfecha_inicioDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarfecha_inicioDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioDescuentoTipoPrecio() {
		return this.mostrarfecha_inicioDescuentoTipoPrecio;
	}

	public void setMostrarfecha_inicioDescuentoTipoPrecio(Boolean mostrarfecha_inicioDescuentoTipoPrecio) {
		this.mostrarfecha_inicioDescuentoTipoPrecio= mostrarfecha_inicioDescuentoTipoPrecio;
	}

	public Boolean getActivarfecha_inicioDescuentoTipoPrecio() {
		return this.activarfecha_inicioDescuentoTipoPrecio;
	}

	public void setActivarfecha_inicioDescuentoTipoPrecio(Boolean activarfecha_inicioDescuentoTipoPrecio) {
		this.activarfecha_inicioDescuentoTipoPrecio= activarfecha_inicioDescuentoTipoPrecio;
	}

	public Border setResaltarfecha_finDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarfecha_finDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finDescuentoTipoPrecio() {
		return this.resaltarfecha_finDescuentoTipoPrecio;
	}

	public void setResaltarfecha_finDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarfecha_finDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarfecha_finDescuentoTipoPrecio() {
		return this.mostrarfecha_finDescuentoTipoPrecio;
	}

	public void setMostrarfecha_finDescuentoTipoPrecio(Boolean mostrarfecha_finDescuentoTipoPrecio) {
		this.mostrarfecha_finDescuentoTipoPrecio= mostrarfecha_finDescuentoTipoPrecio;
	}

	public Boolean getActivarfecha_finDescuentoTipoPrecio() {
		return this.activarfecha_finDescuentoTipoPrecio;
	}

	public void setActivarfecha_finDescuentoTipoPrecio(Boolean activarfecha_finDescuentoTipoPrecio) {
		this.activarfecha_finDescuentoTipoPrecio= activarfecha_finDescuentoTipoPrecio;
	}

	public Border setResaltaresta_activoDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentotipoprecioBeanSwingJInternalFrame.jTtoolBarDescuentoTipoPrecio.setBorder(borderResaltar);
		
		this.resaltaresta_activoDescuentoTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoDescuentoTipoPrecio() {
		return this.resaltaresta_activoDescuentoTipoPrecio;
	}

	public void setResaltaresta_activoDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltaresta_activoDescuentoTipoPrecio= borderResaltar;
	}

	public Boolean getMostraresta_activoDescuentoTipoPrecio() {
		return this.mostraresta_activoDescuentoTipoPrecio;
	}

	public void setMostraresta_activoDescuentoTipoPrecio(Boolean mostraresta_activoDescuentoTipoPrecio) {
		this.mostraresta_activoDescuentoTipoPrecio= mostraresta_activoDescuentoTipoPrecio;
	}

	public Boolean getActivaresta_activoDescuentoTipoPrecio() {
		return this.activaresta_activoDescuentoTipoPrecio;
	}

	public void setActivaresta_activoDescuentoTipoPrecio(Boolean activaresta_activoDescuentoTipoPrecio) {
		this.activaresta_activoDescuentoTipoPrecio= activaresta_activoDescuentoTipoPrecio;
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
		
		
		this.setMostraridDescuentoTipoPrecio(esInicial);
		this.setMostrarid_empresaDescuentoTipoPrecio(esInicial);
		this.setMostrarid_sucursalDescuentoTipoPrecio(esInicial);
		this.setMostrarid_usuarioDescuentoTipoPrecio(esInicial);
		this.setMostrarid_bodegaDescuentoTipoPrecio(esInicial);
		this.setMostrarid_tipo_precioDescuentoTipoPrecio(esInicial);
		this.setMostrardescripcionDescuentoTipoPrecio(esInicial);
		this.setMostrarporcentajeDescuentoTipoPrecio(esInicial);
		this.setMostrarfecha_inicioDescuentoTipoPrecio(esInicial);
		this.setMostrarfecha_finDescuentoTipoPrecio(esInicial);
		this.setMostraresta_activoDescuentoTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.ID)) {
				this.setMostraridDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoDescuentoTipoPrecio(esAsigna);
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
		
		
		this.setActivaridDescuentoTipoPrecio(esInicial);
		this.setActivarid_empresaDescuentoTipoPrecio(esInicial);
		this.setActivarid_sucursalDescuentoTipoPrecio(esInicial);
		this.setActivarid_usuarioDescuentoTipoPrecio(esInicial);
		this.setActivarid_bodegaDescuentoTipoPrecio(esInicial);
		this.setActivarid_tipo_precioDescuentoTipoPrecio(esInicial);
		this.setActivardescripcionDescuentoTipoPrecio(esInicial);
		this.setActivarporcentajeDescuentoTipoPrecio(esInicial);
		this.setActivarfecha_inicioDescuentoTipoPrecio(esInicial);
		this.setActivarfecha_finDescuentoTipoPrecio(esInicial);
		this.setActivaresta_activoDescuentoTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.ID)) {
				this.setActivaridDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoDescuentoTipoPrecio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDescuentoTipoPrecio(esInicial);
		this.setResaltarid_empresaDescuentoTipoPrecio(esInicial);
		this.setResaltarid_sucursalDescuentoTipoPrecio(esInicial);
		this.setResaltarid_usuarioDescuentoTipoPrecio(esInicial);
		this.setResaltarid_bodegaDescuentoTipoPrecio(esInicial);
		this.setResaltarid_tipo_precioDescuentoTipoPrecio(esInicial);
		this.setResaltardescripcionDescuentoTipoPrecio(esInicial);
		this.setResaltarporcentajeDescuentoTipoPrecio(esInicial);
		this.setResaltarfecha_inicioDescuentoTipoPrecio(esInicial);
		this.setResaltarfecha_finDescuentoTipoPrecio(esInicial);
		this.setResaltaresta_activoDescuentoTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.ID)) {
				this.setResaltaridDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finDescuentoTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoDescuentoTipoPrecio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDescuentoTipoPrecio=true;

	public Boolean getMostrarFK_IdBodegaDescuentoTipoPrecio() {
		return this.mostrarFK_IdBodegaDescuentoTipoPrecio;
	}

	public void setMostrarFK_IdBodegaDescuentoTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDescuentoTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDescuentoTipoPrecio=true;

	public Boolean getMostrarFK_IdEmpresaDescuentoTipoPrecio() {
		return this.mostrarFK_IdEmpresaDescuentoTipoPrecio;
	}

	public void setMostrarFK_IdEmpresaDescuentoTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDescuentoTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDescuentoTipoPrecio=true;

	public Boolean getMostrarFK_IdSucursalDescuentoTipoPrecio() {
		return this.mostrarFK_IdSucursalDescuentoTipoPrecio;
	}

	public void setMostrarFK_IdSucursalDescuentoTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDescuentoTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioDescuentoTipoPrecio=true;

	public Boolean getMostrarFK_IdTipoPrecioDescuentoTipoPrecio() {
		return this.mostrarFK_IdTipoPrecioDescuentoTipoPrecio;
	}

	public void setMostrarFK_IdTipoPrecioDescuentoTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioDescuentoTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioDescuentoTipoPrecio=true;

	public Boolean getMostrarFK_IdUsuarioDescuentoTipoPrecio() {
		return this.mostrarFK_IdUsuarioDescuentoTipoPrecio;
	}

	public void setMostrarFK_IdUsuarioDescuentoTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioDescuentoTipoPrecio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDescuentoTipoPrecio=true;

	public Boolean getActivarFK_IdBodegaDescuentoTipoPrecio() {
		return this.activarFK_IdBodegaDescuentoTipoPrecio;
	}

	public void setActivarFK_IdBodegaDescuentoTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDescuentoTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDescuentoTipoPrecio=true;

	public Boolean getActivarFK_IdEmpresaDescuentoTipoPrecio() {
		return this.activarFK_IdEmpresaDescuentoTipoPrecio;
	}

	public void setActivarFK_IdEmpresaDescuentoTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDescuentoTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDescuentoTipoPrecio=true;

	public Boolean getActivarFK_IdSucursalDescuentoTipoPrecio() {
		return this.activarFK_IdSucursalDescuentoTipoPrecio;
	}

	public void setActivarFK_IdSucursalDescuentoTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDescuentoTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioDescuentoTipoPrecio=true;

	public Boolean getActivarFK_IdTipoPrecioDescuentoTipoPrecio() {
		return this.activarFK_IdTipoPrecioDescuentoTipoPrecio;
	}

	public void setActivarFK_IdTipoPrecioDescuentoTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioDescuentoTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioDescuentoTipoPrecio=true;

	public Boolean getActivarFK_IdUsuarioDescuentoTipoPrecio() {
		return this.activarFK_IdUsuarioDescuentoTipoPrecio;
	}

	public void setActivarFK_IdUsuarioDescuentoTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioDescuentoTipoPrecio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDescuentoTipoPrecio=null;

	public Border getResaltarFK_IdBodegaDescuentoTipoPrecio() {
		return this.resaltarFK_IdBodegaDescuentoTipoPrecio;
	}

	public void setResaltarFK_IdBodegaDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdBodegaDescuentoTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDescuentoTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDescuentoTipoPrecio=null;

	public Border getResaltarFK_IdEmpresaDescuentoTipoPrecio() {
		return this.resaltarFK_IdEmpresaDescuentoTipoPrecio;
	}

	public void setResaltarFK_IdEmpresaDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDescuentoTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDescuentoTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDescuentoTipoPrecio=null;

	public Border getResaltarFK_IdSucursalDescuentoTipoPrecio() {
		return this.resaltarFK_IdSucursalDescuentoTipoPrecio;
	}

	public void setResaltarFK_IdSucursalDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdSucursalDescuentoTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDescuentoTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioDescuentoTipoPrecio=null;

	public Border getResaltarFK_IdTipoPrecioDescuentoTipoPrecio() {
		return this.resaltarFK_IdTipoPrecioDescuentoTipoPrecio;
	}

	public void setResaltarFK_IdTipoPrecioDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioDescuentoTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioDescuentoTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioDescuentoTipoPrecio=null;

	public Border getResaltarFK_IdUsuarioDescuentoTipoPrecio() {
		return this.resaltarFK_IdUsuarioDescuentoTipoPrecio;
	}

	public void setResaltarFK_IdUsuarioDescuentoTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdUsuarioDescuentoTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioDescuentoTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoTipoPrecioBeanSwingJInternalFrame descuentotipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioDescuentoTipoPrecio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}