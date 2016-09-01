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


import com.bydan.erp.inventario.util.UbicacionBodeConstantesFunciones;
import com.bydan.erp.inventario.util.UbicacionBodeParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UbicacionBodeParameterGeneral;

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
final public class UbicacionBodeConstantesFunciones extends UbicacionBodeConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UbicacionBode";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UbicacionBode"+UbicacionBodeConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UbicacionBodeHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UbicacionBodeHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UbicacionBodeConstantesFunciones.SCHEMA+"_"+UbicacionBodeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UbicacionBodeHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UbicacionBodeConstantesFunciones.SCHEMA+"_"+UbicacionBodeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UbicacionBodeConstantesFunciones.SCHEMA+"_"+UbicacionBodeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UbicacionBodeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UbicacionBodeConstantesFunciones.SCHEMA+"_"+UbicacionBodeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionBodeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UbicacionBodeHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionBodeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionBodeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UbicacionBodeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UbicacionBodeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UbicacionBodeConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UbicacionBodeConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UbicacionBodeConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UbicacionBodeConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ubicacion Bodes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Ubicacion Bode";
	public static final String SCLASSWEBTITULO_LOWER="Ubicacion Bode";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UbicacionBode";
	public static final String OBJECTNAME="ubicacionbode";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="ubicacion_bode";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ubicacionbode from "+UbicacionBodeConstantesFunciones.SPERSISTENCENAME+" ubicacionbode";
	public static String QUERYSELECTNATIVE="select "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".version_row,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_empresa,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_sucursal,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_bodega,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".id_ubicacion_bode,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".nombre,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".nivel,"+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME+".orden from "+UbicacionBodeConstantesFunciones.SCHEMA+"."+UbicacionBodeConstantesFunciones.TABLENAME;//+" as "+UbicacionBodeConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UbicacionBodeConstantesFuncionesAdditional ubicacionbodeConstantesFuncionesAdditional=null;
	
	public UbicacionBodeConstantesFuncionesAdditional getUbicacionBodeConstantesFuncionesAdditional() {
		return this.ubicacionbodeConstantesFuncionesAdditional;
	}
	
	public void setUbicacionBodeConstantesFuncionesAdditional(UbicacionBodeConstantesFuncionesAdditional ubicacionbodeConstantesFuncionesAdditional) {
		try {
			this.ubicacionbodeConstantesFuncionesAdditional=ubicacionbodeConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDUBICACIONBODE= "id_ubicacion_bode";
    public static final String NOMBRE= "nombre";
    public static final String NIVEL= "nivel";
    public static final String ORDEN= "orden";
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
    	public static final String LABEL_IDUBICACIONBODE= "Ubicacion Bodega";
		public static final String LABEL_IDUBICACIONBODE_LOWER= "Ubicacion Bode";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NIVEL= "Nivel";
		public static final String LABEL_NIVEL_LOWER= "Nivel";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getUbicacionBodeLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.IDEMPRESA)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.IDSUCURSAL)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.IDBODEGA)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.IDUBICACIONBODE)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_IDUBICACIONBODE;}
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.NOMBRE)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.NIVEL)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_NIVEL;}
		if(sNombreColumna.equals(UbicacionBodeConstantesFunciones.ORDEN)) {sLabelColumna=UbicacionBodeConstantesFunciones.LABEL_ORDEN;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getUbicacionBodeDescripcion(UbicacionBode ubicacionbode) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ubicacionbode !=null/* && ubicacionbode.getId()!=0*/) {
			sDescripcion=ubicacionbode.getnombre();//ubicacionbodeubicacionbode.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getUbicacionBodeDescripcionDetallado(UbicacionBode ubicacionbode) {
		String sDescripcion="";
			
		sDescripcion+=UbicacionBodeConstantesFunciones.ID+"=";
		sDescripcion+=ubicacionbode.getId().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ubicacionbode.getVersionRow().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ubicacionbode.getid_empresa().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ubicacionbode.getid_sucursal().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=ubicacionbode.getid_bodega().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.IDUBICACIONBODE+"=";
		sDescripcion+=ubicacionbode.getid_ubicacion_bode().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.NOMBRE+"=";
		sDescripcion+=ubicacionbode.getnombre()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.NIVEL+"=";
		sDescripcion+=ubicacionbode.getnivel().toString()+",";
		sDescripcion+=UbicacionBodeConstantesFunciones.ORDEN+"=";
		sDescripcion+=ubicacionbode.getorden().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUbicacionBodeDescripcion(UbicacionBode ubicacionbode,String sValor) throws Exception {			
		if(ubicacionbode !=null) {
			ubicacionbode.setnombre(sValor);;//ubicacionbodeubicacionbode.getnombre().trim();
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
		} else if(sNombreIndice.equals("FK_IdUbicacionBode")) {
			sNombreIndice="Tipo=  Por Ubicacion Bodega";
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

	public static String getDetalleIndiceFK_IdUbicacionBode(Long id_ubicacion_bode) {
		String sDetalleIndice=" Parametros->";
		if(id_ubicacion_bode!=null) {sDetalleIndice+=" Codigo Unico De Ubicacion Bodega="+id_ubicacion_bode.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUbicacionBode(UbicacionBode ubicacionbode,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ubicacionbode.setnombre(ubicacionbode.getnombre().trim());
	}
	
	public static void quitarEspaciosUbicacionBodes(List<UbicacionBode> ubicacionbodes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UbicacionBode ubicacionbode: ubicacionbodes) {
			ubicacionbode.setnombre(ubicacionbode.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUbicacionBode(UbicacionBode ubicacionbode,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ubicacionbode.getConCambioAuxiliar()) {
			ubicacionbode.setIsDeleted(ubicacionbode.getIsDeletedAuxiliar());	
			ubicacionbode.setIsNew(ubicacionbode.getIsNewAuxiliar());	
			ubicacionbode.setIsChanged(ubicacionbode.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ubicacionbode.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ubicacionbode.setIsDeletedAuxiliar(false);	
			ubicacionbode.setIsNewAuxiliar(false);	
			ubicacionbode.setIsChangedAuxiliar(false);
			
			ubicacionbode.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUbicacionBodes(List<UbicacionBode> ubicacionbodes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UbicacionBode ubicacionbode : ubicacionbodes) {
			if(conAsignarBase && ubicacionbode.getConCambioAuxiliar()) {
				ubicacionbode.setIsDeleted(ubicacionbode.getIsDeletedAuxiliar());	
				ubicacionbode.setIsNew(ubicacionbode.getIsNewAuxiliar());	
				ubicacionbode.setIsChanged(ubicacionbode.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ubicacionbode.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ubicacionbode.setIsDeletedAuxiliar(false);	
				ubicacionbode.setIsNewAuxiliar(false);	
				ubicacionbode.setIsChangedAuxiliar(false);
				
				ubicacionbode.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUbicacionBode(UbicacionBode ubicacionbode,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			ubicacionbode.setnivel(0);
			ubicacionbode.setorden(0);
		}
	}		
	
	public static void InicializarValoresUbicacionBodes(List<UbicacionBode> ubicacionbodes,Boolean conEnteros) throws Exception  {
		
		for(UbicacionBode ubicacionbode: ubicacionbodes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				ubicacionbode.setnivel(0);
				ubicacionbode.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaUbicacionBode(List<UbicacionBode> ubicacionbodes,UbicacionBode ubicacionbodeAux) throws Exception  {
		UbicacionBodeConstantesFunciones.InicializarValoresUbicacionBode(ubicacionbodeAux,true);
		
		for(UbicacionBode ubicacionbode: ubicacionbodes) {
			if(ubicacionbode.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ubicacionbodeAux.setnivel(ubicacionbodeAux.getnivel()+ubicacionbode.getnivel());			
			ubicacionbodeAux.setorden(ubicacionbodeAux.getorden()+ubicacionbode.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUbicacionBode(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UbicacionBodeConstantesFunciones.getArrayColumnasGlobalesUbicacionBode(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUbicacionBode(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UbicacionBodeConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UbicacionBodeConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UbicacionBodeConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UbicacionBodeConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUbicacionBode(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UbicacionBode> ubicacionbodes,UbicacionBode ubicacionbode,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UbicacionBode ubicacionbodeAux: ubicacionbodes) {
			if(ubicacionbodeAux!=null && ubicacionbode!=null) {
				if((ubicacionbodeAux.getId()==null && ubicacionbode.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ubicacionbodeAux.getId()!=null && ubicacionbode.getId()!=null){
					if(ubicacionbodeAux.getId().equals(ubicacionbode.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUbicacionBode(List<UbicacionBode> ubicacionbodes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(UbicacionBode ubicacionbode: ubicacionbodes) {			
			if(ubicacionbode.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUbicacionBode() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_ID, UbicacionBodeConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_VERSIONROW, UbicacionBodeConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_IDEMPRESA, UbicacionBodeConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_IDSUCURSAL, UbicacionBodeConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_IDBODEGA, UbicacionBodeConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_IDUBICACIONBODE, UbicacionBodeConstantesFunciones.IDUBICACIONBODE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_NOMBRE, UbicacionBodeConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_NIVEL, UbicacionBodeConstantesFunciones.NIVEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UbicacionBodeConstantesFunciones.LABEL_ORDEN, UbicacionBodeConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUbicacionBode() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.IDUBICACIONBODE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.NIVEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UbicacionBodeConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUbicacionBode() throws Exception  {
		return UbicacionBodeConstantesFunciones.getTiposSeleccionarUbicacionBode(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUbicacionBode(Boolean conFk) throws Exception  {
		return UbicacionBodeConstantesFunciones.getTiposSeleccionarUbicacionBode(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUbicacionBode(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_IDUBICACIONBODE);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_IDUBICACIONBODE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_NIVEL);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_NIVEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UbicacionBodeConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(UbicacionBodeConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUbicacionBode(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUbicacionBode(UbicacionBode ubicacionbodeAux) throws Exception {
		
			ubicacionbodeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ubicacionbodeAux.getEmpresa()));
			ubicacionbodeAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ubicacionbodeAux.getSucursal()));
			ubicacionbodeAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ubicacionbodeAux.getBodega()));
			ubicacionbodeAux.setubicacionbode_descripcion(UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcion(ubicacionbodeAux.getUbicacionBode()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUbicacionBode(List<UbicacionBode> ubicacionbodesTemp) throws Exception {
		for(UbicacionBode ubicacionbodeAux:ubicacionbodesTemp) {
			
			ubicacionbodeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ubicacionbodeAux.getEmpresa()));
			ubicacionbodeAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ubicacionbodeAux.getSucursal()));
			ubicacionbodeAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(ubicacionbodeAux.getBodega()));
			ubicacionbodeAux.setubicacionbode_descripcion(UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcion(ubicacionbodeAux.getUbicacionBode()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUbicacionBode(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(UbicacionBode.class));
				
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
					if(clas.clas.equals(UbicacionBode.class)) {
						classes.add(new Classe(UbicacionBode.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUbicacionBode(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(UbicacionBode.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionBode.class)); continue;
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

					if(UbicacionBode.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionBode.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUbicacionBode(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UbicacionBodeConstantesFunciones.getClassesRelationshipsOfUbicacionBode(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUbicacionBode(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(UbicacionBode.class));
				classes.add(new Classe(UbicacionProdu.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(UbicacionBode.class)) {
						classes.add(new Classe(UbicacionBode.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(UbicacionProdu.class)) {
						classes.add(new Classe(UbicacionProdu.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUbicacionBode(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UbicacionBodeConstantesFunciones.getClassesRelationshipsFromStringsOfUbicacionBode(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUbicacionBode(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(UbicacionBode.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionBode.class)); continue;
					}

					if(UbicacionProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionProdu.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(UbicacionBode.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionBode.class)); continue;
					}

					if(UbicacionProdu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(UbicacionProdu.class)); continue;
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
	public static void actualizarLista(UbicacionBode ubicacionbode,List<UbicacionBode> ubicacionbodes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UbicacionBode ubicacionbodeEncontrado=null;
			
			for(UbicacionBode ubicacionbodeLocal:ubicacionbodes) {
				if(ubicacionbodeLocal.getId().equals(ubicacionbode.getId())) {
					ubicacionbodeEncontrado=ubicacionbodeLocal;
					
					ubicacionbodeLocal.setIsChanged(ubicacionbode.getIsChanged());
					ubicacionbodeLocal.setIsNew(ubicacionbode.getIsNew());
					ubicacionbodeLocal.setIsDeleted(ubicacionbode.getIsDeleted());
					
					ubicacionbodeLocal.setGeneralEntityOriginal(ubicacionbode.getGeneralEntityOriginal());
					
					ubicacionbodeLocal.setId(ubicacionbode.getId());	
					ubicacionbodeLocal.setVersionRow(ubicacionbode.getVersionRow());	
					ubicacionbodeLocal.setid_empresa(ubicacionbode.getid_empresa());	
					ubicacionbodeLocal.setid_sucursal(ubicacionbode.getid_sucursal());	
					ubicacionbodeLocal.setid_bodega(ubicacionbode.getid_bodega());	
					ubicacionbodeLocal.setid_ubicacion_bode(ubicacionbode.getid_ubicacion_bode());	
					ubicacionbodeLocal.setnombre(ubicacionbode.getnombre());	
					ubicacionbodeLocal.setnivel(ubicacionbode.getnivel());	
					ubicacionbodeLocal.setorden(ubicacionbode.getorden());	
					
					
					ubicacionbodeLocal.setUbicacionBodes(ubicacionbode.getUbicacionBodes());
					ubicacionbodeLocal.setUbicacionProdus(ubicacionbode.getUbicacionProdus());
					
					existe=true;
					break;
				}
			}
			
			if(!ubicacionbode.getIsDeleted()) {
				if(!existe) {
					ubicacionbodes.add(ubicacionbode);
				}
			} else {
				if(ubicacionbodeEncontrado!=null && permiteQuitar)  {
					ubicacionbodes.remove(ubicacionbodeEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UbicacionBode ubicacionbode,List<UbicacionBode> ubicacionbodes) throws Exception {
		try	{			
			for(UbicacionBode ubicacionbodeLocal:ubicacionbodes) {
				if(ubicacionbodeLocal.getId().equals(ubicacionbode.getId())) {
					ubicacionbodeLocal.setIsSelected(ubicacionbode.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUbicacionBode(List<UbicacionBode> ubicacionbodesAux) throws Exception {
		//this.ubicacionbodesAux=ubicacionbodesAux;
		
		for(UbicacionBode ubicacionbodeAux:ubicacionbodesAux) {
			if(ubicacionbodeAux.getIsChanged()) {
				ubicacionbodeAux.setIsChanged(false);
			}		
			
			if(ubicacionbodeAux.getIsNew()) {
				ubicacionbodeAux.setIsNew(false);
			}	
			
			if(ubicacionbodeAux.getIsDeleted()) {
				ubicacionbodeAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUbicacionBode(UbicacionBode ubicacionbodeAux) throws Exception {
		//this.ubicacionbodeAux=ubicacionbodeAux;
		
			if(ubicacionbodeAux.getIsChanged()) {
				ubicacionbodeAux.setIsChanged(false);
			}		
			
			if(ubicacionbodeAux.getIsNew()) {
				ubicacionbodeAux.setIsNew(false);
			}	
			
			if(ubicacionbodeAux.getIsDeleted()) {
				ubicacionbodeAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UbicacionBode ubicacionbodeAsignar,UbicacionBode ubicacionbode) throws Exception {
		ubicacionbodeAsignar.setId(ubicacionbode.getId());	
		ubicacionbodeAsignar.setVersionRow(ubicacionbode.getVersionRow());	
		ubicacionbodeAsignar.setid_empresa(ubicacionbode.getid_empresa());
		ubicacionbodeAsignar.setempresa_descripcion(ubicacionbode.getempresa_descripcion());	
		ubicacionbodeAsignar.setid_sucursal(ubicacionbode.getid_sucursal());
		ubicacionbodeAsignar.setsucursal_descripcion(ubicacionbode.getsucursal_descripcion());	
		ubicacionbodeAsignar.setid_bodega(ubicacionbode.getid_bodega());
		ubicacionbodeAsignar.setbodega_descripcion(ubicacionbode.getbodega_descripcion());	
		ubicacionbodeAsignar.setid_ubicacion_bode(ubicacionbode.getid_ubicacion_bode());
		ubicacionbodeAsignar.setubicacionbode_descripcion(ubicacionbode.getubicacionbode_descripcion());	
		ubicacionbodeAsignar.setnombre(ubicacionbode.getnombre());	
		ubicacionbodeAsignar.setnivel(ubicacionbode.getnivel());	
		ubicacionbodeAsignar.setorden(ubicacionbode.getorden());	
	}
	
	public static void inicializarUbicacionBode(UbicacionBode ubicacionbode) throws Exception {
		try {
				ubicacionbode.setId(0L);	
					
				ubicacionbode.setid_empresa(-1L);	
				ubicacionbode.setid_sucursal(-1L);	
				ubicacionbode.setid_bodega(-1L);	
				ubicacionbode.setid_ubicacion_bode(null);	
				ubicacionbode.setnombre("");	
				ubicacionbode.setnivel(0);	
				ubicacionbode.setorden(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUbicacionBode(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_IDUBICACIONBODE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_NIVEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UbicacionBodeConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUbicacionBode(String sTipo,Row row,Workbook workbook,UbicacionBode ubicacionbode,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getubicacionbode_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getnivel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ubicacionbode.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUbicacionBode=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUbicacionBode() {
		return this.sFinalQueryUbicacionBode;
	}
	
	public void setsFinalQueryUbicacionBode(String sFinalQueryUbicacionBode) {
		this.sFinalQueryUbicacionBode= sFinalQueryUbicacionBode;
	}
	
	public Border resaltarSeleccionarUbicacionBode=null;
	
	public Border setResaltarSeleccionarUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUbicacionBode= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUbicacionBode() {
		return this.resaltarSeleccionarUbicacionBode;
	}
	
	public void setResaltarSeleccionarUbicacionBode(Border borderResaltarSeleccionarUbicacionBode) {
		this.resaltarSeleccionarUbicacionBode= borderResaltarSeleccionarUbicacionBode;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUbicacionBode=null;
	public Boolean mostraridUbicacionBode=true;
	public Boolean activaridUbicacionBode=true;

	public Border resaltarid_empresaUbicacionBode=null;
	public Boolean mostrarid_empresaUbicacionBode=true;
	public Boolean activarid_empresaUbicacionBode=true;
	public Boolean cargarid_empresaUbicacionBode=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUbicacionBode=false;//ConEventDepend=true

	public Border resaltarid_sucursalUbicacionBode=null;
	public Boolean mostrarid_sucursalUbicacionBode=true;
	public Boolean activarid_sucursalUbicacionBode=true;
	public Boolean cargarid_sucursalUbicacionBode=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalUbicacionBode=false;//ConEventDepend=true

	public Border resaltarid_bodegaUbicacionBode=null;
	public Boolean mostrarid_bodegaUbicacionBode=true;
	public Boolean activarid_bodegaUbicacionBode=true;
	public Boolean cargarid_bodegaUbicacionBode=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaUbicacionBode=false;//ConEventDepend=true

	public Border resaltarid_ubicacion_bodeUbicacionBode=null;
	public Boolean mostrarid_ubicacion_bodeUbicacionBode=true;
	public Boolean activarid_ubicacion_bodeUbicacionBode=true;
	public Boolean cargarid_ubicacion_bodeUbicacionBode=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ubicacion_bodeUbicacionBode=false;//ConEventDepend=true

	public Border resaltarnombreUbicacionBode=null;
	public Boolean mostrarnombreUbicacionBode=true;
	public Boolean activarnombreUbicacionBode=true;

	public Border resaltarnivelUbicacionBode=null;
	public Boolean mostrarnivelUbicacionBode=true;
	public Boolean activarnivelUbicacionBode=true;

	public Border resaltarordenUbicacionBode=null;
	public Boolean mostrarordenUbicacionBode=true;
	public Boolean activarordenUbicacionBode=true;

	
	

	public Border setResaltaridUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltaridUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUbicacionBode() {
		return this.resaltaridUbicacionBode;
	}

	public void setResaltaridUbicacionBode(Border borderResaltar) {
		this.resaltaridUbicacionBode= borderResaltar;
	}

	public Boolean getMostraridUbicacionBode() {
		return this.mostraridUbicacionBode;
	}

	public void setMostraridUbicacionBode(Boolean mostraridUbicacionBode) {
		this.mostraridUbicacionBode= mostraridUbicacionBode;
	}

	public Boolean getActivaridUbicacionBode() {
		return this.activaridUbicacionBode;
	}

	public void setActivaridUbicacionBode(Boolean activaridUbicacionBode) {
		this.activaridUbicacionBode= activaridUbicacionBode;
	}

	public Border setResaltarid_empresaUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarid_empresaUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUbicacionBode() {
		return this.resaltarid_empresaUbicacionBode;
	}

	public void setResaltarid_empresaUbicacionBode(Border borderResaltar) {
		this.resaltarid_empresaUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarid_empresaUbicacionBode() {
		return this.mostrarid_empresaUbicacionBode;
	}

	public void setMostrarid_empresaUbicacionBode(Boolean mostrarid_empresaUbicacionBode) {
		this.mostrarid_empresaUbicacionBode= mostrarid_empresaUbicacionBode;
	}

	public Boolean getActivarid_empresaUbicacionBode() {
		return this.activarid_empresaUbicacionBode;
	}

	public void setActivarid_empresaUbicacionBode(Boolean activarid_empresaUbicacionBode) {
		this.activarid_empresaUbicacionBode= activarid_empresaUbicacionBode;
	}

	public Boolean getCargarid_empresaUbicacionBode() {
		return this.cargarid_empresaUbicacionBode;
	}

	public void setCargarid_empresaUbicacionBode(Boolean cargarid_empresaUbicacionBode) {
		this.cargarid_empresaUbicacionBode= cargarid_empresaUbicacionBode;
	}

	public Border setResaltarid_sucursalUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarid_sucursalUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalUbicacionBode() {
		return this.resaltarid_sucursalUbicacionBode;
	}

	public void setResaltarid_sucursalUbicacionBode(Border borderResaltar) {
		this.resaltarid_sucursalUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarid_sucursalUbicacionBode() {
		return this.mostrarid_sucursalUbicacionBode;
	}

	public void setMostrarid_sucursalUbicacionBode(Boolean mostrarid_sucursalUbicacionBode) {
		this.mostrarid_sucursalUbicacionBode= mostrarid_sucursalUbicacionBode;
	}

	public Boolean getActivarid_sucursalUbicacionBode() {
		return this.activarid_sucursalUbicacionBode;
	}

	public void setActivarid_sucursalUbicacionBode(Boolean activarid_sucursalUbicacionBode) {
		this.activarid_sucursalUbicacionBode= activarid_sucursalUbicacionBode;
	}

	public Boolean getCargarid_sucursalUbicacionBode() {
		return this.cargarid_sucursalUbicacionBode;
	}

	public void setCargarid_sucursalUbicacionBode(Boolean cargarid_sucursalUbicacionBode) {
		this.cargarid_sucursalUbicacionBode= cargarid_sucursalUbicacionBode;
	}

	public Border setResaltarid_bodegaUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarid_bodegaUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaUbicacionBode() {
		return this.resaltarid_bodegaUbicacionBode;
	}

	public void setResaltarid_bodegaUbicacionBode(Border borderResaltar) {
		this.resaltarid_bodegaUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarid_bodegaUbicacionBode() {
		return this.mostrarid_bodegaUbicacionBode;
	}

	public void setMostrarid_bodegaUbicacionBode(Boolean mostrarid_bodegaUbicacionBode) {
		this.mostrarid_bodegaUbicacionBode= mostrarid_bodegaUbicacionBode;
	}

	public Boolean getActivarid_bodegaUbicacionBode() {
		return this.activarid_bodegaUbicacionBode;
	}

	public void setActivarid_bodegaUbicacionBode(Boolean activarid_bodegaUbicacionBode) {
		this.activarid_bodegaUbicacionBode= activarid_bodegaUbicacionBode;
	}

	public Boolean getCargarid_bodegaUbicacionBode() {
		return this.cargarid_bodegaUbicacionBode;
	}

	public void setCargarid_bodegaUbicacionBode(Boolean cargarid_bodegaUbicacionBode) {
		this.cargarid_bodegaUbicacionBode= cargarid_bodegaUbicacionBode;
	}

	public Border setResaltarid_ubicacion_bodeUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarid_ubicacion_bodeUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ubicacion_bodeUbicacionBode() {
		return this.resaltarid_ubicacion_bodeUbicacionBode;
	}

	public void setResaltarid_ubicacion_bodeUbicacionBode(Border borderResaltar) {
		this.resaltarid_ubicacion_bodeUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarid_ubicacion_bodeUbicacionBode() {
		return this.mostrarid_ubicacion_bodeUbicacionBode;
	}

	public void setMostrarid_ubicacion_bodeUbicacionBode(Boolean mostrarid_ubicacion_bodeUbicacionBode) {
		this.mostrarid_ubicacion_bodeUbicacionBode= mostrarid_ubicacion_bodeUbicacionBode;
	}

	public Boolean getActivarid_ubicacion_bodeUbicacionBode() {
		return this.activarid_ubicacion_bodeUbicacionBode;
	}

	public void setActivarid_ubicacion_bodeUbicacionBode(Boolean activarid_ubicacion_bodeUbicacionBode) {
		this.activarid_ubicacion_bodeUbicacionBode= activarid_ubicacion_bodeUbicacionBode;
	}

	public Boolean getCargarid_ubicacion_bodeUbicacionBode() {
		return this.cargarid_ubicacion_bodeUbicacionBode;
	}

	public void setCargarid_ubicacion_bodeUbicacionBode(Boolean cargarid_ubicacion_bodeUbicacionBode) {
		this.cargarid_ubicacion_bodeUbicacionBode= cargarid_ubicacion_bodeUbicacionBode;
	}

	public Border setResaltarnombreUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarnombreUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreUbicacionBode() {
		return this.resaltarnombreUbicacionBode;
	}

	public void setResaltarnombreUbicacionBode(Border borderResaltar) {
		this.resaltarnombreUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarnombreUbicacionBode() {
		return this.mostrarnombreUbicacionBode;
	}

	public void setMostrarnombreUbicacionBode(Boolean mostrarnombreUbicacionBode) {
		this.mostrarnombreUbicacionBode= mostrarnombreUbicacionBode;
	}

	public Boolean getActivarnombreUbicacionBode() {
		return this.activarnombreUbicacionBode;
	}

	public void setActivarnombreUbicacionBode(Boolean activarnombreUbicacionBode) {
		this.activarnombreUbicacionBode= activarnombreUbicacionBode;
	}

	public Border setResaltarnivelUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarnivelUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnivelUbicacionBode() {
		return this.resaltarnivelUbicacionBode;
	}

	public void setResaltarnivelUbicacionBode(Border borderResaltar) {
		this.resaltarnivelUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarnivelUbicacionBode() {
		return this.mostrarnivelUbicacionBode;
	}

	public void setMostrarnivelUbicacionBode(Boolean mostrarnivelUbicacionBode) {
		this.mostrarnivelUbicacionBode= mostrarnivelUbicacionBode;
	}

	public Boolean getActivarnivelUbicacionBode() {
		return this.activarnivelUbicacionBode;
	}

	public void setActivarnivelUbicacionBode(Boolean activarnivelUbicacionBode) {
		this.activarnivelUbicacionBode= activarnivelUbicacionBode;
	}

	public Border setResaltarordenUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltar);
		
		this.resaltarordenUbicacionBode= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenUbicacionBode() {
		return this.resaltarordenUbicacionBode;
	}

	public void setResaltarordenUbicacionBode(Border borderResaltar) {
		this.resaltarordenUbicacionBode= borderResaltar;
	}

	public Boolean getMostrarordenUbicacionBode() {
		return this.mostrarordenUbicacionBode;
	}

	public void setMostrarordenUbicacionBode(Boolean mostrarordenUbicacionBode) {
		this.mostrarordenUbicacionBode= mostrarordenUbicacionBode;
	}

	public Boolean getActivarordenUbicacionBode() {
		return this.activarordenUbicacionBode;
	}

	public void setActivarordenUbicacionBode(Boolean activarordenUbicacionBode) {
		this.activarordenUbicacionBode= activarordenUbicacionBode;
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
		
		
		this.setMostraridUbicacionBode(esInicial);
		this.setMostrarid_empresaUbicacionBode(esInicial);
		this.setMostrarid_sucursalUbicacionBode(esInicial);
		this.setMostrarid_bodegaUbicacionBode(esInicial);
		this.setMostrarid_ubicacion_bodeUbicacionBode(esInicial);
		this.setMostrarnombreUbicacionBode(esInicial);
		this.setMostrarnivelUbicacionBode(esInicial);
		this.setMostrarordenUbicacionBode(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.ID)) {
				this.setMostraridUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDUBICACIONBODE)) {
				this.setMostrarid_ubicacion_bodeUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.NIVEL)) {
				this.setMostrarnivelUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.ORDEN)) {
				this.setMostrarordenUbicacionBode(esAsigna);
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
		
		
		this.setActivaridUbicacionBode(esInicial);
		this.setActivarid_empresaUbicacionBode(esInicial);
		this.setActivarid_sucursalUbicacionBode(esInicial);
		this.setActivarid_bodegaUbicacionBode(esInicial);
		this.setActivarid_ubicacion_bodeUbicacionBode(esInicial);
		this.setActivarnombreUbicacionBode(esInicial);
		this.setActivarnivelUbicacionBode(esInicial);
		this.setActivarordenUbicacionBode(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.ID)) {
				this.setActivaridUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDUBICACIONBODE)) {
				this.setActivarid_ubicacion_bodeUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.NOMBRE)) {
				this.setActivarnombreUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.NIVEL)) {
				this.setActivarnivelUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.ORDEN)) {
				this.setActivarordenUbicacionBode(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUbicacionBode(esInicial);
		this.setResaltarid_empresaUbicacionBode(esInicial);
		this.setResaltarid_sucursalUbicacionBode(esInicial);
		this.setResaltarid_bodegaUbicacionBode(esInicial);
		this.setResaltarid_ubicacion_bodeUbicacionBode(esInicial);
		this.setResaltarnombreUbicacionBode(esInicial);
		this.setResaltarnivelUbicacionBode(esInicial);
		this.setResaltarordenUbicacionBode(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.ID)) {
				this.setResaltaridUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.IDUBICACIONBODE)) {
				this.setResaltarid_ubicacion_bodeUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.NIVEL)) {
				this.setResaltarnivelUbicacionBode(esAsigna);
				continue;
			}

			if(campo.clase.equals(UbicacionBodeConstantesFunciones.ORDEN)) {
				this.setResaltarordenUbicacionBode(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarUbicacionBodeUbicacionBode=null;

	public Border getResaltarUbicacionBodeUbicacionBode() {
		return this.resaltarUbicacionBodeUbicacionBode;
	}

	public void setResaltarUbicacionBodeUbicacionBode(Border borderResaltarUbicacionBode) {
		if(borderResaltarUbicacionBode!=null) {
			this.resaltarUbicacionBodeUbicacionBode= borderResaltarUbicacionBode;
		}
	}

	public Border setResaltarUbicacionBodeUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltarUbicacionBode=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltarUbicacionBode);
			
		this.resaltarUbicacionBodeUbicacionBode= borderResaltarUbicacionBode;

		 return borderResaltarUbicacionBode;
	}



	public Boolean mostrarUbicacionBodeUbicacionBode=true;

	public Boolean getMostrarUbicacionBodeUbicacionBode() {
		return this.mostrarUbicacionBodeUbicacionBode;
	}

	public void setMostrarUbicacionBodeUbicacionBode(Boolean visibilidadResaltarUbicacionBode) {
		this.mostrarUbicacionBodeUbicacionBode= visibilidadResaltarUbicacionBode;
	}



	public Boolean activarUbicacionBodeUbicacionBode=true;

	public Boolean gethabilitarResaltarUbicacionBodeUbicacionBode() {
		return this.activarUbicacionBodeUbicacionBode;
	}

	public void setActivarUbicacionBodeUbicacionBode(Boolean habilitarResaltarUbicacionBode) {
		this.activarUbicacionBodeUbicacionBode= habilitarResaltarUbicacionBode;
	}


	public Border resaltarUbicacionProduUbicacionBode=null;

	public Border getResaltarUbicacionProduUbicacionBode() {
		return this.resaltarUbicacionProduUbicacionBode;
	}

	public void setResaltarUbicacionProduUbicacionBode(Border borderResaltarUbicacionProdu) {
		if(borderResaltarUbicacionProdu!=null) {
			this.resaltarUbicacionProduUbicacionBode= borderResaltarUbicacionProdu;
		}
	}

	public Border setResaltarUbicacionProduUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltarUbicacionProdu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ubicacionbodeBeanSwingJInternalFrame.jTtoolBarUbicacionBode.setBorder(borderResaltarUbicacionProdu);
			
		this.resaltarUbicacionProduUbicacionBode= borderResaltarUbicacionProdu;

		 return borderResaltarUbicacionProdu;
	}



	public Boolean mostrarUbicacionProduUbicacionBode=true;

	public Boolean getMostrarUbicacionProduUbicacionBode() {
		return this.mostrarUbicacionProduUbicacionBode;
	}

	public void setMostrarUbicacionProduUbicacionBode(Boolean visibilidadResaltarUbicacionProdu) {
		this.mostrarUbicacionProduUbicacionBode= visibilidadResaltarUbicacionProdu;
	}



	public Boolean activarUbicacionProduUbicacionBode=true;

	public Boolean gethabilitarResaltarUbicacionProduUbicacionBode() {
		return this.activarUbicacionProduUbicacionBode;
	}

	public void setActivarUbicacionProduUbicacionBode(Boolean habilitarResaltarUbicacionProdu) {
		this.activarUbicacionProduUbicacionBode= habilitarResaltarUbicacionProdu;
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

		this.setMostrarUbicacionBodeUbicacionBode(esInicial);
		this.setMostrarUbicacionProduUbicacionBode(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UbicacionBode.class)) {
				this.setMostrarUbicacionBodeUbicacionBode(esAsigna);
				continue;
			}

			if(clase.clas.equals(UbicacionProdu.class)) {
				this.setMostrarUbicacionProduUbicacionBode(esAsigna);
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

		this.setActivarUbicacionBodeUbicacionBode(esInicial);
		this.setActivarUbicacionProduUbicacionBode(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UbicacionBode.class)) {
				this.setActivarUbicacionBodeUbicacionBode(esAsigna);
				continue;
			}

			if(clase.clas.equals(UbicacionProdu.class)) {
				this.setActivarUbicacionProduUbicacionBode(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarUbicacionBodeUbicacionBode(esInicial);
		this.setResaltarUbicacionProduUbicacionBode(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(UbicacionBode.class)) {
				this.setResaltarUbicacionBodeUbicacionBode(esAsigna);
				continue;
			}

			if(clase.clas.equals(UbicacionProdu.class)) {
				this.setResaltarUbicacionProduUbicacionBode(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdBodegaUbicacionBode=true;

	public Boolean getMostrarFK_IdBodegaUbicacionBode() {
		return this.mostrarFK_IdBodegaUbicacionBode;
	}

	public void setMostrarFK_IdBodegaUbicacionBode(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaUbicacionBode= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaUbicacionBode=true;

	public Boolean getMostrarFK_IdEmpresaUbicacionBode() {
		return this.mostrarFK_IdEmpresaUbicacionBode;
	}

	public void setMostrarFK_IdEmpresaUbicacionBode(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUbicacionBode= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalUbicacionBode=true;

	public Boolean getMostrarFK_IdSucursalUbicacionBode() {
		return this.mostrarFK_IdSucursalUbicacionBode;
	}

	public void setMostrarFK_IdSucursalUbicacionBode(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalUbicacionBode= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUbicacionBodeUbicacionBode=true;

	public Boolean getMostrarFK_IdUbicacionBodeUbicacionBode() {
		return this.mostrarFK_IdUbicacionBodeUbicacionBode;
	}

	public void setMostrarFK_IdUbicacionBodeUbicacionBode(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUbicacionBodeUbicacionBode= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaUbicacionBode=true;

	public Boolean getActivarFK_IdBodegaUbicacionBode() {
		return this.activarFK_IdBodegaUbicacionBode;
	}

	public void setActivarFK_IdBodegaUbicacionBode(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaUbicacionBode= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaUbicacionBode=true;

	public Boolean getActivarFK_IdEmpresaUbicacionBode() {
		return this.activarFK_IdEmpresaUbicacionBode;
	}

	public void setActivarFK_IdEmpresaUbicacionBode(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUbicacionBode= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalUbicacionBode=true;

	public Boolean getActivarFK_IdSucursalUbicacionBode() {
		return this.activarFK_IdSucursalUbicacionBode;
	}

	public void setActivarFK_IdSucursalUbicacionBode(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalUbicacionBode= habilitarResaltar;
	}

	public Boolean activarFK_IdUbicacionBodeUbicacionBode=true;

	public Boolean getActivarFK_IdUbicacionBodeUbicacionBode() {
		return this.activarFK_IdUbicacionBodeUbicacionBode;
	}

	public void setActivarFK_IdUbicacionBodeUbicacionBode(Boolean habilitarResaltar) {
		this.activarFK_IdUbicacionBodeUbicacionBode= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaUbicacionBode=null;

	public Border getResaltarFK_IdBodegaUbicacionBode() {
		return this.resaltarFK_IdBodegaUbicacionBode;
	}

	public void setResaltarFK_IdBodegaUbicacionBode(Border borderResaltar) {
		this.resaltarFK_IdBodegaUbicacionBode= borderResaltar;
	}

	public void setResaltarFK_IdBodegaUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaUbicacionBode= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaUbicacionBode=null;

	public Border getResaltarFK_IdEmpresaUbicacionBode() {
		return this.resaltarFK_IdEmpresaUbicacionBode;
	}

	public void setResaltarFK_IdEmpresaUbicacionBode(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUbicacionBode= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUbicacionBode= borderResaltar;
	}

	public Border resaltarFK_IdSucursalUbicacionBode=null;

	public Border getResaltarFK_IdSucursalUbicacionBode() {
		return this.resaltarFK_IdSucursalUbicacionBode;
	}

	public void setResaltarFK_IdSucursalUbicacionBode(Border borderResaltar) {
		this.resaltarFK_IdSucursalUbicacionBode= borderResaltar;
	}

	public void setResaltarFK_IdSucursalUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalUbicacionBode= borderResaltar;
	}

	public Border resaltarFK_IdUbicacionBodeUbicacionBode=null;

	public Border getResaltarFK_IdUbicacionBodeUbicacionBode() {
		return this.resaltarFK_IdUbicacionBodeUbicacionBode;
	}

	public void setResaltarFK_IdUbicacionBodeUbicacionBode(Border borderResaltar) {
		this.resaltarFK_IdUbicacionBodeUbicacionBode= borderResaltar;
	}

	public void setResaltarFK_IdUbicacionBodeUbicacionBode(ParametroGeneralUsuario parametroGeneralUsuario/*UbicacionBodeBeanSwingJInternalFrame ubicacionbodeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUbicacionBodeUbicacionBode= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}