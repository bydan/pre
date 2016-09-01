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


import com.bydan.erp.cartera.util.ReferenciaComercialConstantesFunciones;
import com.bydan.erp.cartera.util.ReferenciaComercialParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ReferenciaComercialParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ReferenciaComercialConstantesFunciones extends ReferenciaComercialConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ReferenciaComercial";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ReferenciaComercial"+ReferenciaComercialConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReferenciaComercialHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReferenciaComercialHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReferenciaComercialConstantesFunciones.SCHEMA+"_"+ReferenciaComercialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaComercialHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReferenciaComercialConstantesFunciones.SCHEMA+"_"+ReferenciaComercialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReferenciaComercialConstantesFunciones.SCHEMA+"_"+ReferenciaComercialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReferenciaComercialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReferenciaComercialConstantesFunciones.SCHEMA+"_"+ReferenciaComercialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaComercialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaComercialHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaComercialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaComercialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReferenciaComercialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReferenciaComercialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReferenciaComercialConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReferenciaComercialConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReferenciaComercialConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReferenciaComercialConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Referencia Comerciales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Referencia Comercial";
	public static final String SCLASSWEBTITULO_LOWER="Referencia Comercial";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ReferenciaComercial";
	public static final String OBJECTNAME="referenciacomercial";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="referenciacomercial";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select referenciacomercial from "+ReferenciaComercialConstantesFunciones.SPERSISTENCENAME+" referenciacomercial";
	public static String QUERYSELECTNATIVE="select "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".version_row,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".idcliente,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".idvalorclientesectoreconomico,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id_pais,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".idciudad,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".nombreempresa,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".codigo_cliente,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".contacto,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".articulo_compra,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".numero_anios,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".numero_meses,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".direccion,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".telefono,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".telefonomovil,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".telefonocodigoarea,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".email,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".monto,"+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME+".esactivo from "+ReferenciaComercialConstantesFunciones.SCHEMA+"."+ReferenciaComercialConstantesFunciones.TABLENAME;//+" as "+ReferenciaComercialConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ReferenciaComercialConstantesFuncionesAdditional referenciacomercialConstantesFuncionesAdditional=null;
	
	public ReferenciaComercialConstantesFuncionesAdditional getReferenciaComercialConstantesFuncionesAdditional() {
		return this.referenciacomercialConstantesFuncionesAdditional;
	}
	
	public void setReferenciaComercialConstantesFuncionesAdditional(ReferenciaComercialConstantesFuncionesAdditional referenciacomercialConstantesFuncionesAdditional) {
		try {
			this.referenciacomercialConstantesFuncionesAdditional=referenciacomercialConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "idcliente";
    public static final String IDTIPOSECTORECONO= "idvalorclientesectoreconomico";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "idciudad";
    public static final String NOMBREEMPRESA= "nombreempresa";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String CONTACTO= "contacto";
    public static final String ARTICULOCOMPRA= "articulo_compra";
    public static final String NUMEROANIOS= "numero_anios";
    public static final String NUMEROMESES= "numero_meses";
    public static final String IDTIPOVALORACION= "id_tipo_valoracion";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String TELEFONOMOVIL= "telefonomovil";
    public static final String TELEFONOCODIGOAREA= "telefonocodigoarea";
    public static final String EMAIL= "email";
    public static final String MONTO= "monto";
    public static final String ESACTIVO= "esactivo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOSECTORECONO= "Tipo Sector Econo";
		public static final String LABEL_IDTIPOSECTORECONO_LOWER= "Tipo Sector Econo";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_NOMBREEMPRESA= "Nombre Empresa";
		public static final String LABEL_NOMBREEMPRESA_LOWER= "Nombre Empresa";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_CONTACTO= "Contacto";
		public static final String LABEL_CONTACTO_LOWER= "Contacto";
    	public static final String LABEL_ARTICULOCOMPRA= "Articulo Compra";
		public static final String LABEL_ARTICULOCOMPRA_LOWER= "Articulo Compra";
    	public static final String LABEL_NUMEROANIOS= "Numero Anios";
		public static final String LABEL_NUMEROANIOS_LOWER= "Numero Anios";
    	public static final String LABEL_NUMEROMESES= "Numero Meses";
		public static final String LABEL_NUMEROMESES_LOWER= "Numero Meses";
    	public static final String LABEL_IDTIPOVALORACION= "Tipo Valoracion";
		public static final String LABEL_IDTIPOVALORACION_LOWER= "Tipo Valoracion";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_TELEFONOMOVIL= "Telefono Movil";
		public static final String LABEL_TELEFONOMOVIL_LOWER= "Telefono Movil";
    	public static final String LABEL_TELEFONOCODIGOAREA= "Telefono Codigo Area";
		public static final String LABEL_TELEFONOCODIGOAREA_LOWER= "Telefono Codigo Area";
    	public static final String LABEL_EMAIL= "Email";
		public static final String LABEL_EMAIL_LOWER= "Email";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBREEMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBREEMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCONTACTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTACTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXARTICULO_COMPRA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXARTICULO_COMPRA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONOMOVIL=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONOMOVIL=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONOCODIGOAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEMAIL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEMAIL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getReferenciaComercialLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.IDEMPRESA)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.IDCLIENTE)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_IDTIPOSECTORECONO;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.IDPAIS)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.IDCIUDAD)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.NOMBREEMPRESA)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_NOMBREEMPRESA;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.CONTACTO)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_CONTACTO;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_ARTICULOCOMPRA;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.NUMEROANIOS)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_NUMEROANIOS;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.NUMEROMESES)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_NUMEROMESES;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.IDTIPOVALORACION)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_IDTIPOVALORACION;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.DIRECCION)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.TELEFONO)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.TELEFONOMOVIL)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_TELEFONOMOVIL;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_TELEFONOCODIGOAREA;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.EMAIL)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.MONTO)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(ReferenciaComercialConstantesFunciones.ESACTIVO)) {sLabelColumna=ReferenciaComercialConstantesFunciones.LABEL_ESACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesactivoDescripcion(ReferenciaComercial referenciacomercial) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!referenciacomercial.getesactivo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesactivoHtmlDescripcion(ReferenciaComercial referenciacomercial) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(referenciacomercial.getId(),referenciacomercial.getesactivo());

		return sDescripcion;
	}	
	
	public static String getReferenciaComercialDescripcion(ReferenciaComercial referenciacomercial) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(referenciacomercial !=null/* && referenciacomercial.getId()!=0*/) {
			if(referenciacomercial.getId()!=null) {
				sDescripcion=referenciacomercial.getId().toString();
			}//referenciacomercialreferenciacomercial.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getReferenciaComercialDescripcionDetallado(ReferenciaComercial referenciacomercial) {
		String sDescripcion="";
			
		sDescripcion+=ReferenciaComercialConstantesFunciones.ID+"=";
		sDescripcion+=referenciacomercial.getId().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=referenciacomercial.getVersionRow().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=referenciacomercial.getid_empresa().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=referenciacomercial.getidcliente().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO+"=";
		sDescripcion+=referenciacomercial.getidvalorclientesectoreconomico().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.IDPAIS+"=";
		sDescripcion+=referenciacomercial.getid_pais().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=referenciacomercial.getidciudad().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.NOMBREEMPRESA+"=";
		sDescripcion+=referenciacomercial.getnombreempresa()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=referenciacomercial.getcodigo_cliente()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.CONTACTO+"=";
		sDescripcion+=referenciacomercial.getcontacto()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA+"=";
		sDescripcion+=referenciacomercial.getarticulo_compra()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.NUMEROANIOS+"=";
		sDescripcion+=referenciacomercial.getnumero_anios().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.NUMEROMESES+"=";
		sDescripcion+=referenciacomercial.getnumero_meses().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.IDTIPOVALORACION+"=";
		sDescripcion+=referenciacomercial.getid_tipo_valoracion().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.DIRECCION+"=";
		sDescripcion+=referenciacomercial.getdireccion()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.TELEFONO+"=";
		sDescripcion+=referenciacomercial.gettelefono()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.TELEFONOMOVIL+"=";
		sDescripcion+=referenciacomercial.gettelefonomovil()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA+"=";
		sDescripcion+=referenciacomercial.gettelefonocodigoarea()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.EMAIL+"=";
		sDescripcion+=referenciacomercial.getemail()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.MONTO+"=";
		sDescripcion+=referenciacomercial.getmonto().toString()+",";
		sDescripcion+=ReferenciaComercialConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=referenciacomercial.getesactivo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setReferenciaComercialDescripcion(ReferenciaComercial referenciacomercial,String sValor) throws Exception {			
		if(referenciacomercial !=null) {
			//referenciacomercialreferenciacomercial.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoSectorEconoDescripcion(TipoSectorEcono tiposectorecono) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiposectorecono!=null/*&&tiposectorecono.getId()>0*/) {
			sDescripcion=TipoSectorEconoConstantesFunciones.getTipoSectorEconoDescripcion(tiposectorecono);
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

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getTipoValoracionDescripcion(TipoValoracion tipovaloracion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipovaloracion!=null/*&&tipovaloracion.getId()>0*/) {
			sDescripcion=TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(tipovaloracion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdTipoValoracion")) {
			sNombreIndice="Tipo=  Por Tipo Valoracion";
		} else if(sNombreIndice.equals("FK_IdValorClienteSectorEconomico")) {
			sNombreIndice="Tipo=  Por Tipo Sector Econo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long idciudad) {
		String sDetalleIndice=" Parametros->";
		if(idciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+idciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long idcliente) {
		String sDetalleIndice=" Parametros->";
		if(idcliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+idcliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoValoracion(Long id_tipo_valoracion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_valoracion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Valoracion="+id_tipo_valoracion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdValorClienteSectorEconomico(Long idvalorclientesectoreconomico) {
		String sDetalleIndice=" Parametros->";
		if(idvalorclientesectoreconomico!=null) {sDetalleIndice+=" Codigo Unico De Tipo Sector Econo="+idvalorclientesectoreconomico.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosReferenciaComercial(ReferenciaComercial referenciacomercial,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		referenciacomercial.setnombreempresa(referenciacomercial.getnombreempresa().trim());
		referenciacomercial.setcodigo_cliente(referenciacomercial.getcodigo_cliente().trim());
		referenciacomercial.setcontacto(referenciacomercial.getcontacto().trim());
		referenciacomercial.setarticulo_compra(referenciacomercial.getarticulo_compra().trim());
		referenciacomercial.setdireccion(referenciacomercial.getdireccion().trim());
		referenciacomercial.settelefono(referenciacomercial.gettelefono().trim());
		referenciacomercial.settelefonomovil(referenciacomercial.gettelefonomovil().trim());
		referenciacomercial.settelefonocodigoarea(referenciacomercial.gettelefonocodigoarea().trim());
		referenciacomercial.setemail(referenciacomercial.getemail().trim());
	}
	
	public static void quitarEspaciosReferenciaComercials(List<ReferenciaComercial> referenciacomercials,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ReferenciaComercial referenciacomercial: referenciacomercials) {
			referenciacomercial.setnombreempresa(referenciacomercial.getnombreempresa().trim());
			referenciacomercial.setcodigo_cliente(referenciacomercial.getcodigo_cliente().trim());
			referenciacomercial.setcontacto(referenciacomercial.getcontacto().trim());
			referenciacomercial.setarticulo_compra(referenciacomercial.getarticulo_compra().trim());
			referenciacomercial.setdireccion(referenciacomercial.getdireccion().trim());
			referenciacomercial.settelefono(referenciacomercial.gettelefono().trim());
			referenciacomercial.settelefonomovil(referenciacomercial.gettelefonomovil().trim());
			referenciacomercial.settelefonocodigoarea(referenciacomercial.gettelefonocodigoarea().trim());
			referenciacomercial.setemail(referenciacomercial.getemail().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferenciaComercial(ReferenciaComercial referenciacomercial,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && referenciacomercial.getConCambioAuxiliar()) {
			referenciacomercial.setIsDeleted(referenciacomercial.getIsDeletedAuxiliar());	
			referenciacomercial.setIsNew(referenciacomercial.getIsNewAuxiliar());	
			referenciacomercial.setIsChanged(referenciacomercial.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			referenciacomercial.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			referenciacomercial.setIsDeletedAuxiliar(false);	
			referenciacomercial.setIsNewAuxiliar(false);	
			referenciacomercial.setIsChangedAuxiliar(false);
			
			referenciacomercial.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReferenciaComercials(List<ReferenciaComercial> referenciacomercials,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ReferenciaComercial referenciacomercial : referenciacomercials) {
			if(conAsignarBase && referenciacomercial.getConCambioAuxiliar()) {
				referenciacomercial.setIsDeleted(referenciacomercial.getIsDeletedAuxiliar());	
				referenciacomercial.setIsNew(referenciacomercial.getIsNewAuxiliar());	
				referenciacomercial.setIsChanged(referenciacomercial.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				referenciacomercial.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				referenciacomercial.setIsDeletedAuxiliar(false);	
				referenciacomercial.setIsNewAuxiliar(false);	
				referenciacomercial.setIsChangedAuxiliar(false);
				
				referenciacomercial.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReferenciaComercial(ReferenciaComercial referenciacomercial,Boolean conEnteros) throws Exception  {
		referenciacomercial.setmonto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			referenciacomercial.setnumero_anios(0);
			referenciacomercial.setnumero_meses(0);
		}
	}		
	
	public static void InicializarValoresReferenciaComercials(List<ReferenciaComercial> referenciacomercials,Boolean conEnteros) throws Exception  {
		
		for(ReferenciaComercial referenciacomercial: referenciacomercials) {
			referenciacomercial.setmonto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				referenciacomercial.setnumero_anios(0);
				referenciacomercial.setnumero_meses(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaReferenciaComercial(List<ReferenciaComercial> referenciacomercials,ReferenciaComercial referenciacomercialAux) throws Exception  {
		ReferenciaComercialConstantesFunciones.InicializarValoresReferenciaComercial(referenciacomercialAux,true);
		
		for(ReferenciaComercial referenciacomercial: referenciacomercials) {
			if(referenciacomercial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			referenciacomercialAux.setnumero_anios(referenciacomercialAux.getnumero_anios()+referenciacomercial.getnumero_anios());			
			referenciacomercialAux.setnumero_meses(referenciacomercialAux.getnumero_meses()+referenciacomercial.getnumero_meses());			
			referenciacomercialAux.setmonto(referenciacomercialAux.getmonto()+referenciacomercial.getmonto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaComercial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReferenciaComercialConstantesFunciones.getArrayColumnasGlobalesReferenciaComercial(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaComercial(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ReferenciaComercialConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ReferenciaComercialConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReferenciaComercial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ReferenciaComercial> referenciacomercials,ReferenciaComercial referenciacomercial,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ReferenciaComercial referenciacomercialAux: referenciacomercials) {
			if(referenciacomercialAux!=null && referenciacomercial!=null) {
				if((referenciacomercialAux.getId()==null && referenciacomercial.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(referenciacomercialAux.getId()!=null && referenciacomercial.getId()!=null){
					if(referenciacomercialAux.getId().equals(referenciacomercial.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReferenciaComercial(List<ReferenciaComercial> referenciacomercials) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
	
		for(ReferenciaComercial referenciacomercial: referenciacomercials) {			
			if(referenciacomercial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=referenciacomercial.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ReferenciaComercialConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReferenciaComercial() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_ID, ReferenciaComercialConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_VERSIONROW, ReferenciaComercialConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_IDEMPRESA, ReferenciaComercialConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_IDCLIENTE, ReferenciaComercialConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_IDTIPOSECTORECONO, ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_IDPAIS, ReferenciaComercialConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_IDCIUDAD, ReferenciaComercialConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_NOMBREEMPRESA, ReferenciaComercialConstantesFunciones.NOMBREEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_CODIGOCLIENTE, ReferenciaComercialConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_CONTACTO, ReferenciaComercialConstantesFunciones.CONTACTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_ARTICULOCOMPRA, ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_NUMEROANIOS, ReferenciaComercialConstantesFunciones.NUMEROANIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_NUMEROMESES, ReferenciaComercialConstantesFunciones.NUMEROMESES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_IDTIPOVALORACION, ReferenciaComercialConstantesFunciones.IDTIPOVALORACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_DIRECCION, ReferenciaComercialConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_TELEFONO, ReferenciaComercialConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_TELEFONOMOVIL, ReferenciaComercialConstantesFunciones.TELEFONOMOVIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_TELEFONOCODIGOAREA, ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_EMAIL, ReferenciaComercialConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_MONTO, ReferenciaComercialConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReferenciaComercialConstantesFunciones.LABEL_ESACTIVO, ReferenciaComercialConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReferenciaComercial() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.NOMBREEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.CONTACTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.NUMEROANIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.NUMEROMESES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.IDTIPOVALORACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.TELEFONOMOVIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReferenciaComercialConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaComercial() throws Exception  {
		return ReferenciaComercialConstantesFunciones.getTiposSeleccionarReferenciaComercial(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaComercial(Boolean conFk) throws Exception  {
		return ReferenciaComercialConstantesFunciones.getTiposSeleccionarReferenciaComercial(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReferenciaComercial(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_IDTIPOSECTORECONO);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_IDTIPOSECTORECONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_NOMBREEMPRESA);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_NOMBREEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_CONTACTO);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_CONTACTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_ARTICULOCOMPRA);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_ARTICULOCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_NUMEROANIOS);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_NUMEROANIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_NUMEROMESES);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_NUMEROMESES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_IDTIPOVALORACION);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_IDTIPOVALORACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_TELEFONOMOVIL);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_TELEFONOMOVIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_TELEFONOCODIGOAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReferenciaComercialConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(ReferenciaComercialConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReferenciaComercial(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReferenciaComercial(ReferenciaComercial referenciacomercialAux) throws Exception {
		
			referenciacomercialAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciacomercialAux.getEmpresa()));
			referenciacomercialAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(referenciacomercialAux.getCliente()));
			referenciacomercialAux.settiposectorecono_descripcion(TipoSectorEconoConstantesFunciones.getTipoSectorEconoDescripcion(referenciacomercialAux.getTipoSectorEcono()));
			referenciacomercialAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(referenciacomercialAux.getPais()));
			referenciacomercialAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(referenciacomercialAux.getCiudad()));
			referenciacomercialAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(referenciacomercialAux.getTipoValoracion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesReferenciaComercial(List<ReferenciaComercial> referenciacomercialsTemp) throws Exception {
		for(ReferenciaComercial referenciacomercialAux:referenciacomercialsTemp) {
			
			referenciacomercialAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(referenciacomercialAux.getEmpresa()));
			referenciacomercialAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(referenciacomercialAux.getCliente()));
			referenciacomercialAux.settiposectorecono_descripcion(TipoSectorEconoConstantesFunciones.getTipoSectorEconoDescripcion(referenciacomercialAux.getTipoSectorEcono()));
			referenciacomercialAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(referenciacomercialAux.getPais()));
			referenciacomercialAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(referenciacomercialAux.getCiudad()));
			referenciacomercialAux.settipovaloracion_descripcion(TipoValoracionConstantesFunciones.getTipoValoracionDescripcion(referenciacomercialAux.getTipoValoracion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReferenciaComercial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoSectorEcono.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(TipoValoracion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoSectorEcono.class)) {
						classes.add(new Classe(TipoSectorEcono.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoValoracion.class)) {
						classes.add(new Classe(TipoValoracion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReferenciaComercial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoSectorEcono.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoSectorEcono.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(TipoValoracion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValoracion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoSectorEcono.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoSectorEcono.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(TipoValoracion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoValoracion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaComercial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaComercialConstantesFunciones.getClassesRelationshipsOfReferenciaComercial(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaComercial(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferenciaComercial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReferenciaComercialConstantesFunciones.getClassesRelationshipsFromStringsOfReferenciaComercial(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReferenciaComercial(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ReferenciaComercial referenciacomercial,List<ReferenciaComercial> referenciacomercials,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ReferenciaComercial referenciacomercialEncontrado=null;
			
			for(ReferenciaComercial referenciacomercialLocal:referenciacomercials) {
				if(referenciacomercialLocal.getId().equals(referenciacomercial.getId())) {
					referenciacomercialEncontrado=referenciacomercialLocal;
					
					referenciacomercialLocal.setIsChanged(referenciacomercial.getIsChanged());
					referenciacomercialLocal.setIsNew(referenciacomercial.getIsNew());
					referenciacomercialLocal.setIsDeleted(referenciacomercial.getIsDeleted());
					
					referenciacomercialLocal.setGeneralEntityOriginal(referenciacomercial.getGeneralEntityOriginal());
					
					referenciacomercialLocal.setId(referenciacomercial.getId());	
					referenciacomercialLocal.setVersionRow(referenciacomercial.getVersionRow());	
					referenciacomercialLocal.setid_empresa(referenciacomercial.getid_empresa());	
					referenciacomercialLocal.setidcliente(referenciacomercial.getidcliente());	
					referenciacomercialLocal.setidvalorclientesectoreconomico(referenciacomercial.getidvalorclientesectoreconomico());	
					referenciacomercialLocal.setid_pais(referenciacomercial.getid_pais());	
					referenciacomercialLocal.setidciudad(referenciacomercial.getidciudad());	
					referenciacomercialLocal.setnombreempresa(referenciacomercial.getnombreempresa());	
					referenciacomercialLocal.setcodigo_cliente(referenciacomercial.getcodigo_cliente());	
					referenciacomercialLocal.setcontacto(referenciacomercial.getcontacto());	
					referenciacomercialLocal.setarticulo_compra(referenciacomercial.getarticulo_compra());	
					referenciacomercialLocal.setnumero_anios(referenciacomercial.getnumero_anios());	
					referenciacomercialLocal.setnumero_meses(referenciacomercial.getnumero_meses());	
					referenciacomercialLocal.setid_tipo_valoracion(referenciacomercial.getid_tipo_valoracion());	
					referenciacomercialLocal.setdireccion(referenciacomercial.getdireccion());	
					referenciacomercialLocal.settelefono(referenciacomercial.gettelefono());	
					referenciacomercialLocal.settelefonomovil(referenciacomercial.gettelefonomovil());	
					referenciacomercialLocal.settelefonocodigoarea(referenciacomercial.gettelefonocodigoarea());	
					referenciacomercialLocal.setemail(referenciacomercial.getemail());	
					referenciacomercialLocal.setmonto(referenciacomercial.getmonto());	
					referenciacomercialLocal.setesactivo(referenciacomercial.getesactivo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!referenciacomercial.getIsDeleted()) {
				if(!existe) {
					referenciacomercials.add(referenciacomercial);
				}
			} else {
				if(referenciacomercialEncontrado!=null && permiteQuitar)  {
					referenciacomercials.remove(referenciacomercialEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ReferenciaComercial referenciacomercial,List<ReferenciaComercial> referenciacomercials) throws Exception {
		try	{			
			for(ReferenciaComercial referenciacomercialLocal:referenciacomercials) {
				if(referenciacomercialLocal.getId().equals(referenciacomercial.getId())) {
					referenciacomercialLocal.setIsSelected(referenciacomercial.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReferenciaComercial(List<ReferenciaComercial> referenciacomercialsAux) throws Exception {
		//this.referenciacomercialsAux=referenciacomercialsAux;
		
		for(ReferenciaComercial referenciacomercialAux:referenciacomercialsAux) {
			if(referenciacomercialAux.getIsChanged()) {
				referenciacomercialAux.setIsChanged(false);
			}		
			
			if(referenciacomercialAux.getIsNew()) {
				referenciacomercialAux.setIsNew(false);
			}	
			
			if(referenciacomercialAux.getIsDeleted()) {
				referenciacomercialAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReferenciaComercial(ReferenciaComercial referenciacomercialAux) throws Exception {
		//this.referenciacomercialAux=referenciacomercialAux;
		
			if(referenciacomercialAux.getIsChanged()) {
				referenciacomercialAux.setIsChanged(false);
			}		
			
			if(referenciacomercialAux.getIsNew()) {
				referenciacomercialAux.setIsNew(false);
			}	
			
			if(referenciacomercialAux.getIsDeleted()) {
				referenciacomercialAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ReferenciaComercial referenciacomercialAsignar,ReferenciaComercial referenciacomercial) throws Exception {
		referenciacomercialAsignar.setId(referenciacomercial.getId());	
		referenciacomercialAsignar.setVersionRow(referenciacomercial.getVersionRow());	
		referenciacomercialAsignar.setid_empresa(referenciacomercial.getid_empresa());
		referenciacomercialAsignar.setempresa_descripcion(referenciacomercial.getempresa_descripcion());	
		referenciacomercialAsignar.setidcliente(referenciacomercial.getidcliente());
		referenciacomercialAsignar.setcliente_descripcion(referenciacomercial.getcliente_descripcion());	
		referenciacomercialAsignar.setidvalorclientesectoreconomico(referenciacomercial.getidvalorclientesectoreconomico());
		referenciacomercialAsignar.settiposectorecono_descripcion(referenciacomercial.gettiposectorecono_descripcion());	
		referenciacomercialAsignar.setid_pais(referenciacomercial.getid_pais());
		referenciacomercialAsignar.setpais_descripcion(referenciacomercial.getpais_descripcion());	
		referenciacomercialAsignar.setidciudad(referenciacomercial.getidciudad());
		referenciacomercialAsignar.setciudad_descripcion(referenciacomercial.getciudad_descripcion());	
		referenciacomercialAsignar.setnombreempresa(referenciacomercial.getnombreempresa());	
		referenciacomercialAsignar.setcodigo_cliente(referenciacomercial.getcodigo_cliente());	
		referenciacomercialAsignar.setcontacto(referenciacomercial.getcontacto());	
		referenciacomercialAsignar.setarticulo_compra(referenciacomercial.getarticulo_compra());	
		referenciacomercialAsignar.setnumero_anios(referenciacomercial.getnumero_anios());	
		referenciacomercialAsignar.setnumero_meses(referenciacomercial.getnumero_meses());	
		referenciacomercialAsignar.setid_tipo_valoracion(referenciacomercial.getid_tipo_valoracion());
		referenciacomercialAsignar.settipovaloracion_descripcion(referenciacomercial.gettipovaloracion_descripcion());	
		referenciacomercialAsignar.setdireccion(referenciacomercial.getdireccion());	
		referenciacomercialAsignar.settelefono(referenciacomercial.gettelefono());	
		referenciacomercialAsignar.settelefonomovil(referenciacomercial.gettelefonomovil());	
		referenciacomercialAsignar.settelefonocodigoarea(referenciacomercial.gettelefonocodigoarea());	
		referenciacomercialAsignar.setemail(referenciacomercial.getemail());	
		referenciacomercialAsignar.setmonto(referenciacomercial.getmonto());	
		referenciacomercialAsignar.setesactivo(referenciacomercial.getesactivo());	
	}
	
	public static void inicializarReferenciaComercial(ReferenciaComercial referenciacomercial) throws Exception {
		try {
				referenciacomercial.setId(0L);	
					
				referenciacomercial.setid_empresa(-1L);	
				referenciacomercial.setidcliente(-1L);	
				referenciacomercial.setidvalorclientesectoreconomico(-1L);	
				referenciacomercial.setid_pais(-1L);	
				referenciacomercial.setidciudad(-1L);	
				referenciacomercial.setnombreempresa("");	
				referenciacomercial.setcodigo_cliente("");	
				referenciacomercial.setcontacto("");	
				referenciacomercial.setarticulo_compra("");	
				referenciacomercial.setnumero_anios(0);	
				referenciacomercial.setnumero_meses(0);	
				referenciacomercial.setid_tipo_valoracion(-1L);	
				referenciacomercial.setdireccion("");	
				referenciacomercial.settelefono("");	
				referenciacomercial.settelefonomovil("");	
				referenciacomercial.settelefonocodigoarea("");	
				referenciacomercial.setemail("");	
				referenciacomercial.setmonto(0.0);	
				referenciacomercial.setesactivo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReferenciaComercial(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_IDTIPOSECTORECONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_NOMBREEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_CONTACTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_ARTICULOCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_NUMEROANIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_NUMEROMESES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_IDTIPOVALORACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_TELEFONOMOVIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_TELEFONOCODIGOAREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReferenciaComercialConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReferenciaComercial(String sTipo,Row row,Workbook workbook,ReferenciaComercial referenciacomercial,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.gettiposectorecono_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getnombreempresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getcontacto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getarticulo_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getnumero_anios());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getnumero_meses());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.gettipovaloracion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.gettelefonomovil());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.gettelefonocodigoarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getemail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(referenciacomercial.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(referenciacomercial.getesactivo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReferenciaComercial=Constantes.SFINALQUERY;
	
	public String getsFinalQueryReferenciaComercial() {
		return this.sFinalQueryReferenciaComercial;
	}
	
	public void setsFinalQueryReferenciaComercial(String sFinalQueryReferenciaComercial) {
		this.sFinalQueryReferenciaComercial= sFinalQueryReferenciaComercial;
	}
	
	public Border resaltarSeleccionarReferenciaComercial=null;
	
	public Border setResaltarSeleccionarReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReferenciaComercial= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReferenciaComercial() {
		return this.resaltarSeleccionarReferenciaComercial;
	}
	
	public void setResaltarSeleccionarReferenciaComercial(Border borderResaltarSeleccionarReferenciaComercial) {
		this.resaltarSeleccionarReferenciaComercial= borderResaltarSeleccionarReferenciaComercial;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReferenciaComercial=null;
	public Boolean mostraridReferenciaComercial=true;
	public Boolean activaridReferenciaComercial=true;

	public Border resaltarid_empresaReferenciaComercial=null;
	public Boolean mostrarid_empresaReferenciaComercial=true;
	public Boolean activarid_empresaReferenciaComercial=true;
	public Boolean cargarid_empresaReferenciaComercial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaReferenciaComercial=false;//ConEventDepend=true

	public Border resaltaridclienteReferenciaComercial=null;
	public Boolean mostraridclienteReferenciaComercial=true;
	public Boolean activaridclienteReferenciaComercial=true;
	public Boolean cargaridclienteReferenciaComercial=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidclienteReferenciaComercial=false;//ConEventDepend=true

	public Border resaltaridvalorclientesectoreconomicoReferenciaComercial=null;
	public Boolean mostraridvalorclientesectoreconomicoReferenciaComercial=true;
	public Boolean activaridvalorclientesectoreconomicoReferenciaComercial=true;
	public Boolean cargaridvalorclientesectoreconomicoReferenciaComercial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidvalorclientesectoreconomicoReferenciaComercial=false;//ConEventDepend=true

	public Border resaltarid_paisReferenciaComercial=null;
	public Boolean mostrarid_paisReferenciaComercial=true;
	public Boolean activarid_paisReferenciaComercial=true;
	public Boolean cargarid_paisReferenciaComercial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisReferenciaComercial=false;//ConEventDepend=true

	public Border resaltaridciudadReferenciaComercial=null;
	public Boolean mostraridciudadReferenciaComercial=true;
	public Boolean activaridciudadReferenciaComercial=true;
	public Boolean cargaridciudadReferenciaComercial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependidciudadReferenciaComercial=true;//ConEventDepend=true

	public Border resaltarnombreempresaReferenciaComercial=null;
	public Boolean mostrarnombreempresaReferenciaComercial=true;
	public Boolean activarnombreempresaReferenciaComercial=true;

	public Border resaltarcodigo_clienteReferenciaComercial=null;
	public Boolean mostrarcodigo_clienteReferenciaComercial=true;
	public Boolean activarcodigo_clienteReferenciaComercial=true;

	public Border resaltarcontactoReferenciaComercial=null;
	public Boolean mostrarcontactoReferenciaComercial=true;
	public Boolean activarcontactoReferenciaComercial=true;

	public Border resaltararticulo_compraReferenciaComercial=null;
	public Boolean mostrararticulo_compraReferenciaComercial=true;
	public Boolean activararticulo_compraReferenciaComercial=true;

	public Border resaltarnumero_aniosReferenciaComercial=null;
	public Boolean mostrarnumero_aniosReferenciaComercial=true;
	public Boolean activarnumero_aniosReferenciaComercial=true;

	public Border resaltarnumero_mesesReferenciaComercial=null;
	public Boolean mostrarnumero_mesesReferenciaComercial=true;
	public Boolean activarnumero_mesesReferenciaComercial=true;

	public Border resaltarid_tipo_valoracionReferenciaComercial=null;
	public Boolean mostrarid_tipo_valoracionReferenciaComercial=true;
	public Boolean activarid_tipo_valoracionReferenciaComercial=true;
	public Boolean cargarid_tipo_valoracionReferenciaComercial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_valoracionReferenciaComercial=false;//ConEventDepend=true

	public Border resaltardireccionReferenciaComercial=null;
	public Boolean mostrardireccionReferenciaComercial=true;
	public Boolean activardireccionReferenciaComercial=true;

	public Border resaltartelefonoReferenciaComercial=null;
	public Boolean mostrartelefonoReferenciaComercial=true;
	public Boolean activartelefonoReferenciaComercial=true;

	public Border resaltartelefonomovilReferenciaComercial=null;
	public Boolean mostrartelefonomovilReferenciaComercial=true;
	public Boolean activartelefonomovilReferenciaComercial=true;

	public Border resaltartelefonocodigoareaReferenciaComercial=null;
	public Boolean mostrartelefonocodigoareaReferenciaComercial=true;
	public Boolean activartelefonocodigoareaReferenciaComercial=true;

	public Border resaltaremailReferenciaComercial=null;
	public Boolean mostraremailReferenciaComercial=true;
	public Boolean activaremailReferenciaComercial=true;

	public Border resaltarmontoReferenciaComercial=null;
	public Boolean mostrarmontoReferenciaComercial=true;
	public Boolean activarmontoReferenciaComercial=true;

	public Border resaltaresactivoReferenciaComercial=null;
	public Boolean mostraresactivoReferenciaComercial=true;
	public Boolean activaresactivoReferenciaComercial=true;

	
	

	public Border setResaltaridReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltaridReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReferenciaComercial() {
		return this.resaltaridReferenciaComercial;
	}

	public void setResaltaridReferenciaComercial(Border borderResaltar) {
		this.resaltaridReferenciaComercial= borderResaltar;
	}

	public Boolean getMostraridReferenciaComercial() {
		return this.mostraridReferenciaComercial;
	}

	public void setMostraridReferenciaComercial(Boolean mostraridReferenciaComercial) {
		this.mostraridReferenciaComercial= mostraridReferenciaComercial;
	}

	public Boolean getActivaridReferenciaComercial() {
		return this.activaridReferenciaComercial;
	}

	public void setActivaridReferenciaComercial(Boolean activaridReferenciaComercial) {
		this.activaridReferenciaComercial= activaridReferenciaComercial;
	}

	public Border setResaltarid_empresaReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarid_empresaReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaReferenciaComercial() {
		return this.resaltarid_empresaReferenciaComercial;
	}

	public void setResaltarid_empresaReferenciaComercial(Border borderResaltar) {
		this.resaltarid_empresaReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarid_empresaReferenciaComercial() {
		return this.mostrarid_empresaReferenciaComercial;
	}

	public void setMostrarid_empresaReferenciaComercial(Boolean mostrarid_empresaReferenciaComercial) {
		this.mostrarid_empresaReferenciaComercial= mostrarid_empresaReferenciaComercial;
	}

	public Boolean getActivarid_empresaReferenciaComercial() {
		return this.activarid_empresaReferenciaComercial;
	}

	public void setActivarid_empresaReferenciaComercial(Boolean activarid_empresaReferenciaComercial) {
		this.activarid_empresaReferenciaComercial= activarid_empresaReferenciaComercial;
	}

	public Boolean getCargarid_empresaReferenciaComercial() {
		return this.cargarid_empresaReferenciaComercial;
	}

	public void setCargarid_empresaReferenciaComercial(Boolean cargarid_empresaReferenciaComercial) {
		this.cargarid_empresaReferenciaComercial= cargarid_empresaReferenciaComercial;
	}

	public Border setResaltaridclienteReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltaridclienteReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridclienteReferenciaComercial() {
		return this.resaltaridclienteReferenciaComercial;
	}

	public void setResaltaridclienteReferenciaComercial(Border borderResaltar) {
		this.resaltaridclienteReferenciaComercial= borderResaltar;
	}

	public Boolean getMostraridclienteReferenciaComercial() {
		return this.mostraridclienteReferenciaComercial;
	}

	public void setMostraridclienteReferenciaComercial(Boolean mostraridclienteReferenciaComercial) {
		this.mostraridclienteReferenciaComercial= mostraridclienteReferenciaComercial;
	}

	public Boolean getActivaridclienteReferenciaComercial() {
		return this.activaridclienteReferenciaComercial;
	}

	public void setActivaridclienteReferenciaComercial(Boolean activaridclienteReferenciaComercial) {
		this.activaridclienteReferenciaComercial= activaridclienteReferenciaComercial;
	}

	public Boolean getCargaridclienteReferenciaComercial() {
		return this.cargaridclienteReferenciaComercial;
	}

	public void setCargaridclienteReferenciaComercial(Boolean cargaridclienteReferenciaComercial) {
		this.cargaridclienteReferenciaComercial= cargaridclienteReferenciaComercial;
	}

	public Border setResaltaridvalorclientesectoreconomicoReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltaridvalorclientesectoreconomicoReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridvalorclientesectoreconomicoReferenciaComercial() {
		return this.resaltaridvalorclientesectoreconomicoReferenciaComercial;
	}

	public void setResaltaridvalorclientesectoreconomicoReferenciaComercial(Border borderResaltar) {
		this.resaltaridvalorclientesectoreconomicoReferenciaComercial= borderResaltar;
	}

	public Boolean getMostraridvalorclientesectoreconomicoReferenciaComercial() {
		return this.mostraridvalorclientesectoreconomicoReferenciaComercial;
	}

	public void setMostraridvalorclientesectoreconomicoReferenciaComercial(Boolean mostraridvalorclientesectoreconomicoReferenciaComercial) {
		this.mostraridvalorclientesectoreconomicoReferenciaComercial= mostraridvalorclientesectoreconomicoReferenciaComercial;
	}

	public Boolean getActivaridvalorclientesectoreconomicoReferenciaComercial() {
		return this.activaridvalorclientesectoreconomicoReferenciaComercial;
	}

	public void setActivaridvalorclientesectoreconomicoReferenciaComercial(Boolean activaridvalorclientesectoreconomicoReferenciaComercial) {
		this.activaridvalorclientesectoreconomicoReferenciaComercial= activaridvalorclientesectoreconomicoReferenciaComercial;
	}

	public Boolean getCargaridvalorclientesectoreconomicoReferenciaComercial() {
		return this.cargaridvalorclientesectoreconomicoReferenciaComercial;
	}

	public void setCargaridvalorclientesectoreconomicoReferenciaComercial(Boolean cargaridvalorclientesectoreconomicoReferenciaComercial) {
		this.cargaridvalorclientesectoreconomicoReferenciaComercial= cargaridvalorclientesectoreconomicoReferenciaComercial;
	}

	public Border setResaltarid_paisReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarid_paisReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisReferenciaComercial() {
		return this.resaltarid_paisReferenciaComercial;
	}

	public void setResaltarid_paisReferenciaComercial(Border borderResaltar) {
		this.resaltarid_paisReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarid_paisReferenciaComercial() {
		return this.mostrarid_paisReferenciaComercial;
	}

	public void setMostrarid_paisReferenciaComercial(Boolean mostrarid_paisReferenciaComercial) {
		this.mostrarid_paisReferenciaComercial= mostrarid_paisReferenciaComercial;
	}

	public Boolean getActivarid_paisReferenciaComercial() {
		return this.activarid_paisReferenciaComercial;
	}

	public void setActivarid_paisReferenciaComercial(Boolean activarid_paisReferenciaComercial) {
		this.activarid_paisReferenciaComercial= activarid_paisReferenciaComercial;
	}

	public Boolean getCargarid_paisReferenciaComercial() {
		return this.cargarid_paisReferenciaComercial;
	}

	public void setCargarid_paisReferenciaComercial(Boolean cargarid_paisReferenciaComercial) {
		this.cargarid_paisReferenciaComercial= cargarid_paisReferenciaComercial;
	}

	public Border setResaltaridciudadReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltaridciudadReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridciudadReferenciaComercial() {
		return this.resaltaridciudadReferenciaComercial;
	}

	public void setResaltaridciudadReferenciaComercial(Border borderResaltar) {
		this.resaltaridciudadReferenciaComercial= borderResaltar;
	}

	public Boolean getMostraridciudadReferenciaComercial() {
		return this.mostraridciudadReferenciaComercial;
	}

	public void setMostraridciudadReferenciaComercial(Boolean mostraridciudadReferenciaComercial) {
		this.mostraridciudadReferenciaComercial= mostraridciudadReferenciaComercial;
	}

	public Boolean getActivaridciudadReferenciaComercial() {
		return this.activaridciudadReferenciaComercial;
	}

	public void setActivaridciudadReferenciaComercial(Boolean activaridciudadReferenciaComercial) {
		this.activaridciudadReferenciaComercial= activaridciudadReferenciaComercial;
	}

	public Boolean getCargaridciudadReferenciaComercial() {
		return this.cargaridciudadReferenciaComercial;
	}

	public void setCargaridciudadReferenciaComercial(Boolean cargaridciudadReferenciaComercial) {
		this.cargaridciudadReferenciaComercial= cargaridciudadReferenciaComercial;
	}

	public Border setResaltarnombreempresaReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarnombreempresaReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreempresaReferenciaComercial() {
		return this.resaltarnombreempresaReferenciaComercial;
	}

	public void setResaltarnombreempresaReferenciaComercial(Border borderResaltar) {
		this.resaltarnombreempresaReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarnombreempresaReferenciaComercial() {
		return this.mostrarnombreempresaReferenciaComercial;
	}

	public void setMostrarnombreempresaReferenciaComercial(Boolean mostrarnombreempresaReferenciaComercial) {
		this.mostrarnombreempresaReferenciaComercial= mostrarnombreempresaReferenciaComercial;
	}

	public Boolean getActivarnombreempresaReferenciaComercial() {
		return this.activarnombreempresaReferenciaComercial;
	}

	public void setActivarnombreempresaReferenciaComercial(Boolean activarnombreempresaReferenciaComercial) {
		this.activarnombreempresaReferenciaComercial= activarnombreempresaReferenciaComercial;
	}

	public Border setResaltarcodigo_clienteReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteReferenciaComercial() {
		return this.resaltarcodigo_clienteReferenciaComercial;
	}

	public void setResaltarcodigo_clienteReferenciaComercial(Border borderResaltar) {
		this.resaltarcodigo_clienteReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteReferenciaComercial() {
		return this.mostrarcodigo_clienteReferenciaComercial;
	}

	public void setMostrarcodigo_clienteReferenciaComercial(Boolean mostrarcodigo_clienteReferenciaComercial) {
		this.mostrarcodigo_clienteReferenciaComercial= mostrarcodigo_clienteReferenciaComercial;
	}

	public Boolean getActivarcodigo_clienteReferenciaComercial() {
		return this.activarcodigo_clienteReferenciaComercial;
	}

	public void setActivarcodigo_clienteReferenciaComercial(Boolean activarcodigo_clienteReferenciaComercial) {
		this.activarcodigo_clienteReferenciaComercial= activarcodigo_clienteReferenciaComercial;
	}

	public Border setResaltarcontactoReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarcontactoReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontactoReferenciaComercial() {
		return this.resaltarcontactoReferenciaComercial;
	}

	public void setResaltarcontactoReferenciaComercial(Border borderResaltar) {
		this.resaltarcontactoReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarcontactoReferenciaComercial() {
		return this.mostrarcontactoReferenciaComercial;
	}

	public void setMostrarcontactoReferenciaComercial(Boolean mostrarcontactoReferenciaComercial) {
		this.mostrarcontactoReferenciaComercial= mostrarcontactoReferenciaComercial;
	}

	public Boolean getActivarcontactoReferenciaComercial() {
		return this.activarcontactoReferenciaComercial;
	}

	public void setActivarcontactoReferenciaComercial(Boolean activarcontactoReferenciaComercial) {
		this.activarcontactoReferenciaComercial= activarcontactoReferenciaComercial;
	}

	public Border setResaltararticulo_compraReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltararticulo_compraReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararticulo_compraReferenciaComercial() {
		return this.resaltararticulo_compraReferenciaComercial;
	}

	public void setResaltararticulo_compraReferenciaComercial(Border borderResaltar) {
		this.resaltararticulo_compraReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrararticulo_compraReferenciaComercial() {
		return this.mostrararticulo_compraReferenciaComercial;
	}

	public void setMostrararticulo_compraReferenciaComercial(Boolean mostrararticulo_compraReferenciaComercial) {
		this.mostrararticulo_compraReferenciaComercial= mostrararticulo_compraReferenciaComercial;
	}

	public Boolean getActivararticulo_compraReferenciaComercial() {
		return this.activararticulo_compraReferenciaComercial;
	}

	public void setActivararticulo_compraReferenciaComercial(Boolean activararticulo_compraReferenciaComercial) {
		this.activararticulo_compraReferenciaComercial= activararticulo_compraReferenciaComercial;
	}

	public Border setResaltarnumero_aniosReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarnumero_aniosReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_aniosReferenciaComercial() {
		return this.resaltarnumero_aniosReferenciaComercial;
	}

	public void setResaltarnumero_aniosReferenciaComercial(Border borderResaltar) {
		this.resaltarnumero_aniosReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarnumero_aniosReferenciaComercial() {
		return this.mostrarnumero_aniosReferenciaComercial;
	}

	public void setMostrarnumero_aniosReferenciaComercial(Boolean mostrarnumero_aniosReferenciaComercial) {
		this.mostrarnumero_aniosReferenciaComercial= mostrarnumero_aniosReferenciaComercial;
	}

	public Boolean getActivarnumero_aniosReferenciaComercial() {
		return this.activarnumero_aniosReferenciaComercial;
	}

	public void setActivarnumero_aniosReferenciaComercial(Boolean activarnumero_aniosReferenciaComercial) {
		this.activarnumero_aniosReferenciaComercial= activarnumero_aniosReferenciaComercial;
	}

	public Border setResaltarnumero_mesesReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarnumero_mesesReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mesesReferenciaComercial() {
		return this.resaltarnumero_mesesReferenciaComercial;
	}

	public void setResaltarnumero_mesesReferenciaComercial(Border borderResaltar) {
		this.resaltarnumero_mesesReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarnumero_mesesReferenciaComercial() {
		return this.mostrarnumero_mesesReferenciaComercial;
	}

	public void setMostrarnumero_mesesReferenciaComercial(Boolean mostrarnumero_mesesReferenciaComercial) {
		this.mostrarnumero_mesesReferenciaComercial= mostrarnumero_mesesReferenciaComercial;
	}

	public Boolean getActivarnumero_mesesReferenciaComercial() {
		return this.activarnumero_mesesReferenciaComercial;
	}

	public void setActivarnumero_mesesReferenciaComercial(Boolean activarnumero_mesesReferenciaComercial) {
		this.activarnumero_mesesReferenciaComercial= activarnumero_mesesReferenciaComercial;
	}

	public Border setResaltarid_tipo_valoracionReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarid_tipo_valoracionReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_valoracionReferenciaComercial() {
		return this.resaltarid_tipo_valoracionReferenciaComercial;
	}

	public void setResaltarid_tipo_valoracionReferenciaComercial(Border borderResaltar) {
		this.resaltarid_tipo_valoracionReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarid_tipo_valoracionReferenciaComercial() {
		return this.mostrarid_tipo_valoracionReferenciaComercial;
	}

	public void setMostrarid_tipo_valoracionReferenciaComercial(Boolean mostrarid_tipo_valoracionReferenciaComercial) {
		this.mostrarid_tipo_valoracionReferenciaComercial= mostrarid_tipo_valoracionReferenciaComercial;
	}

	public Boolean getActivarid_tipo_valoracionReferenciaComercial() {
		return this.activarid_tipo_valoracionReferenciaComercial;
	}

	public void setActivarid_tipo_valoracionReferenciaComercial(Boolean activarid_tipo_valoracionReferenciaComercial) {
		this.activarid_tipo_valoracionReferenciaComercial= activarid_tipo_valoracionReferenciaComercial;
	}

	public Boolean getCargarid_tipo_valoracionReferenciaComercial() {
		return this.cargarid_tipo_valoracionReferenciaComercial;
	}

	public void setCargarid_tipo_valoracionReferenciaComercial(Boolean cargarid_tipo_valoracionReferenciaComercial) {
		this.cargarid_tipo_valoracionReferenciaComercial= cargarid_tipo_valoracionReferenciaComercial;
	}

	public Border setResaltardireccionReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltardireccionReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionReferenciaComercial() {
		return this.resaltardireccionReferenciaComercial;
	}

	public void setResaltardireccionReferenciaComercial(Border borderResaltar) {
		this.resaltardireccionReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrardireccionReferenciaComercial() {
		return this.mostrardireccionReferenciaComercial;
	}

	public void setMostrardireccionReferenciaComercial(Boolean mostrardireccionReferenciaComercial) {
		this.mostrardireccionReferenciaComercial= mostrardireccionReferenciaComercial;
	}

	public Boolean getActivardireccionReferenciaComercial() {
		return this.activardireccionReferenciaComercial;
	}

	public void setActivardireccionReferenciaComercial(Boolean activardireccionReferenciaComercial) {
		this.activardireccionReferenciaComercial= activardireccionReferenciaComercial;
	}

	public Border setResaltartelefonoReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltartelefonoReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoReferenciaComercial() {
		return this.resaltartelefonoReferenciaComercial;
	}

	public void setResaltartelefonoReferenciaComercial(Border borderResaltar) {
		this.resaltartelefonoReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrartelefonoReferenciaComercial() {
		return this.mostrartelefonoReferenciaComercial;
	}

	public void setMostrartelefonoReferenciaComercial(Boolean mostrartelefonoReferenciaComercial) {
		this.mostrartelefonoReferenciaComercial= mostrartelefonoReferenciaComercial;
	}

	public Boolean getActivartelefonoReferenciaComercial() {
		return this.activartelefonoReferenciaComercial;
	}

	public void setActivartelefonoReferenciaComercial(Boolean activartelefonoReferenciaComercial) {
		this.activartelefonoReferenciaComercial= activartelefonoReferenciaComercial;
	}

	public Border setResaltartelefonomovilReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltartelefonomovilReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonomovilReferenciaComercial() {
		return this.resaltartelefonomovilReferenciaComercial;
	}

	public void setResaltartelefonomovilReferenciaComercial(Border borderResaltar) {
		this.resaltartelefonomovilReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrartelefonomovilReferenciaComercial() {
		return this.mostrartelefonomovilReferenciaComercial;
	}

	public void setMostrartelefonomovilReferenciaComercial(Boolean mostrartelefonomovilReferenciaComercial) {
		this.mostrartelefonomovilReferenciaComercial= mostrartelefonomovilReferenciaComercial;
	}

	public Boolean getActivartelefonomovilReferenciaComercial() {
		return this.activartelefonomovilReferenciaComercial;
	}

	public void setActivartelefonomovilReferenciaComercial(Boolean activartelefonomovilReferenciaComercial) {
		this.activartelefonomovilReferenciaComercial= activartelefonomovilReferenciaComercial;
	}

	public Border setResaltartelefonocodigoareaReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltartelefonocodigoareaReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonocodigoareaReferenciaComercial() {
		return this.resaltartelefonocodigoareaReferenciaComercial;
	}

	public void setResaltartelefonocodigoareaReferenciaComercial(Border borderResaltar) {
		this.resaltartelefonocodigoareaReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrartelefonocodigoareaReferenciaComercial() {
		return this.mostrartelefonocodigoareaReferenciaComercial;
	}

	public void setMostrartelefonocodigoareaReferenciaComercial(Boolean mostrartelefonocodigoareaReferenciaComercial) {
		this.mostrartelefonocodigoareaReferenciaComercial= mostrartelefonocodigoareaReferenciaComercial;
	}

	public Boolean getActivartelefonocodigoareaReferenciaComercial() {
		return this.activartelefonocodigoareaReferenciaComercial;
	}

	public void setActivartelefonocodigoareaReferenciaComercial(Boolean activartelefonocodigoareaReferenciaComercial) {
		this.activartelefonocodigoareaReferenciaComercial= activartelefonocodigoareaReferenciaComercial;
	}

	public Border setResaltaremailReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltaremailReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaremailReferenciaComercial() {
		return this.resaltaremailReferenciaComercial;
	}

	public void setResaltaremailReferenciaComercial(Border borderResaltar) {
		this.resaltaremailReferenciaComercial= borderResaltar;
	}

	public Boolean getMostraremailReferenciaComercial() {
		return this.mostraremailReferenciaComercial;
	}

	public void setMostraremailReferenciaComercial(Boolean mostraremailReferenciaComercial) {
		this.mostraremailReferenciaComercial= mostraremailReferenciaComercial;
	}

	public Boolean getActivaremailReferenciaComercial() {
		return this.activaremailReferenciaComercial;
	}

	public void setActivaremailReferenciaComercial(Boolean activaremailReferenciaComercial) {
		this.activaremailReferenciaComercial= activaremailReferenciaComercial;
	}

	public Border setResaltarmontoReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltarmontoReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoReferenciaComercial() {
		return this.resaltarmontoReferenciaComercial;
	}

	public void setResaltarmontoReferenciaComercial(Border borderResaltar) {
		this.resaltarmontoReferenciaComercial= borderResaltar;
	}

	public Boolean getMostrarmontoReferenciaComercial() {
		return this.mostrarmontoReferenciaComercial;
	}

	public void setMostrarmontoReferenciaComercial(Boolean mostrarmontoReferenciaComercial) {
		this.mostrarmontoReferenciaComercial= mostrarmontoReferenciaComercial;
	}

	public Boolean getActivarmontoReferenciaComercial() {
		return this.activarmontoReferenciaComercial;
	}

	public void setActivarmontoReferenciaComercial(Boolean activarmontoReferenciaComercial) {
		this.activarmontoReferenciaComercial= activarmontoReferenciaComercial;
	}

	public Border setResaltaresactivoReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//referenciacomercialBeanSwingJInternalFrame.jTtoolBarReferenciaComercial.setBorder(borderResaltar);
		
		this.resaltaresactivoReferenciaComercial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresactivoReferenciaComercial() {
		return this.resaltaresactivoReferenciaComercial;
	}

	public void setResaltaresactivoReferenciaComercial(Border borderResaltar) {
		this.resaltaresactivoReferenciaComercial= borderResaltar;
	}

	public Boolean getMostraresactivoReferenciaComercial() {
		return this.mostraresactivoReferenciaComercial;
	}

	public void setMostraresactivoReferenciaComercial(Boolean mostraresactivoReferenciaComercial) {
		this.mostraresactivoReferenciaComercial= mostraresactivoReferenciaComercial;
	}

	public Boolean getActivaresactivoReferenciaComercial() {
		return this.activaresactivoReferenciaComercial;
	}

	public void setActivaresactivoReferenciaComercial(Boolean activaresactivoReferenciaComercial) {
		this.activaresactivoReferenciaComercial= activaresactivoReferenciaComercial;
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
		
		
		this.setMostraridReferenciaComercial(esInicial);
		this.setMostrarid_empresaReferenciaComercial(esInicial);
		this.setMostraridclienteReferenciaComercial(esInicial);
		this.setMostraridvalorclientesectoreconomicoReferenciaComercial(esInicial);
		this.setMostrarid_paisReferenciaComercial(esInicial);
		this.setMostraridciudadReferenciaComercial(esInicial);
		this.setMostrarnombreempresaReferenciaComercial(esInicial);
		this.setMostrarcodigo_clienteReferenciaComercial(esInicial);
		this.setMostrarcontactoReferenciaComercial(esInicial);
		this.setMostrararticulo_compraReferenciaComercial(esInicial);
		this.setMostrarnumero_aniosReferenciaComercial(esInicial);
		this.setMostrarnumero_mesesReferenciaComercial(esInicial);
		this.setMostrarid_tipo_valoracionReferenciaComercial(esInicial);
		this.setMostrardireccionReferenciaComercial(esInicial);
		this.setMostrartelefonoReferenciaComercial(esInicial);
		this.setMostrartelefonomovilReferenciaComercial(esInicial);
		this.setMostrartelefonocodigoareaReferenciaComercial(esInicial);
		this.setMostraremailReferenciaComercial(esInicial);
		this.setMostrarmontoReferenciaComercial(esInicial);
		this.setMostraresactivoReferenciaComercial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ID)) {
				this.setMostraridReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDCLIENTE)) {
				this.setMostraridclienteReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO)) {
				this.setMostraridvalorclientesectoreconomicoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDCIUDAD)) {
				this.setMostraridciudadReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NOMBREEMPRESA)) {
				this.setMostrarnombreempresaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.CONTACTO)) {
				this.setMostrarcontactoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA)) {
				this.setMostrararticulo_compraReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NUMEROANIOS)) {
				this.setMostrarnumero_aniosReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NUMEROMESES)) {
				this.setMostrarnumero_mesesReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDTIPOVALORACION)) {
				this.setMostrarid_tipo_valoracionReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONOMOVIL)) {
				this.setMostrartelefonomovilReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setMostrartelefonocodigoareaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.EMAIL)) {
				this.setMostraremailReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.MONTO)) {
				this.setMostrarmontoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ESACTIVO)) {
				this.setMostraresactivoReferenciaComercial(esAsigna);
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
		
		
		this.setActivaridReferenciaComercial(esInicial);
		this.setActivarid_empresaReferenciaComercial(esInicial);
		this.setActivaridclienteReferenciaComercial(esInicial);
		this.setActivaridvalorclientesectoreconomicoReferenciaComercial(esInicial);
		this.setActivarid_paisReferenciaComercial(esInicial);
		this.setActivaridciudadReferenciaComercial(esInicial);
		this.setActivarnombreempresaReferenciaComercial(esInicial);
		this.setActivarcodigo_clienteReferenciaComercial(esInicial);
		this.setActivarcontactoReferenciaComercial(esInicial);
		this.setActivararticulo_compraReferenciaComercial(esInicial);
		this.setActivarnumero_aniosReferenciaComercial(esInicial);
		this.setActivarnumero_mesesReferenciaComercial(esInicial);
		this.setActivarid_tipo_valoracionReferenciaComercial(esInicial);
		this.setActivardireccionReferenciaComercial(esInicial);
		this.setActivartelefonoReferenciaComercial(esInicial);
		this.setActivartelefonomovilReferenciaComercial(esInicial);
		this.setActivartelefonocodigoareaReferenciaComercial(esInicial);
		this.setActivaremailReferenciaComercial(esInicial);
		this.setActivarmontoReferenciaComercial(esInicial);
		this.setActivaresactivoReferenciaComercial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ID)) {
				this.setActivaridReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDCLIENTE)) {
				this.setActivaridclienteReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO)) {
				this.setActivaridvalorclientesectoreconomicoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDCIUDAD)) {
				this.setActivaridciudadReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NOMBREEMPRESA)) {
				this.setActivarnombreempresaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.CONTACTO)) {
				this.setActivarcontactoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA)) {
				this.setActivararticulo_compraReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NUMEROANIOS)) {
				this.setActivarnumero_aniosReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NUMEROMESES)) {
				this.setActivarnumero_mesesReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDTIPOVALORACION)) {
				this.setActivarid_tipo_valoracionReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.DIRECCION)) {
				this.setActivardireccionReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONOMOVIL)) {
				this.setActivartelefonomovilReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setActivartelefonocodigoareaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.EMAIL)) {
				this.setActivaremailReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.MONTO)) {
				this.setActivarmontoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ESACTIVO)) {
				this.setActivaresactivoReferenciaComercial(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReferenciaComercial(esInicial);
		this.setResaltarid_empresaReferenciaComercial(esInicial);
		this.setResaltaridclienteReferenciaComercial(esInicial);
		this.setResaltaridvalorclientesectoreconomicoReferenciaComercial(esInicial);
		this.setResaltarid_paisReferenciaComercial(esInicial);
		this.setResaltaridciudadReferenciaComercial(esInicial);
		this.setResaltarnombreempresaReferenciaComercial(esInicial);
		this.setResaltarcodigo_clienteReferenciaComercial(esInicial);
		this.setResaltarcontactoReferenciaComercial(esInicial);
		this.setResaltararticulo_compraReferenciaComercial(esInicial);
		this.setResaltarnumero_aniosReferenciaComercial(esInicial);
		this.setResaltarnumero_mesesReferenciaComercial(esInicial);
		this.setResaltarid_tipo_valoracionReferenciaComercial(esInicial);
		this.setResaltardireccionReferenciaComercial(esInicial);
		this.setResaltartelefonoReferenciaComercial(esInicial);
		this.setResaltartelefonomovilReferenciaComercial(esInicial);
		this.setResaltartelefonocodigoareaReferenciaComercial(esInicial);
		this.setResaltaremailReferenciaComercial(esInicial);
		this.setResaltarmontoReferenciaComercial(esInicial);
		this.setResaltaresactivoReferenciaComercial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ID)) {
				this.setResaltaridReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDCLIENTE)) {
				this.setResaltaridclienteReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDTIPOSECTORECONO)) {
				this.setResaltaridvalorclientesectoreconomicoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDCIUDAD)) {
				this.setResaltaridciudadReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NOMBREEMPRESA)) {
				this.setResaltarnombreempresaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.CONTACTO)) {
				this.setResaltarcontactoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ARTICULOCOMPRA)) {
				this.setResaltararticulo_compraReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NUMEROANIOS)) {
				this.setResaltarnumero_aniosReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.NUMEROMESES)) {
				this.setResaltarnumero_mesesReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.IDTIPOVALORACION)) {
				this.setResaltarid_tipo_valoracionReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONOMOVIL)) {
				this.setResaltartelefonomovilReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.TELEFONOCODIGOAREA)) {
				this.setResaltartelefonocodigoareaReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.EMAIL)) {
				this.setResaltaremailReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.MONTO)) {
				this.setResaltarmontoReferenciaComercial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReferenciaComercialConstantesFunciones.ESACTIVO)) {
				this.setResaltaresactivoReferenciaComercial(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadReferenciaComercial=true;

	public Boolean getMostrarFK_IdCiudadReferenciaComercial() {
		return this.mostrarFK_IdCiudadReferenciaComercial;
	}

	public void setMostrarFK_IdCiudadReferenciaComercial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadReferenciaComercial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteReferenciaComercial=true;

	public Boolean getMostrarFK_IdClienteReferenciaComercial() {
		return this.mostrarFK_IdClienteReferenciaComercial;
	}

	public void setMostrarFK_IdClienteReferenciaComercial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteReferenciaComercial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaReferenciaComercial=true;

	public Boolean getMostrarFK_IdEmpresaReferenciaComercial() {
		return this.mostrarFK_IdEmpresaReferenciaComercial;
	}

	public void setMostrarFK_IdEmpresaReferenciaComercial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaReferenciaComercial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisReferenciaComercial=true;

	public Boolean getMostrarFK_IdPaisReferenciaComercial() {
		return this.mostrarFK_IdPaisReferenciaComercial;
	}

	public void setMostrarFK_IdPaisReferenciaComercial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisReferenciaComercial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoValoracionReferenciaComercial=true;

	public Boolean getMostrarFK_IdTipoValoracionReferenciaComercial() {
		return this.mostrarFK_IdTipoValoracionReferenciaComercial;
	}

	public void setMostrarFK_IdTipoValoracionReferenciaComercial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoValoracionReferenciaComercial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdValorClienteSectorEconomicoReferenciaComercial=true;

	public Boolean getMostrarFK_IdValorClienteSectorEconomicoReferenciaComercial() {
		return this.mostrarFK_IdValorClienteSectorEconomicoReferenciaComercial;
	}

	public void setMostrarFK_IdValorClienteSectorEconomicoReferenciaComercial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdValorClienteSectorEconomicoReferenciaComercial= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadReferenciaComercial=true;

	public Boolean getActivarFK_IdCiudadReferenciaComercial() {
		return this.activarFK_IdCiudadReferenciaComercial;
	}

	public void setActivarFK_IdCiudadReferenciaComercial(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadReferenciaComercial= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteReferenciaComercial=true;

	public Boolean getActivarFK_IdClienteReferenciaComercial() {
		return this.activarFK_IdClienteReferenciaComercial;
	}

	public void setActivarFK_IdClienteReferenciaComercial(Boolean habilitarResaltar) {
		this.activarFK_IdClienteReferenciaComercial= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaReferenciaComercial=true;

	public Boolean getActivarFK_IdEmpresaReferenciaComercial() {
		return this.activarFK_IdEmpresaReferenciaComercial;
	}

	public void setActivarFK_IdEmpresaReferenciaComercial(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaReferenciaComercial= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisReferenciaComercial=true;

	public Boolean getActivarFK_IdPaisReferenciaComercial() {
		return this.activarFK_IdPaisReferenciaComercial;
	}

	public void setActivarFK_IdPaisReferenciaComercial(Boolean habilitarResaltar) {
		this.activarFK_IdPaisReferenciaComercial= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoValoracionReferenciaComercial=true;

	public Boolean getActivarFK_IdTipoValoracionReferenciaComercial() {
		return this.activarFK_IdTipoValoracionReferenciaComercial;
	}

	public void setActivarFK_IdTipoValoracionReferenciaComercial(Boolean habilitarResaltar) {
		this.activarFK_IdTipoValoracionReferenciaComercial= habilitarResaltar;
	}

	public Boolean activarFK_IdValorClienteSectorEconomicoReferenciaComercial=true;

	public Boolean getActivarFK_IdValorClienteSectorEconomicoReferenciaComercial() {
		return this.activarFK_IdValorClienteSectorEconomicoReferenciaComercial;
	}

	public void setActivarFK_IdValorClienteSectorEconomicoReferenciaComercial(Boolean habilitarResaltar) {
		this.activarFK_IdValorClienteSectorEconomicoReferenciaComercial= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadReferenciaComercial=null;

	public Border getResaltarFK_IdCiudadReferenciaComercial() {
		return this.resaltarFK_IdCiudadReferenciaComercial;
	}

	public void setResaltarFK_IdCiudadReferenciaComercial(Border borderResaltar) {
		this.resaltarFK_IdCiudadReferenciaComercial= borderResaltar;
	}

	public void setResaltarFK_IdCiudadReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadReferenciaComercial= borderResaltar;
	}

	public Border resaltarFK_IdClienteReferenciaComercial=null;

	public Border getResaltarFK_IdClienteReferenciaComercial() {
		return this.resaltarFK_IdClienteReferenciaComercial;
	}

	public void setResaltarFK_IdClienteReferenciaComercial(Border borderResaltar) {
		this.resaltarFK_IdClienteReferenciaComercial= borderResaltar;
	}

	public void setResaltarFK_IdClienteReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteReferenciaComercial= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaReferenciaComercial=null;

	public Border getResaltarFK_IdEmpresaReferenciaComercial() {
		return this.resaltarFK_IdEmpresaReferenciaComercial;
	}

	public void setResaltarFK_IdEmpresaReferenciaComercial(Border borderResaltar) {
		this.resaltarFK_IdEmpresaReferenciaComercial= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaReferenciaComercial= borderResaltar;
	}

	public Border resaltarFK_IdPaisReferenciaComercial=null;

	public Border getResaltarFK_IdPaisReferenciaComercial() {
		return this.resaltarFK_IdPaisReferenciaComercial;
	}

	public void setResaltarFK_IdPaisReferenciaComercial(Border borderResaltar) {
		this.resaltarFK_IdPaisReferenciaComercial= borderResaltar;
	}

	public void setResaltarFK_IdPaisReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisReferenciaComercial= borderResaltar;
	}

	public Border resaltarFK_IdTipoValoracionReferenciaComercial=null;

	public Border getResaltarFK_IdTipoValoracionReferenciaComercial() {
		return this.resaltarFK_IdTipoValoracionReferenciaComercial;
	}

	public void setResaltarFK_IdTipoValoracionReferenciaComercial(Border borderResaltar) {
		this.resaltarFK_IdTipoValoracionReferenciaComercial= borderResaltar;
	}

	public void setResaltarFK_IdTipoValoracionReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoValoracionReferenciaComercial= borderResaltar;
	}

	public Border resaltarFK_IdValorClienteSectorEconomicoReferenciaComercial=null;

	public Border getResaltarFK_IdValorClienteSectorEconomicoReferenciaComercial() {
		return this.resaltarFK_IdValorClienteSectorEconomicoReferenciaComercial;
	}

	public void setResaltarFK_IdValorClienteSectorEconomicoReferenciaComercial(Border borderResaltar) {
		this.resaltarFK_IdValorClienteSectorEconomicoReferenciaComercial= borderResaltar;
	}

	public void setResaltarFK_IdValorClienteSectorEconomicoReferenciaComercial(ParametroGeneralUsuario parametroGeneralUsuario/*ReferenciaComercialBeanSwingJInternalFrame referenciacomercialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdValorClienteSectorEconomicoReferenciaComercial= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}