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


import com.bydan.erp.inventario.util.BodegaSucursalConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaSucursalParameterReturnGeneral;
//import com.bydan.erp.inventario.util.BodegaSucursalParameterGeneral;

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
final public class BodegaSucursalConstantesFunciones extends BodegaSucursalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="BodegaSucursal";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BodegaSucursal"+BodegaSucursalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BodegaSucursalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BodegaSucursalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BodegaSucursalConstantesFunciones.SCHEMA+"_"+BodegaSucursalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BodegaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BodegaSucursalConstantesFunciones.SCHEMA+"_"+BodegaSucursalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BodegaSucursalConstantesFunciones.SCHEMA+"_"+BodegaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BodegaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BodegaSucursalConstantesFunciones.SCHEMA+"_"+BodegaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BodegaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BodegaSucursalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BodegaSucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BodegaSucursalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BodegaSucursalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BodegaSucursalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BodegaSucursalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Bodega Sucursales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Bodega Sucursal";
	public static final String SCLASSWEBTITULO_LOWER="Bodega Sucursal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BodegaSucursal";
	public static final String OBJECTNAME="bodegasucursal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="bodega_sucursal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bodegasucursal from "+BodegaSucursalConstantesFunciones.SPERSISTENCENAME+" bodegasucursal";
	public static String QUERYSELECTNATIVE="select "+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".id,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".version_row,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".id_empresa,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".id_sucursal,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".id_bodega,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".secuencia,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".tamanio,"+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME+".descripcion from "+BodegaSucursalConstantesFunciones.SCHEMA+"."+BodegaSucursalConstantesFunciones.TABLENAME;//+" as "+BodegaSucursalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BodegaSucursalConstantesFuncionesAdditional bodegasucursalConstantesFuncionesAdditional=null;
	
	public BodegaSucursalConstantesFuncionesAdditional getBodegaSucursalConstantesFuncionesAdditional() {
		return this.bodegasucursalConstantesFuncionesAdditional;
	}
	
	public void setBodegaSucursalConstantesFuncionesAdditional(BodegaSucursalConstantesFuncionesAdditional bodegasucursalConstantesFuncionesAdditional) {
		try {
			this.bodegasucursalConstantesFuncionesAdditional=bodegasucursalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String SECUENCIA= "secuencia";
    public static final String TAMANIO= "tamanio";
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
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_SECUENCIA= "Secuencia";
		public static final String LABEL_SECUENCIA_LOWER= "Secuencia";
    	public static final String LABEL_TAMANIO= "Tamanio";
		public static final String LABEL_TAMANIO_LOWER= "Tamanio";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getBodegaSucursalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BodegaSucursalConstantesFunciones.IDEMPRESA)) {sLabelColumna=BodegaSucursalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BodegaSucursalConstantesFunciones.IDSUCURSAL)) {sLabelColumna=BodegaSucursalConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(BodegaSucursalConstantesFunciones.IDBODEGA)) {sLabelColumna=BodegaSucursalConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(BodegaSucursalConstantesFunciones.SECUENCIA)) {sLabelColumna=BodegaSucursalConstantesFunciones.LABEL_SECUENCIA;}
		if(sNombreColumna.equals(BodegaSucursalConstantesFunciones.TAMANIO)) {sLabelColumna=BodegaSucursalConstantesFunciones.LABEL_TAMANIO;}
		if(sNombreColumna.equals(BodegaSucursalConstantesFunciones.DESCRIPCION)) {sLabelColumna=BodegaSucursalConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getBodegaSucursalDescripcion(BodegaSucursal bodegasucursal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bodegasucursal !=null/* && bodegasucursal.getId()!=0*/) {
			if(bodegasucursal.getId()!=null) {
				sDescripcion=bodegasucursal.getId().toString();
			}//bodegasucursalbodegasucursal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBodegaSucursalDescripcionDetallado(BodegaSucursal bodegasucursal) {
		String sDescripcion="";
			
		sDescripcion+=BodegaSucursalConstantesFunciones.ID+"=";
		sDescripcion+=bodegasucursal.getId().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bodegasucursal.getVersionRow().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bodegasucursal.getid_empresa().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=bodegasucursal.getid_sucursal().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=bodegasucursal.getid_bodega().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.SECUENCIA+"=";
		sDescripcion+=bodegasucursal.getsecuencia().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.TAMANIO+"=";
		sDescripcion+=bodegasucursal.gettamanio().toString()+",";
		sDescripcion+=BodegaSucursalConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=bodegasucursal.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setBodegaSucursalDescripcion(BodegaSucursal bodegasucursal,String sValor) throws Exception {			
		if(bodegasucursal !=null) {
			//bodegasucursalbodegasucursal.getId().toString();
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
		} else if(sNombreIndice.equals("PorIdEmpresaPorIdSucursalPorIdBodega")) {
			sNombreIndice="Tipo=  Por Empresa Por Sucursal Por Bodega";
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

	public static String getDetalleIndicePorIdEmpresaPorIdSucursalPorIdBodega(Long id_empresa,Long id_sucursal,Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();}
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBodegaSucursal(BodegaSucursal bodegasucursal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bodegasucursal.setdescripcion(bodegasucursal.getdescripcion().trim());
	}
	
	public static void quitarEspaciosBodegaSucursals(List<BodegaSucursal> bodegasucursals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BodegaSucursal bodegasucursal: bodegasucursals) {
			bodegasucursal.setdescripcion(bodegasucursal.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBodegaSucursal(BodegaSucursal bodegasucursal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bodegasucursal.getConCambioAuxiliar()) {
			bodegasucursal.setIsDeleted(bodegasucursal.getIsDeletedAuxiliar());	
			bodegasucursal.setIsNew(bodegasucursal.getIsNewAuxiliar());	
			bodegasucursal.setIsChanged(bodegasucursal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bodegasucursal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bodegasucursal.setIsDeletedAuxiliar(false);	
			bodegasucursal.setIsNewAuxiliar(false);	
			bodegasucursal.setIsChangedAuxiliar(false);
			
			bodegasucursal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBodegaSucursals(List<BodegaSucursal> bodegasucursals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BodegaSucursal bodegasucursal : bodegasucursals) {
			if(conAsignarBase && bodegasucursal.getConCambioAuxiliar()) {
				bodegasucursal.setIsDeleted(bodegasucursal.getIsDeletedAuxiliar());	
				bodegasucursal.setIsNew(bodegasucursal.getIsNewAuxiliar());	
				bodegasucursal.setIsChanged(bodegasucursal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bodegasucursal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bodegasucursal.setIsDeletedAuxiliar(false);	
				bodegasucursal.setIsNewAuxiliar(false);	
				bodegasucursal.setIsChangedAuxiliar(false);
				
				bodegasucursal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBodegaSucursal(BodegaSucursal bodegasucursal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			bodegasucursal.setsecuencia(0);
			bodegasucursal.settamanio(0);
		}
	}		
	
	public static void InicializarValoresBodegaSucursals(List<BodegaSucursal> bodegasucursals,Boolean conEnteros) throws Exception  {
		
		for(BodegaSucursal bodegasucursal: bodegasucursals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				bodegasucursal.setsecuencia(0);
				bodegasucursal.settamanio(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaBodegaSucursal(List<BodegaSucursal> bodegasucursals,BodegaSucursal bodegasucursalAux) throws Exception  {
		BodegaSucursalConstantesFunciones.InicializarValoresBodegaSucursal(bodegasucursalAux,true);
		
		for(BodegaSucursal bodegasucursal: bodegasucursals) {
			if(bodegasucursal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bodegasucursalAux.setsecuencia(bodegasucursalAux.getsecuencia()+bodegasucursal.getsecuencia());			
			bodegasucursalAux.settamanio(bodegasucursalAux.gettamanio()+bodegasucursal.gettamanio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBodegaSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BodegaSucursalConstantesFunciones.getArrayColumnasGlobalesBodegaSucursal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBodegaSucursal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BodegaSucursalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BodegaSucursalConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BodegaSucursalConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BodegaSucursalConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBodegaSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(BodegaSucursalConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BodegaSucursal> bodegasucursals,BodegaSucursal bodegasucursal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BodegaSucursal bodegasucursalAux: bodegasucursals) {
			if(bodegasucursalAux!=null && bodegasucursal!=null) {
				if((bodegasucursalAux.getId()==null && bodegasucursal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bodegasucursalAux.getId()!=null && bodegasucursal.getId()!=null){
					if(bodegasucursalAux.getId().equals(bodegasucursal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBodegaSucursal(List<BodegaSucursal> bodegasucursals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(BodegaSucursal bodegasucursal: bodegasucursals) {			
			if(bodegasucursal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBodegaSucursal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_ID, BodegaSucursalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_VERSIONROW, BodegaSucursalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_IDEMPRESA, BodegaSucursalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_IDSUCURSAL, BodegaSucursalConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_IDBODEGA, BodegaSucursalConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_SECUENCIA, BodegaSucursalConstantesFunciones.SECUENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_TAMANIO, BodegaSucursalConstantesFunciones.TAMANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BodegaSucursalConstantesFunciones.LABEL_DESCRIPCION, BodegaSucursalConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBodegaSucursal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.SECUENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.TAMANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BodegaSucursalConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodegaSucursal() throws Exception  {
		return BodegaSucursalConstantesFunciones.getTiposSeleccionarBodegaSucursal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodegaSucursal(Boolean conFk) throws Exception  {
		return BodegaSucursalConstantesFunciones.getTiposSeleccionarBodegaSucursal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBodegaSucursal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaSucursalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BodegaSucursalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaSucursalConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(BodegaSucursalConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaSucursalConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(BodegaSucursalConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaSucursalConstantesFunciones.LABEL_SECUENCIA);
			reporte.setsDescripcion(BodegaSucursalConstantesFunciones.LABEL_SECUENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaSucursalConstantesFunciones.LABEL_TAMANIO);
			reporte.setsDescripcion(BodegaSucursalConstantesFunciones.LABEL_TAMANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BodegaSucursalConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(BodegaSucursalConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBodegaSucursal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBodegaSucursal(BodegaSucursal bodegasucursalAux) throws Exception {
		
			bodegasucursalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bodegasucursalAux.getEmpresa()));
			bodegasucursalAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bodegasucursalAux.getSucursal()));
			bodegasucursalAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(bodegasucursalAux.getBodega()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBodegaSucursal(List<BodegaSucursal> bodegasucursalsTemp) throws Exception {
		for(BodegaSucursal bodegasucursalAux:bodegasucursalsTemp) {
			
			bodegasucursalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bodegasucursalAux.getEmpresa()));
			bodegasucursalAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bodegasucursalAux.getSucursal()));
			bodegasucursalAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(bodegasucursalAux.getBodega()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBodegaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBodegaSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodegaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BodegaSucursalConstantesFunciones.getClassesRelationshipsOfBodegaSucursal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBodegaSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBodegaSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BodegaSucursalConstantesFunciones.getClassesRelationshipsFromStringsOfBodegaSucursal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBodegaSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BodegaSucursal bodegasucursal,List<BodegaSucursal> bodegasucursals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			BodegaSucursal bodegasucursalEncontrado=null;
			
			for(BodegaSucursal bodegasucursalLocal:bodegasucursals) {
				if(bodegasucursalLocal.getId().equals(bodegasucursal.getId())) {
					bodegasucursalEncontrado=bodegasucursalLocal;
					
					bodegasucursalLocal.setIsChanged(bodegasucursal.getIsChanged());
					bodegasucursalLocal.setIsNew(bodegasucursal.getIsNew());
					bodegasucursalLocal.setIsDeleted(bodegasucursal.getIsDeleted());
					
					bodegasucursalLocal.setGeneralEntityOriginal(bodegasucursal.getGeneralEntityOriginal());
					
					bodegasucursalLocal.setId(bodegasucursal.getId());	
					bodegasucursalLocal.setVersionRow(bodegasucursal.getVersionRow());	
					bodegasucursalLocal.setid_empresa(bodegasucursal.getid_empresa());	
					bodegasucursalLocal.setid_sucursal(bodegasucursal.getid_sucursal());	
					bodegasucursalLocal.setid_bodega(bodegasucursal.getid_bodega());	
					bodegasucursalLocal.setsecuencia(bodegasucursal.getsecuencia());	
					bodegasucursalLocal.settamanio(bodegasucursal.gettamanio());	
					bodegasucursalLocal.setdescripcion(bodegasucursal.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bodegasucursal.getIsDeleted()) {
				if(!existe) {
					bodegasucursals.add(bodegasucursal);
				}
			} else {
				if(bodegasucursalEncontrado!=null && permiteQuitar)  {
					bodegasucursals.remove(bodegasucursalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(BodegaSucursal bodegasucursal,List<BodegaSucursal> bodegasucursals) throws Exception {
		try	{			
			for(BodegaSucursal bodegasucursalLocal:bodegasucursals) {
				if(bodegasucursalLocal.getId().equals(bodegasucursal.getId())) {
					bodegasucursalLocal.setIsSelected(bodegasucursal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBodegaSucursal(List<BodegaSucursal> bodegasucursalsAux) throws Exception {
		//this.bodegasucursalsAux=bodegasucursalsAux;
		
		for(BodegaSucursal bodegasucursalAux:bodegasucursalsAux) {
			if(bodegasucursalAux.getIsChanged()) {
				bodegasucursalAux.setIsChanged(false);
			}		
			
			if(bodegasucursalAux.getIsNew()) {
				bodegasucursalAux.setIsNew(false);
			}	
			
			if(bodegasucursalAux.getIsDeleted()) {
				bodegasucursalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBodegaSucursal(BodegaSucursal bodegasucursalAux) throws Exception {
		//this.bodegasucursalAux=bodegasucursalAux;
		
			if(bodegasucursalAux.getIsChanged()) {
				bodegasucursalAux.setIsChanged(false);
			}		
			
			if(bodegasucursalAux.getIsNew()) {
				bodegasucursalAux.setIsNew(false);
			}	
			
			if(bodegasucursalAux.getIsDeleted()) {
				bodegasucursalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BodegaSucursal bodegasucursalAsignar,BodegaSucursal bodegasucursal) throws Exception {
		bodegasucursalAsignar.setId(bodegasucursal.getId());	
		bodegasucursalAsignar.setVersionRow(bodegasucursal.getVersionRow());	
		bodegasucursalAsignar.setid_empresa(bodegasucursal.getid_empresa());
		bodegasucursalAsignar.setempresa_descripcion(bodegasucursal.getempresa_descripcion());	
		bodegasucursalAsignar.setid_sucursal(bodegasucursal.getid_sucursal());
		bodegasucursalAsignar.setsucursal_descripcion(bodegasucursal.getsucursal_descripcion());	
		bodegasucursalAsignar.setid_bodega(bodegasucursal.getid_bodega());
		bodegasucursalAsignar.setbodega_descripcion(bodegasucursal.getbodega_descripcion());	
		bodegasucursalAsignar.setsecuencia(bodegasucursal.getsecuencia());	
		bodegasucursalAsignar.settamanio(bodegasucursal.gettamanio());	
		bodegasucursalAsignar.setdescripcion(bodegasucursal.getdescripcion());	
	}
	
	public static void inicializarBodegaSucursal(BodegaSucursal bodegasucursal) throws Exception {
		try {
				bodegasucursal.setId(0L);	
					
				bodegasucursal.setid_empresa(-1L);	
				bodegasucursal.setid_sucursal(-1L);	
				bodegasucursal.setid_bodega(-1L);	
				bodegasucursal.setsecuencia(0);	
				bodegasucursal.settamanio(0);	
				bodegasucursal.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBodegaSucursal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaSucursalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaSucursalConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaSucursalConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaSucursalConstantesFunciones.LABEL_SECUENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaSucursalConstantesFunciones.LABEL_TAMANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BodegaSucursalConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBodegaSucursal(String sTipo,Row row,Workbook workbook,BodegaSucursal bodegasucursal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegasucursal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegasucursal.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegasucursal.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegasucursal.getsecuencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegasucursal.gettamanio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bodegasucursal.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBodegaSucursal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBodegaSucursal() {
		return this.sFinalQueryBodegaSucursal;
	}
	
	public void setsFinalQueryBodegaSucursal(String sFinalQueryBodegaSucursal) {
		this.sFinalQueryBodegaSucursal= sFinalQueryBodegaSucursal;
	}
	
	public Border resaltarSeleccionarBodegaSucursal=null;
	
	public Border setResaltarSeleccionarBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBodegaSucursal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBodegaSucursal() {
		return this.resaltarSeleccionarBodegaSucursal;
	}
	
	public void setResaltarSeleccionarBodegaSucursal(Border borderResaltarSeleccionarBodegaSucursal) {
		this.resaltarSeleccionarBodegaSucursal= borderResaltarSeleccionarBodegaSucursal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBodegaSucursal=null;
	public Boolean mostraridBodegaSucursal=true;
	public Boolean activaridBodegaSucursal=true;

	public Border resaltarid_empresaBodegaSucursal=null;
	public Boolean mostrarid_empresaBodegaSucursal=true;
	public Boolean activarid_empresaBodegaSucursal=true;
	public Boolean cargarid_empresaBodegaSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBodegaSucursal=false;//ConEventDepend=true

	public Border resaltarid_sucursalBodegaSucursal=null;
	public Boolean mostrarid_sucursalBodegaSucursal=true;
	public Boolean activarid_sucursalBodegaSucursal=true;
	public Boolean cargarid_sucursalBodegaSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalBodegaSucursal=false;//ConEventDepend=true

	public Border resaltarid_bodegaBodegaSucursal=null;
	public Boolean mostrarid_bodegaBodegaSucursal=true;
	public Boolean activarid_bodegaBodegaSucursal=true;
	public Boolean cargarid_bodegaBodegaSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaBodegaSucursal=false;//ConEventDepend=true

	public Border resaltarsecuenciaBodegaSucursal=null;
	public Boolean mostrarsecuenciaBodegaSucursal=true;
	public Boolean activarsecuenciaBodegaSucursal=true;

	public Border resaltartamanioBodegaSucursal=null;
	public Boolean mostrartamanioBodegaSucursal=true;
	public Boolean activartamanioBodegaSucursal=true;

	public Border resaltardescripcionBodegaSucursal=null;
	public Boolean mostrardescripcionBodegaSucursal=true;
	public Boolean activardescripcionBodegaSucursal=true;

	
	

	public Border setResaltaridBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltaridBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBodegaSucursal() {
		return this.resaltaridBodegaSucursal;
	}

	public void setResaltaridBodegaSucursal(Border borderResaltar) {
		this.resaltaridBodegaSucursal= borderResaltar;
	}

	public Boolean getMostraridBodegaSucursal() {
		return this.mostraridBodegaSucursal;
	}

	public void setMostraridBodegaSucursal(Boolean mostraridBodegaSucursal) {
		this.mostraridBodegaSucursal= mostraridBodegaSucursal;
	}

	public Boolean getActivaridBodegaSucursal() {
		return this.activaridBodegaSucursal;
	}

	public void setActivaridBodegaSucursal(Boolean activaridBodegaSucursal) {
		this.activaridBodegaSucursal= activaridBodegaSucursal;
	}

	public Border setResaltarid_empresaBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltarid_empresaBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBodegaSucursal() {
		return this.resaltarid_empresaBodegaSucursal;
	}

	public void setResaltarid_empresaBodegaSucursal(Border borderResaltar) {
		this.resaltarid_empresaBodegaSucursal= borderResaltar;
	}

	public Boolean getMostrarid_empresaBodegaSucursal() {
		return this.mostrarid_empresaBodegaSucursal;
	}

	public void setMostrarid_empresaBodegaSucursal(Boolean mostrarid_empresaBodegaSucursal) {
		this.mostrarid_empresaBodegaSucursal= mostrarid_empresaBodegaSucursal;
	}

	public Boolean getActivarid_empresaBodegaSucursal() {
		return this.activarid_empresaBodegaSucursal;
	}

	public void setActivarid_empresaBodegaSucursal(Boolean activarid_empresaBodegaSucursal) {
		this.activarid_empresaBodegaSucursal= activarid_empresaBodegaSucursal;
	}

	public Boolean getCargarid_empresaBodegaSucursal() {
		return this.cargarid_empresaBodegaSucursal;
	}

	public void setCargarid_empresaBodegaSucursal(Boolean cargarid_empresaBodegaSucursal) {
		this.cargarid_empresaBodegaSucursal= cargarid_empresaBodegaSucursal;
	}

	public Border setResaltarid_sucursalBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltarid_sucursalBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalBodegaSucursal() {
		return this.resaltarid_sucursalBodegaSucursal;
	}

	public void setResaltarid_sucursalBodegaSucursal(Border borderResaltar) {
		this.resaltarid_sucursalBodegaSucursal= borderResaltar;
	}

	public Boolean getMostrarid_sucursalBodegaSucursal() {
		return this.mostrarid_sucursalBodegaSucursal;
	}

	public void setMostrarid_sucursalBodegaSucursal(Boolean mostrarid_sucursalBodegaSucursal) {
		this.mostrarid_sucursalBodegaSucursal= mostrarid_sucursalBodegaSucursal;
	}

	public Boolean getActivarid_sucursalBodegaSucursal() {
		return this.activarid_sucursalBodegaSucursal;
	}

	public void setActivarid_sucursalBodegaSucursal(Boolean activarid_sucursalBodegaSucursal) {
		this.activarid_sucursalBodegaSucursal= activarid_sucursalBodegaSucursal;
	}

	public Boolean getCargarid_sucursalBodegaSucursal() {
		return this.cargarid_sucursalBodegaSucursal;
	}

	public void setCargarid_sucursalBodegaSucursal(Boolean cargarid_sucursalBodegaSucursal) {
		this.cargarid_sucursalBodegaSucursal= cargarid_sucursalBodegaSucursal;
	}

	public Border setResaltarid_bodegaBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltarid_bodegaBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaBodegaSucursal() {
		return this.resaltarid_bodegaBodegaSucursal;
	}

	public void setResaltarid_bodegaBodegaSucursal(Border borderResaltar) {
		this.resaltarid_bodegaBodegaSucursal= borderResaltar;
	}

	public Boolean getMostrarid_bodegaBodegaSucursal() {
		return this.mostrarid_bodegaBodegaSucursal;
	}

	public void setMostrarid_bodegaBodegaSucursal(Boolean mostrarid_bodegaBodegaSucursal) {
		this.mostrarid_bodegaBodegaSucursal= mostrarid_bodegaBodegaSucursal;
	}

	public Boolean getActivarid_bodegaBodegaSucursal() {
		return this.activarid_bodegaBodegaSucursal;
	}

	public void setActivarid_bodegaBodegaSucursal(Boolean activarid_bodegaBodegaSucursal) {
		this.activarid_bodegaBodegaSucursal= activarid_bodegaBodegaSucursal;
	}

	public Boolean getCargarid_bodegaBodegaSucursal() {
		return this.cargarid_bodegaBodegaSucursal;
	}

	public void setCargarid_bodegaBodegaSucursal(Boolean cargarid_bodegaBodegaSucursal) {
		this.cargarid_bodegaBodegaSucursal= cargarid_bodegaBodegaSucursal;
	}

	public Border setResaltarsecuenciaBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltarsecuenciaBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuenciaBodegaSucursal() {
		return this.resaltarsecuenciaBodegaSucursal;
	}

	public void setResaltarsecuenciaBodegaSucursal(Border borderResaltar) {
		this.resaltarsecuenciaBodegaSucursal= borderResaltar;
	}

	public Boolean getMostrarsecuenciaBodegaSucursal() {
		return this.mostrarsecuenciaBodegaSucursal;
	}

	public void setMostrarsecuenciaBodegaSucursal(Boolean mostrarsecuenciaBodegaSucursal) {
		this.mostrarsecuenciaBodegaSucursal= mostrarsecuenciaBodegaSucursal;
	}

	public Boolean getActivarsecuenciaBodegaSucursal() {
		return this.activarsecuenciaBodegaSucursal;
	}

	public void setActivarsecuenciaBodegaSucursal(Boolean activarsecuenciaBodegaSucursal) {
		this.activarsecuenciaBodegaSucursal= activarsecuenciaBodegaSucursal;
	}

	public Border setResaltartamanioBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltartamanioBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartamanioBodegaSucursal() {
		return this.resaltartamanioBodegaSucursal;
	}

	public void setResaltartamanioBodegaSucursal(Border borderResaltar) {
		this.resaltartamanioBodegaSucursal= borderResaltar;
	}

	public Boolean getMostrartamanioBodegaSucursal() {
		return this.mostrartamanioBodegaSucursal;
	}

	public void setMostrartamanioBodegaSucursal(Boolean mostrartamanioBodegaSucursal) {
		this.mostrartamanioBodegaSucursal= mostrartamanioBodegaSucursal;
	}

	public Boolean getActivartamanioBodegaSucursal() {
		return this.activartamanioBodegaSucursal;
	}

	public void setActivartamanioBodegaSucursal(Boolean activartamanioBodegaSucursal) {
		this.activartamanioBodegaSucursal= activartamanioBodegaSucursal;
	}

	public Border setResaltardescripcionBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bodegasucursalBeanSwingJInternalFrame.jTtoolBarBodegaSucursal.setBorder(borderResaltar);
		
		this.resaltardescripcionBodegaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionBodegaSucursal() {
		return this.resaltardescripcionBodegaSucursal;
	}

	public void setResaltardescripcionBodegaSucursal(Border borderResaltar) {
		this.resaltardescripcionBodegaSucursal= borderResaltar;
	}

	public Boolean getMostrardescripcionBodegaSucursal() {
		return this.mostrardescripcionBodegaSucursal;
	}

	public void setMostrardescripcionBodegaSucursal(Boolean mostrardescripcionBodegaSucursal) {
		this.mostrardescripcionBodegaSucursal= mostrardescripcionBodegaSucursal;
	}

	public Boolean getActivardescripcionBodegaSucursal() {
		return this.activardescripcionBodegaSucursal;
	}

	public void setActivardescripcionBodegaSucursal(Boolean activardescripcionBodegaSucursal) {
		this.activardescripcionBodegaSucursal= activardescripcionBodegaSucursal;
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
		
		
		this.setMostraridBodegaSucursal(esInicial);
		this.setMostrarid_empresaBodegaSucursal(esInicial);
		this.setMostrarid_sucursalBodegaSucursal(esInicial);
		this.setMostrarid_bodegaBodegaSucursal(esInicial);
		this.setMostrarsecuenciaBodegaSucursal(esInicial);
		this.setMostrartamanioBodegaSucursal(esInicial);
		this.setMostrardescripcionBodegaSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.ID)) {
				this.setMostraridBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.SECUENCIA)) {
				this.setMostrarsecuenciaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.TAMANIO)) {
				this.setMostrartamanioBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionBodegaSucursal(esAsigna);
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
		
		
		this.setActivaridBodegaSucursal(esInicial);
		this.setActivarid_empresaBodegaSucursal(esInicial);
		this.setActivarid_sucursalBodegaSucursal(esInicial);
		this.setActivarid_bodegaBodegaSucursal(esInicial);
		this.setActivarsecuenciaBodegaSucursal(esInicial);
		this.setActivartamanioBodegaSucursal(esInicial);
		this.setActivardescripcionBodegaSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.ID)) {
				this.setActivaridBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.SECUENCIA)) {
				this.setActivarsecuenciaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.TAMANIO)) {
				this.setActivartamanioBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionBodegaSucursal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBodegaSucursal(esInicial);
		this.setResaltarid_empresaBodegaSucursal(esInicial);
		this.setResaltarid_sucursalBodegaSucursal(esInicial);
		this.setResaltarid_bodegaBodegaSucursal(esInicial);
		this.setResaltarsecuenciaBodegaSucursal(esInicial);
		this.setResaltartamanioBodegaSucursal(esInicial);
		this.setResaltardescripcionBodegaSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.ID)) {
				this.setResaltaridBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.SECUENCIA)) {
				this.setResaltarsecuenciaBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.TAMANIO)) {
				this.setResaltartamanioBodegaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(BodegaSucursalConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionBodegaSucursal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaBodegaSucursal=true;

	public Boolean getMostrarFK_IdBodegaBodegaSucursal() {
		return this.mostrarFK_IdBodegaBodegaSucursal;
	}

	public void setMostrarFK_IdBodegaBodegaSucursal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaBodegaSucursal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBodegaSucursal=true;

	public Boolean getMostrarFK_IdEmpresaBodegaSucursal() {
		return this.mostrarFK_IdEmpresaBodegaSucursal;
	}

	public void setMostrarFK_IdEmpresaBodegaSucursal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBodegaSucursal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalBodegaSucursal=true;

	public Boolean getMostrarFK_IdSucursalBodegaSucursal() {
		return this.mostrarFK_IdSucursalBodegaSucursal;
	}

	public void setMostrarFK_IdSucursalBodegaSucursal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalBodegaSucursal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaBodegaSucursal=true;

	public Boolean getActivarFK_IdBodegaBodegaSucursal() {
		return this.activarFK_IdBodegaBodegaSucursal;
	}

	public void setActivarFK_IdBodegaBodegaSucursal(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaBodegaSucursal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBodegaSucursal=true;

	public Boolean getActivarFK_IdEmpresaBodegaSucursal() {
		return this.activarFK_IdEmpresaBodegaSucursal;
	}

	public void setActivarFK_IdEmpresaBodegaSucursal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBodegaSucursal= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalBodegaSucursal=true;

	public Boolean getActivarFK_IdSucursalBodegaSucursal() {
		return this.activarFK_IdSucursalBodegaSucursal;
	}

	public void setActivarFK_IdSucursalBodegaSucursal(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalBodegaSucursal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaBodegaSucursal=null;

	public Border getResaltarFK_IdBodegaBodegaSucursal() {
		return this.resaltarFK_IdBodegaBodegaSucursal;
	}

	public void setResaltarFK_IdBodegaBodegaSucursal(Border borderResaltar) {
		this.resaltarFK_IdBodegaBodegaSucursal= borderResaltar;
	}

	public void setResaltarFK_IdBodegaBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaBodegaSucursal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBodegaSucursal=null;

	public Border getResaltarFK_IdEmpresaBodegaSucursal() {
		return this.resaltarFK_IdEmpresaBodegaSucursal;
	}

	public void setResaltarFK_IdEmpresaBodegaSucursal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBodegaSucursal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBodegaSucursal= borderResaltar;
	}

	public Border resaltarFK_IdSucursalBodegaSucursal=null;

	public Border getResaltarFK_IdSucursalBodegaSucursal() {
		return this.resaltarFK_IdSucursalBodegaSucursal;
	}

	public void setResaltarFK_IdSucursalBodegaSucursal(Border borderResaltar) {
		this.resaltarFK_IdSucursalBodegaSucursal= borderResaltar;
	}

	public void setResaltarFK_IdSucursalBodegaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*BodegaSucursalBeanSwingJInternalFrame bodegasucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalBodegaSucursal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}