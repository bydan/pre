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


import com.bydan.erp.inventario.util.PuertoConstantesFunciones;
import com.bydan.erp.inventario.util.PuertoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PuertoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PuertoConstantesFunciones extends PuertoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Puerto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Puerto"+PuertoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PuertoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PuertoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PuertoConstantesFunciones.SCHEMA+"_"+PuertoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PuertoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PuertoConstantesFunciones.SCHEMA+"_"+PuertoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PuertoConstantesFunciones.SCHEMA+"_"+PuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PuertoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PuertoConstantesFunciones.SCHEMA+"_"+PuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuertoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PuertoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuertoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PuertoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PuertoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PuertoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PuertoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PuertoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PuertoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Puertoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Puerto";
	public static final String SCLASSWEBTITULO_LOWER="Puerto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Puerto";
	public static final String OBJECTNAME="puerto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="puerto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select puerto from "+PuertoConstantesFunciones.SPERSISTENCENAME+" puerto";
	public static String QUERYSELECTNATIVE="select "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".version_row,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id_tipo_puerto,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id_pais,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".nombre,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".es_local,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".descripcion from "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME;//+" as "+PuertoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PuertoConstantesFuncionesAdditional puertoConstantesFuncionesAdditional=null;
	
	public PuertoConstantesFuncionesAdditional getPuertoConstantesFuncionesAdditional() {
		return this.puertoConstantesFuncionesAdditional;
	}
	
	public void setPuertoConstantesFuncionesAdditional(PuertoConstantesFuncionesAdditional puertoConstantesFuncionesAdditional) {
		try {
			this.puertoConstantesFuncionesAdditional=puertoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOPUERTO= "id_tipo_puerto";
    public static final String IDPAIS= "id_pais";
    public static final String NOMBRE= "nombre";
    public static final String ESLOCAL= "es_local";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOPUERTO= "Tipo Puerto";
		public static final String LABEL_IDTIPOPUERTO_LOWER= "Tipo Puerto";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESLOCAL= "Es Local";
		public static final String LABEL_ESLOCAL_LOWER= "Es Local";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPuertoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PuertoConstantesFunciones.IDTIPOPUERTO)) {sLabelColumna=PuertoConstantesFunciones.LABEL_IDTIPOPUERTO;}
		if(sNombreColumna.equals(PuertoConstantesFunciones.IDPAIS)) {sLabelColumna=PuertoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(PuertoConstantesFunciones.NOMBRE)) {sLabelColumna=PuertoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PuertoConstantesFunciones.ESLOCAL)) {sLabelColumna=PuertoConstantesFunciones.LABEL_ESLOCAL;}
		if(sNombreColumna.equals(PuertoConstantesFunciones.DESCRIPCION)) {sLabelColumna=PuertoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_localDescripcion(Puerto puerto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!puerto.getes_local()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_localHtmlDescripcion(Puerto puerto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(puerto.getId(),puerto.getes_local());

		return sDescripcion;
	}	
			
	
	public static String getPuertoDescripcion(Puerto puerto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(puerto !=null/* && puerto.getId()!=0*/) {
			sDescripcion=puerto.getnombre();//puertopuerto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPuertoDescripcionDetallado(Puerto puerto) {
		String sDescripcion="";
			
		sDescripcion+=PuertoConstantesFunciones.ID+"=";
		sDescripcion+=puerto.getId().toString()+",";
		sDescripcion+=PuertoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=puerto.getVersionRow().toString()+",";
		sDescripcion+=PuertoConstantesFunciones.IDTIPOPUERTO+"=";
		sDescripcion+=puerto.getid_tipo_puerto().toString()+",";
		sDescripcion+=PuertoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=puerto.getid_pais().toString()+",";
		sDescripcion+=PuertoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=puerto.getnombre()+",";
		sDescripcion+=PuertoConstantesFunciones.ESLOCAL+"=";
		sDescripcion+=puerto.getes_local().toString()+",";
		sDescripcion+=PuertoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=puerto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPuertoDescripcion(Puerto puerto,String sValor) throws Exception {			
		if(puerto !=null) {
			puerto.setnombre(sValor);//puertopuerto.getId().toString();
		}		
	}
	
		

	public static String getTipoPuertoDescripcion(TipoPuerto tipopuerto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipopuerto!=null/*&&tipopuerto.getId()>0*/) {
			sDescripcion=TipoPuertoConstantesFunciones.getTipoPuertoDescripcion(tipopuerto);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdTipoPuerto")) {
			sNombreIndice="Tipo=  Por Tipo Puerto";
		} else if(sNombreIndice.equals("PorIdPaisPorNombre")) {
			sNombreIndice="Tipo=  Por Pais Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPuerto(Long id_tipo_puerto) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_puerto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Puerto="+id_tipo_puerto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPaisPorNombre(Long id_pais,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPuerto(Puerto puerto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		puerto.setnombre(puerto.getnombre().trim());
		puerto.setdescripcion(puerto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPuertos(List<Puerto> puertos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Puerto puerto: puertos) {
			puerto.setnombre(puerto.getnombre().trim());
			puerto.setdescripcion(puerto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPuerto(Puerto puerto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && puerto.getConCambioAuxiliar()) {
			puerto.setIsDeleted(puerto.getIsDeletedAuxiliar());	
			puerto.setIsNew(puerto.getIsNewAuxiliar());	
			puerto.setIsChanged(puerto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			puerto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			puerto.setIsDeletedAuxiliar(false);	
			puerto.setIsNewAuxiliar(false);	
			puerto.setIsChangedAuxiliar(false);
			
			puerto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPuertos(List<Puerto> puertos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Puerto puerto : puertos) {
			if(conAsignarBase && puerto.getConCambioAuxiliar()) {
				puerto.setIsDeleted(puerto.getIsDeletedAuxiliar());	
				puerto.setIsNew(puerto.getIsNewAuxiliar());	
				puerto.setIsChanged(puerto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				puerto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				puerto.setIsDeletedAuxiliar(false);	
				puerto.setIsNewAuxiliar(false);	
				puerto.setIsChangedAuxiliar(false);
				
				puerto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPuerto(Puerto puerto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPuertos(List<Puerto> puertos,Boolean conEnteros) throws Exception  {
		
		for(Puerto puerto: puertos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPuerto(List<Puerto> puertos,Puerto puertoAux) throws Exception  {
		PuertoConstantesFunciones.InicializarValoresPuerto(puertoAux,true);
		
		for(Puerto puerto: puertos) {
			if(puerto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPuerto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PuertoConstantesFunciones.getArrayColumnasGlobalesPuerto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPuerto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPuerto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Puerto> puertos,Puerto puerto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Puerto puertoAux: puertos) {
			if(puertoAux!=null && puerto!=null) {
				if((puertoAux.getId()==null && puerto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(puertoAux.getId()!=null && puerto.getId()!=null){
					if(puertoAux.getId().equals(puerto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPuerto(List<Puerto> puertos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Puerto puerto: puertos) {			
			if(puerto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPuerto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_ID, PuertoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_VERSIONROW, PuertoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_IDTIPOPUERTO, PuertoConstantesFunciones.IDTIPOPUERTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_IDPAIS, PuertoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_NOMBRE, PuertoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_ESLOCAL, PuertoConstantesFunciones.ESLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PuertoConstantesFunciones.LABEL_DESCRIPCION, PuertoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPuerto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.IDTIPOPUERTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.ESLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PuertoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuerto() throws Exception  {
		return PuertoConstantesFunciones.getTiposSeleccionarPuerto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuerto(Boolean conFk) throws Exception  {
		return PuertoConstantesFunciones.getTiposSeleccionarPuerto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPuerto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PuertoConstantesFunciones.LABEL_IDTIPOPUERTO);
			reporte.setsDescripcion(PuertoConstantesFunciones.LABEL_IDTIPOPUERTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PuertoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(PuertoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PuertoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PuertoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PuertoConstantesFunciones.LABEL_ESLOCAL);
			reporte.setsDescripcion(PuertoConstantesFunciones.LABEL_ESLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PuertoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PuertoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPuerto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPuerto(Puerto puertoAux) throws Exception {
		
			puertoAux.settipopuerto_descripcion(TipoPuertoConstantesFunciones.getTipoPuertoDescripcion(puertoAux.getTipoPuerto()));
			puertoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(puertoAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPuerto(List<Puerto> puertosTemp) throws Exception {
		for(Puerto puertoAux:puertosTemp) {
			
			puertoAux.settipopuerto_descripcion(TipoPuertoConstantesFunciones.getTipoPuertoDescripcion(puertoAux.getTipoPuerto()));
			puertoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(puertoAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoPuerto.class));
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPuerto.class)) {
						classes.add(new Classe(TipoPuerto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPuerto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoPuerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPuerto.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoPuerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPuerto.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PuertoConstantesFunciones.getClassesRelationshipsOfPuerto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPuerto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoCompraImpor.class));
				classes.add(new Classe(LiquidacionImpor.class));
				classes.add(new Classe(Embarcador.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompraImpor.class)) {
						classes.add(new Classe(PedidoCompraImpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(LiquidacionImpor.class)) {
						classes.add(new Classe(LiquidacionImpor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Embarcador.class)) {
						classes.add(new Classe(Embarcador.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPuerto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PuertoConstantesFunciones.getClassesRelationshipsFromStringsOfPuerto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPuerto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(LiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpor.class)); continue;
					}

					if(Embarcador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Embarcador.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(LiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LiquidacionImpor.class)); continue;
					}

					if(Embarcador.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Embarcador.class)); continue;
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
	public static void actualizarLista(Puerto puerto,List<Puerto> puertos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Puerto puertoEncontrado=null;
			
			for(Puerto puertoLocal:puertos) {
				if(puertoLocal.getId().equals(puerto.getId())) {
					puertoEncontrado=puertoLocal;
					
					puertoLocal.setIsChanged(puerto.getIsChanged());
					puertoLocal.setIsNew(puerto.getIsNew());
					puertoLocal.setIsDeleted(puerto.getIsDeleted());
					
					puertoLocal.setGeneralEntityOriginal(puerto.getGeneralEntityOriginal());
					
					puertoLocal.setId(puerto.getId());	
					puertoLocal.setVersionRow(puerto.getVersionRow());	
					puertoLocal.setid_tipo_puerto(puerto.getid_tipo_puerto());	
					puertoLocal.setid_pais(puerto.getid_pais());	
					puertoLocal.setnombre(puerto.getnombre());	
					puertoLocal.setes_local(puerto.getes_local());	
					puertoLocal.setdescripcion(puerto.getdescripcion());	
					
					
					puertoLocal.setPedidoCompraImpors(puerto.getPedidoCompraImpors());
					puertoLocal.setLiquidacionImpors(puerto.getLiquidacionImpors());
					puertoLocal.setEmbarcadors(puerto.getEmbarcadors());
					
					existe=true;
					break;
				}
			}
			
			if(!puerto.getIsDeleted()) {
				if(!existe) {
					puertos.add(puerto);
				}
			} else {
				if(puertoEncontrado!=null && permiteQuitar)  {
					puertos.remove(puertoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Puerto puerto,List<Puerto> puertos) throws Exception {
		try	{			
			for(Puerto puertoLocal:puertos) {
				if(puertoLocal.getId().equals(puerto.getId())) {
					puertoLocal.setIsSelected(puerto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPuerto(List<Puerto> puertosAux) throws Exception {
		//this.puertosAux=puertosAux;
		
		for(Puerto puertoAux:puertosAux) {
			if(puertoAux.getIsChanged()) {
				puertoAux.setIsChanged(false);
			}		
			
			if(puertoAux.getIsNew()) {
				puertoAux.setIsNew(false);
			}	
			
			if(puertoAux.getIsDeleted()) {
				puertoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPuerto(Puerto puertoAux) throws Exception {
		//this.puertoAux=puertoAux;
		
			if(puertoAux.getIsChanged()) {
				puertoAux.setIsChanged(false);
			}		
			
			if(puertoAux.getIsNew()) {
				puertoAux.setIsNew(false);
			}	
			
			if(puertoAux.getIsDeleted()) {
				puertoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Puerto puertoAsignar,Puerto puerto) throws Exception {
		puertoAsignar.setId(puerto.getId());	
		puertoAsignar.setVersionRow(puerto.getVersionRow());	
		puertoAsignar.setid_tipo_puerto(puerto.getid_tipo_puerto());
		puertoAsignar.settipopuerto_descripcion(puerto.gettipopuerto_descripcion());	
		puertoAsignar.setid_pais(puerto.getid_pais());
		puertoAsignar.setpais_descripcion(puerto.getpais_descripcion());	
		puertoAsignar.setnombre(puerto.getnombre());	
		puertoAsignar.setes_local(puerto.getes_local());	
		puertoAsignar.setdescripcion(puerto.getdescripcion());	
	}
	
	public static void inicializarPuerto(Puerto puerto) throws Exception {
		try {
				puerto.setId(0L);	
					
				puerto.setid_tipo_puerto(-1L);	
				puerto.setid_pais(-1L);	
				puerto.setnombre("");	
				puerto.setes_local(false);	
				puerto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPuerto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PuertoConstantesFunciones.LABEL_IDTIPOPUERTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PuertoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PuertoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PuertoConstantesFunciones.LABEL_ESLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PuertoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPuerto(String sTipo,Row row,Workbook workbook,Puerto puerto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(puerto.gettipopuerto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(puerto.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(puerto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(puerto.getes_local()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(puerto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPuerto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPuerto() {
		return this.sFinalQueryPuerto;
	}
	
	public void setsFinalQueryPuerto(String sFinalQueryPuerto) {
		this.sFinalQueryPuerto= sFinalQueryPuerto;
	}
	
	public Border resaltarSeleccionarPuerto=null;
	
	public Border setResaltarSeleccionarPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPuerto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPuerto() {
		return this.resaltarSeleccionarPuerto;
	}
	
	public void setResaltarSeleccionarPuerto(Border borderResaltarSeleccionarPuerto) {
		this.resaltarSeleccionarPuerto= borderResaltarSeleccionarPuerto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPuerto=null;
	public Boolean mostraridPuerto=true;
	public Boolean activaridPuerto=true;

	public Border resaltarid_tipo_puertoPuerto=null;
	public Boolean mostrarid_tipo_puertoPuerto=true;
	public Boolean activarid_tipo_puertoPuerto=true;
	public Boolean cargarid_tipo_puertoPuerto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_puertoPuerto=false;//ConEventDepend=true

	public Border resaltarid_paisPuerto=null;
	public Boolean mostrarid_paisPuerto=true;
	public Boolean activarid_paisPuerto=true;
	public Boolean cargarid_paisPuerto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisPuerto=false;//ConEventDepend=true

	public Border resaltarnombrePuerto=null;
	public Boolean mostrarnombrePuerto=true;
	public Boolean activarnombrePuerto=true;

	public Border resaltares_localPuerto=null;
	public Boolean mostrares_localPuerto=true;
	public Boolean activares_localPuerto=true;

	public Border resaltardescripcionPuerto=null;
	public Boolean mostrardescripcionPuerto=true;
	public Boolean activardescripcionPuerto=true;

	
	

	public Border setResaltaridPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltaridPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPuerto() {
		return this.resaltaridPuerto;
	}

	public void setResaltaridPuerto(Border borderResaltar) {
		this.resaltaridPuerto= borderResaltar;
	}

	public Boolean getMostraridPuerto() {
		return this.mostraridPuerto;
	}

	public void setMostraridPuerto(Boolean mostraridPuerto) {
		this.mostraridPuerto= mostraridPuerto;
	}

	public Boolean getActivaridPuerto() {
		return this.activaridPuerto;
	}

	public void setActivaridPuerto(Boolean activaridPuerto) {
		this.activaridPuerto= activaridPuerto;
	}

	public Border setResaltarid_tipo_puertoPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_puertoPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_puertoPuerto() {
		return this.resaltarid_tipo_puertoPuerto;
	}

	public void setResaltarid_tipo_puertoPuerto(Border borderResaltar) {
		this.resaltarid_tipo_puertoPuerto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_puertoPuerto() {
		return this.mostrarid_tipo_puertoPuerto;
	}

	public void setMostrarid_tipo_puertoPuerto(Boolean mostrarid_tipo_puertoPuerto) {
		this.mostrarid_tipo_puertoPuerto= mostrarid_tipo_puertoPuerto;
	}

	public Boolean getActivarid_tipo_puertoPuerto() {
		return this.activarid_tipo_puertoPuerto;
	}

	public void setActivarid_tipo_puertoPuerto(Boolean activarid_tipo_puertoPuerto) {
		this.activarid_tipo_puertoPuerto= activarid_tipo_puertoPuerto;
	}

	public Boolean getCargarid_tipo_puertoPuerto() {
		return this.cargarid_tipo_puertoPuerto;
	}

	public void setCargarid_tipo_puertoPuerto(Boolean cargarid_tipo_puertoPuerto) {
		this.cargarid_tipo_puertoPuerto= cargarid_tipo_puertoPuerto;
	}

	public Border setResaltarid_paisPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltarid_paisPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisPuerto() {
		return this.resaltarid_paisPuerto;
	}

	public void setResaltarid_paisPuerto(Border borderResaltar) {
		this.resaltarid_paisPuerto= borderResaltar;
	}

	public Boolean getMostrarid_paisPuerto() {
		return this.mostrarid_paisPuerto;
	}

	public void setMostrarid_paisPuerto(Boolean mostrarid_paisPuerto) {
		this.mostrarid_paisPuerto= mostrarid_paisPuerto;
	}

	public Boolean getActivarid_paisPuerto() {
		return this.activarid_paisPuerto;
	}

	public void setActivarid_paisPuerto(Boolean activarid_paisPuerto) {
		this.activarid_paisPuerto= activarid_paisPuerto;
	}

	public Boolean getCargarid_paisPuerto() {
		return this.cargarid_paisPuerto;
	}

	public void setCargarid_paisPuerto(Boolean cargarid_paisPuerto) {
		this.cargarid_paisPuerto= cargarid_paisPuerto;
	}

	public Border setResaltarnombrePuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltarnombrePuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePuerto() {
		return this.resaltarnombrePuerto;
	}

	public void setResaltarnombrePuerto(Border borderResaltar) {
		this.resaltarnombrePuerto= borderResaltar;
	}

	public Boolean getMostrarnombrePuerto() {
		return this.mostrarnombrePuerto;
	}

	public void setMostrarnombrePuerto(Boolean mostrarnombrePuerto) {
		this.mostrarnombrePuerto= mostrarnombrePuerto;
	}

	public Boolean getActivarnombrePuerto() {
		return this.activarnombrePuerto;
	}

	public void setActivarnombrePuerto(Boolean activarnombrePuerto) {
		this.activarnombrePuerto= activarnombrePuerto;
	}

	public Border setResaltares_localPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltares_localPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_localPuerto() {
		return this.resaltares_localPuerto;
	}

	public void setResaltares_localPuerto(Border borderResaltar) {
		this.resaltares_localPuerto= borderResaltar;
	}

	public Boolean getMostrares_localPuerto() {
		return this.mostrares_localPuerto;
	}

	public void setMostrares_localPuerto(Boolean mostrares_localPuerto) {
		this.mostrares_localPuerto= mostrares_localPuerto;
	}

	public Boolean getActivares_localPuerto() {
		return this.activares_localPuerto;
	}

	public void setActivares_localPuerto(Boolean activares_localPuerto) {
		this.activares_localPuerto= activares_localPuerto;
	}

	public Border setResaltardescripcionPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltar);
		
		this.resaltardescripcionPuerto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPuerto() {
		return this.resaltardescripcionPuerto;
	}

	public void setResaltardescripcionPuerto(Border borderResaltar) {
		this.resaltardescripcionPuerto= borderResaltar;
	}

	public Boolean getMostrardescripcionPuerto() {
		return this.mostrardescripcionPuerto;
	}

	public void setMostrardescripcionPuerto(Boolean mostrardescripcionPuerto) {
		this.mostrardescripcionPuerto= mostrardescripcionPuerto;
	}

	public Boolean getActivardescripcionPuerto() {
		return this.activardescripcionPuerto;
	}

	public void setActivardescripcionPuerto(Boolean activardescripcionPuerto) {
		this.activardescripcionPuerto= activardescripcionPuerto;
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
		
		
		this.setMostraridPuerto(esInicial);
		this.setMostrarid_tipo_puertoPuerto(esInicial);
		this.setMostrarid_paisPuerto(esInicial);
		this.setMostrarnombrePuerto(esInicial);
		this.setMostrares_localPuerto(esInicial);
		this.setMostrardescripcionPuerto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuertoConstantesFunciones.ID)) {
				this.setMostraridPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.IDTIPOPUERTO)) {
				this.setMostrarid_tipo_puertoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.ESLOCAL)) {
				this.setMostrares_localPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPuerto(esAsigna);
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
		
		
		this.setActivaridPuerto(esInicial);
		this.setActivarid_tipo_puertoPuerto(esInicial);
		this.setActivarid_paisPuerto(esInicial);
		this.setActivarnombrePuerto(esInicial);
		this.setActivares_localPuerto(esInicial);
		this.setActivardescripcionPuerto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuertoConstantesFunciones.ID)) {
				this.setActivaridPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.IDTIPOPUERTO)) {
				this.setActivarid_tipo_puertoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.ESLOCAL)) {
				this.setActivares_localPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPuerto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPuerto(esInicial);
		this.setResaltarid_tipo_puertoPuerto(esInicial);
		this.setResaltarid_paisPuerto(esInicial);
		this.setResaltarnombrePuerto(esInicial);
		this.setResaltares_localPuerto(esInicial);
		this.setResaltardescripcionPuerto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PuertoConstantesFunciones.ID)) {
				this.setResaltaridPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.IDTIPOPUERTO)) {
				this.setResaltarid_tipo_puertoPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.ESLOCAL)) {
				this.setResaltares_localPuerto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PuertoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPuerto(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoCompraImporPuerto=null;

	public Border getResaltarPedidoCompraImporPuerto() {
		return this.resaltarPedidoCompraImporPuerto;
	}

	public void setResaltarPedidoCompraImporPuerto(Border borderResaltarPedidoCompraImpor) {
		if(borderResaltarPedidoCompraImpor!=null) {
			this.resaltarPedidoCompraImporPuerto= borderResaltarPedidoCompraImpor;
		}
	}

	public Border setResaltarPedidoCompraImporPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoCompraImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltarPedidoCompraImpor);
			
		this.resaltarPedidoCompraImporPuerto= borderResaltarPedidoCompraImpor;

		 return borderResaltarPedidoCompraImpor;
	}



	public Boolean mostrarPedidoCompraImporPuerto=true;

	public Boolean getMostrarPedidoCompraImporPuerto() {
		return this.mostrarPedidoCompraImporPuerto;
	}

	public void setMostrarPedidoCompraImporPuerto(Boolean visibilidadResaltarPedidoCompraImpor) {
		this.mostrarPedidoCompraImporPuerto= visibilidadResaltarPedidoCompraImpor;
	}



	public Boolean activarPedidoCompraImporPuerto=true;

	public Boolean gethabilitarResaltarPedidoCompraImporPuerto() {
		return this.activarPedidoCompraImporPuerto;
	}

	public void setActivarPedidoCompraImporPuerto(Boolean habilitarResaltarPedidoCompraImpor) {
		this.activarPedidoCompraImporPuerto= habilitarResaltarPedidoCompraImpor;
	}


	public Border resaltarLiquidacionImporPuerto=null;

	public Border getResaltarLiquidacionImporPuerto() {
		return this.resaltarLiquidacionImporPuerto;
	}

	public void setResaltarLiquidacionImporPuerto(Border borderResaltarLiquidacionImpor) {
		if(borderResaltarLiquidacionImpor!=null) {
			this.resaltarLiquidacionImporPuerto= borderResaltarLiquidacionImpor;
		}
	}

	public Border setResaltarLiquidacionImporPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltarLiquidacionImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltarLiquidacionImpor);
			
		this.resaltarLiquidacionImporPuerto= borderResaltarLiquidacionImpor;

		 return borderResaltarLiquidacionImpor;
	}



	public Boolean mostrarLiquidacionImporPuerto=true;

	public Boolean getMostrarLiquidacionImporPuerto() {
		return this.mostrarLiquidacionImporPuerto;
	}

	public void setMostrarLiquidacionImporPuerto(Boolean visibilidadResaltarLiquidacionImpor) {
		this.mostrarLiquidacionImporPuerto= visibilidadResaltarLiquidacionImpor;
	}



	public Boolean activarLiquidacionImporPuerto=true;

	public Boolean gethabilitarResaltarLiquidacionImporPuerto() {
		return this.activarLiquidacionImporPuerto;
	}

	public void setActivarLiquidacionImporPuerto(Boolean habilitarResaltarLiquidacionImpor) {
		this.activarLiquidacionImporPuerto= habilitarResaltarLiquidacionImpor;
	}


	public Border resaltarEmbarcadorPuerto=null;

	public Border getResaltarEmbarcadorPuerto() {
		return this.resaltarEmbarcadorPuerto;
	}

	public void setResaltarEmbarcadorPuerto(Border borderResaltarEmbarcador) {
		if(borderResaltarEmbarcador!=null) {
			this.resaltarEmbarcadorPuerto= borderResaltarEmbarcador;
		}
	}

	public Border setResaltarEmbarcadorPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmbarcador=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//puertoBeanSwingJInternalFrame.jTtoolBarPuerto.setBorder(borderResaltarEmbarcador);
			
		this.resaltarEmbarcadorPuerto= borderResaltarEmbarcador;

		 return borderResaltarEmbarcador;
	}



	public Boolean mostrarEmbarcadorPuerto=true;

	public Boolean getMostrarEmbarcadorPuerto() {
		return this.mostrarEmbarcadorPuerto;
	}

	public void setMostrarEmbarcadorPuerto(Boolean visibilidadResaltarEmbarcador) {
		this.mostrarEmbarcadorPuerto= visibilidadResaltarEmbarcador;
	}



	public Boolean activarEmbarcadorPuerto=true;

	public Boolean gethabilitarResaltarEmbarcadorPuerto() {
		return this.activarEmbarcadorPuerto;
	}

	public void setActivarEmbarcadorPuerto(Boolean habilitarResaltarEmbarcador) {
		this.activarEmbarcadorPuerto= habilitarResaltarEmbarcador;
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

		this.setMostrarPedidoCompraImporPuerto(esInicial);
		this.setMostrarLiquidacionImporPuerto(esInicial);
		this.setMostrarEmbarcadorPuerto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setMostrarPedidoCompraImporPuerto(esAsigna);
				continue;
			}

			if(clase.clas.equals(LiquidacionImpor.class)) {
				this.setMostrarLiquidacionImporPuerto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Embarcador.class)) {
				this.setMostrarEmbarcadorPuerto(esAsigna);
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

		this.setActivarPedidoCompraImporPuerto(esInicial);
		this.setActivarLiquidacionImporPuerto(esInicial);
		this.setActivarEmbarcadorPuerto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setActivarPedidoCompraImporPuerto(esAsigna);
				continue;
			}

			if(clase.clas.equals(LiquidacionImpor.class)) {
				this.setActivarLiquidacionImporPuerto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Embarcador.class)) {
				this.setActivarEmbarcadorPuerto(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoCompraImporPuerto(esInicial);
		this.setResaltarLiquidacionImporPuerto(esInicial);
		this.setResaltarEmbarcadorPuerto(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoCompraImpor.class)) {
				this.setResaltarPedidoCompraImporPuerto(esAsigna);
				continue;
			}

			if(clase.clas.equals(LiquidacionImpor.class)) {
				this.setResaltarLiquidacionImporPuerto(esAsigna);
				continue;
			}

			if(clase.clas.equals(Embarcador.class)) {
				this.setResaltarEmbarcadorPuerto(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombrePuerto=true;

	public Boolean getMostrarBusquedaPorNombrePuerto() {
		return this.mostrarBusquedaPorNombrePuerto;
	}

	public void setMostrarBusquedaPorNombrePuerto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePuerto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisPuerto=true;

	public Boolean getMostrarFK_IdPaisPuerto() {
		return this.mostrarFK_IdPaisPuerto;
	}

	public void setMostrarFK_IdPaisPuerto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisPuerto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPuertoPuerto=true;

	public Boolean getMostrarFK_IdTipoPuertoPuerto() {
		return this.mostrarFK_IdTipoPuertoPuerto;
	}

	public void setMostrarFK_IdTipoPuertoPuerto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPuertoPuerto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombrePuerto=true;

	public Boolean getActivarBusquedaPorNombrePuerto() {
		return this.activarBusquedaPorNombrePuerto;
	}

	public void setActivarBusquedaPorNombrePuerto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePuerto= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisPuerto=true;

	public Boolean getActivarFK_IdPaisPuerto() {
		return this.activarFK_IdPaisPuerto;
	}

	public void setActivarFK_IdPaisPuerto(Boolean habilitarResaltar) {
		this.activarFK_IdPaisPuerto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPuertoPuerto=true;

	public Boolean getActivarFK_IdTipoPuertoPuerto() {
		return this.activarFK_IdTipoPuertoPuerto;
	}

	public void setActivarFK_IdTipoPuertoPuerto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPuertoPuerto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombrePuerto=null;

	public Border getResaltarBusquedaPorNombrePuerto() {
		return this.resaltarBusquedaPorNombrePuerto;
	}

	public void setResaltarBusquedaPorNombrePuerto(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePuerto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePuerto= borderResaltar;
	}

	public Border resaltarFK_IdPaisPuerto=null;

	public Border getResaltarFK_IdPaisPuerto() {
		return this.resaltarFK_IdPaisPuerto;
	}

	public void setResaltarFK_IdPaisPuerto(Border borderResaltar) {
		this.resaltarFK_IdPaisPuerto= borderResaltar;
	}

	public void setResaltarFK_IdPaisPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisPuerto= borderResaltar;
	}

	public Border resaltarFK_IdTipoPuertoPuerto=null;

	public Border getResaltarFK_IdTipoPuertoPuerto() {
		return this.resaltarFK_IdTipoPuertoPuerto;
	}

	public void setResaltarFK_IdTipoPuertoPuerto(Border borderResaltar) {
		this.resaltarFK_IdTipoPuertoPuerto= borderResaltar;
	}

	public void setResaltarFK_IdTipoPuertoPuerto(ParametroGeneralUsuario parametroGeneralUsuario/*PuertoBeanSwingJInternalFrame puertoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPuertoPuerto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}