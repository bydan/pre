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


import com.bydan.erp.inventario.util.DescuentoMontoConstantesFunciones;
import com.bydan.erp.inventario.util.DescuentoMontoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DescuentoMontoParameterGeneral;

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
final public class DescuentoMontoConstantesFunciones extends DescuentoMontoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DescuentoMonto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DescuentoMonto"+DescuentoMontoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DescuentoMontoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DescuentoMontoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DescuentoMontoConstantesFunciones.SCHEMA+"_"+DescuentoMontoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DescuentoMontoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DescuentoMontoConstantesFunciones.SCHEMA+"_"+DescuentoMontoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DescuentoMontoConstantesFunciones.SCHEMA+"_"+DescuentoMontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DescuentoMontoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DescuentoMontoConstantesFunciones.SCHEMA+"_"+DescuentoMontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoMontoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DescuentoMontoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoMontoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoMontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DescuentoMontoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DescuentoMontoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DescuentoMontoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DescuentoMontoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DescuentoMontoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DescuentoMontoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Descuento Montos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Descuento Monto";
	public static final String SCLASSWEBTITULO_LOWER="Descuento Monto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DescuentoMonto";
	public static final String OBJECTNAME="descuentomonto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="descuento_monto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select descuentomonto from "+DescuentoMontoConstantesFunciones.SPERSISTENCENAME+" descuentomonto";
	public static String QUERYSELECTNATIVE="select "+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".id,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".version_row,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".id_empresa,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".id_sucursal,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".id_usuario,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".id_bodega,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".descripcion,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".porcentaje,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".valor_inicio,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".valor_fin,"+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME+".esta_activo from "+DescuentoMontoConstantesFunciones.SCHEMA+"."+DescuentoMontoConstantesFunciones.TABLENAME;//+" as "+DescuentoMontoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DescuentoMontoConstantesFuncionesAdditional descuentomontoConstantesFuncionesAdditional=null;
	
	public DescuentoMontoConstantesFuncionesAdditional getDescuentoMontoConstantesFuncionesAdditional() {
		return this.descuentomontoConstantesFuncionesAdditional;
	}
	
	public void setDescuentoMontoConstantesFuncionesAdditional(DescuentoMontoConstantesFuncionesAdditional descuentomontoConstantesFuncionesAdditional) {
		try {
			this.descuentomontoConstantesFuncionesAdditional=descuentomontoConstantesFuncionesAdditional;
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
    public static final String DESCRIPCION= "descripcion";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALORINICIO= "valor_inicio";
    public static final String VALORFIN= "valor_fin";
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
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALORINICIO= "Valor Inicio";
		public static final String LABEL_VALORINICIO_LOWER= "Valor Inicio";
    	public static final String LABEL_VALORFIN= "Valor Fin";
		public static final String LABEL_VALORFIN_LOWER= "Valor Fin";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getDescuentoMontoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.IDUSUARIO)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.IDBODEGA)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.PORCENTAJE)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.VALORINICIO)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_VALORINICIO;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.VALORFIN)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_VALORFIN;}
		if(sNombreColumna.equals(DescuentoMontoConstantesFunciones.ESTAACTIVO)) {sLabelColumna=DescuentoMontoConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(DescuentoMonto descuentomonto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!descuentomonto.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(DescuentoMonto descuentomonto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(descuentomonto.getId(),descuentomonto.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getDescuentoMontoDescripcion(DescuentoMonto descuentomonto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(descuentomonto !=null/* && descuentomonto.getId()!=0*/) {
			if(descuentomonto.getId()!=null) {
				sDescripcion=descuentomonto.getId().toString();
			}//descuentomontodescuentomonto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDescuentoMontoDescripcionDetallado(DescuentoMonto descuentomonto) {
		String sDescripcion="";
			
		sDescripcion+=DescuentoMontoConstantesFunciones.ID+"=";
		sDescripcion+=descuentomonto.getId().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=descuentomonto.getVersionRow().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=descuentomonto.getid_empresa().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=descuentomonto.getid_sucursal().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=descuentomonto.getid_usuario().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=descuentomonto.getid_bodega().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=descuentomonto.getdescripcion()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=descuentomonto.getporcentaje().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.VALORINICIO+"=";
		sDescripcion+=descuentomonto.getvalor_inicio().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.VALORFIN+"=";
		sDescripcion+=descuentomonto.getvalor_fin().toString()+",";
		sDescripcion+=DescuentoMontoConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=descuentomonto.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDescuentoMontoDescripcion(DescuentoMonto descuentomonto,String sValor) throws Exception {			
		if(descuentomonto !=null) {
			//descuentomontodescuentomonto.getId().toString();
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

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDescuentoMonto(DescuentoMonto descuentomonto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		descuentomonto.setdescripcion(descuentomonto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDescuentoMontos(List<DescuentoMonto> descuentomontos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DescuentoMonto descuentomonto: descuentomontos) {
			descuentomonto.setdescripcion(descuentomonto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDescuentoMonto(DescuentoMonto descuentomonto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && descuentomonto.getConCambioAuxiliar()) {
			descuentomonto.setIsDeleted(descuentomonto.getIsDeletedAuxiliar());	
			descuentomonto.setIsNew(descuentomonto.getIsNewAuxiliar());	
			descuentomonto.setIsChanged(descuentomonto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			descuentomonto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			descuentomonto.setIsDeletedAuxiliar(false);	
			descuentomonto.setIsNewAuxiliar(false);	
			descuentomonto.setIsChangedAuxiliar(false);
			
			descuentomonto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDescuentoMontos(List<DescuentoMonto> descuentomontos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DescuentoMonto descuentomonto : descuentomontos) {
			if(conAsignarBase && descuentomonto.getConCambioAuxiliar()) {
				descuentomonto.setIsDeleted(descuentomonto.getIsDeletedAuxiliar());	
				descuentomonto.setIsNew(descuentomonto.getIsNewAuxiliar());	
				descuentomonto.setIsChanged(descuentomonto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				descuentomonto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				descuentomonto.setIsDeletedAuxiliar(false);	
				descuentomonto.setIsNewAuxiliar(false);	
				descuentomonto.setIsChangedAuxiliar(false);
				
				descuentomonto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDescuentoMonto(DescuentoMonto descuentomonto,Boolean conEnteros) throws Exception  {
		descuentomonto.setporcentaje(0.0);
		descuentomonto.setvalor_inicio(0.0);
		descuentomonto.setvalor_fin(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDescuentoMontos(List<DescuentoMonto> descuentomontos,Boolean conEnteros) throws Exception  {
		
		for(DescuentoMonto descuentomonto: descuentomontos) {
			descuentomonto.setporcentaje(0.0);
			descuentomonto.setvalor_inicio(0.0);
			descuentomonto.setvalor_fin(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDescuentoMonto(List<DescuentoMonto> descuentomontos,DescuentoMonto descuentomontoAux) throws Exception  {
		DescuentoMontoConstantesFunciones.InicializarValoresDescuentoMonto(descuentomontoAux,true);
		
		for(DescuentoMonto descuentomonto: descuentomontos) {
			if(descuentomonto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			descuentomontoAux.setporcentaje(descuentomontoAux.getporcentaje()+descuentomonto.getporcentaje());			
			descuentomontoAux.setvalor_inicio(descuentomontoAux.getvalor_inicio()+descuentomonto.getvalor_inicio());			
			descuentomontoAux.setvalor_fin(descuentomontoAux.getvalor_fin()+descuentomonto.getvalor_fin());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDescuentoMonto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DescuentoMontoConstantesFunciones.getArrayColumnasGlobalesDescuentoMonto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDescuentoMonto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DescuentoMontoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DescuentoMontoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DescuentoMontoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DescuentoMontoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DescuentoMontoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DescuentoMontoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDescuentoMonto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DescuentoMonto> descuentomontos,DescuentoMonto descuentomonto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DescuentoMonto descuentomontoAux: descuentomontos) {
			if(descuentomontoAux!=null && descuentomonto!=null) {
				if((descuentomontoAux.getId()==null && descuentomonto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(descuentomontoAux.getId()!=null && descuentomonto.getId()!=null){
					if(descuentomontoAux.getId().equals(descuentomonto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDescuentoMonto(List<DescuentoMonto> descuentomontos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valor_inicioTotal=0.0;
		Double valor_finTotal=0.0;
	
		for(DescuentoMonto descuentomonto: descuentomontos) {			
			if(descuentomonto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=descuentomonto.getporcentaje();
			valor_inicioTotal+=descuentomonto.getvalor_inicio();
			valor_finTotal+=descuentomonto.getvalor_fin();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DescuentoMontoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DescuentoMontoConstantesFunciones.VALORINICIO);
		datoGeneral.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_VALORINICIO);
		datoGeneral.setdValorDouble(valor_inicioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DescuentoMontoConstantesFunciones.VALORFIN);
		datoGeneral.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_VALORFIN);
		datoGeneral.setdValorDouble(valor_finTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDescuentoMonto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_ID, DescuentoMontoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_VERSIONROW, DescuentoMontoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_IDEMPRESA, DescuentoMontoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_IDSUCURSAL, DescuentoMontoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_IDUSUARIO, DescuentoMontoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_IDBODEGA, DescuentoMontoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_DESCRIPCION, DescuentoMontoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_PORCENTAJE, DescuentoMontoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_VALORINICIO, DescuentoMontoConstantesFunciones.VALORINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_VALORFIN, DescuentoMontoConstantesFunciones.VALORFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DescuentoMontoConstantesFunciones.LABEL_ESTAACTIVO, DescuentoMontoConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDescuentoMonto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.VALORINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.VALORFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DescuentoMontoConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDescuentoMonto() throws Exception  {
		return DescuentoMontoConstantesFunciones.getTiposSeleccionarDescuentoMonto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDescuentoMonto(Boolean conFk) throws Exception  {
		return DescuentoMontoConstantesFunciones.getTiposSeleccionarDescuentoMonto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDescuentoMonto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_VALORINICIO);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_VALORINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_VALORFIN);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_VALORFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DescuentoMontoConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(DescuentoMontoConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDescuentoMonto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDescuentoMonto(DescuentoMonto descuentomontoAux) throws Exception {
		
			descuentomontoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(descuentomontoAux.getEmpresa()));
			descuentomontoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(descuentomontoAux.getSucursal()));
			descuentomontoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(descuentomontoAux.getUsuario()));
			descuentomontoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(descuentomontoAux.getBodega()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDescuentoMonto(List<DescuentoMonto> descuentomontosTemp) throws Exception {
		for(DescuentoMonto descuentomontoAux:descuentomontosTemp) {
			
			descuentomontoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(descuentomontoAux.getEmpresa()));
			descuentomontoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(descuentomontoAux.getSucursal()));
			descuentomontoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(descuentomontoAux.getUsuario()));
			descuentomontoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(descuentomontoAux.getBodega()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDescuentoMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Bodega.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDescuentoMonto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDescuentoMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DescuentoMontoConstantesFunciones.getClassesRelationshipsOfDescuentoMonto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDescuentoMonto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDescuentoMonto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DescuentoMontoConstantesFunciones.getClassesRelationshipsFromStringsOfDescuentoMonto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDescuentoMonto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DescuentoMonto descuentomonto,List<DescuentoMonto> descuentomontos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DescuentoMonto descuentomontoEncontrado=null;
			
			for(DescuentoMonto descuentomontoLocal:descuentomontos) {
				if(descuentomontoLocal.getId().equals(descuentomonto.getId())) {
					descuentomontoEncontrado=descuentomontoLocal;
					
					descuentomontoLocal.setIsChanged(descuentomonto.getIsChanged());
					descuentomontoLocal.setIsNew(descuentomonto.getIsNew());
					descuentomontoLocal.setIsDeleted(descuentomonto.getIsDeleted());
					
					descuentomontoLocal.setGeneralEntityOriginal(descuentomonto.getGeneralEntityOriginal());
					
					descuentomontoLocal.setId(descuentomonto.getId());	
					descuentomontoLocal.setVersionRow(descuentomonto.getVersionRow());	
					descuentomontoLocal.setid_empresa(descuentomonto.getid_empresa());	
					descuentomontoLocal.setid_sucursal(descuentomonto.getid_sucursal());	
					descuentomontoLocal.setid_usuario(descuentomonto.getid_usuario());	
					descuentomontoLocal.setid_bodega(descuentomonto.getid_bodega());	
					descuentomontoLocal.setdescripcion(descuentomonto.getdescripcion());	
					descuentomontoLocal.setporcentaje(descuentomonto.getporcentaje());	
					descuentomontoLocal.setvalor_inicio(descuentomonto.getvalor_inicio());	
					descuentomontoLocal.setvalor_fin(descuentomonto.getvalor_fin());	
					descuentomontoLocal.setesta_activo(descuentomonto.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!descuentomonto.getIsDeleted()) {
				if(!existe) {
					descuentomontos.add(descuentomonto);
				}
			} else {
				if(descuentomontoEncontrado!=null && permiteQuitar)  {
					descuentomontos.remove(descuentomontoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DescuentoMonto descuentomonto,List<DescuentoMonto> descuentomontos) throws Exception {
		try	{			
			for(DescuentoMonto descuentomontoLocal:descuentomontos) {
				if(descuentomontoLocal.getId().equals(descuentomonto.getId())) {
					descuentomontoLocal.setIsSelected(descuentomonto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDescuentoMonto(List<DescuentoMonto> descuentomontosAux) throws Exception {
		//this.descuentomontosAux=descuentomontosAux;
		
		for(DescuentoMonto descuentomontoAux:descuentomontosAux) {
			if(descuentomontoAux.getIsChanged()) {
				descuentomontoAux.setIsChanged(false);
			}		
			
			if(descuentomontoAux.getIsNew()) {
				descuentomontoAux.setIsNew(false);
			}	
			
			if(descuentomontoAux.getIsDeleted()) {
				descuentomontoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDescuentoMonto(DescuentoMonto descuentomontoAux) throws Exception {
		//this.descuentomontoAux=descuentomontoAux;
		
			if(descuentomontoAux.getIsChanged()) {
				descuentomontoAux.setIsChanged(false);
			}		
			
			if(descuentomontoAux.getIsNew()) {
				descuentomontoAux.setIsNew(false);
			}	
			
			if(descuentomontoAux.getIsDeleted()) {
				descuentomontoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DescuentoMonto descuentomontoAsignar,DescuentoMonto descuentomonto) throws Exception {
		descuentomontoAsignar.setId(descuentomonto.getId());	
		descuentomontoAsignar.setVersionRow(descuentomonto.getVersionRow());	
		descuentomontoAsignar.setid_empresa(descuentomonto.getid_empresa());
		descuentomontoAsignar.setempresa_descripcion(descuentomonto.getempresa_descripcion());	
		descuentomontoAsignar.setid_sucursal(descuentomonto.getid_sucursal());
		descuentomontoAsignar.setsucursal_descripcion(descuentomonto.getsucursal_descripcion());	
		descuentomontoAsignar.setid_usuario(descuentomonto.getid_usuario());
		descuentomontoAsignar.setusuario_descripcion(descuentomonto.getusuario_descripcion());	
		descuentomontoAsignar.setid_bodega(descuentomonto.getid_bodega());
		descuentomontoAsignar.setbodega_descripcion(descuentomonto.getbodega_descripcion());	
		descuentomontoAsignar.setdescripcion(descuentomonto.getdescripcion());	
		descuentomontoAsignar.setporcentaje(descuentomonto.getporcentaje());	
		descuentomontoAsignar.setvalor_inicio(descuentomonto.getvalor_inicio());	
		descuentomontoAsignar.setvalor_fin(descuentomonto.getvalor_fin());	
		descuentomontoAsignar.setesta_activo(descuentomonto.getesta_activo());	
	}
	
	public static void inicializarDescuentoMonto(DescuentoMonto descuentomonto) throws Exception {
		try {
				descuentomonto.setId(0L);	
					
				descuentomonto.setid_empresa(-1L);	
				descuentomonto.setid_sucursal(-1L);	
				descuentomonto.setid_usuario(-1L);	
				descuentomonto.setid_bodega(-1L);	
				descuentomonto.setdescripcion("");	
				descuentomonto.setporcentaje(0.0);	
				descuentomonto.setvalor_inicio(0.0);	
				descuentomonto.setvalor_fin(0.0);	
				descuentomonto.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDescuentoMonto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_VALORINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_VALORFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DescuentoMontoConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDescuentoMonto(String sTipo,Row row,Workbook workbook,DescuentoMonto descuentomonto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getvalor_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(descuentomonto.getvalor_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(descuentomonto.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDescuentoMonto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDescuentoMonto() {
		return this.sFinalQueryDescuentoMonto;
	}
	
	public void setsFinalQueryDescuentoMonto(String sFinalQueryDescuentoMonto) {
		this.sFinalQueryDescuentoMonto= sFinalQueryDescuentoMonto;
	}
	
	public Border resaltarSeleccionarDescuentoMonto=null;
	
	public Border setResaltarSeleccionarDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDescuentoMonto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDescuentoMonto() {
		return this.resaltarSeleccionarDescuentoMonto;
	}
	
	public void setResaltarSeleccionarDescuentoMonto(Border borderResaltarSeleccionarDescuentoMonto) {
		this.resaltarSeleccionarDescuentoMonto= borderResaltarSeleccionarDescuentoMonto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDescuentoMonto=null;
	public Boolean mostraridDescuentoMonto=true;
	public Boolean activaridDescuentoMonto=true;

	public Border resaltarid_empresaDescuentoMonto=null;
	public Boolean mostrarid_empresaDescuentoMonto=true;
	public Boolean activarid_empresaDescuentoMonto=true;
	public Boolean cargarid_empresaDescuentoMonto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDescuentoMonto=false;//ConEventDepend=true

	public Border resaltarid_sucursalDescuentoMonto=null;
	public Boolean mostrarid_sucursalDescuentoMonto=true;
	public Boolean activarid_sucursalDescuentoMonto=true;
	public Boolean cargarid_sucursalDescuentoMonto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDescuentoMonto=false;//ConEventDepend=true

	public Border resaltarid_usuarioDescuentoMonto=null;
	public Boolean mostrarid_usuarioDescuentoMonto=true;
	public Boolean activarid_usuarioDescuentoMonto=true;
	public Boolean cargarid_usuarioDescuentoMonto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioDescuentoMonto=false;//ConEventDepend=true

	public Border resaltarid_bodegaDescuentoMonto=null;
	public Boolean mostrarid_bodegaDescuentoMonto=true;
	public Boolean activarid_bodegaDescuentoMonto=true;
	public Boolean cargarid_bodegaDescuentoMonto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDescuentoMonto=false;//ConEventDepend=true

	public Border resaltardescripcionDescuentoMonto=null;
	public Boolean mostrardescripcionDescuentoMonto=true;
	public Boolean activardescripcionDescuentoMonto=true;

	public Border resaltarporcentajeDescuentoMonto=null;
	public Boolean mostrarporcentajeDescuentoMonto=true;
	public Boolean activarporcentajeDescuentoMonto=true;

	public Border resaltarvalor_inicioDescuentoMonto=null;
	public Boolean mostrarvalor_inicioDescuentoMonto=true;
	public Boolean activarvalor_inicioDescuentoMonto=true;

	public Border resaltarvalor_finDescuentoMonto=null;
	public Boolean mostrarvalor_finDescuentoMonto=true;
	public Boolean activarvalor_finDescuentoMonto=true;

	public Border resaltaresta_activoDescuentoMonto=null;
	public Boolean mostraresta_activoDescuentoMonto=true;
	public Boolean activaresta_activoDescuentoMonto=true;

	
	

	public Border setResaltaridDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltaridDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDescuentoMonto() {
		return this.resaltaridDescuentoMonto;
	}

	public void setResaltaridDescuentoMonto(Border borderResaltar) {
		this.resaltaridDescuentoMonto= borderResaltar;
	}

	public Boolean getMostraridDescuentoMonto() {
		return this.mostraridDescuentoMonto;
	}

	public void setMostraridDescuentoMonto(Boolean mostraridDescuentoMonto) {
		this.mostraridDescuentoMonto= mostraridDescuentoMonto;
	}

	public Boolean getActivaridDescuentoMonto() {
		return this.activaridDescuentoMonto;
	}

	public void setActivaridDescuentoMonto(Boolean activaridDescuentoMonto) {
		this.activaridDescuentoMonto= activaridDescuentoMonto;
	}

	public Border setResaltarid_empresaDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarid_empresaDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDescuentoMonto() {
		return this.resaltarid_empresaDescuentoMonto;
	}

	public void setResaltarid_empresaDescuentoMonto(Border borderResaltar) {
		this.resaltarid_empresaDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarid_empresaDescuentoMonto() {
		return this.mostrarid_empresaDescuentoMonto;
	}

	public void setMostrarid_empresaDescuentoMonto(Boolean mostrarid_empresaDescuentoMonto) {
		this.mostrarid_empresaDescuentoMonto= mostrarid_empresaDescuentoMonto;
	}

	public Boolean getActivarid_empresaDescuentoMonto() {
		return this.activarid_empresaDescuentoMonto;
	}

	public void setActivarid_empresaDescuentoMonto(Boolean activarid_empresaDescuentoMonto) {
		this.activarid_empresaDescuentoMonto= activarid_empresaDescuentoMonto;
	}

	public Boolean getCargarid_empresaDescuentoMonto() {
		return this.cargarid_empresaDescuentoMonto;
	}

	public void setCargarid_empresaDescuentoMonto(Boolean cargarid_empresaDescuentoMonto) {
		this.cargarid_empresaDescuentoMonto= cargarid_empresaDescuentoMonto;
	}

	public Border setResaltarid_sucursalDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDescuentoMonto() {
		return this.resaltarid_sucursalDescuentoMonto;
	}

	public void setResaltarid_sucursalDescuentoMonto(Border borderResaltar) {
		this.resaltarid_sucursalDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDescuentoMonto() {
		return this.mostrarid_sucursalDescuentoMonto;
	}

	public void setMostrarid_sucursalDescuentoMonto(Boolean mostrarid_sucursalDescuentoMonto) {
		this.mostrarid_sucursalDescuentoMonto= mostrarid_sucursalDescuentoMonto;
	}

	public Boolean getActivarid_sucursalDescuentoMonto() {
		return this.activarid_sucursalDescuentoMonto;
	}

	public void setActivarid_sucursalDescuentoMonto(Boolean activarid_sucursalDescuentoMonto) {
		this.activarid_sucursalDescuentoMonto= activarid_sucursalDescuentoMonto;
	}

	public Boolean getCargarid_sucursalDescuentoMonto() {
		return this.cargarid_sucursalDescuentoMonto;
	}

	public void setCargarid_sucursalDescuentoMonto(Boolean cargarid_sucursalDescuentoMonto) {
		this.cargarid_sucursalDescuentoMonto= cargarid_sucursalDescuentoMonto;
	}

	public Border setResaltarid_usuarioDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarid_usuarioDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioDescuentoMonto() {
		return this.resaltarid_usuarioDescuentoMonto;
	}

	public void setResaltarid_usuarioDescuentoMonto(Border borderResaltar) {
		this.resaltarid_usuarioDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarid_usuarioDescuentoMonto() {
		return this.mostrarid_usuarioDescuentoMonto;
	}

	public void setMostrarid_usuarioDescuentoMonto(Boolean mostrarid_usuarioDescuentoMonto) {
		this.mostrarid_usuarioDescuentoMonto= mostrarid_usuarioDescuentoMonto;
	}

	public Boolean getActivarid_usuarioDescuentoMonto() {
		return this.activarid_usuarioDescuentoMonto;
	}

	public void setActivarid_usuarioDescuentoMonto(Boolean activarid_usuarioDescuentoMonto) {
		this.activarid_usuarioDescuentoMonto= activarid_usuarioDescuentoMonto;
	}

	public Boolean getCargarid_usuarioDescuentoMonto() {
		return this.cargarid_usuarioDescuentoMonto;
	}

	public void setCargarid_usuarioDescuentoMonto(Boolean cargarid_usuarioDescuentoMonto) {
		this.cargarid_usuarioDescuentoMonto= cargarid_usuarioDescuentoMonto;
	}

	public Border setResaltarid_bodegaDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDescuentoMonto() {
		return this.resaltarid_bodegaDescuentoMonto;
	}

	public void setResaltarid_bodegaDescuentoMonto(Border borderResaltar) {
		this.resaltarid_bodegaDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDescuentoMonto() {
		return this.mostrarid_bodegaDescuentoMonto;
	}

	public void setMostrarid_bodegaDescuentoMonto(Boolean mostrarid_bodegaDescuentoMonto) {
		this.mostrarid_bodegaDescuentoMonto= mostrarid_bodegaDescuentoMonto;
	}

	public Boolean getActivarid_bodegaDescuentoMonto() {
		return this.activarid_bodegaDescuentoMonto;
	}

	public void setActivarid_bodegaDescuentoMonto(Boolean activarid_bodegaDescuentoMonto) {
		this.activarid_bodegaDescuentoMonto= activarid_bodegaDescuentoMonto;
	}

	public Boolean getCargarid_bodegaDescuentoMonto() {
		return this.cargarid_bodegaDescuentoMonto;
	}

	public void setCargarid_bodegaDescuentoMonto(Boolean cargarid_bodegaDescuentoMonto) {
		this.cargarid_bodegaDescuentoMonto= cargarid_bodegaDescuentoMonto;
	}

	public Border setResaltardescripcionDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltardescripcionDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDescuentoMonto() {
		return this.resaltardescripcionDescuentoMonto;
	}

	public void setResaltardescripcionDescuentoMonto(Border borderResaltar) {
		this.resaltardescripcionDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrardescripcionDescuentoMonto() {
		return this.mostrardescripcionDescuentoMonto;
	}

	public void setMostrardescripcionDescuentoMonto(Boolean mostrardescripcionDescuentoMonto) {
		this.mostrardescripcionDescuentoMonto= mostrardescripcionDescuentoMonto;
	}

	public Boolean getActivardescripcionDescuentoMonto() {
		return this.activardescripcionDescuentoMonto;
	}

	public void setActivardescripcionDescuentoMonto(Boolean activardescripcionDescuentoMonto) {
		this.activardescripcionDescuentoMonto= activardescripcionDescuentoMonto;
	}

	public Border setResaltarporcentajeDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarporcentajeDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDescuentoMonto() {
		return this.resaltarporcentajeDescuentoMonto;
	}

	public void setResaltarporcentajeDescuentoMonto(Border borderResaltar) {
		this.resaltarporcentajeDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarporcentajeDescuentoMonto() {
		return this.mostrarporcentajeDescuentoMonto;
	}

	public void setMostrarporcentajeDescuentoMonto(Boolean mostrarporcentajeDescuentoMonto) {
		this.mostrarporcentajeDescuentoMonto= mostrarporcentajeDescuentoMonto;
	}

	public Boolean getActivarporcentajeDescuentoMonto() {
		return this.activarporcentajeDescuentoMonto;
	}

	public void setActivarporcentajeDescuentoMonto(Boolean activarporcentajeDescuentoMonto) {
		this.activarporcentajeDescuentoMonto= activarporcentajeDescuentoMonto;
	}

	public Border setResaltarvalor_inicioDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarvalor_inicioDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_inicioDescuentoMonto() {
		return this.resaltarvalor_inicioDescuentoMonto;
	}

	public void setResaltarvalor_inicioDescuentoMonto(Border borderResaltar) {
		this.resaltarvalor_inicioDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarvalor_inicioDescuentoMonto() {
		return this.mostrarvalor_inicioDescuentoMonto;
	}

	public void setMostrarvalor_inicioDescuentoMonto(Boolean mostrarvalor_inicioDescuentoMonto) {
		this.mostrarvalor_inicioDescuentoMonto= mostrarvalor_inicioDescuentoMonto;
	}

	public Boolean getActivarvalor_inicioDescuentoMonto() {
		return this.activarvalor_inicioDescuentoMonto;
	}

	public void setActivarvalor_inicioDescuentoMonto(Boolean activarvalor_inicioDescuentoMonto) {
		this.activarvalor_inicioDescuentoMonto= activarvalor_inicioDescuentoMonto;
	}

	public Border setResaltarvalor_finDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltarvalor_finDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_finDescuentoMonto() {
		return this.resaltarvalor_finDescuentoMonto;
	}

	public void setResaltarvalor_finDescuentoMonto(Border borderResaltar) {
		this.resaltarvalor_finDescuentoMonto= borderResaltar;
	}

	public Boolean getMostrarvalor_finDescuentoMonto() {
		return this.mostrarvalor_finDescuentoMonto;
	}

	public void setMostrarvalor_finDescuentoMonto(Boolean mostrarvalor_finDescuentoMonto) {
		this.mostrarvalor_finDescuentoMonto= mostrarvalor_finDescuentoMonto;
	}

	public Boolean getActivarvalor_finDescuentoMonto() {
		return this.activarvalor_finDescuentoMonto;
	}

	public void setActivarvalor_finDescuentoMonto(Boolean activarvalor_finDescuentoMonto) {
		this.activarvalor_finDescuentoMonto= activarvalor_finDescuentoMonto;
	}

	public Border setResaltaresta_activoDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//descuentomontoBeanSwingJInternalFrame.jTtoolBarDescuentoMonto.setBorder(borderResaltar);
		
		this.resaltaresta_activoDescuentoMonto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoDescuentoMonto() {
		return this.resaltaresta_activoDescuentoMonto;
	}

	public void setResaltaresta_activoDescuentoMonto(Border borderResaltar) {
		this.resaltaresta_activoDescuentoMonto= borderResaltar;
	}

	public Boolean getMostraresta_activoDescuentoMonto() {
		return this.mostraresta_activoDescuentoMonto;
	}

	public void setMostraresta_activoDescuentoMonto(Boolean mostraresta_activoDescuentoMonto) {
		this.mostraresta_activoDescuentoMonto= mostraresta_activoDescuentoMonto;
	}

	public Boolean getActivaresta_activoDescuentoMonto() {
		return this.activaresta_activoDescuentoMonto;
	}

	public void setActivaresta_activoDescuentoMonto(Boolean activaresta_activoDescuentoMonto) {
		this.activaresta_activoDescuentoMonto= activaresta_activoDescuentoMonto;
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
		
		
		this.setMostraridDescuentoMonto(esInicial);
		this.setMostrarid_empresaDescuentoMonto(esInicial);
		this.setMostrarid_sucursalDescuentoMonto(esInicial);
		this.setMostrarid_usuarioDescuentoMonto(esInicial);
		this.setMostrarid_bodegaDescuentoMonto(esInicial);
		this.setMostrardescripcionDescuentoMonto(esInicial);
		this.setMostrarporcentajeDescuentoMonto(esInicial);
		this.setMostrarvalor_inicioDescuentoMonto(esInicial);
		this.setMostrarvalor_finDescuentoMonto(esInicial);
		this.setMostraresta_activoDescuentoMonto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.ID)) {
				this.setMostraridDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.VALORINICIO)) {
				this.setMostrarvalor_inicioDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.VALORFIN)) {
				this.setMostrarvalor_finDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoDescuentoMonto(esAsigna);
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
		
		
		this.setActivaridDescuentoMonto(esInicial);
		this.setActivarid_empresaDescuentoMonto(esInicial);
		this.setActivarid_sucursalDescuentoMonto(esInicial);
		this.setActivarid_usuarioDescuentoMonto(esInicial);
		this.setActivarid_bodegaDescuentoMonto(esInicial);
		this.setActivardescripcionDescuentoMonto(esInicial);
		this.setActivarporcentajeDescuentoMonto(esInicial);
		this.setActivarvalor_inicioDescuentoMonto(esInicial);
		this.setActivarvalor_finDescuentoMonto(esInicial);
		this.setActivaresta_activoDescuentoMonto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.ID)) {
				this.setActivaridDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.VALORINICIO)) {
				this.setActivarvalor_inicioDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.VALORFIN)) {
				this.setActivarvalor_finDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoDescuentoMonto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDescuentoMonto(esInicial);
		this.setResaltarid_empresaDescuentoMonto(esInicial);
		this.setResaltarid_sucursalDescuentoMonto(esInicial);
		this.setResaltarid_usuarioDescuentoMonto(esInicial);
		this.setResaltarid_bodegaDescuentoMonto(esInicial);
		this.setResaltardescripcionDescuentoMonto(esInicial);
		this.setResaltarporcentajeDescuentoMonto(esInicial);
		this.setResaltarvalor_inicioDescuentoMonto(esInicial);
		this.setResaltarvalor_finDescuentoMonto(esInicial);
		this.setResaltaresta_activoDescuentoMonto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.ID)) {
				this.setResaltaridDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.VALORINICIO)) {
				this.setResaltarvalor_inicioDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.VALORFIN)) {
				this.setResaltarvalor_finDescuentoMonto(esAsigna);
				continue;
			}

			if(campo.clase.equals(DescuentoMontoConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoDescuentoMonto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDescuentoMonto=true;

	public Boolean getMostrarFK_IdBodegaDescuentoMonto() {
		return this.mostrarFK_IdBodegaDescuentoMonto;
	}

	public void setMostrarFK_IdBodegaDescuentoMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDescuentoMonto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDescuentoMonto=true;

	public Boolean getMostrarFK_IdEmpresaDescuentoMonto() {
		return this.mostrarFK_IdEmpresaDescuentoMonto;
	}

	public void setMostrarFK_IdEmpresaDescuentoMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDescuentoMonto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDescuentoMonto=true;

	public Boolean getMostrarFK_IdSucursalDescuentoMonto() {
		return this.mostrarFK_IdSucursalDescuentoMonto;
	}

	public void setMostrarFK_IdSucursalDescuentoMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDescuentoMonto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioDescuentoMonto=true;

	public Boolean getMostrarFK_IdUsuarioDescuentoMonto() {
		return this.mostrarFK_IdUsuarioDescuentoMonto;
	}

	public void setMostrarFK_IdUsuarioDescuentoMonto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioDescuentoMonto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDescuentoMonto=true;

	public Boolean getActivarFK_IdBodegaDescuentoMonto() {
		return this.activarFK_IdBodegaDescuentoMonto;
	}

	public void setActivarFK_IdBodegaDescuentoMonto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDescuentoMonto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDescuentoMonto=true;

	public Boolean getActivarFK_IdEmpresaDescuentoMonto() {
		return this.activarFK_IdEmpresaDescuentoMonto;
	}

	public void setActivarFK_IdEmpresaDescuentoMonto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDescuentoMonto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDescuentoMonto=true;

	public Boolean getActivarFK_IdSucursalDescuentoMonto() {
		return this.activarFK_IdSucursalDescuentoMonto;
	}

	public void setActivarFK_IdSucursalDescuentoMonto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDescuentoMonto= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioDescuentoMonto=true;

	public Boolean getActivarFK_IdUsuarioDescuentoMonto() {
		return this.activarFK_IdUsuarioDescuentoMonto;
	}

	public void setActivarFK_IdUsuarioDescuentoMonto(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioDescuentoMonto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDescuentoMonto=null;

	public Border getResaltarFK_IdBodegaDescuentoMonto() {
		return this.resaltarFK_IdBodegaDescuentoMonto;
	}

	public void setResaltarFK_IdBodegaDescuentoMonto(Border borderResaltar) {
		this.resaltarFK_IdBodegaDescuentoMonto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDescuentoMonto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDescuentoMonto=null;

	public Border getResaltarFK_IdEmpresaDescuentoMonto() {
		return this.resaltarFK_IdEmpresaDescuentoMonto;
	}

	public void setResaltarFK_IdEmpresaDescuentoMonto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDescuentoMonto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDescuentoMonto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDescuentoMonto=null;

	public Border getResaltarFK_IdSucursalDescuentoMonto() {
		return this.resaltarFK_IdSucursalDescuentoMonto;
	}

	public void setResaltarFK_IdSucursalDescuentoMonto(Border borderResaltar) {
		this.resaltarFK_IdSucursalDescuentoMonto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDescuentoMonto= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioDescuentoMonto=null;

	public Border getResaltarFK_IdUsuarioDescuentoMonto() {
		return this.resaltarFK_IdUsuarioDescuentoMonto;
	}

	public void setResaltarFK_IdUsuarioDescuentoMonto(Border borderResaltar) {
		this.resaltarFK_IdUsuarioDescuentoMonto= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioDescuentoMonto(ParametroGeneralUsuario parametroGeneralUsuario/*DescuentoMontoBeanSwingJInternalFrame descuentomontoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioDescuentoMonto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}