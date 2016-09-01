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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.RutaTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.RutaTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RutaTransporteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RutaTransporteConstantesFunciones extends RutaTransporteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RutaTransporte";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RutaTransporte"+RutaTransporteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RutaTransporteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RutaTransporteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RutaTransporteConstantesFunciones.SCHEMA+"_"+RutaTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RutaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RutaTransporteConstantesFunciones.SCHEMA+"_"+RutaTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RutaTransporteConstantesFunciones.SCHEMA+"_"+RutaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RutaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RutaTransporteConstantesFunciones.SCHEMA+"_"+RutaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RutaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RutaTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RutaTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RutaTransporteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RutaTransporteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RutaTransporteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RutaTransporteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ruta Transportes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Ruta Transporte";
	public static final String SCLASSWEBTITULO_LOWER="Ruta Transporte";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RutaTransporte";
	public static final String OBJECTNAME="rutatransporte";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="ruta_transporte";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rutatransporte from "+RutaTransporteConstantesFunciones.SPERSISTENCENAME+" rutatransporte";
	public static String QUERYSELECTNATIVE="select "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".id,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".version_row,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".id_empresa,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".nombre,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".origen,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".destino,"+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME+".precio from "+RutaTransporteConstantesFunciones.SCHEMA+"."+RutaTransporteConstantesFunciones.TABLENAME;//+" as "+RutaTransporteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RutaTransporteConstantesFuncionesAdditional rutatransporteConstantesFuncionesAdditional=null;
	
	public RutaTransporteConstantesFuncionesAdditional getRutaTransporteConstantesFuncionesAdditional() {
		return this.rutatransporteConstantesFuncionesAdditional;
	}
	
	public void setRutaTransporteConstantesFuncionesAdditional(RutaTransporteConstantesFuncionesAdditional rutatransporteConstantesFuncionesAdditional) {
		try {
			this.rutatransporteConstantesFuncionesAdditional=rutatransporteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String ORIGEN= "origen";
    public static final String DESTINO= "destino";
    public static final String PRECIO= "precio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ORIGEN= "Origen";
		public static final String LABEL_ORIGEN_LOWER= "Origen";
    	public static final String LABEL_DESTINO= "Destino";
		public static final String LABEL_DESTINO_LOWER= "Destino";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getRutaTransporteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RutaTransporteConstantesFunciones.IDEMPRESA)) {sLabelColumna=RutaTransporteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RutaTransporteConstantesFunciones.NOMBRE)) {sLabelColumna=RutaTransporteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(RutaTransporteConstantesFunciones.ORIGEN)) {sLabelColumna=RutaTransporteConstantesFunciones.LABEL_ORIGEN;}
		if(sNombreColumna.equals(RutaTransporteConstantesFunciones.DESTINO)) {sLabelColumna=RutaTransporteConstantesFunciones.LABEL_DESTINO;}
		if(sNombreColumna.equals(RutaTransporteConstantesFunciones.PRECIO)) {sLabelColumna=RutaTransporteConstantesFunciones.LABEL_PRECIO;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getRutaTransporteDescripcion(RutaTransporte rutatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rutatransporte !=null/* && rutatransporte.getId()!=0*/) {
			sDescripcion=rutatransporte.getnombre();//rutatransporterutatransporte.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRutaTransporteDescripcionDetallado(RutaTransporte rutatransporte) {
		String sDescripcion="";
			
		sDescripcion+=RutaTransporteConstantesFunciones.ID+"=";
		sDescripcion+=rutatransporte.getId().toString()+",";
		sDescripcion+=RutaTransporteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rutatransporte.getVersionRow().toString()+",";
		sDescripcion+=RutaTransporteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rutatransporte.getid_empresa().toString()+",";
		sDescripcion+=RutaTransporteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=rutatransporte.getnombre()+",";
		sDescripcion+=RutaTransporteConstantesFunciones.ORIGEN+"=";
		sDescripcion+=rutatransporte.getorigen()+",";
		sDescripcion+=RutaTransporteConstantesFunciones.DESTINO+"=";
		sDescripcion+=rutatransporte.getdestino()+",";
		sDescripcion+=RutaTransporteConstantesFunciones.PRECIO+"=";
		sDescripcion+=rutatransporte.getprecio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRutaTransporteDescripcion(RutaTransporte rutatransporte,String sValor) throws Exception {			
		if(rutatransporte !=null) {
			rutatransporte.setnombre(sValor);;//rutatransporterutatransporte.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorDestino")) {
			sNombreIndice="Tipo=  Por Destino";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorOrigen")) {
			sNombreIndice="Tipo=  Por Origen";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorDestino(String destino) {
		String sDetalleIndice=" Parametros->";
		if(destino!=null) {sDetalleIndice+=" Destino="+destino;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorOrigen(String origen) {
		String sDetalleIndice=" Parametros->";
		if(origen!=null) {sDetalleIndice+=" Origen="+origen;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRutaTransporte(RutaTransporte rutatransporte,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		rutatransporte.setnombre(rutatransporte.getnombre().trim());
		rutatransporte.setorigen(rutatransporte.getorigen().trim());
		rutatransporte.setdestino(rutatransporte.getdestino().trim());
	}
	
	public static void quitarEspaciosRutaTransportes(List<RutaTransporte> rutatransportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RutaTransporte rutatransporte: rutatransportes) {
			rutatransporte.setnombre(rutatransporte.getnombre().trim());
			rutatransporte.setorigen(rutatransporte.getorigen().trim());
			rutatransporte.setdestino(rutatransporte.getdestino().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRutaTransporte(RutaTransporte rutatransporte,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rutatransporte.getConCambioAuxiliar()) {
			rutatransporte.setIsDeleted(rutatransporte.getIsDeletedAuxiliar());	
			rutatransporte.setIsNew(rutatransporte.getIsNewAuxiliar());	
			rutatransporte.setIsChanged(rutatransporte.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rutatransporte.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rutatransporte.setIsDeletedAuxiliar(false);	
			rutatransporte.setIsNewAuxiliar(false);	
			rutatransporte.setIsChangedAuxiliar(false);
			
			rutatransporte.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRutaTransportes(List<RutaTransporte> rutatransportes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RutaTransporte rutatransporte : rutatransportes) {
			if(conAsignarBase && rutatransporte.getConCambioAuxiliar()) {
				rutatransporte.setIsDeleted(rutatransporte.getIsDeletedAuxiliar());	
				rutatransporte.setIsNew(rutatransporte.getIsNewAuxiliar());	
				rutatransporte.setIsChanged(rutatransporte.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rutatransporte.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rutatransporte.setIsDeletedAuxiliar(false);	
				rutatransporte.setIsNewAuxiliar(false);	
				rutatransporte.setIsChangedAuxiliar(false);
				
				rutatransporte.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRutaTransporte(RutaTransporte rutatransporte,Boolean conEnteros) throws Exception  {
		rutatransporte.setprecio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRutaTransportes(List<RutaTransporte> rutatransportes,Boolean conEnteros) throws Exception  {
		
		for(RutaTransporte rutatransporte: rutatransportes) {
			rutatransporte.setprecio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRutaTransporte(List<RutaTransporte> rutatransportes,RutaTransporte rutatransporteAux) throws Exception  {
		RutaTransporteConstantesFunciones.InicializarValoresRutaTransporte(rutatransporteAux,true);
		
		for(RutaTransporte rutatransporte: rutatransportes) {
			if(rutatransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rutatransporteAux.setprecio(rutatransporteAux.getprecio()+rutatransporte.getprecio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRutaTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RutaTransporteConstantesFunciones.getArrayColumnasGlobalesRutaTransporte(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRutaTransporte(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RutaTransporteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RutaTransporteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRutaTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RutaTransporte> rutatransportes,RutaTransporte rutatransporte,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RutaTransporte rutatransporteAux: rutatransportes) {
			if(rutatransporteAux!=null && rutatransporte!=null) {
				if((rutatransporteAux.getId()==null && rutatransporte.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rutatransporteAux.getId()!=null && rutatransporte.getId()!=null){
					if(rutatransporteAux.getId().equals(rutatransporte.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRutaTransporte(List<RutaTransporte> rutatransportes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(RutaTransporte rutatransporte: rutatransportes) {			
			if(rutatransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=rutatransporte.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RutaTransporteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRutaTransporte() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_ID, RutaTransporteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_VERSIONROW, RutaTransporteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_IDEMPRESA, RutaTransporteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_NOMBRE, RutaTransporteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_ORIGEN, RutaTransporteConstantesFunciones.ORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_DESTINO, RutaTransporteConstantesFunciones.DESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RutaTransporteConstantesFunciones.LABEL_PRECIO, RutaTransporteConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRutaTransporte() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.ORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.DESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RutaTransporteConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRutaTransporte() throws Exception  {
		return RutaTransporteConstantesFunciones.getTiposSeleccionarRutaTransporte(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRutaTransporte(Boolean conFk) throws Exception  {
		return RutaTransporteConstantesFunciones.getTiposSeleccionarRutaTransporte(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRutaTransporte(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaTransporteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaTransporteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaTransporteConstantesFunciones.LABEL_ORIGEN);
			reporte.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_ORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaTransporteConstantesFunciones.LABEL_DESTINO);
			reporte.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_DESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RutaTransporteConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(RutaTransporteConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRutaTransporte(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRutaTransporte(RutaTransporte rutatransporteAux) throws Exception {
		
			rutatransporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rutatransporteAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRutaTransporte(List<RutaTransporte> rutatransportesTemp) throws Exception {
		for(RutaTransporte rutatransporteAux:rutatransportesTemp) {
			
			rutatransporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rutatransporteAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRutaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRutaTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRutaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RutaTransporteConstantesFunciones.getClassesRelationshipsOfRutaTransporte(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRutaTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Proforma.class));
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(ServicioTransporte.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioTransporte.class)) {
						classes.add(new Classe(ServicioTransporte.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRutaTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RutaTransporteConstantesFunciones.getClassesRelationshipsFromStringsOfRutaTransporte(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRutaTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
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
	public static void actualizarLista(RutaTransporte rutatransporte,List<RutaTransporte> rutatransportes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RutaTransporte rutatransporteEncontrado=null;
			
			for(RutaTransporte rutatransporteLocal:rutatransportes) {
				if(rutatransporteLocal.getId().equals(rutatransporte.getId())) {
					rutatransporteEncontrado=rutatransporteLocal;
					
					rutatransporteLocal.setIsChanged(rutatransporte.getIsChanged());
					rutatransporteLocal.setIsNew(rutatransporte.getIsNew());
					rutatransporteLocal.setIsDeleted(rutatransporte.getIsDeleted());
					
					rutatransporteLocal.setGeneralEntityOriginal(rutatransporte.getGeneralEntityOriginal());
					
					rutatransporteLocal.setId(rutatransporte.getId());	
					rutatransporteLocal.setVersionRow(rutatransporte.getVersionRow());	
					rutatransporteLocal.setid_empresa(rutatransporte.getid_empresa());	
					rutatransporteLocal.setnombre(rutatransporte.getnombre());	
					rutatransporteLocal.setorigen(rutatransporte.getorigen());	
					rutatransporteLocal.setdestino(rutatransporte.getdestino());	
					rutatransporteLocal.setprecio(rutatransporte.getprecio());	
					
					
					rutatransporteLocal.setProformas(rutatransporte.getProformas());
					rutatransporteLocal.setPedidos(rutatransporte.getPedidos());
					rutatransporteLocal.setServicioTransportes(rutatransporte.getServicioTransportes());
					
					existe=true;
					break;
				}
			}
			
			if(!rutatransporte.getIsDeleted()) {
				if(!existe) {
					rutatransportes.add(rutatransporte);
				}
			} else {
				if(rutatransporteEncontrado!=null && permiteQuitar)  {
					rutatransportes.remove(rutatransporteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RutaTransporte rutatransporte,List<RutaTransporte> rutatransportes) throws Exception {
		try	{			
			for(RutaTransporte rutatransporteLocal:rutatransportes) {
				if(rutatransporteLocal.getId().equals(rutatransporte.getId())) {
					rutatransporteLocal.setIsSelected(rutatransporte.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRutaTransporte(List<RutaTransporte> rutatransportesAux) throws Exception {
		//this.rutatransportesAux=rutatransportesAux;
		
		for(RutaTransporte rutatransporteAux:rutatransportesAux) {
			if(rutatransporteAux.getIsChanged()) {
				rutatransporteAux.setIsChanged(false);
			}		
			
			if(rutatransporteAux.getIsNew()) {
				rutatransporteAux.setIsNew(false);
			}	
			
			if(rutatransporteAux.getIsDeleted()) {
				rutatransporteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRutaTransporte(RutaTransporte rutatransporteAux) throws Exception {
		//this.rutatransporteAux=rutatransporteAux;
		
			if(rutatransporteAux.getIsChanged()) {
				rutatransporteAux.setIsChanged(false);
			}		
			
			if(rutatransporteAux.getIsNew()) {
				rutatransporteAux.setIsNew(false);
			}	
			
			if(rutatransporteAux.getIsDeleted()) {
				rutatransporteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RutaTransporte rutatransporteAsignar,RutaTransporte rutatransporte) throws Exception {
		rutatransporteAsignar.setId(rutatransporte.getId());	
		rutatransporteAsignar.setVersionRow(rutatransporte.getVersionRow());	
		rutatransporteAsignar.setid_empresa(rutatransporte.getid_empresa());
		rutatransporteAsignar.setempresa_descripcion(rutatransporte.getempresa_descripcion());	
		rutatransporteAsignar.setnombre(rutatransporte.getnombre());	
		rutatransporteAsignar.setorigen(rutatransporte.getorigen());	
		rutatransporteAsignar.setdestino(rutatransporte.getdestino());	
		rutatransporteAsignar.setprecio(rutatransporte.getprecio());	
	}
	
	public static void inicializarRutaTransporte(RutaTransporte rutatransporte) throws Exception {
		try {
				rutatransporte.setId(0L);	
					
				rutatransporte.setid_empresa(-1L);	
				rutatransporte.setnombre("");	
				rutatransporte.setorigen("");	
				rutatransporte.setdestino("");	
				rutatransporte.setprecio(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRutaTransporte(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaTransporteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaTransporteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaTransporteConstantesFunciones.LABEL_ORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaTransporteConstantesFunciones.LABEL_DESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RutaTransporteConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRutaTransporte(String sTipo,Row row,Workbook workbook,RutaTransporte rutatransporte,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rutatransporte.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rutatransporte.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rutatransporte.getorigen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rutatransporte.getdestino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rutatransporte.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRutaTransporte=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRutaTransporte() {
		return this.sFinalQueryRutaTransporte;
	}
	
	public void setsFinalQueryRutaTransporte(String sFinalQueryRutaTransporte) {
		this.sFinalQueryRutaTransporte= sFinalQueryRutaTransporte;
	}
	
	public Border resaltarSeleccionarRutaTransporte=null;
	
	public Border setResaltarSeleccionarRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRutaTransporte= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRutaTransporte() {
		return this.resaltarSeleccionarRutaTransporte;
	}
	
	public void setResaltarSeleccionarRutaTransporte(Border borderResaltarSeleccionarRutaTransporte) {
		this.resaltarSeleccionarRutaTransporte= borderResaltarSeleccionarRutaTransporte;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRutaTransporte=null;
	public Boolean mostraridRutaTransporte=true;
	public Boolean activaridRutaTransporte=true;

	public Border resaltarid_empresaRutaTransporte=null;
	public Boolean mostrarid_empresaRutaTransporte=true;
	public Boolean activarid_empresaRutaTransporte=true;
	public Boolean cargarid_empresaRutaTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRutaTransporte=false;//ConEventDepend=true

	public Border resaltarnombreRutaTransporte=null;
	public Boolean mostrarnombreRutaTransporte=true;
	public Boolean activarnombreRutaTransporte=true;

	public Border resaltarorigenRutaTransporte=null;
	public Boolean mostrarorigenRutaTransporte=true;
	public Boolean activarorigenRutaTransporte=true;

	public Border resaltardestinoRutaTransporte=null;
	public Boolean mostrardestinoRutaTransporte=true;
	public Boolean activardestinoRutaTransporte=true;

	public Border resaltarprecioRutaTransporte=null;
	public Boolean mostrarprecioRutaTransporte=true;
	public Boolean activarprecioRutaTransporte=true;

	
	

	public Border setResaltaridRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltaridRutaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRutaTransporte() {
		return this.resaltaridRutaTransporte;
	}

	public void setResaltaridRutaTransporte(Border borderResaltar) {
		this.resaltaridRutaTransporte= borderResaltar;
	}

	public Boolean getMostraridRutaTransporte() {
		return this.mostraridRutaTransporte;
	}

	public void setMostraridRutaTransporte(Boolean mostraridRutaTransporte) {
		this.mostraridRutaTransporte= mostraridRutaTransporte;
	}

	public Boolean getActivaridRutaTransporte() {
		return this.activaridRutaTransporte;
	}

	public void setActivaridRutaTransporte(Boolean activaridRutaTransporte) {
		this.activaridRutaTransporte= activaridRutaTransporte;
	}

	public Border setResaltarid_empresaRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltarid_empresaRutaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRutaTransporte() {
		return this.resaltarid_empresaRutaTransporte;
	}

	public void setResaltarid_empresaRutaTransporte(Border borderResaltar) {
		this.resaltarid_empresaRutaTransporte= borderResaltar;
	}

	public Boolean getMostrarid_empresaRutaTransporte() {
		return this.mostrarid_empresaRutaTransporte;
	}

	public void setMostrarid_empresaRutaTransporte(Boolean mostrarid_empresaRutaTransporte) {
		this.mostrarid_empresaRutaTransporte= mostrarid_empresaRutaTransporte;
	}

	public Boolean getActivarid_empresaRutaTransporte() {
		return this.activarid_empresaRutaTransporte;
	}

	public void setActivarid_empresaRutaTransporte(Boolean activarid_empresaRutaTransporte) {
		this.activarid_empresaRutaTransporte= activarid_empresaRutaTransporte;
	}

	public Boolean getCargarid_empresaRutaTransporte() {
		return this.cargarid_empresaRutaTransporte;
	}

	public void setCargarid_empresaRutaTransporte(Boolean cargarid_empresaRutaTransporte) {
		this.cargarid_empresaRutaTransporte= cargarid_empresaRutaTransporte;
	}

	public Border setResaltarnombreRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltarnombreRutaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreRutaTransporte() {
		return this.resaltarnombreRutaTransporte;
	}

	public void setResaltarnombreRutaTransporte(Border borderResaltar) {
		this.resaltarnombreRutaTransporte= borderResaltar;
	}

	public Boolean getMostrarnombreRutaTransporte() {
		return this.mostrarnombreRutaTransporte;
	}

	public void setMostrarnombreRutaTransporte(Boolean mostrarnombreRutaTransporte) {
		this.mostrarnombreRutaTransporte= mostrarnombreRutaTransporte;
	}

	public Boolean getActivarnombreRutaTransporte() {
		return this.activarnombreRutaTransporte;
	}

	public void setActivarnombreRutaTransporte(Boolean activarnombreRutaTransporte) {
		this.activarnombreRutaTransporte= activarnombreRutaTransporte;
	}

	public Border setResaltarorigenRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltarorigenRutaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorigenRutaTransporte() {
		return this.resaltarorigenRutaTransporte;
	}

	public void setResaltarorigenRutaTransporte(Border borderResaltar) {
		this.resaltarorigenRutaTransporte= borderResaltar;
	}

	public Boolean getMostrarorigenRutaTransporte() {
		return this.mostrarorigenRutaTransporte;
	}

	public void setMostrarorigenRutaTransporte(Boolean mostrarorigenRutaTransporte) {
		this.mostrarorigenRutaTransporte= mostrarorigenRutaTransporte;
	}

	public Boolean getActivarorigenRutaTransporte() {
		return this.activarorigenRutaTransporte;
	}

	public void setActivarorigenRutaTransporte(Boolean activarorigenRutaTransporte) {
		this.activarorigenRutaTransporte= activarorigenRutaTransporte;
	}

	public Border setResaltardestinoRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltardestinoRutaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardestinoRutaTransporte() {
		return this.resaltardestinoRutaTransporte;
	}

	public void setResaltardestinoRutaTransporte(Border borderResaltar) {
		this.resaltardestinoRutaTransporte= borderResaltar;
	}

	public Boolean getMostrardestinoRutaTransporte() {
		return this.mostrardestinoRutaTransporte;
	}

	public void setMostrardestinoRutaTransporte(Boolean mostrardestinoRutaTransporte) {
		this.mostrardestinoRutaTransporte= mostrardestinoRutaTransporte;
	}

	public Boolean getActivardestinoRutaTransporte() {
		return this.activardestinoRutaTransporte;
	}

	public void setActivardestinoRutaTransporte(Boolean activardestinoRutaTransporte) {
		this.activardestinoRutaTransporte= activardestinoRutaTransporte;
	}

	public Border setResaltarprecioRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltar);
		
		this.resaltarprecioRutaTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioRutaTransporte() {
		return this.resaltarprecioRutaTransporte;
	}

	public void setResaltarprecioRutaTransporte(Border borderResaltar) {
		this.resaltarprecioRutaTransporte= borderResaltar;
	}

	public Boolean getMostrarprecioRutaTransporte() {
		return this.mostrarprecioRutaTransporte;
	}

	public void setMostrarprecioRutaTransporte(Boolean mostrarprecioRutaTransporte) {
		this.mostrarprecioRutaTransporte= mostrarprecioRutaTransporte;
	}

	public Boolean getActivarprecioRutaTransporte() {
		return this.activarprecioRutaTransporte;
	}

	public void setActivarprecioRutaTransporte(Boolean activarprecioRutaTransporte) {
		this.activarprecioRutaTransporte= activarprecioRutaTransporte;
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
		
		
		this.setMostraridRutaTransporte(esInicial);
		this.setMostrarid_empresaRutaTransporte(esInicial);
		this.setMostrarnombreRutaTransporte(esInicial);
		this.setMostrarorigenRutaTransporte(esInicial);
		this.setMostrardestinoRutaTransporte(esInicial);
		this.setMostrarprecioRutaTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RutaTransporteConstantesFunciones.ID)) {
				this.setMostraridRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.ORIGEN)) {
				this.setMostrarorigenRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.DESTINO)) {
				this.setMostrardestinoRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.PRECIO)) {
				this.setMostrarprecioRutaTransporte(esAsigna);
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
		
		
		this.setActivaridRutaTransporte(esInicial);
		this.setActivarid_empresaRutaTransporte(esInicial);
		this.setActivarnombreRutaTransporte(esInicial);
		this.setActivarorigenRutaTransporte(esInicial);
		this.setActivardestinoRutaTransporte(esInicial);
		this.setActivarprecioRutaTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RutaTransporteConstantesFunciones.ID)) {
				this.setActivaridRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.ORIGEN)) {
				this.setActivarorigenRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.DESTINO)) {
				this.setActivardestinoRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.PRECIO)) {
				this.setActivarprecioRutaTransporte(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRutaTransporte(esInicial);
		this.setResaltarid_empresaRutaTransporte(esInicial);
		this.setResaltarnombreRutaTransporte(esInicial);
		this.setResaltarorigenRutaTransporte(esInicial);
		this.setResaltardestinoRutaTransporte(esInicial);
		this.setResaltarprecioRutaTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RutaTransporteConstantesFunciones.ID)) {
				this.setResaltaridRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.ORIGEN)) {
				this.setResaltarorigenRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.DESTINO)) {
				this.setResaltardestinoRutaTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(RutaTransporteConstantesFunciones.PRECIO)) {
				this.setResaltarprecioRutaTransporte(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProformaRutaTransporte=null;

	public Border getResaltarProformaRutaTransporte() {
		return this.resaltarProformaRutaTransporte;
	}

	public void setResaltarProformaRutaTransporte(Border borderResaltarProforma) {
		if(borderResaltarProforma!=null) {
			this.resaltarProformaRutaTransporte= borderResaltarProforma;
		}
	}

	public Border setResaltarProformaRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltarProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltarProforma);
			
		this.resaltarProformaRutaTransporte= borderResaltarProforma;

		 return borderResaltarProforma;
	}



	public Boolean mostrarProformaRutaTransporte=true;

	public Boolean getMostrarProformaRutaTransporte() {
		return this.mostrarProformaRutaTransporte;
	}

	public void setMostrarProformaRutaTransporte(Boolean visibilidadResaltarProforma) {
		this.mostrarProformaRutaTransporte= visibilidadResaltarProforma;
	}



	public Boolean activarProformaRutaTransporte=true;

	public Boolean gethabilitarResaltarProformaRutaTransporte() {
		return this.activarProformaRutaTransporte;
	}

	public void setActivarProformaRutaTransporte(Boolean habilitarResaltarProforma) {
		this.activarProformaRutaTransporte= habilitarResaltarProforma;
	}


	public Border resaltarPedidoRutaTransporte=null;

	public Border getResaltarPedidoRutaTransporte() {
		return this.resaltarPedidoRutaTransporte;
	}

	public void setResaltarPedidoRutaTransporte(Border borderResaltarPedido) {
		if(borderResaltarPedido!=null) {
			this.resaltarPedidoRutaTransporte= borderResaltarPedido;
		}
	}

	public Border setResaltarPedidoRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltarPedido=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltarPedido);
			
		this.resaltarPedidoRutaTransporte= borderResaltarPedido;

		 return borderResaltarPedido;
	}



	public Boolean mostrarPedidoRutaTransporte=true;

	public Boolean getMostrarPedidoRutaTransporte() {
		return this.mostrarPedidoRutaTransporte;
	}

	public void setMostrarPedidoRutaTransporte(Boolean visibilidadResaltarPedido) {
		this.mostrarPedidoRutaTransporte= visibilidadResaltarPedido;
	}



	public Boolean activarPedidoRutaTransporte=true;

	public Boolean gethabilitarResaltarPedidoRutaTransporte() {
		return this.activarPedidoRutaTransporte;
	}

	public void setActivarPedidoRutaTransporte(Boolean habilitarResaltarPedido) {
		this.activarPedidoRutaTransporte= habilitarResaltarPedido;
	}


	public Border resaltarServicioTransporteRutaTransporte=null;

	public Border getResaltarServicioTransporteRutaTransporte() {
		return this.resaltarServicioTransporteRutaTransporte;
	}

	public void setResaltarServicioTransporteRutaTransporte(Border borderResaltarServicioTransporte) {
		if(borderResaltarServicioTransporte!=null) {
			this.resaltarServicioTransporteRutaTransporte= borderResaltarServicioTransporte;
		}
	}

	public Border setResaltarServicioTransporteRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltarServicioTransporte=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rutatransporteBeanSwingJInternalFrame.jTtoolBarRutaTransporte.setBorder(borderResaltarServicioTransporte);
			
		this.resaltarServicioTransporteRutaTransporte= borderResaltarServicioTransporte;

		 return borderResaltarServicioTransporte;
	}



	public Boolean mostrarServicioTransporteRutaTransporte=true;

	public Boolean getMostrarServicioTransporteRutaTransporte() {
		return this.mostrarServicioTransporteRutaTransporte;
	}

	public void setMostrarServicioTransporteRutaTransporte(Boolean visibilidadResaltarServicioTransporte) {
		this.mostrarServicioTransporteRutaTransporte= visibilidadResaltarServicioTransporte;
	}



	public Boolean activarServicioTransporteRutaTransporte=true;

	public Boolean gethabilitarResaltarServicioTransporteRutaTransporte() {
		return this.activarServicioTransporteRutaTransporte;
	}

	public void setActivarServicioTransporteRutaTransporte(Boolean habilitarResaltarServicioTransporte) {
		this.activarServicioTransporteRutaTransporte= habilitarResaltarServicioTransporte;
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

		this.setMostrarProformaRutaTransporte(esInicial);
		this.setMostrarPedidoRutaTransporte(esInicial);
		this.setMostrarServicioTransporteRutaTransporte(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setMostrarProformaRutaTransporte(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setMostrarPedidoRutaTransporte(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setMostrarServicioTransporteRutaTransporte(esAsigna);
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

		this.setActivarProformaRutaTransporte(esInicial);
		this.setActivarPedidoRutaTransporte(esInicial);
		this.setActivarServicioTransporteRutaTransporte(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setActivarProformaRutaTransporte(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setActivarPedidoRutaTransporte(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setActivarServicioTransporteRutaTransporte(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProformaRutaTransporte(esInicial);
		this.setResaltarPedidoRutaTransporte(esInicial);
		this.setResaltarServicioTransporteRutaTransporte(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Proforma.class)) {
				this.setResaltarProformaRutaTransporte(esAsigna);
				continue;
			}

			if(clase.clas.equals(Pedido.class)) {
				this.setResaltarPedidoRutaTransporte(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setResaltarServicioTransporteRutaTransporte(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorDestinoRutaTransporte=true;

	public Boolean getMostrarBusquedaPorDestinoRutaTransporte() {
		return this.mostrarBusquedaPorDestinoRutaTransporte;
	}

	public void setMostrarBusquedaPorDestinoRutaTransporte(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorDestinoRutaTransporte= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreRutaTransporte=true;

	public Boolean getMostrarBusquedaPorNombreRutaTransporte() {
		return this.mostrarBusquedaPorNombreRutaTransporte;
	}

	public void setMostrarBusquedaPorNombreRutaTransporte(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreRutaTransporte= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorOrigenRutaTransporte=true;

	public Boolean getMostrarBusquedaPorOrigenRutaTransporte() {
		return this.mostrarBusquedaPorOrigenRutaTransporte;
	}

	public void setMostrarBusquedaPorOrigenRutaTransporte(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorOrigenRutaTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRutaTransporte=true;

	public Boolean getMostrarFK_IdEmpresaRutaTransporte() {
		return this.mostrarFK_IdEmpresaRutaTransporte;
	}

	public void setMostrarFK_IdEmpresaRutaTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRutaTransporte= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorDestinoRutaTransporte=true;

	public Boolean getActivarBusquedaPorDestinoRutaTransporte() {
		return this.activarBusquedaPorDestinoRutaTransporte;
	}

	public void setActivarBusquedaPorDestinoRutaTransporte(Boolean habilitarResaltar) {
		this.activarBusquedaPorDestinoRutaTransporte= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreRutaTransporte=true;

	public Boolean getActivarBusquedaPorNombreRutaTransporte() {
		return this.activarBusquedaPorNombreRutaTransporte;
	}

	public void setActivarBusquedaPorNombreRutaTransporte(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreRutaTransporte= habilitarResaltar;
	}

	public Boolean activarBusquedaPorOrigenRutaTransporte=true;

	public Boolean getActivarBusquedaPorOrigenRutaTransporte() {
		return this.activarBusquedaPorOrigenRutaTransporte;
	}

	public void setActivarBusquedaPorOrigenRutaTransporte(Boolean habilitarResaltar) {
		this.activarBusquedaPorOrigenRutaTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRutaTransporte=true;

	public Boolean getActivarFK_IdEmpresaRutaTransporte() {
		return this.activarFK_IdEmpresaRutaTransporte;
	}

	public void setActivarFK_IdEmpresaRutaTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRutaTransporte= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorDestinoRutaTransporte=null;

	public Border getResaltarBusquedaPorDestinoRutaTransporte() {
		return this.resaltarBusquedaPorDestinoRutaTransporte;
	}

	public void setResaltarBusquedaPorDestinoRutaTransporte(Border borderResaltar) {
		this.resaltarBusquedaPorDestinoRutaTransporte= borderResaltar;
	}

	public void setResaltarBusquedaPorDestinoRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorDestinoRutaTransporte= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreRutaTransporte=null;

	public Border getResaltarBusquedaPorNombreRutaTransporte() {
		return this.resaltarBusquedaPorNombreRutaTransporte;
	}

	public void setResaltarBusquedaPorNombreRutaTransporte(Border borderResaltar) {
		this.resaltarBusquedaPorNombreRutaTransporte= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreRutaTransporte= borderResaltar;
	}

	public Border resaltarBusquedaPorOrigenRutaTransporte=null;

	public Border getResaltarBusquedaPorOrigenRutaTransporte() {
		return this.resaltarBusquedaPorOrigenRutaTransporte;
	}

	public void setResaltarBusquedaPorOrigenRutaTransporte(Border borderResaltar) {
		this.resaltarBusquedaPorOrigenRutaTransporte= borderResaltar;
	}

	public void setResaltarBusquedaPorOrigenRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorOrigenRutaTransporte= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRutaTransporte=null;

	public Border getResaltarFK_IdEmpresaRutaTransporte() {
		return this.resaltarFK_IdEmpresaRutaTransporte;
	}

	public void setResaltarFK_IdEmpresaRutaTransporte(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRutaTransporte= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRutaTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*RutaTransporteBeanSwingJInternalFrame rutatransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRutaTransporte= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}