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


import com.bydan.erp.cartera.util.DatoConstitucionConstantesFunciones;
import com.bydan.erp.cartera.util.DatoConstitucionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DatoConstitucionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DatoConstitucionConstantesFunciones extends DatoConstitucionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DatoConstitucion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DatoConstitucion"+DatoConstitucionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DatoConstitucionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DatoConstitucionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DatoConstitucionConstantesFunciones.SCHEMA+"_"+DatoConstitucionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DatoConstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DatoConstitucionConstantesFunciones.SCHEMA+"_"+DatoConstitucionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DatoConstitucionConstantesFunciones.SCHEMA+"_"+DatoConstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DatoConstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DatoConstitucionConstantesFunciones.SCHEMA+"_"+DatoConstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoConstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoConstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoConstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoConstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoConstitucionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoConstitucionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DatoConstitucionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DatoConstitucionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DatoConstitucionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DatoConstitucionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dato Constituciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Dato Constitucion";
	public static final String SCLASSWEBTITULO_LOWER="Dato Constitucion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DatoConstitucion";
	public static final String OBJECTNAME="datoconstitucion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="datoconstitucion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select datoconstitucion from "+DatoConstitucionConstantesFunciones.SPERSISTENCENAME+" datoconstitucion";
	public static String QUERYSELECTNATIVE="select "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".id,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".version_row,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".idcliente,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".idvalorclientecompania,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".direccion,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".fechaconstitucion,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".capitalsuscrito,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".plazofiniquito,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".reservalegal,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".fechaestatuto,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".esactivo from "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME;//+" as "+DatoConstitucionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DatoConstitucionConstantesFuncionesAdditional datoconstitucionConstantesFuncionesAdditional=null;
	
	public DatoConstitucionConstantesFuncionesAdditional getDatoConstitucionConstantesFuncionesAdditional() {
		return this.datoconstitucionConstantesFuncionesAdditional;
	}
	
	public void setDatoConstitucionConstantesFuncionesAdditional(DatoConstitucionConstantesFuncionesAdditional datoconstitucionConstantesFuncionesAdditional) {
		try {
			this.datoconstitucionConstantesFuncionesAdditional=datoconstitucionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOCOMPANIA= "idvalorclientecompania";
    public static final String DIRECCION= "direccion";
    public static final String FECHACONSTITUCION= "fechaconstitucion";
    public static final String CAPITALSUSCRITO= "capitalsuscrito";
    public static final String PLAZOFINIQUITO= "plazofiniquito";
    public static final String RESERVALEGAL= "reservalegal";
    public static final String FECHAESTATUTO= "fechaestatuto";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOCOMPANIA= "Tipo Compania";
		public static final String LABEL_IDTIPOCOMPANIA_LOWER= "Tipo Compania";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_FECHACONSTITUCION= "Fecha Constitucion";
		public static final String LABEL_FECHACONSTITUCION_LOWER= "Fecha Constitucion";
    	public static final String LABEL_CAPITALSUSCRITO= "Capital Suscrito";
		public static final String LABEL_CAPITALSUSCRITO_LOWER= "Capital Suscrito";
    	public static final String LABEL_PLAZOFINIQUITO= "Plazo Finiquito";
		public static final String LABEL_PLAZOFINIQUITO_LOWER= "Plazo Finiquito";
    	public static final String LABEL_RESERVALEGAL= "Reserva Legal";
		public static final String LABEL_RESERVALEGAL_LOWER= "Reserva Legal";
    	public static final String LABEL_FECHAESTATUTO= "Fecha Estatuto";
		public static final String LABEL_FECHAESTATUTO_LOWER= "Fecha Estatuto";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getDatoConstitucionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.IDCLIENTE)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_IDTIPOCOMPANIA;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.DIRECCION)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.FECHACONSTITUCION)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_FECHACONSTITUCION;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.CAPITALSUSCRITO)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_CAPITALSUSCRITO;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.PLAZOFINIQUITO)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_PLAZOFINIQUITO;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.RESERVALEGAL)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_RESERVALEGAL;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.FECHAESTATUTO)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_FECHAESTATUTO;}
		if(sNombreColumna.equals(DatoConstitucionConstantesFunciones.ESACTIVO)) {sLabelColumna=DatoConstitucionConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(DatoConstitucion datoconstitucion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datoconstitucion.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(DatoConstitucion datoconstitucion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datoconstitucion.getId(),datoconstitucion.getesactivo());

		return sDescripcion;
	}	
	
	public static String getDatoConstitucionDescripcion(DatoConstitucion datoconstitucion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(datoconstitucion !=null/* && datoconstitucion.getId()!=0*/) {
			sDescripcion=datoconstitucion.getdireccion();//datoconstituciondatoconstitucion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDatoConstitucionDescripcionDetallado(DatoConstitucion datoconstitucion) {
		String sDescripcion="";
			
		sDescripcion+=DatoConstitucionConstantesFunciones.ID+"=";
		sDescripcion+=datoconstitucion.getId().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=datoconstitucion.getVersionRow().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=datoconstitucion.getidcliente().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA+"=";
		sDescripcion+=datoconstitucion.getidvalorclientecompania().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.DIRECCION+"=";
		sDescripcion+=datoconstitucion.getdireccion()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.FECHACONSTITUCION+"=";
		sDescripcion+=datoconstitucion.getfechaconstitucion().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.CAPITALSUSCRITO+"=";
		sDescripcion+=datoconstitucion.getcapitalsuscrito().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.PLAZOFINIQUITO+"=";
		sDescripcion+=datoconstitucion.getplazofiniquito().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.RESERVALEGAL+"=";
		sDescripcion+=datoconstitucion.getreservalegal().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.FECHAESTATUTO+"=";
		sDescripcion+=datoconstitucion.getfechaestatuto().toString()+",";
		sDescripcion+=DatoConstitucionConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=datoconstitucion.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDatoConstitucionDescripcion(DatoConstitucion datoconstitucion,String sValor) throws Exception {			
		if(datoconstitucion !=null) {
			datoconstitucion.setdireccion(sValor);//datoconstituciondatoconstitucion.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoCompaniaDescripcion(TipoCompania tipocompania) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocompania!=null/*&&tipocompania.getId()>0*/) {
			sDescripcion=TipoCompaniaConstantesFunciones.getTipoCompaniaDescripcion(tipocompania);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdValorClienteCompania")) {
			sNombreIndice="Tipo=  Por Tipo Compania";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteCompania(Long idvalorclientecompania) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientecompania!=null) {sDetalleIndice+=" Codigo Unico De Tipo Compania="+idvalorclientecompania.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDatoConstitucion(DatoConstitucion datoconstitucion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		datoconstitucion.setdireccion(datoconstitucion.getdireccion().trim());
	}
	
	public static void quitarEspaciosDatoConstitucions(List<DatoConstitucion> datoconstitucions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DatoConstitucion datoconstitucion: datoconstitucions) {
			datoconstitucion.setdireccion(datoconstitucion.getdireccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoConstitucion(DatoConstitucion datoconstitucion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && datoconstitucion.getConCambioAuxiliar()) {
			datoconstitucion.setIsDeleted(datoconstitucion.getIsDeletedAuxiliar());	
			datoconstitucion.setIsNew(datoconstitucion.getIsNewAuxiliar());	
			datoconstitucion.setIsChanged(datoconstitucion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			datoconstitucion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			datoconstitucion.setIsDeletedAuxiliar(false);	
			datoconstitucion.setIsNewAuxiliar(false);	
			datoconstitucion.setIsChangedAuxiliar(false);
			
			datoconstitucion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoConstitucions(List<DatoConstitucion> datoconstitucions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DatoConstitucion datoconstitucion : datoconstitucions) {
			if(conAsignarBase && datoconstitucion.getConCambioAuxiliar()) {
				datoconstitucion.setIsDeleted(datoconstitucion.getIsDeletedAuxiliar());	
				datoconstitucion.setIsNew(datoconstitucion.getIsNewAuxiliar());	
				datoconstitucion.setIsChanged(datoconstitucion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				datoconstitucion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				datoconstitucion.setIsDeletedAuxiliar(false);	
				datoconstitucion.setIsNewAuxiliar(false);	
				datoconstitucion.setIsChangedAuxiliar(false);
				
				datoconstitucion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDatoConstitucion(DatoConstitucion datoconstitucion,Boolean conEnteros) throws Exception  {
		datoconstitucion.setcapitalsuscrito(0.0);
		datoconstitucion.setreservalegal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			datoconstitucion.setplazofiniquito(0);
		}
	}		
	
	public static void InicializarValoresDatoConstitucions(List<DatoConstitucion> datoconstitucions,Boolean conEnteros) throws Exception  {
		
		for(DatoConstitucion datoconstitucion: datoconstitucions) {
			datoconstitucion.setcapitalsuscrito(0.0);
			datoconstitucion.setreservalegal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				datoconstitucion.setplazofiniquito(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDatoConstitucion(List<DatoConstitucion> datoconstitucions,DatoConstitucion datoconstitucionAux) throws Exception  {
		DatoConstitucionConstantesFunciones.InicializarValoresDatoConstitucion(datoconstitucionAux,true);
		
		for(DatoConstitucion datoconstitucion: datoconstitucions) {
			if(datoconstitucion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			datoconstitucionAux.setcapitalsuscrito(datoconstitucionAux.getcapitalsuscrito()+datoconstitucion.getcapitalsuscrito());			
			datoconstitucionAux.setplazofiniquito(datoconstitucionAux.getplazofiniquito()+datoconstitucion.getplazofiniquito());			
			datoconstitucionAux.setreservalegal(datoconstitucionAux.getreservalegal()+datoconstitucion.getreservalegal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoConstitucion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DatoConstitucionConstantesFunciones.getArrayColumnasGlobalesDatoConstitucion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoConstitucion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDatoConstitucion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DatoConstitucion> datoconstitucions,DatoConstitucion datoconstitucion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DatoConstitucion datoconstitucionAux: datoconstitucions) {
			if(datoconstitucionAux!=null && datoconstitucion!=null) {
				if((datoconstitucionAux.getId()==null && datoconstitucion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(datoconstitucionAux.getId()!=null && datoconstitucion.getId()!=null){
					if(datoconstitucionAux.getId().equals(datoconstitucion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDatoConstitucion(List<DatoConstitucion> datoconstitucions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double capitalsuscritoTotal=0.0;
		Double reservalegalTotal=0.0;
	
		for(DatoConstitucion datoconstitucion: datoconstitucions) {			
			if(datoconstitucion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			capitalsuscritoTotal+=datoconstitucion.getcapitalsuscrito();
			reservalegalTotal+=datoconstitucion.getreservalegal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoConstitucionConstantesFunciones.CAPITALSUSCRITO);
		datoGeneral.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_CAPITALSUSCRITO);
		datoGeneral.setdValorDouble(capitalsuscritoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoConstitucionConstantesFunciones.RESERVALEGAL);
		datoGeneral.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_RESERVALEGAL);
		datoGeneral.setdValorDouble(reservalegalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDatoConstitucion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_ID, DatoConstitucionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_VERSIONROW, DatoConstitucionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_IDCLIENTE, DatoConstitucionConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_IDTIPOCOMPANIA, DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_DIRECCION, DatoConstitucionConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_FECHACONSTITUCION, DatoConstitucionConstantesFunciones.FECHACONSTITUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_CAPITALSUSCRITO, DatoConstitucionConstantesFunciones.CAPITALSUSCRITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_PLAZOFINIQUITO, DatoConstitucionConstantesFunciones.PLAZOFINIQUITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_RESERVALEGAL, DatoConstitucionConstantesFunciones.RESERVALEGAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_FECHAESTATUTO, DatoConstitucionConstantesFunciones.FECHAESTATUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoConstitucionConstantesFunciones.LABEL_ESACTIVO, DatoConstitucionConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDatoConstitucion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.FECHACONSTITUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.CAPITALSUSCRITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.PLAZOFINIQUITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.RESERVALEGAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.FECHAESTATUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoConstitucionConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoConstitucion() throws Exception  {
		return DatoConstitucionConstantesFunciones.getTiposSeleccionarDatoConstitucion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoConstitucion(Boolean conFk) throws Exception  {
		return DatoConstitucionConstantesFunciones.getTiposSeleccionarDatoConstitucion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoConstitucion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_IDTIPOCOMPANIA);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_IDTIPOCOMPANIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_FECHACONSTITUCION);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_FECHACONSTITUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_CAPITALSUSCRITO);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_CAPITALSUSCRITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_PLAZOFINIQUITO);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_PLAZOFINIQUITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_RESERVALEGAL);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_RESERVALEGAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_FECHAESTATUTO);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_FECHAESTATUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoConstitucionConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(DatoConstitucionConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDatoConstitucion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDatoConstitucion(DatoConstitucion datoconstitucionAux) throws Exception {
		
			datoconstitucionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(datoconstitucionAux.getCliente()));
			datoconstitucionAux.settipocompania_descripcion(TipoCompaniaConstantesFunciones.getTipoCompaniaDescripcion(datoconstitucionAux.getTipoCompania()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDatoConstitucion(List<DatoConstitucion> datoconstitucionsTemp) throws Exception {
		for(DatoConstitucion datoconstitucionAux:datoconstitucionsTemp) {
			
			datoconstitucionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(datoconstitucionAux.getCliente()));
			datoconstitucionAux.settipocompania_descripcion(TipoCompaniaConstantesFunciones.getTipoCompaniaDescripcion(datoconstitucionAux.getTipoCompania()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDatoConstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoCompania.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCompania.class)) {
						classes.add(new Classe(TipoCompania.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDatoConstitucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoCompania.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCompania.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoCompania.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCompania.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoConstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoConstitucionConstantesFunciones.getClassesRelationshipsOfDatoConstitucion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoConstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoConstitucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoConstitucionConstantesFunciones.getClassesRelationshipsFromStringsOfDatoConstitucion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoConstitucion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DatoConstitucion datoconstitucion,List<DatoConstitucion> datoconstitucions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DatoConstitucion datoconstitucionEncontrado=null;
			
			for(DatoConstitucion datoconstitucionLocal:datoconstitucions) {
				if(datoconstitucionLocal.getId().equals(datoconstitucion.getId())) {
					datoconstitucionEncontrado=datoconstitucionLocal;
					
					datoconstitucionLocal.setIsChanged(datoconstitucion.getIsChanged());
					datoconstitucionLocal.setIsNew(datoconstitucion.getIsNew());
					datoconstitucionLocal.setIsDeleted(datoconstitucion.getIsDeleted());
					
					datoconstitucionLocal.setGeneralEntityOriginal(datoconstitucion.getGeneralEntityOriginal());
					
					datoconstitucionLocal.setId(datoconstitucion.getId());	
					datoconstitucionLocal.setVersionRow(datoconstitucion.getVersionRow());	
					datoconstitucionLocal.setidcliente(datoconstitucion.getidcliente());	
					datoconstitucionLocal.setidvalorclientecompania(datoconstitucion.getidvalorclientecompania());	
					datoconstitucionLocal.setdireccion(datoconstitucion.getdireccion());	
					datoconstitucionLocal.setfechaconstitucion(datoconstitucion.getfechaconstitucion());	
					datoconstitucionLocal.setcapitalsuscrito(datoconstitucion.getcapitalsuscrito());	
					datoconstitucionLocal.setplazofiniquito(datoconstitucion.getplazofiniquito());	
					datoconstitucionLocal.setreservalegal(datoconstitucion.getreservalegal());	
					datoconstitucionLocal.setfechaestatuto(datoconstitucion.getfechaestatuto());	
					datoconstitucionLocal.setesactivo(datoconstitucion.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!datoconstitucion.getIsDeleted()) {
				if(!existe) {
					datoconstitucions.add(datoconstitucion);
				}
			} else {
				if(datoconstitucionEncontrado!=null && permiteQuitar)  {
					datoconstitucions.remove(datoconstitucionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DatoConstitucion datoconstitucion,List<DatoConstitucion> datoconstitucions) throws Exception {
		try	{			
			for(DatoConstitucion datoconstitucionLocal:datoconstitucions) {
				if(datoconstitucionLocal.getId().equals(datoconstitucion.getId())) {
					datoconstitucionLocal.setIsSelected(datoconstitucion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDatoConstitucion(List<DatoConstitucion> datoconstitucionsAux) throws Exception {
		//this.datoconstitucionsAux=datoconstitucionsAux;
		
		for(DatoConstitucion datoconstitucionAux:datoconstitucionsAux) {
			if(datoconstitucionAux.getIsChanged()) {
				datoconstitucionAux.setIsChanged(false);
			}		
			
			if(datoconstitucionAux.getIsNew()) {
				datoconstitucionAux.setIsNew(false);
			}	
			
			if(datoconstitucionAux.getIsDeleted()) {
				datoconstitucionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDatoConstitucion(DatoConstitucion datoconstitucionAux) throws Exception {
		//this.datoconstitucionAux=datoconstitucionAux;
		
			if(datoconstitucionAux.getIsChanged()) {
				datoconstitucionAux.setIsChanged(false);
			}		
			
			if(datoconstitucionAux.getIsNew()) {
				datoconstitucionAux.setIsNew(false);
			}	
			
			if(datoconstitucionAux.getIsDeleted()) {
				datoconstitucionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DatoConstitucion datoconstitucionAsignar,DatoConstitucion datoconstitucion) throws Exception {
		datoconstitucionAsignar.setId(datoconstitucion.getId());	
		datoconstitucionAsignar.setVersionRow(datoconstitucion.getVersionRow());	
		datoconstitucionAsignar.setidcliente(datoconstitucion.getidcliente());
		datoconstitucionAsignar.setcliente_descripcion(datoconstitucion.getcliente_descripcion());	
		datoconstitucionAsignar.setidvalorclientecompania(datoconstitucion.getidvalorclientecompania());
		datoconstitucionAsignar.settipocompania_descripcion(datoconstitucion.gettipocompania_descripcion());	
		datoconstitucionAsignar.setdireccion(datoconstitucion.getdireccion());	
		datoconstitucionAsignar.setfechaconstitucion(datoconstitucion.getfechaconstitucion());	
		datoconstitucionAsignar.setcapitalsuscrito(datoconstitucion.getcapitalsuscrito());	
		datoconstitucionAsignar.setplazofiniquito(datoconstitucion.getplazofiniquito());	
		datoconstitucionAsignar.setreservalegal(datoconstitucion.getreservalegal());	
		datoconstitucionAsignar.setfechaestatuto(datoconstitucion.getfechaestatuto());	
		datoconstitucionAsignar.setesactivo(datoconstitucion.getesactivo());	
	}
	
	public static void inicializarDatoConstitucion(DatoConstitucion datoconstitucion) throws Exception {
		try {
				datoconstitucion.setId(0L);	
					
				datoconstitucion.setidcliente(-1L);	
				datoconstitucion.setidvalorclientecompania(-1L);	
				datoconstitucion.setdireccion("");	
				datoconstitucion.setfechaconstitucion(new Date());	
				datoconstitucion.setcapitalsuscrito(0.0);	
				datoconstitucion.setplazofiniquito(0);	
				datoconstitucion.setreservalegal(0.0);	
				datoconstitucion.setfechaestatuto(new Date());	
				datoconstitucion.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDatoConstitucion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_IDTIPOCOMPANIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_FECHACONSTITUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_CAPITALSUSCRITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_PLAZOFINIQUITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_RESERVALEGAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_FECHAESTATUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoConstitucionConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDatoConstitucion(String sTipo,Row row,Workbook workbook,DatoConstitucion datoconstitucion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.gettipocompania_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getfechaconstitucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getcapitalsuscrito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getplazofiniquito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getreservalegal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datoconstitucion.getfechaestatuto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datoconstitucion.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDatoConstitucion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDatoConstitucion() {
		return this.sFinalQueryDatoConstitucion;
	}
	
	public void setsFinalQueryDatoConstitucion(String sFinalQueryDatoConstitucion) {
		this.sFinalQueryDatoConstitucion= sFinalQueryDatoConstitucion;
	}
	
	public Border resaltarSeleccionarDatoConstitucion=null;
	
	public Border setResaltarSeleccionarDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDatoConstitucion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDatoConstitucion() {
		return this.resaltarSeleccionarDatoConstitucion;
	}
	
	public void setResaltarSeleccionarDatoConstitucion(Border borderResaltarSeleccionarDatoConstitucion) {
		this.resaltarSeleccionarDatoConstitucion= borderResaltarSeleccionarDatoConstitucion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDatoConstitucion=null;
	public Boolean mostraridDatoConstitucion=true;
	public Boolean activaridDatoConstitucion=true;

	public Border resaltaridclienteDatoConstitucion=null;
	public Boolean mostraridclienteDatoConstitucion=true;
	public Boolean activaridclienteDatoConstitucion=true;
	public Boolean cargaridclienteDatoConstitucion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteDatoConstitucion=false;//ConEventDepend=true

	public Border resaltaridvalorclientecompaniaDatoConstitucion=null;
	public Boolean mostraridvalorclientecompaniaDatoConstitucion=true;
	public Boolean activaridvalorclientecompaniaDatoConstitucion=true;
	public Boolean cargaridvalorclientecompaniaDatoConstitucion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientecompaniaDatoConstitucion=false;//ConEventDepend=true

	public Border resaltardireccionDatoConstitucion=null;
	public Boolean mostrardireccionDatoConstitucion=true;
	public Boolean activardireccionDatoConstitucion=true;

	public Border resaltarfechaconstitucionDatoConstitucion=null;
	public Boolean mostrarfechaconstitucionDatoConstitucion=true;
	public Boolean activarfechaconstitucionDatoConstitucion=false;

	public Border resaltarcapitalsuscritoDatoConstitucion=null;
	public Boolean mostrarcapitalsuscritoDatoConstitucion=true;
	public Boolean activarcapitalsuscritoDatoConstitucion=true;

	public Border resaltarplazofiniquitoDatoConstitucion=null;
	public Boolean mostrarplazofiniquitoDatoConstitucion=true;
	public Boolean activarplazofiniquitoDatoConstitucion=true;

	public Border resaltarreservalegalDatoConstitucion=null;
	public Boolean mostrarreservalegalDatoConstitucion=true;
	public Boolean activarreservalegalDatoConstitucion=true;

	public Border resaltarfechaestatutoDatoConstitucion=null;
	public Boolean mostrarfechaestatutoDatoConstitucion=true;
	public Boolean activarfechaestatutoDatoConstitucion=false;

	public Border resaltaresactivoDatoConstitucion=null;
	public Boolean mostraresactivoDatoConstitucion=true;
	public Boolean activaresactivoDatoConstitucion=true;

	
	

	public Border setResaltaridDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltaridDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDatoConstitucion() {
		return this.resaltaridDatoConstitucion;
	}

	public void setResaltaridDatoConstitucion(Border borderResaltar) {
		this.resaltaridDatoConstitucion= borderResaltar;
	}

	public Boolean getMostraridDatoConstitucion() {
		return this.mostraridDatoConstitucion;
	}

	public void setMostraridDatoConstitucion(Boolean mostraridDatoConstitucion) {
		this.mostraridDatoConstitucion= mostraridDatoConstitucion;
	}

	public Boolean getActivaridDatoConstitucion() {
		return this.activaridDatoConstitucion;
	}

	public void setActivaridDatoConstitucion(Boolean activaridDatoConstitucion) {
		this.activaridDatoConstitucion= activaridDatoConstitucion;
	}

	public Border setResaltaridclienteDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltaridclienteDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteDatoConstitucion() {
		return this.resaltaridclienteDatoConstitucion;
	}

	public void setResaltaridclienteDatoConstitucion(Border borderResaltar) {
		this.resaltaridclienteDatoConstitucion= borderResaltar;
	}

	public Boolean getMostraridclienteDatoConstitucion() {
		return this.mostraridclienteDatoConstitucion;
	}

	public void setMostraridclienteDatoConstitucion(Boolean mostraridclienteDatoConstitucion) {
		this.mostraridclienteDatoConstitucion= mostraridclienteDatoConstitucion;
	}

	public Boolean getActivaridclienteDatoConstitucion() {
		return this.activaridclienteDatoConstitucion;
	}

	public void setActivaridclienteDatoConstitucion(Boolean activaridclienteDatoConstitucion) {
		this.activaridclienteDatoConstitucion= activaridclienteDatoConstitucion;
	}

	public Boolean getCargaridclienteDatoConstitucion() {
		return this.cargaridclienteDatoConstitucion;
	}

	public void setCargaridclienteDatoConstitucion(Boolean cargaridclienteDatoConstitucion) {
		this.cargaridclienteDatoConstitucion= cargaridclienteDatoConstitucion;
	}

	public Border setResaltaridvalorclientecompaniaDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltaridvalorclientecompaniaDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientecompaniaDatoConstitucion() {
		return this.resaltaridvalorclientecompaniaDatoConstitucion;
	}

	public void setResaltaridvalorclientecompaniaDatoConstitucion(Border borderResaltar) {
		this.resaltaridvalorclientecompaniaDatoConstitucion= borderResaltar;
	}

	public Boolean getMostraridvalorclientecompaniaDatoConstitucion() {
		return this.mostraridvalorclientecompaniaDatoConstitucion;
	}

	public void setMostraridvalorclientecompaniaDatoConstitucion(Boolean mostraridvalorclientecompaniaDatoConstitucion) {
		this.mostraridvalorclientecompaniaDatoConstitucion= mostraridvalorclientecompaniaDatoConstitucion;
	}

	public Boolean getActivaridvalorclientecompaniaDatoConstitucion() {
		return this.activaridvalorclientecompaniaDatoConstitucion;
	}

	public void setActivaridvalorclientecompaniaDatoConstitucion(Boolean activaridvalorclientecompaniaDatoConstitucion) {
		this.activaridvalorclientecompaniaDatoConstitucion= activaridvalorclientecompaniaDatoConstitucion;
	}

	public Boolean getCargaridvalorclientecompaniaDatoConstitucion() {
		return this.cargaridvalorclientecompaniaDatoConstitucion;
	}

	public void setCargaridvalorclientecompaniaDatoConstitucion(Boolean cargaridvalorclientecompaniaDatoConstitucion) {
		this.cargaridvalorclientecompaniaDatoConstitucion= cargaridvalorclientecompaniaDatoConstitucion;
	}

	public Border setResaltardireccionDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltardireccionDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionDatoConstitucion() {
		return this.resaltardireccionDatoConstitucion;
	}

	public void setResaltardireccionDatoConstitucion(Border borderResaltar) {
		this.resaltardireccionDatoConstitucion= borderResaltar;
	}

	public Boolean getMostrardireccionDatoConstitucion() {
		return this.mostrardireccionDatoConstitucion;
	}

	public void setMostrardireccionDatoConstitucion(Boolean mostrardireccionDatoConstitucion) {
		this.mostrardireccionDatoConstitucion= mostrardireccionDatoConstitucion;
	}

	public Boolean getActivardireccionDatoConstitucion() {
		return this.activardireccionDatoConstitucion;
	}

	public void setActivardireccionDatoConstitucion(Boolean activardireccionDatoConstitucion) {
		this.activardireccionDatoConstitucion= activardireccionDatoConstitucion;
	}

	public Border setResaltarfechaconstitucionDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltarfechaconstitucionDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaconstitucionDatoConstitucion() {
		return this.resaltarfechaconstitucionDatoConstitucion;
	}

	public void setResaltarfechaconstitucionDatoConstitucion(Border borderResaltar) {
		this.resaltarfechaconstitucionDatoConstitucion= borderResaltar;
	}

	public Boolean getMostrarfechaconstitucionDatoConstitucion() {
		return this.mostrarfechaconstitucionDatoConstitucion;
	}

	public void setMostrarfechaconstitucionDatoConstitucion(Boolean mostrarfechaconstitucionDatoConstitucion) {
		this.mostrarfechaconstitucionDatoConstitucion= mostrarfechaconstitucionDatoConstitucion;
	}

	public Boolean getActivarfechaconstitucionDatoConstitucion() {
		return this.activarfechaconstitucionDatoConstitucion;
	}

	public void setActivarfechaconstitucionDatoConstitucion(Boolean activarfechaconstitucionDatoConstitucion) {
		this.activarfechaconstitucionDatoConstitucion= activarfechaconstitucionDatoConstitucion;
	}

	public Border setResaltarcapitalsuscritoDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltarcapitalsuscritoDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcapitalsuscritoDatoConstitucion() {
		return this.resaltarcapitalsuscritoDatoConstitucion;
	}

	public void setResaltarcapitalsuscritoDatoConstitucion(Border borderResaltar) {
		this.resaltarcapitalsuscritoDatoConstitucion= borderResaltar;
	}

	public Boolean getMostrarcapitalsuscritoDatoConstitucion() {
		return this.mostrarcapitalsuscritoDatoConstitucion;
	}

	public void setMostrarcapitalsuscritoDatoConstitucion(Boolean mostrarcapitalsuscritoDatoConstitucion) {
		this.mostrarcapitalsuscritoDatoConstitucion= mostrarcapitalsuscritoDatoConstitucion;
	}

	public Boolean getActivarcapitalsuscritoDatoConstitucion() {
		return this.activarcapitalsuscritoDatoConstitucion;
	}

	public void setActivarcapitalsuscritoDatoConstitucion(Boolean activarcapitalsuscritoDatoConstitucion) {
		this.activarcapitalsuscritoDatoConstitucion= activarcapitalsuscritoDatoConstitucion;
	}

	public Border setResaltarplazofiniquitoDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltarplazofiniquitoDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplazofiniquitoDatoConstitucion() {
		return this.resaltarplazofiniquitoDatoConstitucion;
	}

	public void setResaltarplazofiniquitoDatoConstitucion(Border borderResaltar) {
		this.resaltarplazofiniquitoDatoConstitucion= borderResaltar;
	}

	public Boolean getMostrarplazofiniquitoDatoConstitucion() {
		return this.mostrarplazofiniquitoDatoConstitucion;
	}

	public void setMostrarplazofiniquitoDatoConstitucion(Boolean mostrarplazofiniquitoDatoConstitucion) {
		this.mostrarplazofiniquitoDatoConstitucion= mostrarplazofiniquitoDatoConstitucion;
	}

	public Boolean getActivarplazofiniquitoDatoConstitucion() {
		return this.activarplazofiniquitoDatoConstitucion;
	}

	public void setActivarplazofiniquitoDatoConstitucion(Boolean activarplazofiniquitoDatoConstitucion) {
		this.activarplazofiniquitoDatoConstitucion= activarplazofiniquitoDatoConstitucion;
	}

	public Border setResaltarreservalegalDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltarreservalegalDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreservalegalDatoConstitucion() {
		return this.resaltarreservalegalDatoConstitucion;
	}

	public void setResaltarreservalegalDatoConstitucion(Border borderResaltar) {
		this.resaltarreservalegalDatoConstitucion= borderResaltar;
	}

	public Boolean getMostrarreservalegalDatoConstitucion() {
		return this.mostrarreservalegalDatoConstitucion;
	}

	public void setMostrarreservalegalDatoConstitucion(Boolean mostrarreservalegalDatoConstitucion) {
		this.mostrarreservalegalDatoConstitucion= mostrarreservalegalDatoConstitucion;
	}

	public Boolean getActivarreservalegalDatoConstitucion() {
		return this.activarreservalegalDatoConstitucion;
	}

	public void setActivarreservalegalDatoConstitucion(Boolean activarreservalegalDatoConstitucion) {
		this.activarreservalegalDatoConstitucion= activarreservalegalDatoConstitucion;
	}

	public Border setResaltarfechaestatutoDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltarfechaestatutoDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaestatutoDatoConstitucion() {
		return this.resaltarfechaestatutoDatoConstitucion;
	}

	public void setResaltarfechaestatutoDatoConstitucion(Border borderResaltar) {
		this.resaltarfechaestatutoDatoConstitucion= borderResaltar;
	}

	public Boolean getMostrarfechaestatutoDatoConstitucion() {
		return this.mostrarfechaestatutoDatoConstitucion;
	}

	public void setMostrarfechaestatutoDatoConstitucion(Boolean mostrarfechaestatutoDatoConstitucion) {
		this.mostrarfechaestatutoDatoConstitucion= mostrarfechaestatutoDatoConstitucion;
	}

	public Boolean getActivarfechaestatutoDatoConstitucion() {
		return this.activarfechaestatutoDatoConstitucion;
	}

	public void setActivarfechaestatutoDatoConstitucion(Boolean activarfechaestatutoDatoConstitucion) {
		this.activarfechaestatutoDatoConstitucion= activarfechaestatutoDatoConstitucion;
	}

	public Border setResaltaresactivoDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datoconstitucionBeanSwingJInternalFrame.jTtoolBarDatoConstitucion.setBorder(borderResaltar);
		
		this.resaltaresactivoDatoConstitucion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoDatoConstitucion() {
		return this.resaltaresactivoDatoConstitucion;
	}

	public void setResaltaresactivoDatoConstitucion(Border borderResaltar) {
		this.resaltaresactivoDatoConstitucion= borderResaltar;
	}

	public Boolean getMostraresactivoDatoConstitucion() {
		return this.mostraresactivoDatoConstitucion;
	}

	public void setMostraresactivoDatoConstitucion(Boolean mostraresactivoDatoConstitucion) {
		this.mostraresactivoDatoConstitucion= mostraresactivoDatoConstitucion;
	}

	public Boolean getActivaresactivoDatoConstitucion() {
		return this.activaresactivoDatoConstitucion;
	}

	public void setActivaresactivoDatoConstitucion(Boolean activaresactivoDatoConstitucion) {
		this.activaresactivoDatoConstitucion= activaresactivoDatoConstitucion;
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
		
		
		this.setMostraridDatoConstitucion(esInicial);
		this.setMostraridclienteDatoConstitucion(esInicial);
		this.setMostraridvalorclientecompaniaDatoConstitucion(esInicial);
		this.setMostrardireccionDatoConstitucion(esInicial);
		this.setMostrarfechaconstitucionDatoConstitucion(esInicial);
		this.setMostrarcapitalsuscritoDatoConstitucion(esInicial);
		this.setMostrarplazofiniquitoDatoConstitucion(esInicial);
		this.setMostrarreservalegalDatoConstitucion(esInicial);
		this.setMostrarfechaestatutoDatoConstitucion(esInicial);
		this.setMostraresactivoDatoConstitucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.ID)) {
				this.setMostraridDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA)) {
				this.setMostraridvalorclientecompaniaDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.FECHACONSTITUCION)) {
				this.setMostrarfechaconstitucionDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.CAPITALSUSCRITO)) {
				this.setMostrarcapitalsuscritoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.PLAZOFINIQUITO)) {
				this.setMostrarplazofiniquitoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.RESERVALEGAL)) {
				this.setMostrarreservalegalDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.FECHAESTATUTO)) {
				this.setMostrarfechaestatutoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoDatoConstitucion(esAsigna);
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
		
		
		this.setActivaridDatoConstitucion(esInicial);
		this.setActivaridclienteDatoConstitucion(esInicial);
		this.setActivaridvalorclientecompaniaDatoConstitucion(esInicial);
		this.setActivardireccionDatoConstitucion(esInicial);
		this.setActivarfechaconstitucionDatoConstitucion(esInicial);
		this.setActivarcapitalsuscritoDatoConstitucion(esInicial);
		this.setActivarplazofiniquitoDatoConstitucion(esInicial);
		this.setActivarreservalegalDatoConstitucion(esInicial);
		this.setActivarfechaestatutoDatoConstitucion(esInicial);
		this.setActivaresactivoDatoConstitucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.ID)) {
				this.setActivaridDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA)) {
				this.setActivaridvalorclientecompaniaDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.DIRECCION)) {
				this.setActivardireccionDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.FECHACONSTITUCION)) {
				this.setActivarfechaconstitucionDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.CAPITALSUSCRITO)) {
				this.setActivarcapitalsuscritoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.PLAZOFINIQUITO)) {
				this.setActivarplazofiniquitoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.RESERVALEGAL)) {
				this.setActivarreservalegalDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.FECHAESTATUTO)) {
				this.setActivarfechaestatutoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoDatoConstitucion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDatoConstitucion(esInicial);
		this.setResaltaridclienteDatoConstitucion(esInicial);
		this.setResaltaridvalorclientecompaniaDatoConstitucion(esInicial);
		this.setResaltardireccionDatoConstitucion(esInicial);
		this.setResaltarfechaconstitucionDatoConstitucion(esInicial);
		this.setResaltarcapitalsuscritoDatoConstitucion(esInicial);
		this.setResaltarplazofiniquitoDatoConstitucion(esInicial);
		this.setResaltarreservalegalDatoConstitucion(esInicial);
		this.setResaltarfechaestatutoDatoConstitucion(esInicial);
		this.setResaltaresactivoDatoConstitucion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.ID)) {
				this.setResaltaridDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA)) {
				this.setResaltaridvalorclientecompaniaDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.FECHACONSTITUCION)) {
				this.setResaltarfechaconstitucionDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.CAPITALSUSCRITO)) {
				this.setResaltarcapitalsuscritoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.PLAZOFINIQUITO)) {
				this.setResaltarplazofiniquitoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.RESERVALEGAL)) {
				this.setResaltarreservalegalDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.FECHAESTATUTO)) {
				this.setResaltarfechaestatutoDatoConstitucion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoConstitucionConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoDatoConstitucion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteDatoConstitucion=true;

	public Boolean getMostrarFK_IdClienteDatoConstitucion() {
		return this.mostrarFK_IdClienteDatoConstitucion;
	}

	public void setMostrarFK_IdClienteDatoConstitucion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDatoConstitucion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteCompaniaDatoConstitucion=true;

	public Boolean getMostrarFK_IdValorClienteCompaniaDatoConstitucion() {
		return this.mostrarFK_IdValorClienteCompaniaDatoConstitucion;
	}

	public void setMostrarFK_IdValorClienteCompaniaDatoConstitucion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteCompaniaDatoConstitucion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteDatoConstitucion=true;

	public Boolean getActivarFK_IdClienteDatoConstitucion() {
		return this.activarFK_IdClienteDatoConstitucion;
	}

	public void setActivarFK_IdClienteDatoConstitucion(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDatoConstitucion= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteCompaniaDatoConstitucion=true;

	public Boolean getActivarFK_IdValorClienteCompaniaDatoConstitucion() {
		return this.activarFK_IdValorClienteCompaniaDatoConstitucion;
	}

	public void setActivarFK_IdValorClienteCompaniaDatoConstitucion(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteCompaniaDatoConstitucion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteDatoConstitucion=null;

	public Border getResaltarFK_IdClienteDatoConstitucion() {
		return this.resaltarFK_IdClienteDatoConstitucion;
	}

	public void setResaltarFK_IdClienteDatoConstitucion(Border borderResaltar) {
		this.resaltarFK_IdClienteDatoConstitucion= borderResaltar;
	}

	public void setResaltarFK_IdClienteDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDatoConstitucion= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteCompaniaDatoConstitucion=null;

	public Border getResaltarFK_IdValorClienteCompaniaDatoConstitucion() {
		return this.resaltarFK_IdValorClienteCompaniaDatoConstitucion;
	}

	public void setResaltarFK_IdValorClienteCompaniaDatoConstitucion(Border borderResaltar) {
		this.resaltarFK_IdValorClienteCompaniaDatoConstitucion= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteCompaniaDatoConstitucion(ParametroGeneralUsuario parametroGeneralUsuario/*DatoConstitucionBeanSwingJInternalFrame datoconstitucionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteCompaniaDatoConstitucion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}